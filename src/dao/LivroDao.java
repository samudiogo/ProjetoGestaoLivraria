package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Livro;


public class LivroDao {
	public static List<Livro> obterLista() {

		PreparedStatement ps = null;

		List<Livro> lista = new ArrayList<Livro>();

		try {
			ps = Conexao.obterConexao().prepareStatement("SELECT id, nome, qtde FROM livro ORDER BY nome");

			ResultSet rs = null;

			rs = ps.executeQuery();

			while (rs.next()) {

				lista.add(new Livro(rs.getInt("id"), rs.getString("nome"), rs.getInt("qtde")));
			}

			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static Livro obterPorId(int id){
		PreparedStatement ps = null;
		try {
			
			ps = Conexao.obterConexao()
					.prepareStatement("SELECT * FROM livro where id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			if(rs.next()){
				return new Livro(rs.getInt("id"),
						rs.getString("nome"),
						rs.getInt("qtde"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static boolean Alterar(Livro livro){
		PreparedStatement ps = null;
		try {
			
			ps = Conexao.obterConexao()
					.prepareStatement("UPDATE Livro set nome = ?, qtde = ? where id = ?");
			ps.setString(1, livro.getNome());
			ps.setInt(2, livro.getQtde());
			ps.setInt(3, livro.getId());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
