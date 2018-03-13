package com.avd.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avd.model.ProductImages;
import com.avd.model.TblProductInformation;
import com.avd.service.CustomerService;
import com.avd.service.vo.ProductMenu;

@Controller
public class CustomersProductController {

	
	@Autowired
	CustomerService customerServc;
	
	@RequestMapping("/contactUs")
	public ModelAndView contactUs(HttpServletRequest req,
			HttpServletResponse httpResp) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String cartProduct="0";
		
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		cartProduct=customerServc.getCartProducts(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
		
		}
		map.put("productInCart", cartProduct);
		
		return new ModelAndView("contact", "map", map);
	}

	
	
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs(HttpServletRequest req,
			HttpServletResponse httpResp) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		String cartProduct="0";
		if(session!=null && session.getAttribute("loginId")!=null){
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		cartProduct=customerServc.getCartProducts(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
		}
		map.put("productInCart", cartProduct);
		return new ModelAndView("aboutUs", "map", map);
	}
	
	
	@RequestMapping("/t&c")
	public ModelAndView termsAndConditions(HttpServletRequest req,
			HttpServletResponse httpResp) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		String cartProduct="0";
		if(session!=null && session.getAttribute("loginId")!=null){
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		cartProduct=customerServc.getCartProducts(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
		}
		map.put("productInCart", cartProduct);
		return new ModelAndView("t&c", "map", map);
	}
	@RequestMapping("/suggestion")
	public void hindiWords(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		String term = httpReq.getParameter("term");
		
		
		System.out.println("term"+term);
		PrintWriter out = httpResp.getWriter();
		HttpSession session = httpReq.getSession(false);
		String status="A#B#C#D";
		System.out.println(status);
		out.print(status);
			
	}
	@RequestMapping("/productShowCase")
	public ModelAndView productShowCase(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> mapper = new HashMap<String, Object>();
		String categoryId=req.getParameter("categoryId");
				
				String subCategoryId=req.getParameter("subCategoryId");
				String count1=req.getParameter("count1");
				String count2=req.getParameter("count2");
				String categoryName=req.getParameter("name");

				mapper.put("category",categoryId);
				mapper.put("subCategory",subCategoryId);	
				mapper.put("count1",count1);
				mapper.put("count2",count2);	
				mapper.put("categoryName",categoryName);
		
		
		
		List<Object[]> obj = customerServc.getProductInfo(mapper);
		mapper=getProductMenu(mapper,session);
		mapper.put("productInfo", obj);
		return new ModelAndView("products", "map", mapper);
	}
	public  Map<String , Object> getProductMenu(Map<String , Object> map ,HttpSession session)
	{

	//	Map<String, Object> mapper = new HashMap<String, Object>();
		List<ProductMenu> menu =  new ArrayList<ProductMenu>();
		menu=customerServc.getProductMenu(map);
		String cartProduct="0";
		
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		cartProduct=customerServc.getCartProducts(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
		
		}
		map.put("slideFlag", "1");		
		List<Object[]> productOfTheDay = customerServc.productOfTheDay(map);
			map.put("productOfTheDay", productOfTheDay);
		map.put("menu", menu);
		map.put("productInCart", cartProduct);
		return map;		
	}	
	
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,
			HttpServletResponse httpResp) {

		Map<String, Object> mapper = new HashMap<String, Object>();
		
		HttpSession session = req.getSession(false);
		mapper=getProductMenu(mapper,session);
		
		
		mapper.put("showId", "1");
		List<Object[]> firstGrid = customerServc.getShowProducts(mapper);
		
		mapper.put("showId", "2");
		List<Object[]> secondGrid = customerServc.getShowProducts(mapper);
		
		mapper.put("showId", "3");
		List<Object[]> thirdGrid = customerServc.getShowProducts(mapper);
	
		
		mapper.put("slideFlag", "2");
		List<Object[]> slides = customerServc.productOfTheDay(mapper);
		
		mapper.put("slides", slides);
		mapper.put("firstGrid", firstGrid);
		mapper.put("secondGrid", secondGrid);
		mapper.put("thirdGrid", thirdGrid);
		/*R*/			
		return new ModelAndView("login", "map", mapper);
	}
	
	
	@RequestMapping("/productInfo")
	public ModelAndView productInfo(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		HttpSession session = httpReq.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		map=getProductMenu(map,session);
		String productId= httpReq.getParameter("productId");
		String categoryId= httpReq.getParameter("categoryId");
		String subCategoryId= httpReq.getParameter("subCategoryId");
		map.put("productId", productId);
		map.put("categoryId", categoryId);
		map.put("subCategoryId", subCategoryId);
		
		List<TblProductInformation> info = customerServc.getProductData(map);
		List<Object[]> obj = customerServc.getSelectedProductImages(map);
		String flag="0";
		
		
		
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		flag=customerServc.getCartProductId(map);
		}
		else if(session.getAttribute("logId")!=null){
					
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			flag=customerServc.getCartProductId(map);
		
		}
	
	
		map.put("cartExistFlag",flag);
		map.put("images",obj);
		map.put("info",info);


		return new ModelAndView("single", "map", map);
	
	}
	
	@RequestMapping("/getLogId")
	public void getLogId(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		Map<String, String> map = new HashMap<String, String>();
		PrintWriter out = httpResp.getWriter();
		HttpSession session = httpReq.getSession(false);
		String bhamashahId = "";
		String status="";
		String flag="";
		String pre="APS";
		String ZX = "346217895083474843285785214875";
		String AC="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 
	/*	 Random rndm = new Random();
		StringBuilder sbS = new StringBuilder();
			   for( int i = 0; i < 3; i++ ) 
			   { 
				   sbS.append( ZX.charAt( rndm.nextInt(ZX.length()) ) );
			   
			   } 
			 for( int i = 0; i < 3; i++ ) 
						   { 
							   sbS.append( AC.charAt( rndm.nextInt(AC.length()) ) );
						   
						   }
	*/	
		Integer h=customerServc.getArtificalId();
		String main=h.toString();
		status=pre+main;
		session.setAttribute("logId", status);
		out.print(status);
	}
	
	@RequestMapping("/setLogId")
	public void setLogId(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		HttpSession session = httpReq.getSession(false);
		String logId= httpReq.getParameter("logId");
		session.setAttribute("logId", logId);		
		String loginId=session.getAttribute("logId").toString();
		Map<String, Object> map = new HashMap<String, Object>();
		PrintWriter out = httpResp.getWriter();
		String cartProduct="0";
		if(session!=null && session.getAttribute("loginId")!=null)
		{
			loginId=session.getAttribute("loginId").toString();
	map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
		}
		else if(session.getAttribute("logId")!=null){
					
		 loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
		 cartProduct=customerServc.getCartProducts(map);
		
		}
	
			out.print(cartProduct);
		
		 
	}
	
	
	
	
	
	
	@RequestMapping("/addToCart")
	public void addToCart(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		HttpSession session = httpReq.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		String productId= httpReq.getParameter("pId");
		String quantity= httpReq.getParameter("quantity");
		try{
		map.put("productId", productId);
		map.put("quantity", quantity);
	
		if(session!=null && session.getAttribute("loginId")!=null)
		{
			System.out.println("b");
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		customerServc.saveToCart(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
					
			System.out.println("a");
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			customerServc.saveToCart(map);
		
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
}