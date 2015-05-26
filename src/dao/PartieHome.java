package dao;
// default package
// Generated 29 mars 2015 16:42:25 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.List;

import model.Partie;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Home object for domain model class Partie.
 * 
 * @see .Partie
 * @author Hibernate Tools
 */
public class PartieHome {

	private static SessionFactory sessionFactory = getSessionFactory();
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;		
	}

	public Integer save(Partie partie) {
		Session session = sessionFactory.openSession();
		Serializable ser = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ser = session.save(partie);
			tx.commit();			
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
		return (Integer)ser;
	}

	public Partie findById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Partie partie = (Partie) session.get(Partie.class, id);
			tx.commit();
			return partie;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
	
	public Partie get(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Partie partie = (Partie) session.get(Partie.class, id);
			if(partie!=null){
				Hibernate.initialize(partie.getJoueurs());				
			}
			tx.commit();
			return partie;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
	
	public Partie delete(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Partie partie = (Partie) session.get(Partie.class, id);
			Hibernate.initialize(partie.getJoueurs());
			session.delete(partie);
			tx.commit();
			return partie;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
	
	public List<Partie> fetchAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Partie.class);
			@SuppressWarnings("unchecked")
			List<Partie> parties = cr.list();
			for(Partie partie : parties){
				Hibernate.initialize(partie.getJoueurs());				
			}
			tx.commit();
			return parties;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
}
