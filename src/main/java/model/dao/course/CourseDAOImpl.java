package model.dao.course;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.course.Course;
import model.factory.connection.ConnectionFactory;

public class CourseDAOImpl implements CourseDAO {

	private ConnectionFactory factory;

	public CourseDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertCourse(Course course) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(course);

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

	public void removeCourse(Course course) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(course);

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

	public void updateCourse(Course course) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(course);

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

	public List<Course> listCourse() {

		Session session = null;
		List<Course> course = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<Course> criteria = construtor.createQuery(Course.class);
			Root<Course> rootCustomer = criteria.from(Course.class);

			criteria.select(rootCustomer);

			course = session.createQuery(criteria).getResultList();

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

		return course;

	}
}