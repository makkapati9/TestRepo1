<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bhamashah Yojana</title>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<link href="style/menu.css" rel="stylesheet" type="text/css" />
<link href="style/newstyle.css" rel="stylesheet" type="text/css" />
<link href="style/style_3.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/Common.js"></script>
</head>
<body>
<div class="wrapf">
<div id="header">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
					<tr>
						<td class="headerbg">
						<table width="100%" border="0"	cellspacing="0" cellpadding="0">
								
								
								<tr>
									<td align="left" width="50%"><img
										src="images/national_logo.png" alt="" /></td>
									<td align="right" width="50%"><img
										src="images/bha_logo.png" alt="" /></td>
								</tr>
								<tr>
									<td colspan="2"><div
											style="margin-left: 18px; font-size: 9px">राजस्थान
											सरकार</div></td>
								</tr>
								
								
							</table></td>
					</tr>
					<tr>
						<td valign="top" colspan="2">
							<div id="menu">
								<ul class="menu">
									<li><a href="#" class="parent"><span>Home</span></a></li>
									<li><a href="http://bhamashah.rajasthan.gov.in/PDF/About_us.pdf"  target="_blank"><span>About Us</span></a></li>
									<li><a href="http://bhamashah.rajasthan.gov.in/UserP/feedback.aspx" target="_blank"><span>FeedBack</span></a></li>
									<li><a href="http://bhamashah.rajasthan.gov.in/PDF/Bhamashah%20FAQ.pdf" target="_blank"><span>FAQ</span></a></li>
									<li class="last"><a href="http://bhamashah.rajasthan.gov.in/UserP/Contactus.aspx" target="_blank"><span>Contact Us</span></a></li>
<%-- 									<li class="last"><jsp:include page="date.jsp" flush="true" /></li>
 --%>								</ul>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="banner_innerNew">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="672" class="titlelogo_inner"></td>
									<td width="320" class="titlelogo_inner"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
				</tr>
					</table>
						
							<table cellspacing="0" cellpadding="0" border="0" width="100%"  style="background:#fff">
                                    <tbody><tr id="trLogin">
		<td width="2%">&nbsp;</td>
		<td align="left" width="98%" class="lables">
                                            <span style="font-size:Small;font-weight:bold;" id="lblUserName">Welcome :${loginname}</span> &nbsp;
                                            <span style="font-size:Small;font-weight:bold;" id="lblDistrictName"></span> &nbsp;
                                             <span style="font-size:Small;font-weight:bold;" id="lblUserName"> <c:if test="${map.districtName !=null}">| District:${districtName} |</c:if></span> &nbsp;
                                             
                                             <span style="font-size:Small;font-weight:bold;" id="lblLoggedinTime">Logged in Time:${loginTime}</span>
                                        </td>
										<td>
                                            </td><td align="right" width="98%" class="lables">
                                             <a style="font-size:Small;font-weight:bold;" href="verifyDashBoard" >Go Back To Dashboard</a>&nbsp;
                                             &nbsp;
                                             
                                            <a style="font-size:Small;font-weight:bold;" href="changePasswordLink" >Change Password</a>&nbsp;
                                            <a style="font-size:Small;font-weight:bold;" href="verifyLogout">Logout</a>
                                        </td>
                                        <td width="2%">&nbsp;</td>
                                    </tr>
                                </tbody></table>
		</div>
