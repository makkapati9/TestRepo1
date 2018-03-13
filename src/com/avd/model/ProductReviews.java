package com.avd.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Product_reviews")
public class ProductReviews implements Serializable{
	  private static final long serialVersionUID =1L;
	
	 	@Id
	    @Column(name = "PRODUCT_ID")
	    private Integer productId;
	   
	 	@Id
	    @Column(name="Login_ID")
	    private String loginId;

	    @Column(name="Review")
	    private String review;
	    
	    @Column(name="IS_ACTIVE")
	    private String isActive;
	   
	    
	    
	    @Column(name="CREATED_AT")
	    private Timestamp createdAt;
	  

	    
	    
	    
		public String getIsActive() {
			return isActive;
		}

		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}

		public Timestamp getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}

		public String getReview() {
			return review;
		}

		public void setReview(String review) {
			this.review = review;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
}

