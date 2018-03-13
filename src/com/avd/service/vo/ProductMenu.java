package com.avd.service.vo;

import java.util.ArrayList;
import java.util.List;



public class ProductMenu {

	
	
	private String categoryId;
	private String categoryDesc;
	private String flag;

	List<SubProduct> memberList= new ArrayList<SubProduct>();

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public List<SubProduct> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<SubProduct> memberList) {
		this.memberList = memberList;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
