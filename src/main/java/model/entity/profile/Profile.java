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
	@Column(name = "id_profile")
	private Long id;

	@Column(name = "login_profile", length = 20, nullable = false, unique = true)
	private String login;


	public Profile() {
	}

	public Profile(Long id, String login) {
		setId(id);
		setLogin(login);
	}

	public Profile(String login) {
		setLogin(login);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
