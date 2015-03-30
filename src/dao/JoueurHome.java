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

	public void save(Joueur transientInstance) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(transientInstance);
			tx.commit();
		} catch (RuntimeException re) {
			throw re;
		}
		finally {
			session.close();
		}
	}

	public void attachDirty(Joueur instance) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Joueur instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Joueur persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Joueur merge(Joueur detachedInstance) {
		try {
			Joueur result = (Joueur) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Joueur findById(java.lang.String id) {
		try {
			sessionFactory.openSession().beginTransaction();
			Joueur instance = (Joueur) sessionFactory.openSession().get(
					"model.Joueur", id);
			sessionFactory.openSession().beginTransaction().commit();
			if (instance == null) {
			} else {
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByExample(Joueur instance) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Joueur").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
