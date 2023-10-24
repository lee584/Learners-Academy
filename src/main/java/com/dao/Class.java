package com.dao;

import java.util.List;

import javax.transaction.Transaction;

import util.HibernateUtil;

public class Class {
	
	
	public List<Class> selectClass() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <Class> classes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classes = session.createNamedQuery("GET_ALL_CLASSES", Class.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classes;
}
public Class selectClass(int id) {
		
		Transaction transaction = null;
		Class classTable= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classTable = session.get(Class.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classTable;
	}

	public List<Class> showAllClasses() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <Class> classes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classes = session.createNamedQuery("GET_ALL_CLASSES", Class.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classes;
}
	public void AddClass(Class classObj) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.persist(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void updateClass(Class classObj) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.update(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
	
	public void deleteClass(Class classObj) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.delete(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
	public void setClass_name(String parameter) {
		// TODO Auto-generated method stub
		
	}
}


