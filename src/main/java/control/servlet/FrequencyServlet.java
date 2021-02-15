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

import model.dao.frequency.FrequencyDAO;
import model.dao.frequency.FrequencyDAOImpl;
import model.entity.frequency.Frequency;
import model.entity.student.Student;
import model.enumeration.frequency.FrequencyStatus;

@WebServlet("/")
public class FrequencyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FrequencyDAO dao = new FrequencyDAOImpl();

	public void init() {
		dao = new FrequencyDAOImpl();
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
				showFrequencyform(request, response);
				break;
				
			case "/showupdate":
				showFrequencyupdate(request, response);
				break;
			
			case "/insert":
				insertFrequency(request, response);
				break;
				
			case "update":
				updateFrequency(request, response);
				break;
				
			default:
				listFrequency(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listFrequency(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Frequency> frequencys = dao.listFrequency();
		request.setAttribute("frequencys", frequencys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-frequency.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showFrequencyform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-frequency.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showFrequencyupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Frequency frequency = dao.recoverFrequency(new Frequency(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-frequency.jsp");
			request.setAttribute("frequency", frequency);
			dispatcher.forward(request, response);
	}
	
	private void insertFrequency(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		FrequencyStatus status = FrequencyStatus.values(request.getParameter("frequency"))[0];
		Student student = request.getParameter("student");
		dao.insertFrequency(new Frequency(status, student));
		response.sendRedirect("list");
	}
	
	private void updateFrequency(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		FrequencyStatus status = FrequencyStatus.values(request.getParameter("frequency"))[0];
		Student student = request.getParameter("student");
		dao.updateFrequency(new Frequency(status, student));
		response.sendRedirect("list");
	}
}