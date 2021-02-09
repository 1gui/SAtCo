package model.entity.position;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.entity.profile.Profile;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_position")
	private Long id;

	@Column(name = "name_position", length = 40, nullable = false, unique = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile")
	private Profile profile;

	public Position() {
	}

	public Position(Long id) {
		setId(id);
	}

	public Position(Long id, String name, Profile profile) {
		setId(id);
		setName(name);
		setProfile(profile);
	}

	public Position(String name, Profile profile) {
		setName(name);
		setProfile(profile);
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
