package model.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.entity.company.Company;
import model.entity.course.Course;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private Long id;

	@Column(name = "name_student", length = 40, nullable = false, unique = false)
	private String name;

	@Column(name = "cpf_student", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "email_student", length = 40, nullable = false, unique = true)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course")
	private Course course;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company")
	private Company company;

	public Student() {
	}

	public Student(Long id) {
		setId(id);
	}

	public Student(String name, String cpf, String email, Course course, Company company) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setCourse(course);
		setCompany(company);
	}

	public Student(Long id, String name, String cpf, String email, Course course, Company company) {
		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setCourse(course);
		setCompany(company);
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}