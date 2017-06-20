package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import negocio.Usuario;

public class ControlaAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private HttpSession session;
       
    public ControlaAcesso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		session = request.getSession();
		
		usuario = new Usuario(request.getParameter("login"),request.getParameter("senha"));
		
		request.setAttribute("ehIncluido", UsuarioDao.valida(usuario));
		
		session.setAttribute("usuario", usuario);
		
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}
}
