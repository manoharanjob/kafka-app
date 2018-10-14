package app.kafka.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDAO {

	private static SessionFactory sessionFactory;

	@PostConstruct
	public static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

		System.out.println("DB Connection Initialized");
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		return buildSessionFactory();
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			return getSessionFactory().openSession();
		}
		return buildSessionFactory().openSession();
	}

	public static <T> void save(T object) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			session.save(object);

			session.getTransaction().commit();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> find(String query) {
		Session session = null;
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			session.beginTransaction();

			list = session.createQuery(query).list();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> find(String query, Object[] values) {
		Session session = null;
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			session.beginTransaction();

			Query hquery = session.createQuery(query);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					hquery.setParameter(i, values[i]);
				}
			}
			list = hquery.list();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> find(String query, String[] params, Object[] values) {
		Session session = null;
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			session.beginTransaction();

			Query hquery = session.createQuery(query);
			if (params != null && values != null) {
				for (int i = 0; i < values.length; i++) {
					hquery.setParameter(params[i], values[i]);
				}
			}
			list = hquery.list();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
		return list;
	}

	public static void get(Serializable id, Class claz) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			session.get(claz, id);

			session.getTransaction().commit();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
	}

	public static void deleteAllRecords(String query) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			Query queryObj = session.createQuery(query);
			queryObj.executeUpdate();

			session.getTransaction().commit();
		} catch (Exception sqlException) {
			rollback(session);
			sqlException.printStackTrace();
		} finally {
			closeSession(session);
		}
	}

	public static void rollback(Session session) {
		if (session.getTransaction() != null) {
			session.getTransaction().rollback();
		}
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}