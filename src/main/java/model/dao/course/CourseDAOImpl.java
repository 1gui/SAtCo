package model.dao.course;
 
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
	
	public Course recoverCourse(Course course) {

		Session session = null;
		Course recoverCourse = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Course> criteria = cb.createQuery(Course.class);
			Root<Course> rootCustomer = criteria.from(Course.class);

			criteria.select(rootCustomer);
			
			ParameterExpression<Long> idCourse= cb.parameter(Long.class);
			criteria.where(cb.equal(rootCustomer.get("id"), idCourse));

			recoverCourse = session.createQuery(criteria).setParameter(idCourse, course.getId()).getSingleResult();

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

		return recoverCourse;
	}

	public List<Course> listCourse() {

		Session session = null;
		List<Course> course = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Course> criteria = cb.createQuery(Course.class);
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