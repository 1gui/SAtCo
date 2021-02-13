package model.dao.student;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.course.Course;
import model.entity.student.Student;
import model.factory.connection.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {

	private ConnectionFactory factory;

	public StudentDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertStudent(Student student) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public void removeStudent(Student student) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(student);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public void updateStudent(Student student) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(student);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public List<Student> listStudent() {

		Session session = null;
		List<Student> student = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<Student> criteria = construtor.createQuery(Student.class);
			Root<Student> rootCustomer = criteria.from(Student.class);

			criteria.select(rootCustomer);

			student = session.createQuery(criteria).getResultList();

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return student;

	}

	public List<Student> listStudentsToCourse(Course course) {

		Session session = null;
		List<Student> student = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
			Root<Student> rootCustomer = criteria.from(Student.class);

			Join<Student, Course> JoinCourse = rootCustomer.join(Course_.student);

			ParameterExpression<Long> idCourse = cb.parameter(Long.class);
			criteria.where(cb.equal(JoinCourse.get(Course_.id), idCourse));

			student = session.createQuery(criteria).setParameter(idCourse, course.getId()).getResultList();

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return student;

	}
}