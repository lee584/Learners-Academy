package com.dao;

import java.util.List;

import javax.transaction.Transaction;

import util.HibernateUtil;

public class Subject {
public List<Subject> showAllSubjects() {
		
		Transaction transaction = null;
		List <Subject> subjects = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			subjects = session.createNamedQuery("GET_ALL_SUBJECTS", Subject.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return subjects;
}
	
public Subject selectSubject(int id) {
		
		Transaction transaction = null;
		Subject subject= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return subject;
	}
	public void addSubject(Subject subject) {
	
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.persist(subject);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void updateSubject(Subject subject) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.update(subject);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void deleteSubject(Subject subject) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.delete(subject);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

}
