package model.entity.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "subject")
public class Subject {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subject")
	private Long id;
	
	
	@Column(name = "name_subject", length = 40, nullable = false, unique = false)
	private String name;
	
	

	@Column(name = "teacher_subject")
	private Long teacher;
	
	public Subject() {}

	public Subject(Long id, String name, Long teacher) {

		setId(id);
		setName(name);
		setTeacher(teacher);

	}

	public Subject(String name, Long teacher) {

		setName(name);
		setTeacher(teacher);

	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTeacher(Long teacher) {
		this.teacher = teacher;
	}

	public Long getTeacher() {
		return teacher;
	}
}