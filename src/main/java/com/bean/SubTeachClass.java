package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
	@NamedNativeQueries({
	    @NamedNativeQuery(name = "GET_CLASS_REPORT_BY_CLASS_ID", query = "select * from subject_teacher_class where cid=:cid"),
	    @NamedNativeQuery(name = "GET_CLASS_REPORT", query = "select * from sub_teacher_class", resultClass = SubTeachClass.class)
	})
	@Table(name = "sub_teacher_class")
	public class SubTeachClass {
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		@Column(name = "cid")
		private int classId;


		@Override
		public String toString() {
			return "SubTeachClass [id=" + id + ", classId=" + classId + ", subjectId="  + ", TeacherId="
					 + ", className=" + className + ", teacherFname=" + teacherFname + ", teacherLname="
					 + ", subjectName=" + subjectName + "]";
		}


		@Column(name="class")
		private String className;
		
		@Column(name="teacherFname")
		private String teacherFname;
		
		
		@Column(name="subject")
		private String subjectName;
		
		public String getClassName() {
			return className;
		}


		public void setClassName(String className) {
			this.className = className;
		}


		public String getTeacherFname() {
			return teacherFname;
		}


		public void setTeacherFname(String teacherFname) {
			this.teacherFname = teacherFname;
		}


		public String getSubjectName() {
			return subjectName;
		}


		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}


		public int getClassId() {
			return classId;
		}


		public void setClassId(int classId) {
			this.classId = classId;
		}

		
	}




