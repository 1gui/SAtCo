package control.main;

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


import model.dao.company.CompanyDAO;
import model.entity.company.Company;


import model.dao.company.CompanyDAO;
import model.entity.company.Company;


public class Main {

	public static void main(String[] args) {

		//teacher
		//frequency
		//student
		//subject
		//course
		
		Company company = new Company();
		Subject subject = new Subject("Geografia");
		Teacher teacher = new Teacher("João", "12341234", "joaozinho@email.com");
		Course course = new Course("Javaweb", subject);
		Student student = new Student("Guilherme", "12312312", "gui123@email.com", course, company);
		Frequency frequency = new Frequency(null, student);
		
		
		CompanyDAO companydao = new CompanyDAOImpl();
		SubjectDAO subjectdao = new SubjectDAOImpl();
		TeacherDAO teacherdao = new TeacherDAOImpl();
		CourseDAO coursedao = new CourseDAOImpl();
		StudentDAO studentdao = new StudentDAOImpl();
		FrequencyDAO frequencydao = new FrequencyDAOImpl();
	
		companydao.insertCompany(company);
		subjectdao.insertSubject(subject);
		teacherdao.insertTeacher(teacher);
		coursedao.insertCourse(course);
		studentdao.insertStudent(student);
		frequencydao.insertFrequency(frequency);
		

		CompanyDAO companyDAO = new CompanyDAOIMPL();
		//PositionDAO positionDAO = new positionDAOIMPL();
		//ProfileDAO profileDAO = new profileDAOIMPL();
		//UserDAO userDAO = new userDAOIMPL();
		
		String name = "AmbevTech";
		String cnpj = "192.324.124-59";
		String email = "ambevtech@gmail.com";
		String address = "rua gasparzinho";
		int phone = 47932019392;
		
		Company company = new Company();
		
		company.setName(name);
		company.setCnpj(cnpj);
		company.setEmail(email);
		company.setAddress(address);
		company.setPhone(phone);
		
		CompanyDAO.insertCompany(company);

	}
}
