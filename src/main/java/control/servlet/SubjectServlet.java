package control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.subject.SubjectDAO;
import model.dao.subject.SubjectDAOImpl;
import model.entity.subject.Subject;

@WebServlet("/")
public class SubjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SubjectDAO dao = new SubjectDAOImpl();

	public void init() {
		dao = new SubjectDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void goGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/show":
				showSubjectform(request, response);
				break;
				
			case "/showupdate":
				showSubjectupdate(request, response);
				break;
			
			case "/insert":
				insertSubject(request, response);
				break;
				
			case "/remove":
				removeSubject(request, response);
				break;
				
			case "update":
				updateSubject(request, response);
				break;
				
			default:
				listSubject(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Subject> subjects = dao.listSubject();
		request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-subject.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showSubjectform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-subject.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showSubjectupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Subject subject = dao.recoverSubject(new Subject(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-subject.jsp");
			request.setAttribute("subject", subject);
			dispatcher.forward(request, response);
	}
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		dao.insertSubject(new Subject(name));
		response.sendRedirect("list");
	}
	
	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		dao.updateSubject(new Subject(name));
		response.sendRedirect("list");
	}
	
	private void removeSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		Subject subject = dao.recoverSubject(new Subject(id));
		dao.removeSubject(subject);
		response.sendRedirect("list");
	}	
}