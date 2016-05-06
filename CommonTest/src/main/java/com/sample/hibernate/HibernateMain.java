package com.sample.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = buildSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Client client = session.get(Client.class, new Long(1));
		tx.commit();
		
		System.out.println(client.getName());
		client.setName("RABO");
		
		session = sessionFactory.getCurrentSession();
		Transaction tx3 = session.beginTransaction();
		Client client3 = session.get(Client.class, new Long(1));
		tx3.commit();
		
		client3.setCode("RABO_3");
		
		session = sessionFactory.getCurrentSession();
		Transaction tx2 = session.beginTransaction();
		Client client2 = session.get(Client.class, (long)1);
		client2.setCode("RABO_3");
		session.saveOrUpdate(client2);
		session.merge(client);
		tx2.commit();
		System.exit(0);
	}

	private static SessionFactory buildSessionAnnotationFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-annotation.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(Comment.class)
				.addAnnotatedClass(Release.class)
				.addAnnotatedClass(Script.class)
				.addAnnotatedClass(Section.class)
				.addAnnotatedClass(User.class)
				.getMetadataBuilder()
				.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
				.build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;
	}
}
