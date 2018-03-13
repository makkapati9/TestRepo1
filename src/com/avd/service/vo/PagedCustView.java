package com.avd.service.vo;

import java.util.List;

import com.avd.model.TblProductInformation;
import com.avd.service.vo.NavigationInfo;


public class PagedCustView {

	private NavigationInfo navInfo = new NavigationInfo();
	
	private List<TblProductInformation> productInfo;

	public NavigationInfo getNavInfo() {
		return navInfo;
	}

	public void setNavInfo(NavigationInfo navInfo) {
		this.navInfo = navInfo;
	}

	public List<TblProductInformation> getproductInfo() {
		return productInfo;
	}

	public void setproductInfo(List<TblProductInformation> productInfo) {
		this.productInfo = productInfo;
	}

	public TblProductInformation getproductObject(int i) {
		return (TblProductInformation) productInfo.get(i);
	}

	public void setproductObject(int i, TblProductInformation productObject) {
		this.productInfo.add(i, productObject);
	}
}

