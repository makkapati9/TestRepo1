package com.avd.service;

import java.util.List;
import java.util.Map;

import com.avd.model.Lu_Category;
import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;
import com.avd.service.vo.ProductMenu;

public interface CustomerService {
	
	
	
	
	public List<Object[]> getProductInfo(Map<String,Object> map);
	public List<Object[]> getSelectedProductImages(Map<String,Object> map);
	public String signup(Map<String,Object> map);
	public List<ProductMenu> getProductMenu(Map<String,Object> map);
	public String authenticateSignup(Map<String,Object> map);
	public String checkEmail(Map<String,Object> map);
	public String authenticateLogin(Map<String,Object> map);
	public List<Object[]> getLoginCredentials(Map<String,Object> map);
	public List<TblProductInformation> getProductData(Map<String,Object> map);
	public String getCartProducts(Map<String,Object> map);
	public String getCartProductId(Map<String,Object> map);
	public Integer getArtificalId();
	public String saveToCart(Map<String,Object> map);
	public String removeProducts(Map<String,Object> map);
	public List<Object[]> getCartProductsDesc(Map<String,Object> map);
	public String saveFinalProducts(Map<String,Object> map);
	public List<Object[]> getFinalProductsDesc(Map<String,Object> map);
	public List<Object[]> getReceiverAddress(Map<String,Object> map);
	public List<Object[]> updateCartProducts(Map<String,Object> map);
	public String removeFinalProducts(Map<String,Object> map);
	public List<Object[]> updateFinalCartProducts(Map<String,Object> map);
	public List<Object[]> getOrderDetails(Map<String,Object> map);
	public String updateTotalAmount(Map<String,Object> map);
	public String saveComplain(Map<String,Object> map);
	public List<Object[]> getShowProducts(Map<String,Object> map);
	public List<Object[]> productOfTheDay(Map<String,Object> map);
	public String addReview(Map<String,Object> map);
	public List<Object[]> getProductReview(Map<String,Object> map);
	public List<Object[]> getTrackDesc(Map<String,Object> map);
	
	
}
