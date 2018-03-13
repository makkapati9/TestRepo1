package com.avd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the product_final_orders database table.
 * 
 */
@Entity
@Table(name="product_final_orders")
public class ProductFinalOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	private int amount;

	@Column(name="order_date")
	private Timestamp orderDate;
	@Id
	@Column(name="order_id")
	private String orderId;
	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="return_days")
	private int returnDays;

	
	
	private int quantity;
	
	@Column(name="gift_wrap")
	public String giftWrap;
	
	
	public ProductFinalOrder() {
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public int getReturnDays() {
		return returnDays;
	}

	public void setReturnDays(int returnDays) {
		this.returnDays = returnDays;
	}

	public String getGiftWrap() {
		return giftWrap;
	}

	public void setGiftWrap(String giftWrap) {
		this.giftWrap = giftWrap;
	}
	

}