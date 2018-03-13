package com.avd.controller;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avd.service.CustomerService;
import com.avd.service.SellerService;
@Controller
public class LoginController {
	@Autowired
	CustomerService customerServc;

	
	

	@RequestMapping("/contact")
	public ModelAndView contact() {

		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("contactUs", "map", map);
	}

	

		
	@RequestMapping("/loginup")
	public ModelAndView loginUp(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		return new ModelAndView("ForgotPasswordUserId", "map", map);
	}
	
	
	
	@RequestMapping("/signup")
	public ModelAndView signup(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
			return new ModelAndView("signup", "map", map);
	}
	
	
	
	@RequestMapping("/signedup")
	public void signedup(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		PrintWriter out = httpResp.getWriter();
		String email= httpReq.getParameter("email");	
		String password= httpReq.getParameter("password");	
		String userName= httpReq.getParameter("userName");	
		map.put("email",email );
		map.put("userName", userName);
		map.put("password", password);
		
		String one= "3C4621Bda78AAXVB";
		String two= "87678GHGFh6vhvdbsv90";		
		 
		 Random rndm = new Random();
		 Random randm = new Random();
		StringBuilder sbS = new StringBuilder();
			   for( int i = 0; i < 5; i++ ) 
			   { 
				   sbS.append( one.charAt( rndm.nextInt(one.length()) ) );
			   
			   } 
			   
			   for( int i = 0; i < 5; i++ ) 
			   { 
				   sbS.append( two.charAt( randm.nextInt(two.length()) ) );
			   
			   } 

			   map.put("code", sbS);
			   String  id=customerServc.signup(map);

			   	String verifyLink ="http://mohinimart.com//live//authenticateSignup?fdgd7T6shyfr="+sbS.toString()+id;
			   	
				String mailMessg = "<h3>Greetings from Mohini</h3>"
						+ "To activate your account, please click on the below link "
						+ "<br /><a href='"+verifyLink+"'>"+verifyLink+"</a>"
						+ " <br /> "
						+ "</b><br /><br /><br /><br /><table border=\"1\"><tr><td> </td><td> </td></table>"
						+ "Best Regards,<br />Mohini Team<br />";
				Map<String, String> inlineImages = new HashMap<String, String>();
						
				try {
					com.avd.common.util.SendMail.sendEmailimg(email,"Registration Link",mailMessg,inlineImages);
				} catch (Exception e) {
					System.out.println("not sent");
				}
				
				
				
				out.print("<br/><br/><br/><br/><h3><font color='green'>Registration link has been sent to your mail</font></h3><br/><br/><br/><br/>");
	
	}
	
	
	
	@RequestMapping("/authenticateSignup")
	public ModelAndView authenticateSignup(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		PrintWriter out = httpResp.getWriter();
		String validateCode= httpReq.getParameter("fdgd7T6shyfr");	
		System.out.println(validateCode);
		map.put("validCode", validateCode);
		String check="";
	
		check=customerServc.authenticateSignup(map);
		System.out.println("check"+check);
		if("1".equals(check))
		{
			
			return new ModelAndView("redirect:login");
		}
		else if("2".equals(check))
		{
			
			map.put("message", "The link has already expired");
			return new ModelAndView("signupErr");
			
		}
		else{
			
			map.put("message", "The link is not valid");
			return new ModelAndView("error");
			
		}
		
		
	}
	
	
	
	
	@RequestMapping("/checkIfEmailIdExists")
	public void checkIfEmailIdExists(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		PrintWriter out = httpResp.getWriter();
		String email= httpReq.getParameter("email");	
		
		map.put("email",email );
	    String  id=customerServc.checkEmail(map);
	    String message="";
	    
if("1".equals(id))
{
	message="<input type='hidden' id ='check' value='1'/><font color='red'>Account exists already</font>";
}
else{
	message="<input type='hidden' id ='check' value='0'/>";
	
}
				out.print(message);
	
	}
	
	
	@RequestMapping("/loggedIn")
	public void loggedIn(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		System.out.println("hellooo");
		PrintWriter out = httpResp.getWriter();
		String email= httpReq.getParameter("email");
		String password= httpReq.getParameter("password");
		HttpSession session = httpReq.getSession(false);
		map.put("email",email);
		map.put("password",password);
	 	String  id=customerServc.authenticateLogin(map);
	    String message="";
	    
	    
if("1".equals(id))
{
	
	List<Object[]> data= customerServc.getLoginCredentials(map);
	for(Object[] a: data)
	{
	session.setAttribute("loginId", String.valueOf(a[0]));
	session.setAttribute("loginName", String.valueOf(a[1]));
	session.setAttribute("emailId", String.valueOf(a[2]));
	session.setAttribute("shoppingCode", String.valueOf(a[3]));
	session.setAttribute("loginFlag", "1");

	}
	message="<input type='hidden' id='logCheck' value='1'>";
	
}
else {
	message="<input type='hidden' id='logCheck' value='0'><font color='red'>Incorrect Email and Password</font>";
	
}
				out.print(message);
	
	}
		

@RequestMapping(value = "/signout", method = RequestMethod.POST)
public ModelAndView signout(HttpServletRequest request) {
	HttpSession session = request.getSession(false);
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, String> mapper = new HashMap<String, String>();

	try {
		String loginname = null;
		String SessionValue = "FAIL";
		if (session != null) {
			
			session.invalidate();
		}
		return new ModelAndView("redirect:login", map);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return new ModelAndView("error", map);
	}
}





@RequestMapping("/contactUsNow")
public void contactUsNow(HttpServletRequest httpReq,
		HttpServletResponse httpResp) throws Exception {
	Map<String, Object> map = new HashMap<String, Object>();
	httpReq.setCharacterEncoding("UTF-8");
	httpResp.setContentType("text/plain");
	httpResp.setContentType("text/html; charset=UTF-8");
	httpResp.setCharacterEncoding("UTF-8");
	System.out.println("hellooo");
	PrintWriter out = httpResp.getWriter();
	String email= httpReq.getParameter("email");	
	String name= httpReq.getParameter("name");	
	String mobileNo= httpReq.getParameter("mobileNo");	
	String message= httpReq.getParameter("message");
	if(mobileNo.trim()=="")
	{
		mobileNo="0";
	}
	map.put("email",email );
	map.put("name", name);
	map.put("mobileNo", mobileNo);
	map.put("message", message);
	customerServc.saveComplain(map);
	out.print("<br/><br/><br/><br/><h3><font color='green'>Your request is sent , We will contact you shortly <br/> Thanks For the patience.</font></h3><br/><br/><br/><br/>");

}



}