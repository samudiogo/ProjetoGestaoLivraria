package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import negocio.Usuario;

public class ManterUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private HttpSession session;
       
    public ManterUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		usuario = (Usuario)session.getAttribute("usuario");
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		if("incluir".equals(request.getParameter("operacao"))){
			
			UsuarioDao.incluir(usuario);
			
		} else {
			
			UsuarioDao.alterar(usuario);
		}

		request.getRequestDispatcher("livros.jsp").forward(request, response);
	}
}