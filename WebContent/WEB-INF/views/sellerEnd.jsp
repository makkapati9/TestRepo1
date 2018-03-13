<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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


				<td width="20%" valign="top">
					<table width="95%" border="1" cellspacing="0" cellpadding="4"
						bgcolor="blue">

						<tr>
							<td onmouseover="" style="cursor: pointer" bgcolor="red"
								onclick="addProduct();">ADD PRODUCT</td>
						</tr>
						<tr>
							<td onmouseover="" style="cursor: pointer"
								onclick="existingProduct();">EXISTING PRODUCTS</td>
						</tr>
						<tr>
							<td onmouseover="" style="cursor: pointer" onclick="orders();">ORDERS</td>
						</tr>
						<tr>
							<td onmouseover="" style="cursor: pointer" onclick="rating();">RATING</td>
						</tr>





					</table>




				</td>

				<td>
					<table width="95%" border="0" cellspacing="0" cellpadding="4"
						class="nom">

						<tr>
							<td colspan="4">
								<h2>Add Product Form</h2>
							</td>
						</tr>


						<tr>
							<td height="40" colspan="4" style="border-top: 1px solid #000"
								align="center">
								<h3>
									<font color="green"><u>Product Information</u></font>
								</h3>
							</td>
						</tr>
					</table>
					<table width="98%" border="0" cellspacing="0" cellpadding="4"
						class="nom">
						<tr>
							<td width='10%'>Product Name</td>
							<td width='35%'>
							
							<input type="hidden"
								id="productId" name="productId" value="${map.productId}"></input>
								
								<input type="hidden"
								id="sellerId" name="sellerId" value="${map.sellerId}"></input>
								
									<input type="hidden"
								id="isActive" name="isActive" value="1"></input>
							
							<input type="text" class="text1" value="" maxlength="80"
								id="productName" name="productName"  onclick="hideSpan('productNameError')"/></td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Actual Price</td>
							<td width='35%'><input type="text" class="text1"
								id="actualPrice" name="actualPrice" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>
						
						<tr><td></td>
						<td><font color='red'>
						<span id=productNameError></span>
						</font></td>
						<td></td>
						<td></td>
						<td></td>
						</tr>

						<tr>

							<td>Product Description</td>




							<td><textarea rows="2" id="productDesc" name="productDescription"
									style="width: 88%; resize: none;" maxlength="1000" value="">
									<c:out value=""></c:out> </textarea></td>
							<td width=10%></td>
							<td width='10%' colspan="1" align="left">Discount Price</td>
							<td width='35%'><input type="text" class="text1"
								id="discountedPrice" name="discountedPrice" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>
						</tr>

						<tr>
	<td >Quantity</td>
							<td width='35%'><input type="text" class="text1"
								id="quantity" name="quantity" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>
								
							
							<td width=10%></td>
							<td width='10%' colspan="1" align="left">Discount %</td>
							<td width='35%'><input type="text" class="text1"
								id="discount" name="discount" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>
						</tr>
<tr>

						
					
						
								<td>Select Category</td>
							<td><select class="select" id="categoryId" name="categoryId"
								onchange="">
									<option value="0">Please Select category</option>

									<c:forEach var="listItems" items="${map.catList}">
										<option value="${listItems.categoryId}">${listItems.categoryName}</option>



									</c:forEach>
							</select></td>
							
							
							<td></td>
								<td>Select Sub Category</td>
							<td><select class="select" id="subCategoryId" name="subCategoryId"
								onchange="">
									<option value="0">Please Select Sub Category</option>
								
							</select></td>
							
						</tr>

						<tr>
							<td><br /></td>
						</tr>
						<tr>

							<td align="left" colspan="2" class="heading1"><u>Delivery
									Information</u></td>
							<td align="left" colspan="2"></td>
							<td align="left" colspan="2"></td>
						</tr>
						<tr>
						<tr>
							<td width='10%'>Delivery Time (Days)</td>
							<td width='35%'><input type="text" class="text1" value=""
								id="deliveryTime" name="deliveryTime" maxlength="1"
								onkeypress="return isNumberKeyForMobile(event);" /></td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Delivery Charges</td>
							<td width='35%'><input type="text" class="text1"
								id="deliveryCharges" name="deliveryCharges" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>

						<tr>
							<td width='10%'>Cash On Delivery</td>
							<td width='35%'><input type="radio" value="Y"
								name="cashOnDeliveryCheck" id="yes" onclick="selectValue('Y','cashOnDelivery','cashOnDeliveryCharges');">YES</input>
								<input type="radio" value="N" name="cashOnDeliveryCheck" id="no" checked="checked"
								onclick="selectValue('N','cashOnDelivery','cashOnDeliveryCharges');">NO</input> <input type="hidden"
								id="cashOnDelivery" name="cashOnDelivery" value="N"></input>

							</td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">C.O.D Charges</td>
							<td width='35%'><input type="text" class="text1" disabled="disabled"
								id="cashOnDeliveryCharges" name="cashOnDeliveryCharges" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>

