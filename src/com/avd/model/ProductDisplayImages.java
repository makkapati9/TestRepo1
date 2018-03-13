package com.avd.model;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_display_images")
public class ProductDisplayImages implements Serializable {
	
	
	@Id
	@Column(name = "P_ID")
	public Integer productId;
	
	
	
	@Column(name = "CATEGORY_ID")
	public Integer categoryId;
	
	@Column(name = "SUB_CATEGORY_ID")
	public Integer subCategoryId;
	
	
	@Column(name = "PRODUCT_IMAGES")
	public Clob productImages;

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

	public Clob getProductImages() {
		return productImages;
	}

	public void setProductImages(Clob productImages) {
		this.productImages = productImages;
	}
}
