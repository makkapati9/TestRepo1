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
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
 -->
<!--  <link href="style/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="js/js-image-slider.js" type="text/javascript"></script>
    <link href="style/generic.css" rel="stylesheet" type="text/css" />
 -->
<!-- <style>

.productModule  {
    background-color: #fff;
    border: 1px solid #ccc;
    height: 260px;
    text-decoration: none;
}
.module {
	position: relative;

	background-color:#0a3151;
	
}

.pu-offer {
    background-color: #f44e4e;
    color: #fff;
    margin-bottom: 4px;
    overflow: hidden;
    padding: 4px 5px;
    text-overflow: ellipsis;
   white-space: nowrap;
margin-bottom: 4px;
}

.nam {
    background-color:blue;
    color: #fff;
    margin-bottom: 0px;
    overflow: hidden;
    padding: 4px 5px;
    text-overflow: ellipsis;
   white-space: nowrap;
margin-top: 20px;
}


</style>
 -->
</head>

<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>
<link rel="stylesheet" type="text/css" href="style/style_3.css" />


<%@ include file="/WEB-INF/views/header_login.jsp"%>





<body>
	<form name="loginform" id="loginform" method="post" autocomplete="off">
<input type="hidden" id="onProcessing" value="0">




 <div class="container"> 
	<div class="women-product">
		<div class=" w_content">
			<div class="women">
				<a href="#"><h4><span>${map.categoryName}</span> </h4></a>
				<ul class="w_nav">
					<li>Sort : </li>
			     	<li><a href="#">Low </a></li> |
			     	<li><a href="#">Medium</a></li> |
			     	<li><a href="#">High </a></li> 
			     <div class="clearfix"> </div>	
			     </ul>
			     <div class="clearfix"> </div>	
			</div>
		</div>
		
		<!-- grids_of_4 -->
		<div class="grid-product" id="gridoo">
		
	 	<c:forEach var="listItems" items="${map.productInfo}">
	 	
	 	  <div class="  product-grid">
			<div class="content_box"><a href="productInfo?productId=${listItems[0]}&categoryId=${listItems[3]}&subCategoryId=${listItems[4]}">
			   	<div class="left-grid-view grid-view-left">
			   	   	 <img src="data:image/png;base64, ${listItems[7]}" class="img-response watch-right" alt=""/>
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				</div>
				    <h4><a href="#"> ${listItems[1]}</a></h4>
				  <!--    <p>It is a long established fact that a reader</p>
 -->				     Rs. ${listItems[5]}
			   	</div>
              </div>
              
	 	</c:forEach> 
		
<script type="text/javascript">
$(window).scroll(function() {
	
	if($(this).scrollTop() >= $('#gridoo').innerHeight()) {
		
		lazyLoad("getMoreProducts","categoryId=${map.categoryId}&subCategoryId=${map.subCategoryId}&count1=${map.count1}&count2=${map.count1}","");
           
        }
  
});

</script>              
              <div id ="moreProducts"> </div>
              
              
              
				<div class="clearfix"> </div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/productMenu.jsp"%>
	
	
		</div>		
 <div class="clearfix"> </div>			
			<div class="clear"></div>




	
	</form>

	<%@ include file="/WEB-INF/views/footer.jsp"%>



</body>

</html>



