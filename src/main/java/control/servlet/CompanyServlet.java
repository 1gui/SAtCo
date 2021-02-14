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

import model.dao.company.CompanyDAO;
import model.dao.company.CompanyDAOImpl;
import model.entity.company.Company;

@WebServlet("/")
public class CompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CompanyDAO dao = new CompanyDAOImpl();

	public void init() {
		dao = new CompanyDAOImpl();
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
				showCompanyform(request, response);
				break;
				
			case "/showupdate":
				showCompanyupdate(request, response);
				break;
			
			case "/insert":
				insertCompany(request, response);
				break;
				
			case "/remove":
				removeCompany(request, response);
				break;
				
			case "update":
				updateCompany(request, response);
				break;
				
			default:
				listCompany(request, response);
				break;
				
				}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listCompany(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException{
		
		List<Company> companys = dao.listCompany();
		request.setAttribute("companys", companys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-company.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showCompanyform(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-company.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showCompanyupdate(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Company company = dao.recoverCompany(new Company(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-company.jsp");
			request.setAttribute("company", company);
			dispatcher.forward(request, response);
	}
	
	private void insertCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		dao.insertCompany(new Company(name, cnpj, email, address, phone));
		response.sendRedirect("list");
	}
	
	private void updateCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		dao.updateCompany(new Company(name, cnpj, email, address, phone));
		response.sendRedirect("list");
	}
	
	private void removeCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		Company company = dao.recoverCompany(new Company(id));
		dao.removeCompany(company);
		response.sendRedirect("list");
	}	
}