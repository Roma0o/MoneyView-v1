package dados;

import java.sql.*;

public class CategoriaDAO {
    
    public int buscarId(String nomeCategoria) throws SQLException {
        String sql = "SELECT id FROM categorias WHERE nome = ?";
        
        try (Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, nomeCategoria);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    return -1;
                }
            }
        }
    }
    
    public int adicionarCategoria(String nomeCategoria) throws SQLException{
        String sql = "INSERT INTO categorias (nome) VALUES (?)";
        
        try (Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, nomeCategoria);
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }else{
                    throw new SQLException("Falha ao criar categoria, nenhum id obtido");
                }
            }
        }
    }

}
