package control.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.company.CompanyDAO;
import model.dao.company.CompanyDAOImpl;

@WebServlet("/")
public class Servlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private CompanyDAO cdao = new CompanyDAOImpl();
	
	public void init() {
		cdao = new CompanyDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletResquest request, HttpServletResponse response)
		throws ServletExeception, IOException {
		
		String action = request.getServletPath();
		
		try {
			switch(action) {
			
			case "/login":
				showlogin(request, response);
				break;
				
			case "/option":
				showoptions(request, response);
				break;
			
			case "/insert":
				insertCompany(request, response);
				break;
				
			case "/remove":
				removeCompany(request, response);
				break;
				
			case "/update":
				updateCompany(request, response);
				
				
			}
		} catch (SQLException ex) {
			throw new ServletExeption(ex);
		}
	}
	
	private void showlogin(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
		
		String login = request.getParameter("login");
		
		
	}
}

