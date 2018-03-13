package com.avd.dao;

import java.util.List;
import java.util.Map;

import com.avd.model.Lu_Category;
import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;

public interface SellerServiceDao {

	
	public List<Lu_Category> getCategory(Map<String,String> map);
	String saveImage(Map<String,Object> map) throws Exception;
	Integer getProductId() throws Exception;
	

	public String saveProduct(Map<String,Object> map) throws Exception;

	public List<TblProductInformation> getProductsData(Map<String,Object> map);
	

	List<TblProductInformation> getUnauthorizedProductDetails(int startPage,
			int pageSize, Map<String,Object> map);
	
	public int getcountProductRegistered( Map<String,Object> map);
	
	public List<ProductImages> getProductImages(Map<String,Object> map);
	
	String saveSliderImage(Map<String,Object> map) throws Exception;

	


}
