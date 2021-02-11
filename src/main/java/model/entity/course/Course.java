package model.entity.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7c1b684143bb6c57c172e8a1ed7fdbdada747b75

import model.entity.student.Student;
import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
<<<<<<< HEAD
=======
=======
import javax.security.auth.Subject;
>>>>>>> ae5733225d3af3d7b6b6f0ac9138f525431dba01
>>>>>>> 7c1b684143bb6c57c172e8a1ed7fdbdada747b75


@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course")
	private Long id;

	@Column(name = "name_course", length = 20, nullable = false, unique = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
	private List<Subject> subjects = new ArrayList<Subject>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_student")
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher teacher;

	public Course() {
	}

	public Course(Long id) {
		setId(id);
	}

	public Course(String name, Subject subjects) {
		setName(name);
		setSubjects(subjects);
	}

	public Course(Long id, String name, Subject subjects) {
		setId(id);
		setName(name);
		setSubjects(subjects);
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

	private void setSubjects(Subject subjects) {

	}

	public void addSubject(Subject subject) {
		((List<Subject>) subjects).add(subject);
	}

	public void removeSubject(Subject subject) {
		((List<Subject>) subjects).remove(subject);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
