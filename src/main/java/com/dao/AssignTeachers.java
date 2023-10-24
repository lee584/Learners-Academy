package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import com.bean.SubTeachClass;
import com.mysql.cj.Session;

import util.HibernateUtil;

public class AssignTeachers {

		
		public void AssignTeacher(SubTeachClass subTeachClass) {
				
				Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					// start a transaction
					transaction = session.beginTransaction();
					session.persist(subTeachClass);
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						//transaction.rollback();
					}
					e.printStackTrace();

				}
		}
			public List<SubTeachClass> classReportByID(int cid) {
			//boolean isAdded = false;
			Transaction transaction = null;
			List <SubTeachClass> classList = null;
			List<SubTeachClass> singleClass = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				System.out.println("Inside Dao id :"+cid);
				singleClass = new ArrayList<SubTeachClass>();
				classList = session.createNamedQuery("GET_CLASS_REPORT", SubTeachClass.class).getResultList();
				System.out.println("Class list is : "+classList.size());
				for (SubTeachClass each:classList) {
					if(each.getClassId()==cid)
						singleClass.add(each);
				}
				System.out.println("After removal "+singleClass.size());
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					//transaction.rollback();
				}
				e.printStackTrace();

			}
			return singleClass;
		}

		public void DeleteAssignTeacher(SubTeachClass subjectTeacherClass) {
			
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				session.delete(subjectTeacherClass);
				
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					//transaction.rollback();
				}
				e.printStackTrace();

			}
		}

		}


