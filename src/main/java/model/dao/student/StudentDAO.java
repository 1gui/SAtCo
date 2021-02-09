package model.dao.student;

import java.util.List;

import model.entity.student.Student;

public interface StudentDAO {

	void insertStudent(Student student);

	void removeStudent(Student student);

	void updateStudent(Student student);

	List<Student> listStudent();
}