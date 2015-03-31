package dao;
// default package
// Generated 29 mars 2015 16:42:25 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Joueur;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Joueur.
 * 
 * @see .Joueur
 * @author Hibernate Tools
 */
public class JoueurHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public void save(Joueur joueur) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(joueur);
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
}
