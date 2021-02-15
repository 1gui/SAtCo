/*package control.main;

import java.util.List;

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
import model.entity.position.Position;
import model.entity.profile.Profile;
import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
import model.enumeration.frequency.FrequencyStatus;



public class Main {

	public static void main(String[] args) {

		

		//teacher
		//frequency
		//student
		//subject
		//course
		

		// teacher
		// frequency
		// student
		// subject
		// course


		Company company = new Company("HBSIS", "12341234123", "hbsis@mail.com", "R. aquela rua la tlg", "47931313131");
		Subject subject = new Subject("Geografia");
		Course course = new Course("Javaweb", subject);
		Student student = new Student("Guilherme", "12312312", "gui123@email.com", course, company);

		Teacher teacher = new Teacher("João", "1212", "joaozinho@email.com");
		
		FrequencyStatus status = FrequencyStatus.values()[0];
		Frequency frequency =  new Frequency();
		Profile profile = new Profile();
		Position position = new Position();

		

		CompanyDAO companydao = new CompanyDAOImpl();
		SubjectDAO subjectdao = new SubjectDAOImpl();
		TeacherDAO teacherdao = new TeacherDAOImpl();
		CourseDAO coursedao = new CourseDAOImpl();
		StudentDAO studentdao = new StudentDAOImpl();
		FrequencyDAO frequencydao = new FrequencyDAOImpl();
		
		
		companydao.insertCompany(company);
		subjectdao.insertSubject(subject);
		coursedao.insertCourse(course);
		teacherdao.insertTeacher(teacher);
		studentdao.insertStudent(student);
		
		teacher.addSubject(subject);
		teacher.addCourse(course);

		student.setCourse(course);		
		frequency.setStatus(status);
		frequency.setStudent(student);
		
		course.addTeacher(teacher);
		course.addSubject(subject);
		
		teacherdao.updateTeacher(teacher);
		coursedao.updateCourse(course);
		studentdao.updateStudent(student);
		
		frequencydao.insertFrequency(frequency);
		
		
		List<Student> students = studentdao.listStudentsToCourse(course);
		
		for(Student studentsRecover : students) {
			
			System.out.println("Nome: " + studentsRecover.getName());
			
		}
	}
}
*/