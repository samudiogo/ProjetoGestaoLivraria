package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDao;
import negocio.Livro;

/**
 * Servlet implementation class ManterLivro
 */
public class ManterLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterLivro() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro(
				Integer.valueOf(request.getParameter("id")),
				request.getParameter("nome"),
				Integer.valueOf(request.getParameter("qtde")));
		String msg;
		if(LivroDao.Alterar(livro)){
			msg = "livro alterado com sucesso";
		}else{
			msg = "erro ao alterar o seu livro.";
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("Msg.jsp").forward(request, response);
		
	}

}
