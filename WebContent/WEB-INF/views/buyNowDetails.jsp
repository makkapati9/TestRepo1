<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>




<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>


<style>

.alpha30 {
    background: none repeat scroll 0px 0px rgba(51, 51, 51, 0.3);
}
.black_overlay {
	display: block;
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 106%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.1;
	opacity: .70;
	filter: alpha(opacity = 80);
	
}

.white_content {
	display: block;
	position: fixed;
	top: 8%;
	left: 35%;
	width: 30%;
	height: 187px;
	padding: 0px;
	border: 16px;
	/* background-color: white; */ 
	z-index: 1002;
	
} 
.mai{
  margin: 0em 0px;
width:100%;
}




.create-account {
  background: url("images/bg.jpg")0px 0px no-repeat;
  display: block;
  width:105%;
  height: 60%;
  margin: 0 auto;
}
.create-account lable{
  color:#ed1c2f;
}
.login-head {
  padding: .5em 0em 0 2em;
  text-align: left;
}
.login-head h2 {
  font-size: 1.4em;
color: #fff;
font-weight: 400;
text-transform: uppercase;
font-family: 'Copse', serif;
}
span.line{
  width: 92%;
  height: 1px;
  background: #e6e6e6;
  margin: 0 auto;
  position: relative;
  display: inline-block;
}
span.sub-line{
  width: 43%;
  height: 1px;
  background: #ef1b34;
  position: absolute;
  top: 26%;
  left: 0%;
  display: inline-block;
  
}

h1, .h1, h2, .h2, h3, .h3 {
    margin-bottom: 0px;
    margin-top: 0px;
}
.create-account p {
  font-size: 1.1em;
  color: #fff;
  padding: .3em 0;
  font-weight: 400;
  font-family: 'Copse', serif;
   margin: 0 0 1px;
}
.login-head h1 {
font-size: 2em;
color: #fff;
font-weight:500;
font-family: 'Copse', serif;
}
form {
  padding: 1em 2em 0.3em 2em;
}
.create-account input[type="text"],.create-account input[type="password"] {
	width: 93%;
	height:42px;
  padding: 0.8em 0.8em;
  color: #fff;
  font-size: 14px;
  outline: none;
  background: none;
  font-weight: 500;
  border: 1px solid #fff;
  font-family: 'Roboto', sans-serif;
}

.textA {
resize: none;
	width: 93%;
	height:84px;
  padding: 0.8em 0.8em;
  color: #fff;
  font-size: 14px;
  outline: none;
  background: none;
  font-weight: 500;
  border: 1px solid #fff;
  font-family: 'Roboto', sans-serif;
}
.submit {
  padding: 1.5em 0em;
  border-bottom:1px dotted #fff;
}
.create-account h5 {
  text-align: center;
  padding: 2em 0 3em 0;
  color: #fff;
  font-size:1em;
}
.create-account h5 a{
	color: #ed1c2f;
  outline: none;
  border: none;
}
.create-account h5 a:hover{
  text-decoration:underline;
}
.submit h5 a:hover{
	text-decoration: underline;
}
.submit input[type="submit"]{
	font-size: 20px;
	font-weight: 400;
	color: #fff;
	cursor: pointer;
	outline: none;
	padding: 1em 1em;
	width:99%;
	border: none;
	background: #88c407;
	border-bottom:3px solid #77ab07;
}
.submit input[type="submit"]:hover{
	  opacity: 0.8;
}
/*----------*/

p {
   
}
.p-container {
  margin: 0.2em 0 1.5em 0;
}
.p-container  .checkbox input {
	position: absolute;
	left: -9999px;
}
.p-container.checkbox i {
	border-color: #fff;
	transition: border-color 0.3s;
	-o-transition: border-color 0.3s;
	-ms-transition: border-color 0.3s;
	-moz-transition: border-color 0.3s;
	-webkit-transition: border-color 0.3s;
	
}
.p-container.checkbox i:hover {
	border-color:red;
	
}
.p-container  i:before {
	background-color: #2da5da;	
}
.p-container  .rating label {
	color: #ccc;
	transition: color 0.3s;
	-o-transition: color 0.3s;
	-ms-transition: color 0.3s;
	-moz-transition: color 0.3s;
	-webkit-transition: color 0.3s;
}
.p-container  .checkbox input + i:after {
	position: absolute;
	opacity: 0;
	transition: opacity 0.1s;
	-o-transition: opacity 0.1s;
	-ms-transition: opacity 0.1s;
	-moz-transition: opacity 0.1s;
	-webkit-transition: opacity 0.1s;
}
.p-container .checkbox input + i:after {
	content:url(/images/tick.png) no-repeat 7px 1px;
	top:5px;
	left: 5px;
	width: 13px;
	height: 12px;
}
.p-container.checkbox {
	float: left;
	margin-right: 30px;
}
.p-container .checkbox {
	padding-left: 40px;
  font-size: 14px;
  line-height: 14px;
  color: #999;
  cursor: pointer;
}
.p-container  .checkbox {
	position: relative;
	display: block;
}
.p-container  h6 a {
	float: right;
	color: #898989;
}
.p-container  h6 a:hover{
	text-decoration: underline;
}
label.checkbox {
float: left;
margin-top: 3px;
}
.p-container  .checkbox i {
	position: absolute;
	top: -5px;
	left: 5px;
	display: block;
	width: 22px;
	height: 22px;
	outline: none;
	border: none;
	background: #dfdfdf;
}
.p-container  .checkbox input + i:after {
	position: absolute;
	opacity: 0;
	transition: opacity 0.1s;
	-o-transition: opacity 0.1s;
	-ms-transition: opacity 0.1s;
	-moz-transition: opacity 0.1s;
	-webkit-transition: opacity 0.1s;
}
.p-container .checkbox input + i:after {
	color: #2da5da;
}
.p-container .checkbox input:checked + i,
.p-container . input:checked + i {
	border-color: #2da5da;	
}
.p-container .rating input:checked ~ label {
	color: #2da5da;	
}