<tr>
							<td width='10%'>One Day Delivery</td>
							<td width='35%'><input type="radio" value="Y"
								name="oneDayDeliveryCheck" id="y" onclick="selectValue('Y','oneDayDelivery','oneDayDeliveryCharges');">YES</input>
								<input type="radio" value="N" name="oneDayDeliveryCheck" id="n" checked="checked"
								onclick="selectValue('N','oneDayDelivery','oneDayDeliveryCharges');">NO</input> <input type="hidden"
								id="oneDayDelivery" name="oneDayDelivery" value="N"></input>

							</td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">O.D.D Charges</td>
							<td width='35%'><input type="text" class="text1" disabled="disabled"
								id="oneDayDeliveryCharges" name="oneDayDeliveryCharges" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>




	<tr>
							<td width='10%'>Return Policy</td>
							<td width='35%'><input type="radio" value="Y"
								name="returnPolicyCheck" id="yes" onclick="selectValue('Y','returnPolicy','returnPolicyDays');">YES</input>
								<input type="radio" value="N" name="returnPolicyCheck" id="no" checked="checked"
								onclick="selectValue('N','returnPolicy','returnPolicyDays');">NO</input> <input type="hidden"
								id="returnPolicy" name="returnPolicy" value="N"></input>

							</td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Return Days</td>
							<td width='35%'><input type="text" class="text1" disabled="disabled"
								id="returnPolicyDays" name="returnPolicyDays" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>


<tr>
							<td width='10%'>Gift Wrap</td>
							<td width='35%'><input type="radio" value="Y"
								name="giftWrapCheck" id="ye" onclick="selectValue('Y','giftWrap','giftWrapCharges');">YES</input>
								<input type="radio" value="N" name="giftWrapCheck" id="noe" checked="checked"
								onclick="selectValue('N','giftWrap','giftWrapCharges');">NO</input> <input type="hidden"
								id="giftWrap" name="giftWrap" value="N"></input>

							</td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Charges</td>
							<td width='35%'><input type="text" class="text1" disabled="disabled"
								id="giftWrapCharges" name="giftWrapCharges" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="" /></td>


						</tr>



						<tr>
							<td align="left" colspan="2" class="heading1"><u>Images
									Panel</u></td>
							<td align="left" colspan="2"></td>
							<td align="left" colspan="2"></td>
						</tr>
						
						
						<tr>
							<td width='10%'> <font color="red">Main Image</font></td>
							<td width='35%' id="byteimg1">
							</td>
							<td  colspan="3" align="left"><input type="file" name="upfile1"
							id="upfile1" /> 
							<input type="hidden"
								id="image1" name="image1" value="0"></input>
							<input type="button" value="Upload"
							onclick="saveImage('upfile1','1','byteimg1','image1');" /></td>


						</tr>
						
						
						
						
						<tr>
							<td width='10%'>1st Image</td>
							<td width='35%' id="byteimg2">
							</td>
							<td  colspan="3" align="left"> 
							<input type="hidden"
								id="image2" name="image2" value="0"></input>
							<input type="file" name="upfile2"
							id="upfile2" /> <input type="button" value="Upload"
							onclick="saveImage('upfile2','2','byteimg2','image2');" /> </td>


						</tr>
						
							<tr>
							<td width='10%'>2nd Image</td>
							<td width='35%' id="byteimg3">
							</td>
							<td  colspan="3" align="left"> 
							<input type="hidden"
								id="image3" name="image3" value="0"></input>
						<input type="file" name="upfile3"
							id="upfile3" /> <input type="button" value="Upload"
							onclick="saveImage('upfile3','3','byteimg3','image3');" /></td>


						</tr>
						


					</table>

			</tr>
			<tr><td colspan="2" align="center"><input type="button" value="submit" onclick="add();"> </td></tr>
		</table>
	</form>
<%-- 	<%@ include file="/WEB-INF/views/footer.jsp"%> --%>


	<script type="text/javascript">




function addProduct()
{
	document.sellerform.action = "sellerEnd";
	document.sellerform.submit();
}


function add()
{
	
	alert("1");
	
	 if(document.getElementById("productName").value=="")
	 {
		 document.getElementById("productNameError").innerHTML="Please fill Product Name";
		 
	 return false;
	 }
	 
	 else{
		 
		 document.sellerform.action = "addProduct";
			document.sellerform.submit();
	 }
	
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


function selectValue(val, ID1,ID2)
{
	document.getElementById(ID1).value = val;	
if (val=="N"){
	document.getElementById(ID2).value="";
	document.getElementById(ID2).disabled =true;	
}
	else{
		document.getElementById(ID2).disabled =false;	
}
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
			  var oMyForm = new FormData();
			  oMyForm.append("upfile", document.getElementById(imgId).files[0]);
			  oMyForm.append("imageId", id);
	 		  oMyForm.append("pId", document.getElementById("productId").value);
	 		  oMyForm.append("categoryId",document.getElementById("categoryId").value);
	 		  oMyForm.append("subCategoryId",document.getElementById("subCategoryId").value);
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