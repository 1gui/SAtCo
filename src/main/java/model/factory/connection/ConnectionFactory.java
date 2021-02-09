package model.factory.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionFactory {

	public SessionFactory getConnection() {

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(model.entity.teacher.Teacher.class);
		configuration.addAnnotatedClass(model.entity.course.Course.class);
		configuration.addAnnotatedClass(model.entity.student.Student.class);
		configuration.addAnnotatedClass(model.entity.company.Company.class);
		configuration.addAnnotatedClass(model.entity.subject.Subject.class);
		configuration.addAnnotatedClass(model.entity.profile.Profile.class);
		configuration.addAnnotatedClass(model.entity.user.User.class);
		configuration.addAnnotatedClass(model.entity.frequency.Frequency.class);
		configuration.addAnnotatedClass(model.entity.position.Position.class);

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();

		SessionFactory factorySession = configuration.buildSessionFactory(service);

		return factorySession;
	}
}