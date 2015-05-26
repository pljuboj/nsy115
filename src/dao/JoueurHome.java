package dao;
// default package
// Generated 29 mars 2015 16:42:25 by Hibernate Tools 3.4.0.CR1

import model.Joueur;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Home object for domain model class Joueur.
 * 
 * @see .Joueur
 * @author Hibernate Tools
 */
public class JoueurHome {

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

	public void save(Joueur joueur) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(joueur);
			tx.commit();
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
	public Joueur findById(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Joueur joueur = (Joueur) session.get(Joueur.class, id);
			tx.commit();
			return joueur;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
	
	public Joueur get(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Joueur joueur = (Joueur) session.get(Joueur.class, id);
			Hibernate.initialize(joueur.getParties());
			tx.commit();
			return joueur;
		} catch (RuntimeException re) {
			if (tx != null) tx.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
}
