package com.avd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="lu_sub_category")
public class LU_SUB_CATEGORY implements Serializable{
	  private static final long serialVersionUID =1L;
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "CATEGORY_ID")
	    private Integer categoryId;
	 	
	 	@Column(name = "SUB_CATEGORY_ID")
		    private Integer subCategoryId;
	   
	    @Column(name="SUB_CATEGORY_DESC")
	    private String subCategoryDesc;

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


		public Integer getSubCategoryId() {
			return subCategoryId;
		}


		public void setSubCategoryId(Integer subCategoryId) {
			this.subCategoryId = subCategoryId;
		}


		public String getSubCategoryDesc() {
			return subCategoryDesc;
		}


		public void setSubCategoryDesc(String subCategoryDesc) {
			this.subCategoryDesc = subCategoryDesc;
		}


}
