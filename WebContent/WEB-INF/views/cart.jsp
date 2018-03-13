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
<!-- <link rel="stylesheet" type="text/css" href="style/style_3.css" />
 -->

<%@ include file="/WEB-INF/views/header_login.jsp"%>
<style>



</style>
<body>

									

<div class="checkout">
		<c:choose>
			<c:when test="${fn:length(map.cartProductsDesc)>0}">
				<form id="cart" name="cart" method="post">
					
	<input type="hidden" id="orderId" name="orderId" value="">				
<input type="hidden" id="productId" name="productId" value=""></form>
				
					
					<div class="container" style="box-shadow: 10px 10px 5px #888888;">

						<table>
						<thead style="background-color:#E0E0D1">
						<tr><th colspan='2' width='37%'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item </th>
						<th align="center">Quantity</th>
						<th align="center">Price</th>
						<th align="center">Delivered By</th>
						<th align="center">SubTotal</th> 
						</tr>
						</thead>
						<tbody>
						<c:forEach var="listItem" items="${map.cartProductsDesc}"
					varStatus="counter">
						<tr style="border:1px solid;border-color:threedlightshadow;"><td colspan='2'>
						 <img src="data:image/png;base64, ${listItem[9]}" height="80" width="70" alt=""/>
				
						&nbsp;&nbsp;&nbsp;${listItem[1]}</td>

									<c:choose>

										<c:when test="${listItem[10] eq '0' || listItem[11] eq '0' }">
										<td colspan="4" width='80%' ><b>You are late, Item is out of Stock</b></td>
										
										</c:when>

										<c:otherwise>
											<td width="20%"><input type="hidden"
												id="preQuant${listItem[0]}" value="${listItem[7]}">
												<input type="text" id="quant${listItem[0]}" onpaste="return false"
												value="${listItem[7]}" style="height: 27px; width: 25px;"
												maxlength="1"
												onkeypress="isCartCheck(event);showSpan('span${listItem[0]}');"
												onblur="checkCartVal('preQuant${listItem[0]}','quant${listItem[0]}');">
												<br /> <a style="font-size: 10px; color: blue;"><span
													id="span${listItem[0]}"
													style="display: none; width: 20px; cursor: pointer;"
													onclick="updateQuant('quant${listItem[0]}','updateQuantity','span${listItem[0]}','totalAmountDisplay','subTot${listItem[0]}','${listItem[0]}','preQuant${listItem[0]}','${listItem[11]}','${listItem[1]}');">Save</span></a>

											</td>
											<td width="20%">${listItem[5]}</td>
											<td width="20%"></td>
											<td width="20%"><span id="subTot${listItem[0]}">${listItem[8]}</span></td>
										</c:otherwise>
									</c:choose>



								</tr>
						
						
							<tr><td colspan="6" align="center"><a><span onmouseover="" style="cursor:pointer;font-size:10px;" onclick="removeFromCart('${listItem[0]}')"><u>REMOVE</u></span></a></td></tr>
						
					
						</c:forEach>
						</tbody>
						</table>
						
						

					</div>
					<div style="float:right;"><h3>Amount Payable:<b> Rs.<span id="totalAmountDisplay">${map.totalAmount}</span></b></h3></div>
					<c:set var="finlAmnt" value="${map.totalAmount}"></c:set>
															
					<br></br>
					
					<br></br>

								
									<div class="banner-left">
										
										<a href="login"  >
										
										<input type="button" class="continue" value="Continue Shopping" />
										</a>
										
										<c:if test="${finlAmnt ne '0'}">
										<a href="buyNow?flag=2&totalAmount=0"; rel="ibox"><input type="button" class="order" value="Checkout" /> </a>
					
										</c:if>
														</div>
									
					

			</c:when>
			<c:otherwise>
				<div class="container">
					<h1 class="title1">Shopping cart is empty</h1>
					<p class="cart">
						You have no items in your shopping cart.<br>Click<a
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