package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity

	@Table(name="subject")
	@NamedNativeQuery(name = "GET_ALL_SUBJECTS", query = "select * from subject", resultClass = Subject.class)
	public class Subject {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int sub_id;
		
		@Column(nullable = false)
		private String sub_name;
		


		public int getSub_id() {
			return sub_id;
		}

		public void setSub_id(int sub_id) {
			this.sub_id = sub_id;
		}

		public String getSub_name() {
			return sub_name;
		}

		public void setSub_name(String sub_name) {
			this.sub_name = sub_name;
		}
		
	}




