package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import util.HibernateUtil;

public class Student {


	public List<Student> showAllStudents() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			students = session.createNamedQuery("GET_ALL_STUDENTS", Student.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return students;
}
	public List<Student> GetStudentByClass(int cid) {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <Student> students = null;
		List<Student> studentByClass = new ArrayList<Student>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			students = session.createNamedQuery("GET_ALL_STUDENTS", Student.class).getResultList();
			for(Student each:students) {
				if(each.getClass_map().getCid()==cid)
					studentByClass.add(each);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return studentByClass;
}
	
	
	public void addStudent(Student student, Class sClass) {
			//boolean isAdded = false;
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				sClass = session.get(Class.class,sClass.getCid());
				student.setClass_map(sClass);
				session.persist(student);
				
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					//transaction.rollback();
				}
				e.printStackTrace();

			}

	}
	
	
	public Student selectStudent(int id) {
		
		Transaction transaction = null;
		Student student= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return student;
	}
	public void updateStudent(Student student, Class sClass) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			sClass = session.get(Class.class,sClass.getCid());
			student.setClass_map(sClass);
			session.update(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
	
	public void deleteStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.delete(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
}



