package model.entity.company;

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

import model.entity.student.Student;
import model.entity.user.User;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	private Long id;

	@Column(name = "name_company", length = 40, nullable = false, unique = true)
	private String name;

	@Column(name = "cnpj_company", length = 18, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "email_company", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "address_company", length = 140, nullable = false, unique = false)
	private String address;

	@Column(name = "phone_company", length = 20, nullable = false, unique = true)
	private String phone;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_student")
	private List<Student> students = new ArrayList<Student>();

	public Company() {
	}
	
	public Company(Long id) {
		setId(id);
	}

	public Company(String name, String cnpj, String email, String address, String phone) {
		setName(name);
		setCnpj(cnpj);
		setEmail(email);
		setAddress(address);
		setPhone(phone);

	}
	
	public Company(Long id, String name, String cnpj, String email, String address, String phone) {
		setId(id);
		setName(name);
		setCnpj(cnpj);
		setEmail(email);
		setAddress(address);
		setPhone(phone);

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	public List<Student> getStudents() {
		return students;
	}


}