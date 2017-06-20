package testes;

import dao.UsuarioDao;
import negocio.Usuario;

public class TestaInclusao {

	public static void main(String[] args) {
		
		if (UsuarioDao.incluir(new Usuario("Elberth Moraes","elberth.moraes@gmail.com","elberth","moraes"))){
			
			System.out.println("Inclusão realizada!!!");
			
		} else {
			
			System.out.println("Problemas!!! Verifique.");			
		}
	}
}
