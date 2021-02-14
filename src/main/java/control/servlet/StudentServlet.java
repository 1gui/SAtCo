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

import model.dao.student.StudentDAO;
import model.dao.student.StudentDAOImpl;
import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.student.Student;

@WebServlet("/")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAOImpl();

	public void init() {
		dao = new StudentDAOImpl();
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
				showStudentform(request, response);
				break;
				
			case "/showupdate":
				showStudentupdate(request, response);
				break;
				
			case "/shouwcompany":
				showStudentcompany(request, response);
				break;
				
			case "/showcourse":
				showStudentcourse(request, response);
				break;
			
			case "/insert":
				insertStudent(request, response);
				break;
				
			case "/remove":
				removeStudent(request, response);
				break;
				
			case "update":
				updateStudent(request, response);
				break;
				
			default:
				listStudent(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Student> students = dao.listStudent();
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showStudentform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-student.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showStudentupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Student student = dao.recoverStudent(new Student(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-student.jsp");
			request.setAttribute("student", student);
			dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		dao.insertStudent(new Student(name, cpf, email));
		response.sendRedirect("list");
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		dao.updateStudent(new Student(name, cpf, email));
		response.sendRedirect("list");
	}
	
	private void removeStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		Student student = dao.recoverStudent(new Student(id));
		dao.removeStudent(student);
		response.sendRedirect("list");
	}	
}