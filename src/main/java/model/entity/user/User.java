package model.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entity.company.Company;
import model.entity.profile.Profile;
import model.entity.teacher.Teacher;
import model.enumeration.Position.PositionEnum;

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
	private Company company;

	@Column(name = "Position_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

	@OneToOne(fetch = FetchType.LAZY)
	private Teacher teacher;

	@OneToOne(fetch = FetchType.LAZY)
	private Profile profile;

	public User() {
	}

	public User(Long id) {
		setId(id);
	}

	public User(Long id, String username, String password, Company company, PositionEnum position) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setPosition(position);
	}

	public User(String username, String password, Company company) {
		setUsername(username);
		setPassword(password);
		setCompany(company);
		setPosition(position);
	}


	public User(Long id, String username, String password, Teacher teacher, PositionEnum position) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setTeacher(teacher);
		setPosition(position);
	}

	public User(String username, String password, Teacher teacher, PositionEnum position) {
		setUsername(username);
		setPassword(password);
		setTeacher(teacher);
		setPosition(position);
	}

	public User(Long id, String username, String password, Profile profile, PositionEnum position) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setProfile(profile);
		setPosition(position);
	}

	public User(String username, String password, Profile profile, PositionEnum position) {
		setUsername(username);
		setPassword(password);
		setProfile(profile);
		setPosition(position);
	}
    
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	private void setProfile(Profile profile) {
		this.profile = profile;
	}

}


