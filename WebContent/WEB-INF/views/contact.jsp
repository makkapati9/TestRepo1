<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
 <style>
 h1.title1 {
    color: #000;
    font-size: 1.4em;
    font-weight: normal;
    letter-spacing: -1px;
    line-height: 1.2;
    margin-bottom: 0.5em;
    margin-top: 0;
    padding-bottom: 13px;
    text-transform: uppercase;
}
p.cart {
    color: #555;
    font-size: 1em;
    line-height: 1.8em;
}

.checkout {
    min-height: 500px;
   
}
 </style>

</head>

<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>


<%@ include file="/WEB-INF/views/header_login.jsp"%>

<style>



</style>
<body>
				
					
				
<div class="contact" id="contact">
	<div class="container">
		<div class="portfolio-info">
			<h3>CONTACT US</h3>
			<p class="paragraph">WE LOVE TALKING</p>
			<div class="fig3">
				<span> </span>
			</div>
			<p class="paragraph1">
				<span> If we have caused any trouble We are extremely sorry, Please feel free to contact us , We are always here to help you.
					</span>You can also use  24X7 live support and write us your problem.
					<span>More than happy to help you</span>
					</p>
		</div>
		<div class="tv-home-call">
			<div class="tv">
				<div class="figure">
					<span> </span>
				</div>
				<a href="mailto:info@example.com">mohinijwellery@gmail.com</a>
			</div>
			<div class="tv tv-mid">
				<div class="figure1">
					<span> </span>
				</div>
				<p>Mohini <span>1307 , Kedia Bhavan , Johari bazar , Jaipur</span></p>
			</div>
			<div class="tv">
				<div class="figure2">
					<span> </span>
				</div>
				<p>09643206186</p>
			</div>
			<div class="clearfix"> </div>
		</div>
	

		
		
		
		</div>

</div>



<%@ include file="/WEB-INF/views/footer.jsp"%>





</body>
</html>