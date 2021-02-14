package control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.course.CourseDAO;
import model.dao.course.CourseDAOImpl;
import model.entity.course.Course;

@WebServlet("/")
public class CourseServlet {
	
	private static final long serialVersionUID = 1L;
	private CourseDAO dao = new CourseDAOImpl();

	public void init() {
		dao = new CourseDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/show":
				showCourseform(request, response);
				break;
				
			case "/showupdate":
				showCourseupdate(request, response);
				break;
			
			case "/insert":
				insertCourse(request, response);
				break;
				
			case "/remove":
				removeCourse(request, response);
				break;
				
			case "update":
				updateCourse(request, response);
				break;
				
			default:
				listCourse(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listCourse(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Course> courses = dao.listCourse();
		request.setAttribute("courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-course.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showCourseform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-course.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showCourseupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Course course = dao.recoverCourse(new Course(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-course.jsp");
			request.setAttribute("course", course);
			dispatcher.forward(request, response);
	}
	
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		dao.insertCourse(new Course (name));
		response.sendRedirect("list");
	}
	
	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		dao.updateCourse(new Course (name));
		response.sendRedirect("list");
	}
	
	private void removeCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		Course course = dao.recoverCourse(new Course(id));
		dao.removeCourse(course);
		response.sendRedirect("list");
	}
	
}