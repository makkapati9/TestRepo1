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
								<h2>Slider</h2>
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
						  loader('chakri');
			  $.ajax({
			    url: 'setSlider',
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