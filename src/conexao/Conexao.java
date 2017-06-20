package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conn = null;
	
	public static Connection obterConexao(){

		if (conn == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String serverName = "localhost";
				
			String bancoDados = "instituto";      
				
			String url = "jdbc:mysql://" + serverName + "/" + bancoDados;
				
			String usuario = "infnet";              
				
			String senha = "infnet";

			try {
				conn = DriverManager.getConnection(url,usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return conn;
	}
}