<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="js/Common.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller-End</title>
<link rel="stylesheet" type="text/css" href="style/style_3.css" />


<%@ include file="/WEB-INF/views/header_seller.jsp"%>
</head>
<body>
<form name="sellerform" id="sellerform" method="post">
<div id="chakri"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="4"
			class="nom">
			
			
			<tr>
			
			
			<td width="20%" valign="top" >
				<table width="95%" border="1" cellspacing="0" cellpadding="4"
			bgcolor="blue">
			
<tr><td  onmouseover="" style="cursor:pointer"  onclick="addProduct();">ADD PRODUCT</td></tr>
<tr><td  onmouseover="" style="cursor:pointer" onclick="existingProduct();">EXISTING PRODUCTS</td></tr>	
<tr><td  onmouseover="" style="cursor:pointer"  bgcolor="red"  onclick="orders();">ORDERS</td></tr>
<tr><td  onmouseover="" style="cursor:pointer" onclick="rating();">RATING</td></tr>		
	




	</table>
			
			
			
			
			</td>
			
			<td>
<table width="95%" border="0" cellspacing="0" cellpadding="4"
			class="nom">
			
			<tr>
				<td colspan="4">
					<h2>Add Product Form </h2>
				</td>
			</tr>
		
			
			<tr>
			<td height="40" colspan="4" style="border-top: 1px solid #000" align="center"> <h3><font color="green"><u>Product Information</u></font></h3> </td>
			</tr>
		</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="4"
			class="nom">
<tr>
					<td width='10%'>Product Name</td><td width='35%'><input type="text"  class="text1" value="" id="productName" name="productName" /> </td>
<td width=10%></td>
					
						<td width='10%' colspan="1" align="left"><input type="file"
							name="upfile1" id="upfile1" />
							</td>
							<td width='35%'>
							<input type="button" value="Upload Main Image"
							onclick="saveImage('upfile1','byteimg1');" /></td>
					
				
				</tr>
				
				<tr>
				
				<td>Product Description</td>    
				
				
				
				
				<td>
				
				
								<textarea rows="2" id="productDesc" name="productDesc"
									style="width: 88%; border-color: #F205EA; resize: none;"
									maxlength="250" value="">
									<c:out value=""></c:out> </textarea>
				
				
				</td>
				<td width=10%></td>
				<td width='10%' colspan="1" align="left"><input type="file"
							name="upfile2" id="upfile2" />
							</td>
							<td width='35%'>
							<input type="button" value="Upload 2nd Image"
							onclick="saveImage();" /></td>
				</tr>

		<tr>
				
				<td>Select Category</td>    <td>
				
				
								<select class="select" id="category" name="category" onchange="">
									<option value="0">Please Select category</option>

								<c:forEach var="listItems" items="${map.catList}">
										<option value="${listItems.categoryId}">${listItems.categoryName}</option>
										
								
								
								</c:forEach>
								</select>
				
				
				</td>
				<td width=10%></td>
				<td width='10%' colspan="1" align="left"><input type="file"
							name="upfile3" id="upfile3" />
							</td>
							<td width='35%'>
							<input type="button" value="Upload 3rd Image"
							onclick="saveImage();" /></td>
				</tr>
				
					<tr>
					<td colspan="2"></td>
					<td style="padding-left: 0px;" width="5%" align="left">
						
								<font color="red">Photo*
									</font>
								<br />
								<font color="red" size="1"> </font>
								</td>
					<td width="40%" id="byteimg1">	
					</td>
				</tr>
		

</table>
			
			</td>
			
			</tr>
			</table>
	</form>		
	<%@ include file="/WEB-INF/views/footer.jsp"%>


<script type="text/javascript">


function addProduct()
{
	document.sellerform.action = "sellerEnd";
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







function saveImage(x,y) {
			if (document.getElementById(x).value == "") {
				alert("Please select Image");
				return false;
			}

			imageVal = document.getElementById(x).value.split('.');
			var ext = imageVal[imageVal.length - 1].toLowerCase();
			if ((ext != 'jpg')
					&& (ext != 'jpeg')
					&& (ext != 'gif')
					&& (ext != 'png')) {
				alert("कृपया फाइल jpg, jpeg, gif, png फॉर्मेट में चुने|");
				return false;
			}

			var filesize = ((document.getElementById(x).files[0].size) / (1024 * 1024))
					.toFixed(2);
			if (filesize > 0.1) {

				alert("फाइल का साइज 100 kb से अधिक नही हो सकता|");
				return false;
			}
		/* 	document.getElementById("isImageSaved").value = "y";
			document.getElementById("actionType").value = "";
 */
			/* document.mukhiyaDataForm.encoding = "multipart/form-data";
			document.mukhiyaDataForm.action = 'saveImage';
			document.mukhiyaDataForm.submit(); */
			var oMyForm = new FormData();
			 oMyForm.append("upfile", document.getElementById(x).files[0]);
			/*  oMyForm.append("pId", document.getElementById("pId").value);
			 oMyForm.append("imageId",document.getElementById("imageId").value);
	 */		 
	 oMyForm.append("pId", '11123');
	 oMyForm.append("imageId",'1');

	 
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
			    		document.getElementById(y).innerHTML = "<img width='110' src=data:image/png;base64,"+ data + " />";
			    	} else{
			    		alert(" can not save image");
			    	}
			    }
			  });
		
		}
		</script>
</body>
</html>