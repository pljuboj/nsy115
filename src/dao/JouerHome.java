package dao;
// default package
// Generated 29 mars 2015 16:42:25 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Jouer;
import model.JouerId;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Jouer.
 * 
 * @see .Jouer
 * @author Hibernate Tools
 */
public class JouerHome {


	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public void persist(Jouer transientInstance) {
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Jouer instance) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Jouer instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Jouer persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Jouer merge(Jouer detachedInstance) {
		try {
			Jouer result = (Jouer) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Jouer findById(JouerId id) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Jouer instance = (Jouer) sessionFactory.getCurrentSession().get(
					"Jouer", id);
			sessionFactory.getCurrentSession().beginTransaction().commit();
			if (instance == null) {
			} else {
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByExample(Jouer instance) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Jouer").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
