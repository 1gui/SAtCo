package control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.login.LoginDAO;
import model.dao.login.LoginDAOImpl;
import model.entity.user.User;

public class ProfileServlet {

    private LoginDAO loginDAO = new LoginDAOImpl();
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();

		user.setUsername(username);
		user.setPassword(password);

		try {
			
			List<User> validateUser = loginDAO.validateUser(user);

			if (validateUser.equals("Admin_Role")) {
				
				System.out.println("Page Admin.");

				HttpSession session = request.getSession(); // Criando a sessÃ£o
				session.setAttribute("Admin", user); // Definindo atributos
				request.setAttribute("userName", user);

				request.getRequestDispatcher("/JSP/admin.jsp").forward(request, response);
				
			} else if (validateUser.equals("Teacher_Role")) {
				
				System.out.println("Page Teacher.");

				HttpSession session = request.getSession();
				session.setAttribute("Teacher", user);
				request.setAttribute("userName", user);

				request.getRequestDispatcher("/JSP/teacher.jsp").forward(request, response);
				
			} else if (validateUser.equals("Company_Role")) {
				
				System.out.println("Page Company.");

				HttpSession session = request.getSession();
				session.setAttribute("Company", user);
				request.setAttribute("userName", user);

				request.getRequestDispatcher("/JSP/company.jsp").forward(request, response);
				
			} else {
				
				System.out.println("Error message = " + user);
				request.setAttribute("errMessage", user);

				request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
	}
}

