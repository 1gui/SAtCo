package control.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	//Servlet implementation class Servlet
 
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

/*
 * >(1) login.jsp
 * 
 * >Em options.jsp será necessário fazer a listagem de professores ou empresas quando a instituição selecionar "Procurar"
 * 
 * >No rollcall.jsp será necessário exibir o nome do professor, nome da turma, nome de cada aluno, salvar a frequência e cada id do checkbox terá
 * o id do respectivo aluno
 * 
 * >
*/
