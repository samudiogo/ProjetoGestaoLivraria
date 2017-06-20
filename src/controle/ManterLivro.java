package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LivroDao;
import negocio.Livro;
import negocio.Usuario;

/**
 * Servlet implementation class ManterLivro
 */
public class ManterLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterLivro() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();

		usuario = (Usuario) session.getAttribute("usuario");
		Livro livro = new Livro();
		livro.setId(Integer.valueOf(request.getParameter("livroId")));
		String msg = "";
		if (usuario != null && livro.getId() > 0) {
			if (LivroDao.ReservaLlivro(livro.getId(), usuario.getId())) {
				msg = "Livro reservado com sucesso para " + usuario.getNome() + "!";
			} else
				msg = "Erro ao reservar o livro..";

			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Msg.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int livroId = 0;
		
		if(!request.getParameter("id").isEmpty())
			livroId = Integer.valueOf(request.getParameter("id"));
		
		Livro livro = new Livro(livroId, request.getParameter("nome"),
				Integer.valueOf(request.getParameter("qtde")));
		
		String msg;

		if (livro.getId() > 0) {

			if (LivroDao.Alterar(livro)) {
				msg = "livro alterado com sucesso";
			} else {
				msg = "erro ao alterar o seu livro.";
			}
		} else {
			if (LivroDao.CadastraLivro(livro))
				msg = "livro cadastrado com sucesso";
			else
				msg = "erro ao cadastrar o seu livro.";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("Msg.jsp").forward(request, response);

	}

}
