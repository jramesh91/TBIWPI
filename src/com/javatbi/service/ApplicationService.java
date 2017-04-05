package com.javatbi.service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javatbi.hibernate.util.HibernateUtil;
import com.javatbi.model.Application;
import com.javatbi.model.Surrogate;
import com.javatbi.model.User;

public class ApplicationService {

	public static long application_id;
	
	public boolean register(Application app) {
		Session session = HibernateUtil.openSession();
		if (isApplicationExists(app))
			return false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(app);
			tx.commit();
			application_id = app.getApp_id();
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

	public boolean isApplicationExists(Application app) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Application where APP_Id='"
					+ app.getApp_id() + "'");
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