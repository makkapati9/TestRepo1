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
.address{
	display:inline-block;
	width:100%;
	float:right;
	text-align:center;
}

.address p {
    color: #a6a6a6;
    
    font-size: 1.4em;
    font-weight: 200;
    display: block;
}

.editAdd{
float:right:
      display: inline-block;
    height: 26px;
    vertical-align: middle;
    width: 26px;
}
</style>


<body>




<c:choose>
			<c:when test="${fn:length(map.cartProductsDesc)>0}">
		




	<div class="container" style="box-shadow: 10px 10px 5px #888888;">
<span class="editAdd"> <a href="buyNow?flag=3&orderId=${map.orderId}" rel="ibox"> <img src="images/file_edit.png" height="20px" width="20px">Edit </a></span>
	<c:forEach var="listItem" items="${map.address}"
				
					varStatus="counter">
					<h4>${listItem[0]} <c:set var="emailId" value="${listItem[0]}" /></h4>
					<h4>${listItem[1]}</h4>
					<h4>${listItem[4]}</h4>
					<h4>${listItem[6]}</h4>
					<h4>${listItem[5]} <c:set var="contact" value="${listItem[5]}" /></h4>
					
			
					</c:forEach>
		</div>





 <div class="clearfix"> </div>

<div class="container" style="box-shadow: 10px 10px 5px #888888;">
<h3>Amount Payable:<b> Rs.<span id="totalAmountDisplay">${map.totalAmount}</span>

<c:set var="finlAmnt" value="${map.totalAmount}"></c:set></b></h3>
				
</div>		


 <div class="clearfix"> </div>
		<div class="checkout">



				<form id="cart" name="cart" method="post">
					
					<input type="hidden" id="email" name="email" value="${emailId}">
				<input type="hidden" id="productId" name="productId" value="">
				<input type="hidden" id="paymentId" name="paymentId" value="">
				<input type="hidden" id="totalAmount" name="totalAmount" value="">
			
				<input type="hidden" id="orderId" name="orderId" value="${map.orderId}"></form>
				
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
						
						<td width="20%" >
								<input type="hidden" id="preQuant${listItem[0]}"  value="${listItem[7]}">
										
						<input type="text" id="quant${listItem[0]}" value="${listItem[7]}" style="height:27px;width:25px;" maxlength="1" onkeypress="isCartCheck(event);showSpan('span${listItem[0]}');" onblur="checkCartVal('preQuant${listItem[0]}','quant${listItem[0]}');" >
						<br/>
						<a style="font-size:10px;color:blue;"><span id="span${listItem[0]}" style="display:none;width:20px;cursor:pointer;" onclick="updateQuant('quant${listItem[0]}','updateFinalQuantity','span${listItem[0]}','totalAmountDisplay','subTot${listItem[0]}','${listItem[0]}','preQuant${listItem[0]}','${listItem[11]}','${listItem[1]}');">Save</span></a>
						
						</td>
						<td width="20%">${listItem[5]}</td><td width="20%" > </td><td width="20%"><span id="subTot${listItem[0]}">${listItem[8]}</span></td>
						
						</c:otherwise>
						</c:choose>
						
						</tr>
							<tr><td colspan="6" align="center"><a><span onmouseover="" style="cursor:pointer;font-size:10px;" onclick="removeFromFinalCart('${listItem[0]}')"><u>REMOVE</u></span></a></td></tr>
						</c:forEach>
						</tbody>
						</table>
						
						

					</div>
						<br></br>
					
					<br></br>

								
									<div class="banner-left">
										
										<a href="login"  >
										
										<input type="button" class="continue" value="Continue Shopping" />
										</a>
										
										<c:if test="${finlAmnt ne '0'}">
										
										<input type="button" class="order"  id="rzp-button1" name="rzp-button1" value="Payment" />
										
										</c:if>


										
									</div>
									
					

		
		
		
		
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


    <div id="chakri"></div>

<!-- <table>
<tr><th>Product</th><th>Price</th><th></th></tr>

</table> -->




<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>


$("#rzp-button1").click(function(e){

	
	var options = {
		    "key": "rzp_test_fELiPnnFZxkgi2",
		    "amount":document.getElementById("totalAmountDisplay").innerHTML.trim()*100,
		    "name": "Avdhesh Gupta",
		    "description": "Purchase Description",
		    "image": "",
		    "handler": function (response){
		    	
		    	if(response.razorpay_payment_id==""|response.razorpay_payment_id==null)
		    		{
		    		alert("Please Try Again");
		    		}
		    	else{
		 document.getElementById("paymentId").value=response.razorpay_payment_id;
		 document.getElementById("totalAmount").value=document.getElementById("totalAmountDisplay").innerHTML.trim()*100;
		 document.cart.action="authorizePayment";
		 document.cart.submit();	  
		 loader("chakri");
		    	}
		     		    },
		    "prefill": {
		        "name": "",
		        "email": '${emailId}',
		        	 "contact": '${contact}'
		    },
		    "notes": {
		        "address": ""
		    }
		};

	var rzp1 = new Razorpay(options);
	rzp1.open();
    e.preventDefault();
});
</script>

</body>
</html>
