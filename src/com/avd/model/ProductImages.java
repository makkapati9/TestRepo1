package com.avd.model;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_product_images")
public class ProductImages implements Serializable {
	
	
	@Id
	@Column(name = "P_ID")
	public Integer productId;
	
	
	
	@Column(name = "CATEGORY_ID")
	public Integer categoryId;
	
	@Column(name = "SUB_CATEGORY_ID")
	public Integer subCategoryId;
	
	
	@Column(name = "PRODUCT_IMAGE_LARGE")
	public Clob productImageLarge;

	@Column(name = "PRODUCT_IMAGE_MEDIUM")
	public Clob productImageMedium;
	
	@Id
	@Column(name = "IMAGE_ID")
	public Integer imageId;

	
	
		public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public Clob getProductImageLarge() {
		return productImageLarge;
	}

	public void setProductImageLarge(Clob productImageLarge) {
		this.productImageLarge = productImageLarge;
	}

	public Clob getProductImageMedium() {
		return productImageMedium;
	}

	public void setProductImageMedium(Clob productImageMedium) {
		this.productImageMedium = productImageMedium;
	}

	

	

}
