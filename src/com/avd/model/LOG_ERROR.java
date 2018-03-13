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
@Table(name="log_payment_fail")
public class LOG_ERROR implements Serializable{
	  private static final long serialVersionUID =1L;
	
	 	@Id
	 	@GenericGenerator(name = "mygen3", strategy = "increment")
	 	@GeneratedValue(generator = "mygen3")
	    @Column(name = "ID")
	    private Integer Id;
	   
	    @Column(name="ORDER_ID")
	    private String orderId;

	    @Column(name="PAYMENT_ID")
	    private String paymentId;
	    
	    @Column(name="EMAIL")
	    private String email;
	    
	    @Column(name="CREATED_AT")
	    private Timestamp createdAt;
	  
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Timestamp getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}


}
