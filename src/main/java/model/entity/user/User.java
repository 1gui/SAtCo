package model.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entity.company.Company;
import model.entity.position.Position;
import model.entity.teacher.Teacher;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(name = "username_user", length = 20, nullable = false, unique = true)
	private String username;

	@Column(name = "password_user", length = 20, nullable = false, unique = false)
	private String password;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company")
	private Company company;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_position")
	private Position position;

<<<<<<< HEAD
=======

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;

>>>>>>> ae5733225d3af3d7b6b6f0ac9138f525431dba01
	public User() {
	}

	public User(Long id) {
		setId(id);
	}

	public User(String username, String password, String email, Company company, Position position,
			Teacher teacher) {
		setUsername(username);
		setPassword(password);
		setCompany(company);
		setPosition(position);
		setTeacher(teacher);
	}

	public User(Long id, String username, String password, String email, Company company,
			Position position, Teacher teacher) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setCompany(company);
		setPosition(position);
		setTeacher(teacher);
	}

<<<<<<< HEAD
=======

>>>>>>> ae5733225d3af3d7b6b6f0ac9138f525431dba01
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Company getCompany() {
		return company;
	}

	public Position getPosition() {
		return position;
	}

<<<<<<< HEAD
=======

>>>>>>> ae5733225d3af3d7b6b6f0ac9138f525431dba01
	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}

}
