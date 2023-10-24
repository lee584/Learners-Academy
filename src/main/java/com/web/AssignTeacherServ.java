package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/teacher-subject","/stcinsert","/stcdelete","/stclist",})
	public class AssignTeacherServ extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    private AssignTeacher assignTeacherDao=null;
	    
	    public AssignTeacherServ() {
	        super();
	        
	    }

		
		public void init(ServletConfig config) throws ServletException {
			assignTeacher = new AssignTeachers();
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

			String action = request.getServletPath();
			System.out.println("Servlet path "+action);

			try {
				switch (action) {
				case "/stcinsert":
					assignTeachers(request, response);
					break;
				case "/stcdelete":
					deleteAssignedTeacher(request, response);
					break;
				default:
					listClassReportById(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
		
		private void assignTeachers(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException{
			SubTeachClass subjectTeacherClass = new SubTeachClass();
			subjectTeacherClass.setClassId(Integer.parseInt((request.getParameter("cid"))));

			subjectTeacherClass.setClassName(request.getParameter("cname"));
			subjectTeacherClass.setSubjectName(request.getParameter("subject"));
			subjectTeacherClass.setTeacherFname(request.getParameter("teacher"));
	
			System.out.println("Inside Insert");
			assignTeachers.AssignTeacher(subjectTeacherClass);
			listClassReportById(request, response);
			
		}
		
		private void listClassReportById(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			Teacher teacher = new Teacher();
			Subject subject = new Subject();
			System.out.println("Inside List ");
			System.out.println("Cid inside list +"+request.getParameter("cid"));
			List<SubTeachClass> listClassReport = assignTeachers.classReportByID(Integer.parseInt(request.getParameter("cid")));
			request.setAttribute("listClassReport", listClassReport);
			List<Teacher> listTeacher = teacher.showAllTeachers();
			request.setAttribute("listTeacher", listTeacher);
			if(listClassReport.size()>0)
				request.setAttribute("className", listClassReport.get(0).getClassName());
			List<Subject> listSubject = subject.showAllSubjects();
			request.setAttribute("listSubject", listSubject);
			RequestDispatcher dispatcher = request.getRequestDispatcher("assign-teacher.jsp");
			dispatcher.forward(request, response);
		}
		
		private void deleteAssignedTeacher(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException,ServletException {
			int id = Integer.parseInt(request.getParameter("id"));
			SubTeachClass subjectTeacherClass = new SubTeachClass();
			subjectTeacherClass.setId(id);
			assignTeacher.DeleteAssignTeacher(subjectTeacherClass);
			listClassReportById(request, response);
		}
		
		

	}


