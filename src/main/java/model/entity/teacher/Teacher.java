package model.entity.teacher;

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
import javax.persistence.Table;

import model.entity.course.Course;
import model.entity.subject.Subject;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher")
	private Long id;

	@Column(name = "name_teacher", length = 25, nullable = false, unique = false)
	private String name;

	@Column(name = "cpf_teacher", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "email_teacher", length = 50, nullable = false, unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subject")
	private List<Subject> subjects = new ArrayList<Subject>();


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course")
	private List<Course> courses = new ArrayList<Course>();

	public Teacher() {
	}

	public Teacher(String name, String cpf, String email) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
	}

	public Teacher(Long id, String name, String cpf, String email) {
		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);
	}

	public Teacher(String name, String cpf, String email, List<Subject> subject) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setSubjects(subject);

	}

	public Teacher(Long id, String name, String cpf, String email, List<Subject> subject) {
		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setSubjects(subject);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(Subject subject) {
		((List<Subject>) subjects).add(subject);
	}

	public void removeSubject(Subject subject) {
		((List<Subject>) subjects).remove(subject);
	}


	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		((List<Course>) courses).add(course);
	}
	
	public void removeCourse(Course course) {
		((List<Course>) courses).remove(course);
	}

}
