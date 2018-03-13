<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>



<style>

.alpha30 {
    background: none repeat scroll 0px 0px rgba(51, 51, 51, 0.3);
}
.black_overlay {
	display: block;
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 106%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.1;
	opacity: .70;
	filter: alpha(opacity = 80);
	
}

.white_content {
	display: block;
	position: fixed;
	top: 8%;
	left: 35%;
	width: 40%;
	height: 60%;
	padding: 0px;
	border: 16px;
	/* background-color: white; */ 
	z-index: 1002;
	
} 

.login-form
{
  width: 100%;
  margin: 0% auto 0 auto;
}
.login-form h1 {
  font-size: 2.5em;
  text-align: center;
  padding: 2em 0;
  color: #fff;
}
/*--- form-left ----*/
.form-left 
{
  position: relative;
  background: #fff;
  padding: 1em;
  width: 100%;
  height:150%;
  margin: 0 auto;
}
.form-left span
{
	width: 17%;
	float:left;
	margin-top: 0;
	text-align:right;
}
.form-left  input[type="text"],.form-left  input[type="password"]
{
	   width: 66%;
	float:right;
	font-family: 'Open Sans', sans-serif;
	letter-spacing: 1px;
}
.form-left  form
{
	line-height:2.6em;
}
.form-left form span
{
	color:#999;
	font-size:18px;
}
.form-left form input[type="text"] 
{
  padding: 3% 12% 3% 3%;
  background: #fafafa;
  color: #999;
    border: rgba(181, 181, 181, 0.21) solid 1px;
  outline: none;
  font-size: 14px;
  border-radius: 5px;
}
.form-left form input[type="text"]:hover
{
	border:1px solid #0399C7;
}
.form-left input[type="button"]{

  
   background: #282828 url("../images/submit-btn1.png") no-repeat scroll 0 0;
    border: 5px solid #ececec;
    cursor: pointer;
    display: inline-block;
    height: 40px;
    left: 18%;
    outline: medium none;
    position: relative;
    top: 15%;
    width: 40px;
}

h1, .h1, h2, .h2, h3, .h3 {
    margin-bottom: 0px;
    margin-top: 0;
}


.form-left p {
  margin-left: 19%;
}
.form-left form p a
{
	color:#999;
	font-size: 16px;
}
.form-left  p a:hover
{
	color:#B5B5B5;
}
.clear
{
	clear:both;
}	
/*--- copy-right ----*/
.copy-right
{
  text-align: center;
  position: absolute;
  bottom: -274px;
    right: 720px;
  padding-bottom: 3em;
}
.copy-right p
{
	color:#fff;	
}
.copy-right p a
{
	color:#fff;
}
.copy-right p a:hover
{
	color:#999;
	transition:0.5s;
	-webkit-transition:0.5s;
	-moz-transition:0.5s;
	-o-transition:0.5s;
	-ms-transition:	0.5s;
}
.form-control:focus {  border-color: #66afe9;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102, 175, 233, 0.83);
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102, 175, 233, 0.75);
}
img{max-width:100%;}
.lb-close-btn {
    background: rgba(0, 0, 0, 0) url("images/into.png") no-repeat scroll -5px -2px;
    cursor: pointer;
    height: 27px;
    margin: 4px 0px 0 0;
    position: absolute;
    right:0px;
    top: 0px;
    width: 27px;
}
.lb-close-btn {
    transition: box-shadow 0.4s ease 0s;
}

</style>

</head>
<body>
<div  class="alpha30">

					<div id="light" class="white_content">
				<div id="chakri"></div>

	<div class="form-left">
	 <div class="lb-close-btn" onclick="closeIt();"></div> 
		<c:forEach var="listItem" items="${map.cartProductsDesc}">
			
		
		<h4>Order Id <font color="blue"> ${listItem[1]}</font> &nbsp;&nbsp;  Status <font color="green">
			<c:set var="stat" value="${listItem[24]}"></c:set>
		<u>${listItem[24]} </u></font></h4>
		
		<table>
		<tr><td width="50%">Name: ${listItem[18]}</td><td width="50%">Email ${listItem[0]}</td></tr>
		<tr><td width="50%" >Mobile No ${listItem[4]}</td>
		<td width="50%" >Address ${listItem[3]}</td></tr>
		<tr><td>Order Date: <fmt:formatDate
															pattern="dd-MM-yyyy" value="${listItem[6]}" /> </td>
															<td>Delivery Date: <c:set var="tot" value="${listItem[23]}"></c:set>
															
															<c:set var="sellFlag" value="${listItem[16]}"></c:set>
															
															<c:choose>
															<c:when test="${sellFlag eq '1'}">
															<fmt:formatDate
															pattern="dd-MM-yyyy" value="${listItem[8]}" />
															</c:when>
															<c:otherwise>
															<fmt:formatDate
															pattern="dd-MM-yyyy" value="${listItem[7]}" />
															</c:otherwise>
															</c:choose>
															</td></tr>
		</table>
</c:forEach>
	<!-- <h6>Name:</h6>
		<h6> Id:</h6>
		<h6>:</h6>
	 <h6>Address:</h6> 
	 -->
			<form name="sellerform" id="sellerform" method="post">
								<div class="container" style="box-shadow: 10px 10px 5px #888888;">

						<table>
						<thead style="background-color:#E0E0D1">
						<tr><th colspan='2' width='40%'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item </th>
						<th align="center">Quantity</th>
					<!-- 	<th align="center">Price</th> -->
						<th align="center">SubTotal</th> 
						<th align="center">Status</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="listItem" items="${map.cartProductsDesc1}"
					varStatus="counter">
						<tr style="border:1px solid;border-color:threedlightshadow;">
						<td colspan='2'>
						 <img src="data:image/png;base64, ${listItem[9]}" height="44" width="44" alt=""/>
				
						&nbsp;&nbsp;&nbsp;${listItem[1]}</td>
						
						<td width="20%" align="center">
								${listItem[7]}
						</td>
					
						<td width="30%" align="left">${listItem[8]}</td>
						<td> ${stat}
						<%-- 
						<c:if test="${sellFlag eq '1'}" >
						<c:if test="${listItem[12] ne '9'}" >
						<a class="now-get get-cart-in" style="float:left;" rel ="ibox" href="trackOrderDetails?orderId=${listItem[1]}" id='bef'>Return</a> 
</c:if>

<c:if test="${listItem[12] eq '9'}" >		
					  <a class="now-already get-cart-in" href="#" id='af'  style="display:none"><font color='black'>Returned</font></a> 
				
						</c:if>
</c:if>
 --%></td></tr>
								
					
						</c:forEach>
						</tbody>
						</table>
						
						

					</div>
					
					<div style="float:right;"><h4>Amount Paid:<b> Rs.${tot}</b></h4></div>
					
			
			</form>
		</div>
	</div>
					
						
				</div>
				
		<div id="fade" class="black_overlay"></div>
</body>

