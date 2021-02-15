package model.dao.company;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.company.Company;
import model.factory.connection.ConnectionFactory;

public class CompanyDAOImpl implements CompanyDAO {

	private ConnectionFactory factory;

	public CompanyDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertCompany(Company company) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(company);

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

	public void removeCompany(Company company) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(company);

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

	public void updateCompany(Company company) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(company);

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

	public Company recoverCompany(Company company) {

		Session session = null;
		Company recoverCompany = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Company> criteria = cb.createQuery(Company.class);
			Root<Company> rootCustomer = criteria.from(Company.class);

			criteria.select(rootCustomer);
			
			ParameterExpression<Long> idCompany= cb.parameter(Long.class);
			criteria.where(cb.equal(rootCustomer.get("id"), idCompany));

			recoverCompany = session.createQuery(criteria).setParameter(idCompany, company.getId()).getSingleResult();

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

		return recoverCompany;
	}
	
	public List<Company> listCompany() {

		Session session = null;
		List<Company> company = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Company> criteria = cb.createQuery(Company.class);
			Root<Company> rootCustomer = criteria.from(Company.class);

			criteria.select(rootCustomer);

			company = session.createQuery(criteria).getResultList();

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

		return company;

	}
}