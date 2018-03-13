package com.avd.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_product_information database table.
 * 
 */
@Entity
@Table(name="tbl_product_information")
public class TblProductInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="ACTUAL_PRICE")
	private int actualPrice;

	@Column(name="CASH_ON_DELIVERY")
	private String cashOnDelivery;

	@Column(name="CATEGORY_ID")
	private int categoryId;

	@Column(name="DELIVERY_CHARGES")
	private int deliveryCharges;

	@Column(name="DELIVERY_TIME")
	private int deliveryTime;

	@Column(name="DISCOUNT")
	private int discount;

	@Column(name="DISCOUNTED_PRICE")
	private int discountedPrice;

	@Column(name="IS_ACTIVE")
	private int isActive;

	@Column(name="ONE_DAY_DELIVERY")
	private String oneDayDelivery;

	@Column(name="ONEDAY_DELIVERY_CHARGES")
	private int onedayDeliveryCharges;

	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="SELLER_ID")
	private int sellerId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="CASH_ON_DELIVERY_CHARGES")
	private int cashOnDeliveryCharges;


	@Column(name="RETURN_POLICY")
	private String returnPolicy;

	
	@Column(name="RETURN_DAYS")
	private int returnPolicyDays;
	
	@Column(name="SUB_CATEGORY_ID")
	private int subCategoryId;
	
	@Column(name="GIFT_WRAP")
	private String giftWrap;
	@Column(name="GIFT_WRAP_CHARGES")
	private int giftWrapCharges;


	
	public TblProductInformation() {
	}
	
	

		public int getSubCategoryId() {
		return subCategoryId;
	}



	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}



		public int getCashOnDeliveryCharges() {
		return cashOnDeliveryCharges;
	}

	public void setCashOnDeliveryCharges(int cashOnDeliveryCharges) {
		this.cashOnDeliveryCharges = cashOnDeliveryCharges;
	}

	public String getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	public int getReturnPolicyDays() {
		return returnPolicyDays;
	}

	public void setReturnPolicyDays(int returnPolicyDays) {
		this.returnPolicyDays = returnPolicyDays;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getActualPrice() {
		return this.actualPrice;
	}

	public void setActualPrice(int actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getCashOnDelivery() {
		return this.cashOnDelivery;
	}

	public void setCashOnDelivery(String cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getDeliveryCharges() {
		return this.deliveryCharges;
	}

	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public int getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDiscountedPrice() {
		return this.discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}



	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	

	public String getOneDayDelivery() {
		return this.oneDayDelivery;
	}

	public void setOneDayDelivery(String oneDayDelivery) {
		this.oneDayDelivery = oneDayDelivery;
	}

	public int getOnedayDeliveryCharges() {
		return this.onedayDeliveryCharges;
	}

	public void setOnedayDeliveryCharges(int onedayDeliveryCharges) {
		this.onedayDeliveryCharges = onedayDeliveryCharges;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getGiftWrap() {
		return giftWrap;
	}



	public void setGiftWrap(String giftWrap) {
		this.giftWrap = giftWrap;
	}



	public int getGiftWrapCharges() {
		return giftWrapCharges;
	}



	public void setGiftWrapCharges(int giftWrapCharges) {
		this.giftWrapCharges = giftWrapCharges;
	}

}