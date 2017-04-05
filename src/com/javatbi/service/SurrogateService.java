package com.javatbi.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javatbi.hibernate.util.HibernateUtil;
import com.javatbi.model.Surrogate;
import com.javatbi.model.User;

public class SurrogateService {
	public boolean register(Surrogate surr) {
		Session session = HibernateUtil.openSession();
		if (isSurrogateExists(surr))
			return false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(surr);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isSurrogateExists(Surrogate surr) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Surrogate_table where SURR_Id='"
					+ surr.getSurr_id() + "'");
			Surrogate u = (Surrogate) query.uniqueResult();
			tx.commit();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
}