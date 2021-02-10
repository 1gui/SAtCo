package control.main;


import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.frequency.Frequency;
import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;


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
		
		
		
		
	}
}
