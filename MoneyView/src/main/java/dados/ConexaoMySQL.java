package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/moneyview";
    private static final String USUARIO = "root";
    private static final String SENHA = "senha00001";
    
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public static void desconectar(Connection conexao){
        if (conexao != null) {
            try{
                conexao.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
