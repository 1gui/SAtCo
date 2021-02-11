package model.entity.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login_profile", length = 20, nullable = false, unique = true)
	private String login;

	@Column(name = "password_profile", length = 40, nullable = false, unique = false)
	private String password;

	public Profile() {
	}

	public Profile(Long id, String login, String password) {
		setId(id);
		setLogin(login);
		setPassword(password);
	}

	public Profile(String login, String password) {
		setLogin(login);
		setPassword(password);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
