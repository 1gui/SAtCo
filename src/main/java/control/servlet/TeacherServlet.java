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

import model.dao.teacher.TeacherDAO;
import model.dao.teacher.TeacherDAOImpl;
import model.entity.teacher.Teacher;

@WebServlet("/")
public class TeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TeacherDAO dao = new TeacherDAOImpl();

	public void init() {
		dao = new TeacherDAOImpl();
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
				showTeacherform(request, response);
				break;
				
			case "/showupdate":
				showTeacherupdate(request, response);
				break;
			
			case "/insert":
				insertTeacher(request, response);
				break;
				
			case "/remove":
				removeTeacher(request, response);
				break;
				
			case "update":
				updateTeacher(request, response);
				break;
				
			default:
				listTeacher(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Teacher> teachers = dao.listTeacher();
		request.setAttribute("teachers", teachers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-teacher.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showTeacherform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-teacher.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showTeacherupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Teacher teacher = dao.recoverTeacher(new Teacher(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-teacher.jsp");
			request.setAttribute("teacher", teacher);
			dispatcher.forward(request, response);
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cpf = request.getParameter("cnpj");
		String email = request.getParameter("email");
		dao.insertTeacher(new Teacher(name, cpf, email));
		response.sendRedirect("list");
	}
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cpf = request.getParameter("cnpj");
		String email = request.getParameter("email");
		dao.updateTeacher(new Teacher(name, cpf, email));
		response.sendRedirect("list");
	}
	
	private void removeTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		Teacher teacher = dao.recoverTeacher(new Teacher(id));
		dao.removeTeacher(teacher);
		response.sendRedirect("list");
	}	
}