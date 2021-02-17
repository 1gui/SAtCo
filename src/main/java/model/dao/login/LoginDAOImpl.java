package model.dao.login;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.user.User;
import model.factory.connection.ConnectionFactory;

public class LoginDAOImpl implements LoginDAO {


    private ConnectionFactory factory;

    public LoginDAOImpl() {
        factory = new ConnectionFactory();

    }

    public List<User> validateUser(User user) {

        Session session = null;
        List<User> users = null;

        try {

            session = factory.getConnection().openSession();
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = cb.createQuery(User.class);
            Root<User> rootCustomer = criteria.from(User.class);

            
            Predicate predicateUserName = cb.equal(rootCustomer.get("username_user"), "username");

            Predicate predicatePassword = cb.equal(rootCustomer.get("password_user"), "password");

            Predicate predicatePositon = cb.equal(rootCustomer.get("position_user"), "position");

            Predicate predicateLSC = cb.and(predicateUserName, predicatePassword, predicatePositon);

            criteria.where(predicateLSC);

            users = session.createQuery(criteria).getResultList();

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

        return users;
    }
}

