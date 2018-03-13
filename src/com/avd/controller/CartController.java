package com.avd.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.avd.service.CustomerService;



@Controller
public class CartController {

	@Autowired
	CustomerService customerServc;
	@RequestMapping("/removeFromCart")
	public ModelAndView removeFromCart(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		String cartProduct="0";
		String productId=req.getParameter("productId");
		map.put("productId", productId);
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		customerServc.removeProducts(map);
		cartProduct=customerServc.getCartProducts(map);
		dat= customerServc.getCartProductsDesc(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			customerServc.removeProducts(map);
			cartProduct=customerServc.getCartProducts(map);
			dat= customerServc.getCartProductsDesc(map);
		}
		
		Integer total=0;
		for(Object[] a: dat)
		{
			total=total+new Integer(String.valueOf(a[8]));	
		}
		
		map.put("totalAmount", total);
		map.put("cartProductsDesc", dat);
		map.put("productInCart", cartProduct);		
		return new ModelAndView("cart", "map", map);
	}

	@RequestMapping("/cart")
	public ModelAndView cart(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		String cartProduct="0";
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		cartProduct=customerServc.getCartProducts(map);
		dat= customerServc.getCartProductsDesc(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct=customerServc.getCartProducts(map);
			dat= customerServc.getCartProductsDesc(map);			 
		}						
		Integer total=0;
		for(Object[] a: dat)
		{
			if("0".equals(a[10].toString()) |"0".equals(a[11].toString()) ) 
			{
				
			}
			else{
			total=total+new Integer(String.valueOf(a[8]));	
			}
			}
		
		map.put("totalAmount", total);

		map.put("cartProductsDesc", dat);
		map.put("productInCart", cartProduct);
		return new ModelAndView("cart", "map", map);
	}	
	@RequestMapping("/buyNow")
	public ModelAndView buyNow(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		
		String flag=req.getParameter("flag");
		map.put("flag", flag);
		String totalAmount=req.getParameter("totalAmount");
		map.put("totalAmount", totalAmount);
		List<Object[]> dat1 = new ArrayList<Object[]>();
		
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String emailId=session.getAttribute("emailId").toString();
		map.put("emailId", emailId);
			}
		if("1".equals(flag))
		{
			String productId=req.getParameter("productId");
			String returnPolicy=req.getParameter("returnPolicy");
			
			String returnDays=req.getParameter("returnDays");
			map.put("productId", productId);
			map.put("returnPolicy", returnPolicy);
			
			map.put("returnDays", returnDays);
		}
		
