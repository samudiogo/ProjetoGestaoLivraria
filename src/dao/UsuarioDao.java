package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {

	public static List<Usuario> obterLista(){
		PreparedStatement ps = null;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM usuario ORDER BY nome");
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				lista.add(
						new Usuario(
								rs.getInt("id"), 
								rs.getString("nome"), 
								rs.getString("login"), 
								rs.getString("senha"), 
								rs.getString("email")
							)
				);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}	

	public static Usuario obterUsuarioPorId(int id){
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.obterConexao().prepareStatement("SELECT * FROM usuario WHERE id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if (rs.next()){
				
				return new Usuario(
							rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("login"), 
							rs.getString("senha"), 
							rs.getString("email")						
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean valida(Usuario usuario){
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.obterConexao().prepareStatement("SELECT * FROM instituto.usuario where login = ? and senha = ?");
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if (rs.next()){
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean incluir(Usuario usuario){
		PreparedStatement ps = null;
			
		try {
			ps = Conexao.obterConexao().prepareStatement("INSERT INTO usuario (nome, email, login, senha) VALUES (?,?,?,?)");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	public static boolean alterar(Usuario usuario){
		PreparedStatement ps = null;
			
		try {
			ps = Conexao.obterConexao().prepareStatement("UPDATE usuario SET nome = ?, email = ?, login = ?, senha = ? WHERE id = ?");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setInt(5, usuario.getId());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
}