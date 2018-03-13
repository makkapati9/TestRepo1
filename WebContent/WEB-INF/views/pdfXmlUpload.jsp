
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/views/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/views/EmitraHeader.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="js/Validation.js"></script>
<link href="style/style_3.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="style/form.css" />
<style type="text/css">
a:link {
	color: blue;
}

.span {
	display: inline-block;
	width: 20px;
}

.text {
	font-weight: bold;
}
</style>
<script type="text/javascript">

	

	function chckExists() {
		var file = document.getElementById("uploadFile");
		if (file.value == "") {
			alert("कृपया कोई फाइल चुने|");
			return false;
		}
		imageVal = file.value.split('.');
		var ext = imageVal[imageVal.length - 1].toLowerCase();
				if (ext != 'xml') {
					alert("कृपया सभी फाइल xml फॉर्मेट में चुने|");
					return false;
				}
				var filesize = ((file.files[0].size) / (1024 * 1024))
						.toFixed(2);
			if (filesize > 5.0) {
					alert("फाइल का साइज 5 MB से अधिक नही हो सकता|");
					return false;
				}
			var oMyForm = new FormData();
			oMyForm.append("uploadFile", file.files[0]);
			loader('chakri');
			$.ajax({
				url : 'uploadingCitizenPdfXmDoc',
				data : oMyForm,
				dataType : 'text',
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					//alert(data);
					if (data.trim() != "0") {
						alert("File Uploaded Succesfully");
						document.searchBid.action = "uploadCitizenDocument";
						document.searchBid.submit();
					} else {
						remove_popup('chakri');
						alert("File can not be uploaded Succesfully");
					}
				}
			});

	}

	function openDoc(id) {
		var url = 'http://164.100.222.209:9080/DocAck/model/searches/SearchAndViewAckWithTemplateDOIT.html?ackno='
				+ id;
		popupWin = window.open(url, 'open_window',
				'scrollbars=yes, dependent, width=1200, height=700');
	}

	function downloadDoc(id) {
		popupWin = window.open('downloadBhamashahDoc?documentName=' + id,
				'open_window',
				'scrollbars=yes, dependent, width=600, height=350');
	}
</script>
</head>
<body>
	<form name="searchBid" id="searchBid" method="post">
		<input type="hidden" value="${map.bhamashahId}" id="mainBhid" name="mainBhid"/>
			
		<h2>Document Upload</h2>
		<hr />
		

		<div id="chakri"></div>

		
		<hr />
		<div id="details">
		
							<table class="gridviewnew" id="mapperTable" width="60%">
					<tr class="nom1">
										<th>क्र सं </th>
										<th>आधार  संख्या</th>
										<th>भामाशाह रसीद संख्या</th>
										<th>नाम</th>
										<th>माता का नाम</th>
										<th>पिता का नाम</th>
										<th>पति / पत्नी का नाम</th>
										<th align="left">दस्तावेज़</th>
							

									</tr>

								 

										<c:forEach var="list1" items="${map.enrollhof}" varStatus="counter">
											<tr>
										<td>${counter.count}</td>
											<td>${list1[0]}</td>
											<td>${map.bhamashahId}</td>
											<td>${list1[3]}</td>
											<td>${list1[39]}</td>
											<td>${list1[59]}</td>
											
											<td>${list1[43]}</td>
											<td><c:choose>
												<c:when test="${map.count ne '0'}">
													<a href="#" onclick="openDoc('${map.bhamashahId}')"><img
														src="images/badge-pdf.jpg" width="20" height="20"
														alt="View-Document" /></a>
												</c:when>
											</c:choose></td>
									
									</tr>					
										</c:forEach>
										 					
									
				
							</table>
<table>
								<tr>
									<td width="40%" valign="5"></td>
									<td width="30%">
									<input type="file" value="" name="uploadFile" id="uploadFile" /></td>
									<td align="left"><input type="button"
										value="अपलोड पी.डी.एफ़" onClick="chckExists()" class="appBtns"></input></td>
								</tr>
							</table>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>