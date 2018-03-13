<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:forEach var="listItems" items="${map.productData}">

<table width="98%" border="0" cellspacing="0" cellpadding="4"
						class="nom">
						<tr>
							<td width='10%'>Product Name</td>
							<td width='35%'>
							
							<input type="hidden"
								id="productId" name="productId" value="${listItems.productId}"></input>
										<input type="hidden"
								id="sellerId" name="sellerId" value="${listItems.sellerId}"></input>
								
									
							<input type="text" class="text1" value="${listItems.productName}" maxlength="80"
								id="productName" name="productName"  onclick="hideSpan('productNameError')"/></td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Actual Price</td>
							<td width='35%'><input type="text" class="text1"
								id="actualPrice" name="actualPrice" maxlength="4"
		`						onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="${listItems.actualPrice}" /></td>


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
									<c:out value="${listItems.productDescription}"></c:out> </textarea></td>
							<td width=10%></td>
							<td width='10%' colspan="1" align="left">Discount Price</td>
							<td width='35%'><input type="text" class="text1"
								id="discountedPrice" name="discountedPrice" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="${listItems.discountedPrice}" /></td>
						</tr>

						<tr>

							<td>Select Category</td>
							<td><select class="select" id="categoryId" name="categoryId"
								onchange="">
									<option value="0">Please Select category</option>

									<c:forEach var="listItem" items="${map.catList}">
										<option value="${listItem.categoryId}">${listItem.categoryName}</option>



									</c:forEach>
							</select></td>
							<td width=10%></td>
							<td width='10%' colspan="1" align="left">Discount %</td>
							<td width='35%'><input type="text" class="text1"
								id="discount" name="discount" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="${listItems.discount}" /></td>
						</tr>
<tr>

						
					
							<td >Quantity</td>
							<td width='35%'><input type="text" class="text1"
								id="quantity" name="quantity" maxlength="2"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="${listItems.quantity}" /></td>
								
											<td width=10%></td>
							<td width='10%' colspan="1" align="left">Is Active</td>
							<td width='35%'>
							<select class="select" id="isActive" name="isActive"
								onchange="">
								<c:choose>
								<c:when test="${listItems.isActive eq 1}">
									<option value="1" selected>Active</option>

									<option value="0" >In Active</option>
									</c:when>
									<c:otherwise>
									<option value="1" >Active</option>

									<option value="0" selected>In Active</option>
									</c:otherwise>
									
									
									</c:choose>
							</select>
								
								
								</td>
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
							<td width='35%'><input type="text" class="text1" value="${listItems.deliveryTime}"
								id="deliveryTime" name="deliveryTime" maxlength="1"
								onkeypress="return isNumberKeyForMobile(event);" /></td>
							<td width=10%></td>

							<td width='10%' colspan="1" align="left">Delivery Charges</td>
							<td width='35%'><input type="text" class="text1"
								id="deliveryCharges" name="deliveryCharges" maxlength="4"
								onkeypress="return isNumberKeyForMobile(event);" onblur=""
								value="${listItems.deliveryCharges}" /></td>


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
							<td align="left" colspan="2" class="heading1"><u>Images
									Panel</u></td>
							<td align="left" colspan="2"></td>
							<td align="left" colspan="2"></td>
						</tr>
						
												
					</table>
					</c:forEach>
					
				<table width="98%" border="0" cellspacing="0" cellpadding="4"
						class="nom">
											
<c:forEach var="listItems" items="${map.productImages}">
						
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
						

</c:forEach>
					</table>