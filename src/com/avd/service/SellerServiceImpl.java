package com.avd.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.avd.dao.SellerServiceDao;
import com.avd.model.Lu_Category;
import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;

public class SellerServiceImpl implements SellerService{

	
	@Autowired
	SellerServiceDao sellSrvcDao;

	@Override
	public List<Lu_Category> getCategory(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getCategory(map);
	}

	@Override
	public String saveImage(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveImage(map);
	}
	
	@Override
	public Integer getProductId() throws Exception {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductId();
	}
	
	@Override
	public String saveProduct(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveProduct(map);
	}
	
	
	@Override
	public List<TblProductInformation> getProductsData(Map<String, Object> map)  {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductsData(map);
	}

	@Override
	public List<TblProductInformation> getUnauthorizedProductDetails(
			int startPage, int pageSize, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getUnauthorizedProductDetails(
				 startPage, pageSize,  map);
	}

	@Override
	public int getcountProductRegistered(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getcountProductRegistered( map);
	}
	
	@Override
	public List<ProductImages> getProductImages( Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellSrvcDao.getProductImages(map);
	}

	@Override
	public String saveSliderImage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sellSrvcDao.saveSliderImage(map);
	}
	
}
