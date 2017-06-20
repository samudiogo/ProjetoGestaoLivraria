package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDao;
import negocio.Livro;

/**
 * Servlet implementation class ControlaLivro
 */
public class ControlaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlaLivro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			int livroId = Integer.valueOf(request.getParameter("id"));

			Livro livro = LivroDao.obterPorId(livroId);
			request.setAttribute("livro", livro);

			request.getRequestDispatcher("detalheLivro.jsp").forward(request, response);

		} else if ("new".equals(request.getParameter("ac"))) {
			
			request.getRequestDispatcher("detalheLivro.jsp").forward(request, response);
		} else {

			request.setAttribute("listalivros", LivroDao.obterLista());

			request.getRequestDispatcher("listaLivros.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
