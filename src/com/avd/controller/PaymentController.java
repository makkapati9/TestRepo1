package com.avd.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Synchronization;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.BasicScheme;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avd.service.CustomerService;
import com.oreilly.servlet.Base64Encoder;


@Controller
public class PaymentController {
	
	@Autowired
	CustomerService customerServc;
	
	@RequestMapping("/authorizePayment")
	public ModelAndView authorizePayment(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {
		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setContentType("text/plain");
		httpResp.setContentType("text/html; charset=UTF-8");
		httpResp.setCharacterEncoding("UTF-8");	
		PrintWriter out = httpResp.getWriter();
		HttpSession session = httpReq.getSession(false);
		String check="";
		Map<String, Object> map = new HashMap<String, Object>();
		String orderId=httpReq.getParameter("orderId");
		String paymentId=httpReq.getParameter("paymentId").trim();
		String amount=httpReq.getParameter("totalAmount").trim();
		String email=httpReq.getParameter("email").trim();
		map.put("orderId",orderId);
		map.put("paymentId",paymentId);
		map.put("amount",amount);
		map.put("email",email);	
		
	
		try{
			System.out.println("PaymentId"+paymentId);
		System.out.println("amount"+amount);		

		URL url = new URL ("https://api.razorpay.com/v1/payments/"+paymentId+"/capture");
		String encoding = Base64Encoder.encode ("rzp_test_fELiPnnFZxkgi2:RlJ7TtXaChIayI32Q5U4eRs4");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty  ("Authorization", "Basic " + encoding);
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		writer.write("amount="+amount);
		writer.flush();
		String line;
		StringBuffer bf= new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			bf.append(line);
		}
		writer.close();
		reader.close();
		System.out.println("line>>>"+line);
		System.out.println("bf>>>"+bf.toString());
		
		JSONObject myObject = new JSONObject(bf.toString());
		System.out.println(myObject.get("id"));
		System.out.println(myObject.get("status"));
		System.out.println(myObject.get("amount"));
		System.out.println(myObject.get("created_at"));
	
		Integer amnt= new Integer(myObject.get("amount").toString());
		amnt=amnt/100;
		map.put("paymentId",myObject.get("id"));
		map.put("amount",amnt);
		map.put("createdAt",myObject.get("created_at"));
		
		map.put("flag", "2");
	
		if(session!=null && session.getAttribute("loginId")!=null)
		{
		String loginId=session.getAttribute("loginId").toString();
		map.put("loginId", loginId);
		}
		else if(session!=null &&session.getAttribute("logId")!=null){
			String loginId=session.getAttribute("logId").toString();
			map.put("loginId", loginId);
		}
		customerServc.updateTotalAmount(map);

	
	String mailMessg = "<h3>Greeting from Mohini All</h3>"
			+ "Your transaction of Rs."+amnt+" has been successful" 
			+ "<br />ORDER ID:"+orderId
			+ " <br /> Order will be delivered to you till promised date, Stay assured"
			+ "<br />Keep Smiling <br /><br /><br /><table border=\"1\"><tr><td> </td><td> </td></table>"
			+ "Best Regards,<br />Mohini Team<br />";
	Map<String, String> inlineImages = new HashMap<String, String>();
			
	try {
		com.avd.common.util.SendMail.sendEmailimg(email, "Mohini Order Id:"+orderId+"Transaction Successful",mailMessg,inlineImages);
	} catch (Exception e) {
		System.out.println("not sent");
	}
	
	return new ModelAndView("redirect:paymentSuccessful?dsvGfTRFekjhgdfnm32Gjfh="+orderId+"&amount=djsT565yhFG");
}
		
		catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "3");
			customerServc.updateTotalAmount(map);

			map.put("message", "Please try Again");
			return new ModelAndView("error", "map", map);
		}	
		
		
		


}
	
	@RequestMapping("/paymentSuccessful")
	public ModelAndView paymentSuccessful(HttpServletRequest httpReq,
			HttpServletResponse httpResp) throws Exception {

			String orderId=httpReq.getParameter("dsvGfTRFekjhgdfnm32Gjfh");
			Map<String, Object> map = new HashMap<String, Object>();
			
			
			if(orderId=="")
			{
				map.put("message", "Please try Again");
				return new ModelAndView("error", "map", map);

			}
			else{
				return new ModelAndView("paymentSuccessful", "map", map);
				
			}
			
	}
}