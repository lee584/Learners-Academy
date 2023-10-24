package com.dao;

import javax.transaction.Transaction;

import com.bean.Admin;

import util.HibernateUtil;


public class Password {
	

	public boolean resetPassword(Admin admin,String pwd) {
		boolean isChanged = false;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			admin.setPassword(pwd);
			session.update(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return isChanged;
	}
}

