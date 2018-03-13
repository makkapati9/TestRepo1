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

import com.avd.model.Lu_Category;
import com.avd.model.TblProductInformation;
import com.avd.service.SellerService;


@Controller
public class AddProductController {
	
	
	@Autowired
	SellerService sellServc;
	
	

	@RequestMapping("/addProduct")
	public ModelAndView sellerEnd(HttpServletRequest httpReq,
			HttpServletResponse httpResp) {

		
		Map<String, Object> map = new HashMap<String, Object>();
		
		TblProductInformation info= new TblProductInformation();
	try{	
		BeanUtils.populate(info, httpReq.getParameterMap());
		map.put("info", info);
		sellServc.saveProduct(map);

	return new ModelAndView("sellerEnd", "map", map);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return new ModelAndView("error", "map", map);
	}
}
	
}
