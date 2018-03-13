package com.avd.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name="TBL_MESSAGE_LOG")
public class TblMessageLog implements Serializable{
	  private static final long serialVersionUID =1L;
	
	 	@Id
	 	@GenericGenerator(name = "mygen1", strategy = "increment")
	 	@GeneratedValue(generator = "mygen1")
	    @Column(name = "ID")
	    private Integer Id;
	   
	    @Column(name="NAME")
	    private String name;

	    @Column(name="MESSAGE")
	    private String message;
	    
	    @Column(name="EMAIL")
	    private String email;
	    
	    @Column(name="MOBILE")
	    private String mobile;
	    
	    
	    @Column(name="CREATED_AT")
	    private Timestamp createdAt;


		public Integer getId() {
			return Id;
		}


		public void setId(Integer id) {
			Id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getMobile() {
			return mobile;
		}


		public void setMobile(String mobile) {
			this.mobile = mobile;
		}


		public Timestamp getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	  
	  
	    
}
