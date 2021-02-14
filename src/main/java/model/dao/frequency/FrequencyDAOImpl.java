package model.dao.frequency;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.frequency.Frequency;
import model.factory.connection.ConnectionFactory;

public class FrequencyDAOImpl implements FrequencyDAO {

	private ConnectionFactory factory;

	public FrequencyDAOImpl() {
		factory = new ConnectionFactory();

	}

	public void insertFrequency(Frequency frequency) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(frequency);

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

	public void removeFrequency(Frequency frequency) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(frequency);

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

	public void updateFrequency(Frequency frequency) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(frequency);

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

	public Frequency recoverFrequency(Frequency frequency) {

		Session session = null;
		Frequency recoverFrequency = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Frequency> criteria = cb.createQuery(Frequency.class);
			Root<Frequency> rootCustomer = criteria.from(Frequency.class);

			criteria.select(rootCustomer);

			ParameterExpression<Long> idFrequency = cb.parameter(Long.class);
			criteria.where(cb.equal(rootCustomer.get("id"), idFrequency));

			recoverFrequency = session.createQuery(criteria).setParameter(idFrequency, frequency.getId()).getSingleResult();

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

		return recoverFrequency;
	}

	public List<Frequency> listFrequency() {

		Session session = null;
		List<Frequency> frequency = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Frequency> criteria = cb.createQuery(Frequency.class);
			Root<Frequency> rootCustomer = criteria.from(Frequency.class);

			criteria.select(rootCustomer);

			frequency = session.createQuery(criteria).getResultList();

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

		return frequency;

	}
}