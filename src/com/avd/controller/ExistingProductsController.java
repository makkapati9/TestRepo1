package com.avd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;
import com.avd.service.SellerService;
@Controller
public class ExistingProductsController {
	
	
	
	@Autowired
	SellerService sellServc;
	
	
	
	
	@RequestMapping("/editProduct")
	public ModelAndView editProduct(HttpServletRequest httpReq,
			HttpServletResponse httpResp) {

		
		Map<String, Object> map = new HashMap<String, Object>();
		
	String productId= httpReq.getParameter("productId");
	
	System.out.println("productId"+productId);
	try{	
		map.put("productId", productId);
		
		List<TblProductInformation> productData= sellServc.getProductsData(map);
		
		
		
		List<ProductImages> productImages = sellServc.getProductImages(map);
		
		map.put("productData", productData);
		map.put("productImages", productImages);
	return new ModelAndView("editProduct", "map", map);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return new ModelAndView("error", "map", map);
	}
}
	
	

	
	

}
