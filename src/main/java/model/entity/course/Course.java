package model.entity.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;



@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course")
	private Long id;

	@Column(name = "name_course", length = 20, nullable = false, unique = false)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subject")
	private List<Subject> subjects = new ArrayList<Subject>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Teacher> teachers = new ArrayList<Teacher>();

	public Course() {
	}

	public Course(Long id) {
		setId(id);
	}

	public Course(String name, Subject subjects) {
		setName(name);
	}

	public Course(Long id, String name, Subject subjects) {
		setId(id);
		setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	
	
	public void addSubject(Subject subject) {
		((List<Subject>) subjects).add(subject);
	}

	public void removeSubject(Subject subject) {
		((List<Subject>) subjects).remove(subject);
	}


	public List<Student> getStudents() {
		return students;
	}

	public void addSubject(Student student) {
		((List<Student>) students).add(student);
	}

	public void removeSubject(Student student) {
		((List<Student>) students).remove(student);
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void addTeacher(Teacher teacher) {
		((List<Teacher>) teachers).add(teacher);
	}

	public void removeTeacher(Teacher teacher) {
		((List<Teacher>)teachers).remove(teacher);
	}
	
}
