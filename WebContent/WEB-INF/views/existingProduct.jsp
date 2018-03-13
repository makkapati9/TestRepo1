<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller-End</title>
<link rel="stylesheet" type="text/css" href="style/style_3.css" />
<link rel="stylesheet" type="text/css" href="style/form.css" />
<script type="text/javascript" src="js/Common.js"></script>

<%@ include file="/WEB-INF/views/header_seller.jsp"%>
</head>
<body>
<form name="sellerform" id="sellerform" method="post">
<div id="chakri"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="4"
			>
			
			
			<tr>
			
			
			<td width="20%" valign="top" >
				<table width="95%" border="1" cellspacing="0" cellpadding="4"
			bgcolor="blue">
			
<tr><td  onmouseover="" style="cursor:pointer"  onclick="addProduct();">ADD PRODUCT</td></tr>
<tr><td  onmouseover="" style="cursor:pointer"  bgcolor="red"  onclick="existingProduct();">EXISTING PRODUCTS</td></tr>	
<tr><td  onmouseover="" style="cursor:pointer" onclick="orders();">ORDERS</td></tr>
<tr><td  onmouseover="" style="cursor:pointer" onclick="rating();">RATING</td></tr>		
	




	</table>
			
			
			
			
			</td>
			
			<td>
<table width="95%" border="0" cellspacing="0" cellpadding="4"
			class="nom">
			
			<tr>
				<td colspan="4">
					<h2>Existing Products </h2>
				</td>
			</tr>
		
			
			<tr>
			<td height="40" colspan="4" style="border-top: 1px solid #000" align="center"> <h3><font color="green"><u>Product Information</u></font></h3> </td>
			</tr>
		</table>
					
<c:choose>
<c:when test="${fn:length(pagedcust.productInfo)>0}">
			<table id="tbl_report" align="center" cellpadding="3" cellspacing="2" border="0" class="gridviewnew" style="width:97%; padding: 5px;">       
					<thead>
					<tr>
					    <th width="15">Select</th>
					    <th width="10">S.No</th>
						<th width="25">Product Id</th>
							<th width="25">Product Name</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="cust" items="${pagedcust.productInfo}" varStatus="status">
					<tr>
					   <td><input type='radio' name='selection' value=""
						id='selRd2'
							onclick="load_product('editProduct','bhDtl','chakri', 'productId=${cust.productId}');"> </td>
					  	   
					  	   <td>
					  	   <c:choose>
					  	   <c:when test="${status.count == 10}">
					  	   ${page+1}0
					  	   </c:when>
					  	  <c:otherwise>
					  	   ${page}${status.count}
					  	  </c:otherwise> 
					  	   </c:choose>
					  	  
					  	   </td>
					  	    <td>${cust.productId}</td>
					  	     <td>${cust.productName}</td>
						   				
					</tr>
					</c:forEach>
					</tbody>
				</table>
		
			
			<div id="content">
				<div align="center">
					<c:if test="${!pagedcust.navInfo.firstPage}">
						<a href="existingProduct?page=0">First</a>&nbsp;
					</c:if>
					<c:forEach var="i" items="${pagedcust.navInfo.indexList}">
						<c:choose>
						<c:when test="${i != pagedcust.navInfo.currentPage}">
							<a href="existingProduct?page=${i}">${i}</a>&nbsp;
						</c:when>
						<c:otherwise>
							<b>${i}</b>&nbsp;
						</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${!pagedcust.navInfo.lastPage}">
						<a href="existingProduct?page=${pagedcust.navInfo.pageCount - 1}">Last</a>
					</c:if>
				</div>
		</div>
		
		</c:when>
			<c:otherwise>
			
			
		<font color="red">No Details Found</font>	
			
			</c:otherwise>
				
				</c:choose>
				
				</td>
				</tr>
				</table>
				<div id="bhDtl"></div>
				
			</form>
		
	<%@ include file="/WEB-INF/views/footer.jsp"%>


<script type="text/javascript">


function addProduct()
{
	document.sellerform.action = "getProductId";
	document.sellerform.submit();
}


function existingProduct()
{
	document.sellerform.action = "existingProduct";
	document.sellerform.submit();
}


function orders()
{
	document.sellerform.action = "orders";
	document.sellerform.submit();
}


function rating()
{
	document.sellerform.action = "rating";
	document.sellerform.submit();
}






function saveImage(imgId,id,imageSetter,hiddenImageId) {
	if (document.getElementById(imgId).value == "") {
		alert("Please select Image");
		return false;
	}

	imageVal = document.getElementById(imgId).value.split('.');
	var ext = imageVal[imageVal.length - 1].toLowerCase();
	if ((ext != 'jpg')
			&& (ext != 'jpeg')
			&& (ext != 'gif')
			&& (ext != 'png')) {
		alert("कृपया फाइल jpg, jpeg, gif, png फॉर्मेट में चुने|");
		return false;
	}

	var filesize = ((document.getElementById(imgId).files[0].size) / (1024 * 1024))
			.toFixed(2);
	if (filesize > 0.1) {

		alert("File size must not be greater than 100 kb");
		return false;
	}
		var oMyForm = new FormData();
	  oMyForm.append("upfile", document.getElementById(imgId).files[0]); 
		  oMyForm.append("pId", document.getElementById("productId").value);
		  oMyForm.append("imageId",id);


loader('chakri');
	  $.ajax({
	    url: 'saveImage',
	    data: oMyForm,
	    dataType: 'text',
	    processData: false,
	    contentType: false,
	    type: 'POST',
	    success: function(data){
	    	remove_popup('chakri');
	    	if(data != "2"){
	    		document.getElementById(imageSetter).innerHTML = "<img width='110' src=data:image/png;base64,"+ data + " />";
	    		document.getElementById(hiddenImageId).value ="1";
	    	} else{
	    		alert("IMAGE NOT SAVED");
	    	}
	    }
	  });

}
		</script>
</body>
</html>