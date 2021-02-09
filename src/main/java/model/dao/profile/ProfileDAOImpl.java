package model.dao.profile;

import org.hibernate.Session;

import model.entity.profile.Profile;
import model.factory.connection.ConnectionFactory;

public class ProfileDAOImpl implements ProfileDAO {

	private ConnectionFactory factory;

	public ProfileDAOImpl() {

		factory = new ConnectionFactory();
	}

	public void insertProfile(Profile profile) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(profile);

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

	public void removeProfile(Profile profile) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(profile);

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

	public void updateProfile(Profile profile) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(profile);

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

}