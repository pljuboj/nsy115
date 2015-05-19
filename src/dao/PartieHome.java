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
import org.hibernate.cfg.Configuration;

/**
 * Home object for domain model class Partie.
 * 
 * @see .Partie
 * @author Hibernate Tools
 */
public class PartieHome {


	private final SessionFactory sessionFactory = getSessionFactory();

	@SuppressWarnings("deprecation")
	protected SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
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
			Hibernate.initialize(partie.getJoueurs());
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
