package control.main;

import model.dao.company.CompanyDAO;
import model.dao.company.CompanyDAOImpl;
import model.dao.course.CourseDAO;
import model.dao.course.CourseDAOImpl;
import model.dao.frequency.FrequencyDAO;
import model.dao.frequency.FrequencyDAOImpl;
import model.dao.position.PositionDAO;
import model.dao.position.PositionDAOImpl;
import model.dao.profile.ProfileDAO;
import model.dao.profile.ProfileDAOImpl;
import model.dao.student.StudentDAO;
import model.dao.student.StudentDAOImpl;
import model.dao.subject.SubjectDAO;
import model.dao.subject.SubjectDAOImpl;
import model.dao.teacher.TeacherDAO;
import model.dao.teacher.TeacherDAOImpl;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.frequency.Frequency;
import model.entity.position.Position;
import model.entity.profile.Profile;
import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
import model.entity.user.User;

public class Main {

	public static void main(String[] args) {

		// teacher
		// frequency
		// student
		// subject
		// course

		Company company = new Company();
		Subject subject = new Subject("Geografia");
		Teacher teacher = new Teacher("João", "12341234", "joaozinho@email.com");
		Course course = new Course("Javaweb", subject);
		Student student = new Student("Guilherme", "12312312", "gui123@email.com", course, company);
		Frequency frequency = new Frequency(null, student);
		User user = new User();
		Profile profile = new Profile();
		Position position = new Position();

		CompanyDAO companydao = new CompanyDAOImpl();
		SubjectDAO subjectdao = new SubjectDAOImpl();
		TeacherDAO teacherdao = new TeacherDAOImpl();
		CourseDAO coursedao = new CourseDAOImpl();
		StudentDAO studentdao = new StudentDAOImpl();
		FrequencyDAO frequencydao = new FrequencyDAOImpl();
		UserDAO userdao = new UserDAOImpl();
		ProfileDAO profiledao = new ProfileDAOImpl();
		PositionDAO positiondao = new PositionDAOImpl();
		
		companydao.insertCompany(company);
		subjectdao.insertSubject(subject);
		teacherdao.insertTeacher(teacher);
		coursedao.insertCourse(course);
		studentdao.insertStudent(student);
		frequencydao.insertFrequency(frequency);
		userdao.insertUser(user);
		profiledao.insertProfile(profile);
		positiondao.insertPosition(position);

	}
}
