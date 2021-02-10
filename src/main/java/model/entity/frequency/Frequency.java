package model.entity.frequency;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.enumeration.frequency.FrequencyStatus;

@Entity
@Table(name = "frequency")
public class Frequency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "status_frequency", nullable = false)
	@Enumerated(EnumType.STRING)
	private FrequencyStatus status;

	@Column(name = "date_frequency")
	private Date date;

	@Column(name = "jusfied_frequency", length = 40, nullable = true, unique = false)
	private String jusfied;

	public Frequency(FrequencyStatus status) {
		setStatus(status);
		new Date();
	}

	public Frequency(String jusfied) {
		setJusfied(jusfied);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJusfied() {
		return jusfied;
	}

	public void setJusfied(String jusfied) {
		this.jusfied = jusfied;
	}

	public FrequencyStatus getStatus() {
		return status;
	}

	public void setStatus(FrequencyStatus status) {
		this.status = status;
	}
}