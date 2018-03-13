package com.avd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="lu_category")
public class Lu_Category implements Serializable{
	  private static final long serialVersionUID =1L;
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "CATEGORY_ID")
	    private Integer categoryId;
	   
	    @Column(name="CATEGORY_NAME")
	    private String categoryName;

	    @Column(name="IS_ACTIVE")
	    private String isActive;
	  
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public String getIsActive() {
			return isActive;
		}


		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}


		public Integer getCategoryId() {
			return categoryId;
		}


		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}


		public String getCategoryName() {
			return categoryName;
		}


		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}


}