.p-container .checkbox input:checked + i:after {
	opacity: 1;
}
.p-container a {
color: #000;
}
.p-container a:hover{
	text-decoration: underline;
}
.sign-up {
  padding: 1em 0em 3.7em 0;
  border-bottom: 1px dotted #fff;
}
.sign-up input[type="reset"] {
  float: left;
  background: #e2e5e2;
  padding: 0.7em 1.4em;
  color: #3B3B3B;
  font-weight: 400;
  border: none;
  outline: none;
  font-size: 1.1em;
  transition: 0.1s all;
  -webkit-transition: 0.1s all;
  -moz-transition: 0.1s all;
  -o-transition: 0.1s all;
  cursor: pointer;
}
.sign-up input[type="reset"]:hover {
   background: #ec222f;
   color: #e2e5e2;
}
.sign-up input[type="button"] {
  float: right;
  background: #ec222f;
  padding: 0.7em 1.5em;
  color: #e2e5e2;
  font-weight: 400;
  border:none;
  outline: none;
  cursor: pointer;
  font-size: 1.1em;
  transition: 0.1s all;
  -webkit-transition: 0.1s all;
  -moz-transition: 0.1s all;
  -o-transition: 0.1s all;
}
.sign-up input[type="button"]:hover{
  background: #e2e5e2;
  color:#ec222f;
}

.lb-close-btn {
    background: rgba(0, 0, 0, 0) url("images/into.png") no-repeat scroll -5px -2px;
    cursor: pointer;
    height: 27px;
    margin: 4px 18px 0 0;
    position: absolute;
    right: 10px;
    top: 0px;
    width: 27px;
}
.lb-close-btn {
    transition: box-shadow 0.4s ease 0s;
}


</style>

</head>
<body>
<div class="alpha30">
<div id="light" class="white_content">					


<div class="mai">
	<div class="wrap">
	<!--/start-topo-one-->
	<div class="top-one">
	<!--/start-login-->
	<div class="login-one">
		<div class="create-account">
		<div class="lb-close-btn" onclick="closeIt();"></div>
			<div class="login-head">
					<h2>Fill Details</h2>
					<span class="line">
						<span class="sub-line"></span>
					</span>

			</div>
				<form  name="buyNow" id="buyNow" method="post">
					<p>Email<lable> *</lable></p>
					<input type="text" id="email" name="email" class="text" value="${map.emailId}" />
					<p>Name<lable> *</lable></p>
					<input type="text" id="receiverName" name="receiverName" class="text" value="${map.dat1[0][1]}" />
					<p>Pin Code <lable> *</lable></p>
					<input type="text" id="pincode" name="pincode" onkeypress="isNumberKeyForMobile(event)" maxlength="6" class="text" value="${map.dat1[0][6]}"  >
					<p>Address<lable> *</lable></p>
				<textarea rows="2" id="address" name="address" class="textA"
									 maxlength="250" >${map.dat1[0][4]}</textarea>
				 <p>Mobile No <lable> *</lable></p>
					<input type="text" id="mobileNo" name="mobileNo" value="${map.dat1[0][5]}" onkeypress="isNumberKeyForMobile(event)" maxlength="10">
					
					<div id="emailInvalid">--</div>
					
					<input type="hidden" name="orderId" id="orderId" value="${map.orderId}"></input>
					<input type="hidden" name="flag"  id="flag" value="${map.flag}"></input>
				<input type="hidden" name="productId" value="${map.productId}"></input>
				<input type="hidden" name="returnPolicy" value="${map.returnPolicy}"></input>
				<input type="hidden" name="totalAmount" value="${map.totalAmount}"></input>				
				<input type="hidden" name="returnDays" value="${map.returnDays}"></input>
				<div class="sign-up">
					<input type="reset" value="Clear">
					<input type="button" onclick="detailsFilled();" value="Save" ></div>
		</form>
		<div class="clear"> </div>
		</div>
	</div>

		</div>
	</div>
</div>

	
				</div>
					</div>


			


		<div id="fade" class="black_overlay"></div>
</body>

