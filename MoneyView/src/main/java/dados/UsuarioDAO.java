package dados;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
    public boolean cadastrarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios (nome_usuario, email, senha) VALUES (?, ?, MD5(?))";
        
        try(Connection conexao = ConexaoMySQL.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public String criptografar(String stringDescriptografada) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(stringDescriptografada.getBytes());
        
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        String stringCriptografada = sb.toString();
        
        return stringCriptografada;
    }
    
    public String login(String email, String senha) throws NoSuchAlgorithmException{
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        try (Connection conexao = ConexaoMySQL.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)){
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (!rs.next()) {
                return  "Usuario nao encontrado";
            }
            
            String senhabanco = rs.getString("senha");
            String senhaCriptografada = criptografar(senha);
            
            if (!senhaCriptografada.equals(senhabanco)) {
                return "senha incorreta";
            }
            
            SessaoUsuario.getInstancia().setUsuario(new Usuario(
                rs.getInt("id"),
                rs.getString("nome_usuario"),
                rs.getString("email"),
                senhabanco
            ));
            return "Login bem-sucedido! Bem-vindo, " + rs.getString("nome_usuario");
            
        } catch(SQLException e){
            e.printStackTrace();
            return "Erro no banco de dados.";
        }
    }
    
}
