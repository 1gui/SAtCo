package model.dao.student;

import java.util.List;

import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.student.Student;

public interface StudentDAO {

	void insertStudent(Student student);

	void removeStudent(Student student);

	void updateStudent(Student student);

	Student recoverStudent(Student student);
	
	List<Student> listStudent();
	
	List<Student> listStudentsToCourse(Course course);
	
	List<Student> listStudentsToCompany(Company company);
	
}