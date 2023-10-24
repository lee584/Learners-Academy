package com.dao;

import javax.transaction.Transaction;

import com.bean.Admin;

import util.HibernateUtil;

public class Login {
	

		public Admin loginCheck(String username, String password) {
			Transaction transaction = null;
			Admin admin= null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				admin = (Admin)session.get(Admin.class, username);
				if(admin!=null) {
					if(!(admin.getPassword().equals(password))) {
						admin=null;
					}
				}
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					//transaction.rollback();
				}
				e.printStackTrace();
			}
			return admin;
		}
	}

