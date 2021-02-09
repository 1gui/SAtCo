package model.dao.subject;

import java.util.List;

import model.entity.subject.Subject;

public interface SubjectDAO {

	void insertSubject(Subject subject);

	void removeSubject(Subject subject);

	void updateSubject(Subject subject);

	List<Subject> listSubject();
}