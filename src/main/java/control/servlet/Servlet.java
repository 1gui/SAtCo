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
import model.dao.course.CourseDAO;
import model.dao.course.CourseDAOImpl;
import model.dao.frequency.FrequencyDAO;
import model.dao.frequency.FrequencyDAOImpl;
import model.dao.student.StudentDAO;
import model.dao.student.StudentDAOImpl;
import model.dao.subject.SubjectDAO;
import model.dao.subject.SubjectDAOImpl;
import model.dao.teacher.TeacherDAO;
import model.dao.teacher.TeacherDAOImpl;
import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.frequency.Frequency;
import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
import model.enumeration.frequency.FrequencyStatus;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CompanyDAO companydao = new CompanyDAOImpl();
	private CourseDAO coursedao = new CourseDAOImpl();
	private FrequencyDAO frequencydao = new FrequencyDAOImpl();
	private StudentDAO studentdao = new StudentDAOImpl();
	private SubjectDAO subjectdao = new SubjectDAOImpl();
	private TeacherDAO teacherdao = new TeacherDAOImpl();

	public void init() {
		companydao = new CompanyDAOImpl();
		coursedao = new CourseDAOImpl();
		frequencydao = new FrequencyDAOImpl();
		studentdao = new StudentDAOImpl();
		subjectdao = new SubjectDAOImpl();
		teacherdao = new TeacherDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void goGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			switch (action) {

			case "/options":
				showoptions(request, response);
				break;

			case "/company":
				showcompany(request, response);
				break;

			case "/course":
				showcourse(request, response);
				break;

			case "/frequency":
				showfrequency(request, response);
				break;

			case "/student":
				showstudent(request, response);
				break;

			case "/subject":
				showsubject(request, response);
				break;

			case "/teacher":
				showteacher(request, response);
				break;

			case "/showupdatecompany":
				showCompanyupdate(request, response);
				break;

			case "/insertcompany":
				insertCompany(request, response);
				break;

			case "/removecompany":
				removeCompany(request, response);
				break;

			case "/updatecompany":
				updateCompany(request, response);
				break;

			case "/listcompany":
				listCompany(request, response);
				break;

			case "/showupdatecourse":
				showCourseupdate(request, response);
				break;

			case "/insertcourse":
				insertCourse(request, response);
				break;

			case "/removecourse":
				removeCourse(request, response);
				break;

			case "/updatecourse":
				updateCourse(request, response);
				break;

			case "/listcoure":
				listCourse(request, response);
				break;

			case "/showupdatefrequency":
				showFrequencyupdate(request, response);
				break;

			case "/insertfrequency":
				insertFrequency(request, response);
				break;

			case "/updatefrequency":
				updateFrequency(request, response);
				break;

			case "/list frequency":
				listFrequency(request, response);
				break;

			case "/showupdatestudent":
				showStudentupdate(request, response);
				break;

			case "/shouwcompanystudent":
				showStudentcompany(request, response);
				break;

			case "/showcoursestudent":
				showStudentcourse(request, response);
				break;

			case "/insertstudent":
				insertStudent(request, response);
				break;

			case "/removestudent":
				removeStudent(request, response);
				break;

			case "/updatestudent":
				updateStudent(request, response);
				break;

			case "/liststundet":
				listStudent(request, response);
				break;

			case "/showupdatesubject":
				showSubjectupdate(request, response);
				break;

			case "/insertsubject":
				insertSubject(request, response);
				break;

			case "/removesubject":
				removeSubject(request, response);
				break;

			case "/updatesubject":
				updateSubject(request, response);
				break;

			case "/listsubect":
				listSubject(request, response);
				break;

			case "/showupdateteacher":
				showTeacherupdate(request, response);
				break;

			case "/insertteacher":
				insertTeacher(request, response);
				break;

			case "/removeteacher":
				removeTeacher(request, response);
				break;

			case "/updateteacher":
				updateTeacher(request, response);
				break;

			case "/listteacher":
				listTeacher(request, response);
				break;

			default:
				errorpage(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showoptions(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-options.jsp");
		dispatcher.forward(request, response);

	}

	private void showcompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-company.jsp");
		dispatcher.forward(request, response);

	}

	private void showcourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-course.jsp");
		dispatcher.forward(request, response);

	}

	private void showfrequency(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-frequency.jsp");
		dispatcher.forward(request, response);

	}

	private void showstudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-student.jsp");
		dispatcher.forward(request, response);

	}

	private void showsubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-subject.jsp");
		dispatcher.forward(request, response);

	}

	private void showteacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-teacher.jsp");
		dispatcher.forward(request, response);

	}

	private void listCompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Company> companys = companydao.listCompany();
		request.setAttribute("companys", companys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-company.jsp");
		dispatcher.forward(request, response);
	}

	private void showCompanyupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Company company = companydao.recoverCompany(new Company(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-company.jsp");
		request.setAttribute("company", company);
		dispatcher.forward(request, response);
	}

	private void insertCompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		companydao.insertCompany(new Company(name, cnpj, email, address, phone));
		response.sendRedirect("list");
	}

	private void updateCompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		companydao.updateCompany(new Company(name, cnpj, email, address, phone));
		response.sendRedirect("list");
	}

	private void removeCompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Company company = companydao.recoverCompany(new Company(id));
		companydao.removeCompany(company);
		response.sendRedirect("list");
	}

	private void listCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Course> courses = coursedao.listCourse();
		request.setAttribute("courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-course.jsp");
		dispatcher.forward(request, response);
	}

	private void showCourseupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Course course = coursedao.recoverCourse(new Course(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-course.jsp");
		request.setAttribute("course", course);
		dispatcher.forward(request, response);
	}

	private void insertCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		coursedao.insertCourse(new Course(name));
		response.sendRedirect("list");
	}

	private void updateCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		coursedao.updateCourse(new Course(name));
		response.sendRedirect("list");
	}

	private void removeCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Course course = coursedao.recoverCourse(new Course(id));
		coursedao.removeCourse(course);
		response.sendRedirect("list");
	}

	private void listFrequency(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Frequency> frequencys = frequencydao.listFrequency();
		request.setAttribute("frequencys", frequencys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-frequency.jsp");
		dispatcher.forward(request, response);
	}

	private void showFrequencyupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Frequency frequency = frequencydao.recoverFrequency(new Frequency(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-frequency.jsp");
		request.setAttribute("frequency", frequency);
		dispatcher.forward(request, response);
	}

	private void insertFrequency(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		FrequencyStatus status = FrequencyStatus.values()[Integer.parseInt(request.getParameter("frequency"))];
		Student student = (Student) request.getAttribute("student");
		frequencydao.insertFrequency(new Frequency(status, student));
		response.sendRedirect("list");
	}

	private void updateFrequency(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		FrequencyStatus status = FrequencyStatus.values()[Integer.parseInt(request.getParameter("frequency"))];
		Student student = (Student) request.getAttribute("student");
		frequencydao.updateFrequency(new Frequency(status, student));
		response.sendRedirect("list");
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Student> students = studentdao.listStudent();
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);
	}

	private void showStudentcompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		Company company = companydao.recoverCompany(new Company(id));
    List<Student> students = studentdao.listStudentsToCompany(company);
    request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student-company.jsp");
		dispatcher.forward(request, response);
	}

	private void showStudentcourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		Course course = coursedao.recoverCourse(new Course(id));
		List<Student> students = studentdao.listStudentsToCourse(course);
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student-course.jsp");
		dispatcher.forward(request, response);
	}

	private void showStudentupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Student student = studentdao.recoverStudent(new Student(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-student.jsp");
		request.setAttribute("student", student);
		dispatcher.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		studentdao.insertStudent(new Student(name, cpf, email));
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		studentdao.updateStudent(new Student(name, cpf, email));
		response.sendRedirect("list");
	}

	private void removeStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Student student = studentdao.recoverStudent(new Student(id));
		studentdao.removeStudent(student);
		response.sendRedirect("list");
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Subject> subjects = subjectdao.listSubject();
		request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-subject.jsp");
		dispatcher.forward(request, response);
	}

	private void showSubjectupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Subject subject = subjectdao.recoverSubject(new Subject(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-subject.jsp");
		request.setAttribute("subject", subject);
		dispatcher.forward(request, response);
	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		subjectdao.insertSubject(new Subject(name));
		response.sendRedirect("list");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		subjectdao.updateSubject(new Subject(name));
		response.sendRedirect("list");
	}

	private void removeSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Subject subject = subjectdao.recoverSubject(new Subject(id));
		subjectdao.removeSubject(subject);
		response.sendRedirect("list");
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Teacher> teachers = teacherdao.listTeacher();
		request.setAttribute("teachers", teachers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-teacher.jsp");
		dispatcher.forward(request, response);
	}

	private void showTeacherupdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Teacher teacher = teacherdao.recoverTeacher(new Teacher(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-teacher.jsp");
		request.setAttribute("teacher", teacher);
		dispatcher.forward(request, response);
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cpf = request.getParameter("cnpj");
		String email = request.getParameter("email");
		teacherdao.insertTeacher(new Teacher(name, cpf, email));
		response.sendRedirect("list");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");
		String cpf = request.getParameter("cnpj");
		String email = request.getParameter("email");
		teacherdao.updateTeacher(new Teacher(name, cpf, email));
		response.sendRedirect("list");
	}

	private void removeTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Teacher teacher = teacherdao.recoverTeacher(new Teacher(id));
		teacherdao.removeTeacher(teacher);
		response.sendRedirect("list");

	}

	private void errorpage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
	}
}
