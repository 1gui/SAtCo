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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entity.course.Course;
import model.entity.subject.Subject;
import model.entity.user.User;

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
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

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


	public void addSubject(Subject subject) {
		((List<Subject>) getSubjects()).add(subject);
	}

	public void removeSubject(Subject subject) {
		((List<Subject>) getSubjects()).remove(subject);
	}

	
	public void addCourse(Course course) {
		((List<Course>) getCourses()).add(course);
	}
	
	public void removeCourse(Course course) {
		((List<Course>) getCourses()).remove(course);
	}

	public List<Course> getCourses() {
		return courses;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