		else if("3".equals(flag))
		{
			String orderId=req.getParameter("orderId");
			map.put("orderId",orderId );
		
			
			
			if(session!=null && session.getAttribute("loginId")!=null)
			{
			String loginId=session.getAttribute("loginId").toString();
			map.put("loginId", loginId);
			}
			else if(session!=null &&session.getAttribute("logId")!=null){
				String loginId=session.getAttribute("logId").toString();
				map.put("loginId", loginId);
						 
			}				
			 dat1=customerServc.getReceiverAddress(map);
			 Object[] abc=dat1.get(0); 
			 map.put("emailId",abc[0]);
		}
		map.put("dat1", dat1);
		return new ModelAndView("buyNowDetails", "map", map);
	}
	
	@RequestMapping("/productAddSummary")
	public ModelAndView productAddSummary(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		
		String email=req.getParameter("email");
		String mobileNo=req.getParameter("mobileNo");
		String receiverName=req.getParameter("receiverName");
		String address=req.getParameter("address");
		String pincode=req.getParameter("pincode");
		String flag=req.getParameter("flag");
		String productId=req.getParameter("productId");
		
		String totalAmount=req.getParameter("totalAmount");
		String returnPolicy=req.getParameter("productId");
		String returnDays=req.getParameter("returnDays");
		String orderId=req.getParameter("orderId");
	
		map.put("orderId",orderId );
		map.put("email",email );
		map.put("mobileNo",mobileNo );
		map.put("name",receiverName );
		map.put("address",address);
		map.put("pincode",pincode );
		map.put("flag",flag );
		map.put("productId",productId);
		map.put("totalAmount",totalAmount );
		map.put("returnPolicy",returnPolicy );
		map.put("returnDays",returnDays);

		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
					 
		}		
	
		String result=customerServc.saveFinalProducts(map);
		if("X".equals(result))
		{
			map.put("message", "Please try Again");
			return new ModelAndView("error", "map", map);
		}
		else{
			return new ModelAndView("redirect:productSummary?gdsgfvssdjfhYRTRY2142rh3DS=4trhjdgshfvdh32y4&emfdshfGFj165ga="+result, "map", map);
		}
	
	}
	
	
	@RequestMapping("/productSummary")
	public ModelAndView productSummary(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		
		String orderId=req.getParameter("emfdshfGFj165ga");
		
	
		map.put("orderId",orderId );
		
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
					 
		}		
	
		List<Object[]> dat = new ArrayList<Object[]>();
		List<Object[]> dat1 = new ArrayList<Object[]>();
		dat=customerServc.getFinalProductsDesc(map);
		dat1=customerServc.getReceiverAddress(map);
		
		Integer total=0;
		for(Object[] a: dat)
		{
			if("0".equals(a[10].toString()) |"0".equals(a[11].toString()) ) 
			{
				
			}
			else{
			total=total+new Integer(String.valueOf(a[8]));	
			}
			}
		
		map.put("totalAmount", total);
		map.put("flag", "1");
		
		customerServc.updateTotalAmount(map);
		
		String	cartProduct=customerServc.getCartProducts(map);
		map.put("cartProductsDesc", dat);
		map.put("address", dat1);
		map.put("headerCheck", "1");
		map.put("productInCart", cartProduct);
	    return new ModelAndView("productSummary", "map", map);
		
	
	}
	
	@RequestMapping("/updateQuantity")
	public void updateQuantity(HttpServletRequest httpReq,
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
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
					
			System.out.println("a");
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
		
		}
		List<Object[]> dat = new ArrayList<Object[]>();
		dat=customerServc.updateCartProducts(map);
		
		
		Integer subTotal=0;
		Integer total=0;
		for(Object[] a: dat)
		{
			
			total=total+new Integer(String.valueOf(a[1]));
			
			if(productId.equals(String.valueOf(a[0])))
			{
				
				subTotal=new Integer(String.valueOf(a[1]));
			}
			
		}
		
		
		PrintWriter out = httpResp.getWriter();
		out.print(quantity+"#"+subTotal+"#"+total);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/updateFinalQuantity")
	public void updateFinalQuantity(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		HttpSession session = httpReq.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		String productId= httpReq.getParameter("pId");
		String quantity= httpReq.getParameter("quantity");
		String orderId= httpReq.getParameter("orderId");
		try{
		map.put("productId", productId);
		map.put("quantity", quantity);
		map.put("orderId", orderId);
	
		if(session!=null && session.getAttribute("loginId")!=null)
		{
			System.out.println("b");
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
					
			System.out.println("a");
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
		
		}
		List<Object[]> dat = new ArrayList<Object[]>();
		dat=customerServc.updateFinalCartProducts(map);
		
		
		Integer subTotal=0;
		Integer total=0;
		for(Object[] a: dat)
		{
			
			total=total+new Integer(String.valueOf(a[1]));
			
			if(productId.equals(String.valueOf(a[0])))
			{
				
				subTotal=new Integer(String.valueOf(a[1]));
			}
			
		}
		
		
		PrintWriter out = httpResp.getWriter();
		out.print(quantity+"#"+subTotal+"#"+total);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	@RequestMapping("/removeFromFinalCart")
	public ModelAndView removeFromFinalCart(HttpServletRequest req,
			HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		
		String orderId=req.getParameter("orderId");
		String productId=req.getParameter("productId");
		map.put("productId", productId);
		map.put("orderId", orderId);
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		customerServc.removeFinalProducts(map);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			customerServc.removeFinalProducts(map);
		}
		
			return new ModelAndView("redirect:productSummary?emfdshfGFj165ga="+orderId);
	}	
}