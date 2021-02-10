package model.entity.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import model.entity.course.Course;
import model.entity.teacher.Teacher;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subject")
	private Long id;

	@Column(name = "name_subject", length = 40, nullable = false, unique = false)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course")
	private Course course;

	public Subject() {
	}
	
	public Subject(String name) {
		setName(name);
	}

	public Subject(Long id, String name, Teacher teacher) {

		setId(id);
		setName(name);
		setTeacher(teacher);

	}

	public Subject(String name, Teacher teacher) {

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

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

}