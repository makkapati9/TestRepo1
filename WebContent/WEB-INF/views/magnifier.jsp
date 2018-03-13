<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/header_login.jsp"%>
 <script src="js/jquery-1.6.js"></script>
        <script src="js/jquery.jqzoom-core.js"></script>
        <link href="style/jquery.jqzoom.css" rel="stylesheet" />


<style>

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


</style>
<script type="text/javascript">
            $(document).ready(function () {
                $('.minipic').jqzoom({
                    zoomType: 'standard',
                    lens: true,
                    preloadImages: false,
                    alwaysOn: false,
                   zoomHeight: 200,
                    zoomWidth:300
                });

            });
        </script>
</head>

<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>
<link rel="stylesheet" type="text/css" href="style/style_3.css" />








<body>
<form name="productForm" id="productForm" method="post">

<input type="hidden" id="productId" name="productId"  value="${map.productId}" />
					

 <c:forEach var="listItems" items="${map.productSelectedInfo}" varStatus="counter" begin="0" end="0">
		<table border="0px">

			<tr>
				<td width="10%">&nbsp;</td>
				<td colspan="2" rowspan="10" valign="bottom"><br /> <br />
					<div style="position: block; left: 500px; width: 400px;">
						<a href="data:image/png;base64, ${listItems[6]}" class="minipic"
							title="Magnified Image"> <img width="350" height="400"
							src="data:image/png;base64, ${listItems[6]}" /></a>


					</div></td>


				<td align="center"><h2>${listItems[3]}</h2></td>

			</tr>


<tr><td></td><td align="center">	 MRP : <del>Rs ${listItems[4]} </del>
		 </td></tr>
			 
			 <tr><td></td><td align="center">	
			 <div class="inbold">Deal price : Rs ${listItems[2]}</div> </td></tr>
			 
			  <tr><td></td><td align="center">	
			 <div class="inbold">No. Of Products : 
			 
			 <select id ="quantitySelected" name="quantitySelected"  >
			 <c:forEach var="quantity" begin="1" end="${listItems[7]}" >
			 <option value="${quantity}">${quantity}</option>
			 </c:forEach>
			 </select>
			
			
			  </div> </td></tr>
			
			  <tr><td></td><td align="center">	
			   <c:choose>
			   <c:when test="${listItems[8] eq 'Y'}">
			 <div class="inbold">Cash On delivery Charges: 
			 
			
			 ${listItems[9]}
			  </div> 
			  
			   </c:when>
			 </c:choose>
			  </td></tr>
			 
			 
			    <tr><td></td><td align="center">	
			   <c:choose>
			   <c:when test="${listItems[10] eq Y}">
			 <div class="inbold"> 
			 
			
			 ${listItems[11]} days Policy Applicable
			  </div> 
			  
			   </c:when>
			   
			   <c:otherwise>
			   <font color="red"> No return Policy</font> </c:otherwise>
			 </c:choose>
			  </td></tr> 
			 
			  <tr><td></td><td align="center">	
			 <div class="inbold">What Seller has to say : ${listItems[5]}</div> </td></tr>


<tr>
<td></td><td align="center">	
			 <input type="button" value="ADD TO CART" onclick="addToCart();" class="appBtns"> 

			 <input type="button" value="BUY NOW" onclick="buyNow();" class="appBtn">



			 <input type="button" value="BULK ORDER" onclick="bulkOrder();" class="appBt"> </td>
</tr>			 
		</table>

		
        </div>
        
        </c:forEach>
        
	<%@ include file="/WEB-INF/views/footer.jsp"%>


</form>
</body>

</html>