package com.avd.model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tbl_cart_record database table.
 * 
 */
@Entity
@Table(name="tbl_cart_record")
public class TblCartRecord implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="created_date")
	private Timestamp createdDate;
	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="quantity")
	private int quantity;
	@Id
	@Column(name="user_id")
	private String userId;

	
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}