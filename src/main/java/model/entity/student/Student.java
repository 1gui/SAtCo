package model.entity.student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entity.company.Company;
import model.entity.course.Course;
import model.entity.frequency.Frequency;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_course")
	private Course course;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_company")
	private Company company;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_student")
	private List<Frequency> frequencys = new ArrayList<Frequency>();

	public Student() {
	}

	public Student(Long id) {
		setId(id);
	}
	
	public Student(String name, String cpf, String email) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
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

	public void addFrequency(Frequency frequency) {
		frequencys.add(frequency);
	}
	
	public void removeFrequency(Frequency frequency) {
		frequencys.remove(frequency);
	}
	
	public List<Frequency> getFrequencys() {
		return frequencys;
	}

	

	
}