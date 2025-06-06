package dados;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    
    //(gastos OU ganhos)
    public List<Transacao> buscarTransacoesDoUsuario(int usuarioId, String tipo) {
    List<Transacao> transacoes = new ArrayList<>();
    String sql = "SELECT t.id, t.descricao, t.valor, t.data, t.tipo, c.nome AS categoria " +
                 "FROM transacoes t " +
                 "JOIN categorias c ON t.categoria_id = c.id " +
                 "WHERE t.usuario_id = ? AND t.tipo = ?";

    try (Connection conexao = ConexaoMySQL.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {
        
        stmt.setInt(1, usuarioId);
        stmt.setString(2, tipo); 
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            transacoes.add(new Transacao(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getDouble("valor"),
                rs.getString("data"),
                rs.getString("tipo"),
                rs.getString("categoria"), 
                usuarioId
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return transacoes;
}
    
    //(gastos E ganhos)
    public List<Transacao> buscarTodasTransacoesDoUsuario(int usuarioId) {
    List<Transacao> transacoes = new ArrayList<>();
    String sql = "SELECT t.id, t.descricao, t.valor, t.data, t.tipo, c.nome AS categoria " +
                 "FROM transacoes t " +
                 "JOIN categorias c ON t.categoria_id = c.id " +
                 "WHERE t.usuario_id = ?";

    try (Connection conexao = ConexaoMySQL.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {
        
        stmt.setInt(1, usuarioId); 
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            transacoes.add(new Transacao(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getDouble("valor"),
                rs.getString("data"),
                rs.getString("tipo"),
                rs.getString("categoria"), 
                usuarioId
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return transacoes;
}
    
    public void adicionarTransacao(Transacao transacao, int categoriaId, int usuarioId) {
        String sql = "INSERT INTO transacoes (descricao, valor, data, tipo, categoria_id, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, transacao.getDescricao());
            stmt.setDouble(2, transacao.getValor());
            stmt.setString(3, transacao.getData());
            stmt.setString(4, transacao.getTipo());
            stmt.setInt(5, categoriaId); 
            stmt.setInt(6, usuarioId);
        
            stmt.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarTransacao(Transacao transacao, int categoriaId){
        String sql = "UPDATE transacoes SET descricao = ?, valor = ?, data = ?, tipo = ?, categoria_id = ? WHERE id = ?";
        
        try (Connection conexao = ConexaoMySQL.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, transacao.getDescricao());
            stmt.setDouble(2, transacao.getValor());
            stmt.setString(3, transacao.getData());
            stmt.setString(4, transacao.getTipo());
            stmt.setInt(5, categoriaId);
            stmt.setInt(6, transacao.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean validarData(String data){
        try {
            LocalDate.parse(data);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}