package model.dao.teacher;

import java.util.List;

import model.entity.teacher.Teacher;

public interface TeacherDAO {

	void insertTeacher(Teacher teacher);

	void removeTeacher(Teacher teacher);

	void updateTeacher(Teacher teacher);
	
	Teacher recoverTeacher(Teacher teacher);

	List<Teacher> listTeacher();

}
