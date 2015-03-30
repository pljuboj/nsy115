package dao;
// default package
// Generated 29 mars 2015 16:42:25 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import model.Partie;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Partie.
 * 
 * @see .Partie
 * @author Hibernate Tools
 */
public class PartieHome {


	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public void persist(Partie transientInstance) {
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Partie instance) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Partie instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Partie persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Partie merge(Partie detachedInstance) {
		try {
			Partie result = (Partie) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Partie findById(java.lang.Integer id) {
		try {
			Partie instance = (Partie) sessionFactory.getCurrentSession().get(
					"Partie", id);
			if (instance == null) {
			} else {
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByExample(Partie instance) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Partie").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
