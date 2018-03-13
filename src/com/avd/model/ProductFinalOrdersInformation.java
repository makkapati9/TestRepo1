package com.avd.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the product_final_orders_information database table.
 * 
 */
@Entity
@Table(name="product_final_orders_information")
public class ProductFinalOrdersInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private String orderId;

	private String address;

	private String name;
	private String cod;

	@Column(name="COD_CHARGES")
	private int codCharges;

	@Column(name="CUSTOMER_FINALIZE")
	private int customerFinalize;

	@Temporal(TemporalType.DATE)
	@Column(name="delivered_date")
	private Date deliveredDate;

	@Column(name="email_id")
	private String emailId;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;

	@Column(name="GIFT_WRAP_CHARGES")
	private int giftWrapCharges;

	@Column(name="mobile_no")
	private String mobileNo;

	@Column(name="ODD_CHARGES")
	private int oddCharges;

	@Column(name="ONE_DAY_DELIVERY")
	private String oneDayDelivery;

	@Column(name="order_date")
	private Timestamp orderDate;

	@Column(name="payment_type")
	private String paymentType;

	@Column(name="pin_code")
	private int pinCode;

	
	@Column(name="SELLER_FINALIZE")
	private int sellerFinalize;

	@Column(name="STATUS_ID")
	private int statusId;

	@Column(name="total_amount")
	private int totalAmount;


	@Column(name="LOGIN_ID")
	private String loginId;

	
	public ProductFinalOrdersInformation() {
	}
	
	

	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getCodCharges() {
		return this.codCharges;
	}

	public void setCodCharges(int codCharges) {
		this.codCharges = codCharges;
	}

	public int getCustomerFinalize() {
		return this.customerFinalize;
	}

	public void setCustomerFinalize(int customerFinalize) {
		this.customerFinalize = customerFinalize;
	}

	public Date getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public int getGiftWrapCharges() {
		return this.giftWrapCharges;
	}

	public void setGiftWrapCharges(int giftWrapCharges) {
		this.giftWrapCharges = giftWrapCharges;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getOddCharges() {
		return this.oddCharges;
	}

	public void setOddCharges(int oddCharges) {
		this.oddCharges = oddCharges;
	}

	public String getOneDayDelivery() {
		return this.oneDayDelivery;
	}

	public void setOneDayDelivery(String oneDayDelivery) {
		this.oneDayDelivery = oneDayDelivery;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}


	public int getSellerFinalize() {
		return this.sellerFinalize;
	}

	public void setSellerFinalize(int sellerFinalize) {
		this.sellerFinalize = sellerFinalize;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}