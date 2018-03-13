package com.avd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.avd.dao.CustomerServiceDao;
import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;
import com.avd.service.vo.ProductMenu;


public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerServiceDao sellSrvcDao;

	@Override
	public List<Object[]> getProductInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductInfo(map);
	}
	
	@Override
	public List<Object[]> getSelectedProductImages(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getSelectedProductImages(map);
	}
	
	
	@Override
	public String signup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.signup(map);
	}

	@Override
	public List<ProductMenu> getProductMenu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductMenu(map);
	}

	@Override
	public String checkEmail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.checkEmail(map);
	}

	@Override
	public String authenticateSignup(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.authenticateSignup(map);
	}
	
	@Override
	public String authenticateLogin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.authenticateLogin(map);
	}
	
	@Override
	public List<Object[]> getLoginCredentials(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getLoginCredentials(map);
	}

	@Override
	public List<TblProductInformation> getProductData(Map<String, Object> map) {
		// TODO Auto-generated method stub
			return sellSrvcDao.getProductData(map);


	}
	
	@Override
	public String getCartProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getCartProducts(map);
	}
	@Override
	public String getCartProductId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getCartProductId(map);
	}

	@Override
	public Integer getArtificalId() {
		// TODO Auto-generated method stub
		return sellSrvcDao.getArtificalId();
	}
	
	@Override
	public String saveToCart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveToCart(map);
	}
	@Override
	public List<Object[]> getCartProductsDesc(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getCartProductsDesc(map);
	}
	
	@Override
	public String removeProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.removeProducts(map);
	}

	@Override
	public String saveFinalProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveFinalProducts(map);
	}

	@Override
	public List<Object[]> getFinalProductsDesc(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getFinalProductsDesc(map);
	}

	@Override
	public List<Object[]> getReceiverAddress(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getReceiverAddress(map);
	}

	@Override
	public List<Object[]> updateCartProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.updateCartProducts(map);
	}

	@Override
	public String removeFinalProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.removeFinalProducts(map);
	}

	@Override
	public List<Object[]> updateFinalCartProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.updateFinalCartProducts(map);
	}

	@Override
	public List<Object[]> getOrderDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getOrderDetails(map);
	}

	@Override
	public String updateTotalAmount(Map<String, Object> map) {
		return sellSrvcDao.updateTotalAmount(map);
	}

	@Override
	public String saveComplain(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveComplain(map);
	}
	
	
	
	@Override
	public List<Object[]> getShowProducts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getShowProducts(map);
	}
	@Override
	public List<Object[]> productOfTheDay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.productOfTheDay(map);
	}
	
	@Override
	public String addReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.addReview(map);
	}
	
	@Override
	public List<Object[]> getProductReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductReview(map);
	}
	
	@Override
	public List<Object[]> getTrackDesc(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getTrackDesc(map);
	}
}
