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
<link rel="stylesheet" type="text/css" href="style/style_3.css" />


<%@ include file="/WEB-INF/views/header_login.jsp"%>

<style>



</style>
<body>

									

<div class="checkout">
		<c:choose>
			<c:when test="${fn:length(map.cartProductsDesc)>0}">
				<form id="cart" name="cart" method="post">
					
					
<input type="hidden" id="productId" name="productId" value=""></form>
				
					
				<div class="container" style="box-shadow: 10px 10px 5px #888888;">

						<table>
						<thead style="background-color:#E0E0D1">
						<tr><th colspan='2' width='23%'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Order Id</th>
						<th align="center">Receiver Name</th>
						<th align="center">E mail</th>
						<th align="center">Order Date</th>
						<th align="center">Delivery on</th> 
						<th align="center">Total Amount</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="listItem" items="${map.cartProductsDesc}"
					varStatus="counter">
						<tr style="border:1px solid;border-color:threedlightshadow;"><td colspan='2' align="left">
						
				  <a class="now-get get-cart-in" style="float:left;" rel ="ibox" href="trackOrderDetails?orderId=${listItem[1]}" id='bef'><span> ${listItem[1]}</span></a> 
				
						</td>
						<td width="20%" >
								 ${listItem[18]}	
						</td>
						<td width="20%">${listItem[0]}</td><td width="20%" ><fmt:formatDate
															pattern="dd-MM-yyyy" value="${listItem[6]}" /> </td>
															<td width="20%" ><fmt:formatDate
															pattern="dd-MM-yyyy" value="${listItem[7]}" /> </td>
															<td width="20%"><span>${listItem[23]}</span></td></tr>
							
						
					<tr><td>&nbsp;</td></tr>
						</c:forEach>
						</tbody>
						</table>
					</div>
					<%-- <div style="float:right;"><h3>Amount Payable:<b> Rs.<span id="totalAmountDisplay">${map.totalAmount}</span></b></h3></div>
				 --%>	<br></br>
					
					<br></br>

								
									<div class="banner-left">
										
										<a href="login"  >
										
										<input type="button" class="continue" value="Continue Shopping" />
										</a>
									</div>
									
					

			</c:when>
			<c:otherwise>
				<div class="container">
					<h1 class="title1">Tracking cart is empty</h1>
					<p class="cart">
						You have not ordered any items yet.<br>Click<a
							href="login"> here</a> to continue shopping
					</p>
				</div>


			</c:otherwise>
		</c:choose> 
		
		
		
		</div>




    

<!-- <table>
<tr><th>Product</th><th>Price</th><th></th></tr>

</table> -->





</body>
</html>