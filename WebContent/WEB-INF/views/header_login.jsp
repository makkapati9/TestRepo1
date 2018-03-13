<%@page pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MDM</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/Common.js"></script>
<link rel="shortcut icon" type="image/png" href="images/log.png">
<!-- <link href="style/style.css" rel="stylesheet" type="text/css" /> -->
<!-- <link href="style/menu.css" rel="stylesheet" type="text/css" />
<link href="style/newstyle.css" rel="stylesheet" type="text/css" />
<link href="style/style_3.css" rel="stylesheet" type="text/css" />
 <link href="style/menu.css" rel="stylesheet" type="text/css" /> 
  <link href="style/styles.css" rel="stylesheet" type="text/css" />  -->
 <!--  <link href="style/style_3.css" rel="stylesheet" type="text/css" /> -->
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all" />
 <link href="style/style_3.css" rel="stylesheet" type="text/css" /> 


<style>


.header-content {
    background-color: #0a3151;
    box-shadow: 0 0 5px #333;
    min-width: 978px;
    position: relative;
    transition: all 200ms linear 0s;
    width: 100%;
    color: white;
    padding-left: 5px;
}

.las {
    color: #FFF;
    background: none repeat scroll 0% 0% #3498DB;
    border-radius: 50%;
    padding: 3px 10px;
    font-size: 16px;
    font-weight: 400;
    font-family: "Open Sans",sans-serif;
}


</style>

<script>
function openNewWindow(url)
{
	
		popupWin = window.open(url);
}


</script>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body><!---->
	 <div id="wait" align="center" style="display: none; width: 99%; height: 180%; z-index: 1; background-color: gray; opacity: 0.5; border: 1px solid black; position: absolute; padding: 2px;">
		<img style="margin-top: 150px;" src='<%=request.getContextPath()%>/images/spinnerLarge.gif' width="80"	height="80" /><br>
	</div>
		<div class="wrap">
		
		
				<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<td >
					 -->	
<input type="hidden" id="availableTags" value=""></input>						
						<div class="header">
<div  class="top-header">
			
				<div class="top-header-left">
					<ul class="support">
						<li><a href="#"><label> </label></a></li>
						<li><a href="contact" rel="ibox">24x7 live<span class="live"> support</span></a></li>
					</ul>
					<ul class="support">
						<li class="van"><a href="#"><label> </label></a></li>
						<li><c:choose>
				
				<c:when test="${loginName eq '' || loginName eq null}">
					<a href="trackOrder" rel="ibox">Track Order</a>
					</c:when>
				<c:otherwise>
					<a href="trackOrder">Track Order</a>
				</c:otherwise>
				</c:choose>
				</li>
					</ul>
					<div class="clearfix"> </div>
					 <!---->
					<div class="clearfix"> </div>	
				</div>
				<div class="clearfix"> </div>		
			</div>
	


		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="login"><img src="images/logo.jpg" alt=" " /></a>
					</div>
					<div class="search">
											<input type="text" value="" id="searc"	onkeypress="sugg('searc');" placeholder="Search" >
					
				
						

					</div>
					
				</div>
				<div class="header-bottom-right">	
				<c:choose>
				
				<c:when test="${loginName eq '' || loginName eq null}">
				
			<!-- 	<div class="account">	<a href="signup" rel="ibox"><b>
									<font size="2px" color="#F97E76"><u>Sign Up</u> </font></b></a>
								&nbsp;&nbsp;
									
									<a href="loginup" rel="ibox"><b>
									<font size="2px" color="#F97E76"><u>Login</u></font></b></a>
									</div> -->
									<ul class="login">
								<li>	<a href="loginup" rel="ibox"><span> </span>LOGIN</a></li> <!-- | -->
							<li ><!-- <a href="signup" rel="ibox">SIGNUP</a> --></li>
							</ul>
									
				</c:when>
				<c:otherwise>
						<div class="account"><a href="#"><span></span></a> <font size='3'><b>${loginName}</b></font></div>
				</c:otherwise>
				</c:choose>			
				
				
							
								<c:choose>
				
				<c:when test="${loginName eq '' || loginName eq null}">
					</c:when>
				<c:otherwise>
					<div class="cart"><a href="cart"><span></span>&nbsp;</a><span id="productSelectedNo" class="las">${map.productInCart}</span>  
								</div>
						
				<form id="logout" name="logout" method="post"> </form>
								 <a href="#"><b>
									<font size="2px" color="#F97E76"><span onclick="signout();">Logout</span></font></b></a>
					</c:otherwise>
				</c:choose>			
				
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
						<%-- <table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								
								
								<tr>
							
									<td align="right" width="50%">
								<c:choose>
								
								<c:when test="${loginName eq '' || loginName ==null}">
							
								<a href="signup" rel="ibox"><b>
									<font size="2px" color="white"><u>Sign Up</u> </font></b></a>
								&nbsp;&nbsp;
									
									<a href="loginup" rel="ibox"><b>
									<font size="2px" color="white"><u>Login</u></font></b></a>
									
			
								</c:when>
								<c:otherwise>
								Welcome ${loginName}
							
										
								
								</c:otherwise>
								</c:choose>		
														</td>
										</tr>
								
								
							</table>  --%></td>
					</tr>
					<tr>
						<td valign="top" >
						
							<%-- <div style="width:45%;float:left"><jsp:include page="date.jsp" flush="true" /> | <a href="verifyLogout"><span>LOGOUT</span></a></div>
							<div style="text-align:right;width:50%;padding-right:10px;font-size:15px;float:left">${map.loginname}</div>
							<div class="clear"></div> --%>
						</td>
					</tr>
					
					</table>
<%-- 		
<div class="header-content"> 
						
			   <script src="js/script.js"></script>
      
<c:choose>

<c:when test="${map.headerCheck eq '1'}">
</c:when>

<c:otherwise>
<div id='cssmenu'>
<ul>
   <li class='active'><a href='#'>Home </a></li>
   <li><a href='#'>About Us</a></li>
   <li><a href='#'>Contact Us</a></li>
   <li><a href='#'>News</a></li>
</ul>
</div>

</c:otherwise>
</c:choose>		
 </div> --%>
 <script type="text/javascript" src="js/ibox.js"></script>
 