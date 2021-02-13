package model.dao.subject;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.subject.Subject;
import model.entity.teacher.Teacher;
import model.factory.connection.ConnectionFactory;

public class SubjectDAOImpl implements SubjectDAO {

	private ConnectionFactory factory;

	public SubjectDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertSubject(Subject subject) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(subject);

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

	public void removeSubject(Subject subject) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(subject);

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

	public void updateSubject(Subject subject) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(subject);

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

	public List<Subject> listSubject() {

		Session session = null;
		List<Subject> subject = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Subject> criteria = cb.createQuery(Subject.class);
			Root<Subject> rootCustomer = criteria.from(Subject.class);

			criteria.select(rootCustomer);

			subject = session.createQuery(criteria).getResultList();

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

		return subject;

	}

	public Subject recorverSubject(Subject subject) {

		Session session = null;
		Subject recoverSubject = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Subject> criteria = cb.createQuery(Subject.class);
			Root<Subject> rootCustomer = criteria.from(Subject.class);
			
			criteria.select(rootCustomer);
			
			ParameterExpression<Long> idSubject = cb.parameter(Long.class);
			criteria.where(cb.equal(rootCustomer.get("id"), idSubject));

			recoverSubject = session.createQuery(criteria).setParameter(idSubject, subject.getId()).getSingleResult();

			session.getTransaction().commit();
		
		}	catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
		return recoverSubject;
	}
}