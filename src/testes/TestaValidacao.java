package testes;

import dao.UsuarioDao;
import negocio.Usuario;

public class TestaValidacao {

	public static void main(String[] args) {
		
		String login = "elberth";
		String senha = "moraes";
		
		if(UsuarioDao.valida(new Usuario(login, senha))){
			System.out.printf("Usu�rio %s v�lido! Existe no banco.\n", login);
		} else {
			System.out.printf("Usu�rio %s inexistente!!!\n", login);
		}
		
		login = "moraes";
		senha = "elberth";
		
		if(UsuarioDao.valida(new Usuario(login, senha))){
			System.out.printf("Usu�rio %s v�lido! Existe no banco.\n", login);
		} else {
			System.out.printf("Usu�rio %s inexistente!!!\n", login);
		}
		
	}
}
