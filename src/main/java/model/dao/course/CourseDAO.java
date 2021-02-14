package model.dao.course;

import java.util.List;

import model.entity.course.Course;

public interface CourseDAO {

	void insertCourse(Course course);

	void removeCourse(Course course);

	void updateCourse(Course course);
	
	Course recoverCourse(Course course);

	List<Course> listCourse();
}
