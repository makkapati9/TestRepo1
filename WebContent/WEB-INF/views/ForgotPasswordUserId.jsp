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

.one-login-head{
	background: #ffc50c;
	padding: 1em 1em;
	text-align:center;
	position: relative;
}
.one-login-head span{
	background: url('../images/tip.png') no-repeat 0px 0px;
	width: 30px;
	height: 13px;
	position: absolute;
	bottom: -12px;
	left: 203px;
	display: inline-block;
}
.one-login{
width:105%;
margin:5% auto;
background: #fff;
text-align: center;
border-bottom: 3px solid#1c817c;
}
/* Float Shadow */
.hvr-float-shadow {
  vertical-align: middle;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  -moz-osx-font-smoothing: grayscale;
  position: relative;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-property: transform;
  transition-property: transform;
}
.hvr-float-shadow:before {
  pointer-events: none;
	position: absolute;
	z-index: -1;
	content: '';
	top: 105%;
	left: 5%;
	height: 52px;
	width: 95%;
	opacity: 0.5;
	background: -webkit-radial-gradient(center, ellipse, rgba(0, 0, 0, 0.16) 0%, rgba(0, 0, 0, 0) 80%);
	background: radial-gradient(ellipse at center, rgba(0, 0, 0, 0.18) 0%, rgba(0, 0, 0, 0) 80%);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
	-webkit-transition-property: transform, opacity;
	transition-property: transform, opacity;
}
.hvr-float-shadow:hover, .hvr-float-shadow:focus, .hvr-float-shadow:active {
  -webkit-transform: translateY(-5px);
  transform: translateY(-5px);
  /* move the element up by 5px */
}
.hvr-float-shadow:hover:before, .hvr-float-shadow:focus:before, .hvr-float-shadow:active:before {
  opacity: 1;
  -webkit-transform: translateY(5px);
  transform: translateY(5px);
  /* move the element down by 5px (it will stay in place because it's attached to the element that also moves up 5px) */
}
.one-login-head h1 {
font-size: 2em;
color: #fff;
font-weight:500;
}
.formA {
	padding: 12% 9%;
}
.formA li{
	border:none;
	list-style:none;
	margin-bottom:25px;
	width:100%;
	background:#dfdfdf;
}
.icon{
height:45px;
width: 46px;
display: block;
float: left;
margin: 1px -13px 0px 0px;
}
.user{
	background: url(images/icon.png) no-repeat 0px -1px #ffc50c;
	
}
.lock{
	background: url(images/icon.png) no-repeat -49px 0px #ffc50c;
}
input[type="text"], input[type="password"] {
	width: 85%;
	padding: 0.8em 4em 0.8em 1.7em;
	color: #858282;
	font-size: 16px;
	outline: none;
	background: none;
	font-weight: 500;
	border: none;
	}
	.submit{
		border-bottom: 1px dashed #999;
		padding: 23px 0;
	}
.submit input[type="submit"]{
	font-size: 20px;
	font-weight: 400;
	color: #fff;
	cursor: pointer;
	outline: none;
	padding: 13px 10px;
	width: 100%;
	border: none;
	background: #ffc50c;
}
.submit input[type="button"]{
	font-size: 20px;
	font-weight: 400;
	color: #fff;
	cursor: pointer;
	outline: none;
	padding: 13px 10px;
	width: 100%;
	border: none;
	background: #ffc50c;
}
input[type="submit"]:hover{
	background:#D13E2F;
}
input[type="button"]:hover{
	background:#D13E2F;
}
h6 {
float: right;
}
/*----------*/
.p-container{
	margin-top: 1em;
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
	content:url(images/tick.png) no-repeat 7px 1px;
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
font-size: 16px;
line-height: 14px;
color: #858282;
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

.one-login h5 a,.one-login  h5 {
	color: #898989;
	font-size: 16px;
	text-align: center;
	padding: 10px 0;
}
.one-login h5 a:hover{
	text-decoration: underline;
}
.p-container a {
color: #702C91;
font-size: 15px;
}
.p-container a:hover{
	text-decoration: underline;
}
.txt-rt{text-align:right;}/* text align right */
.txt-lt{text-align:left;}/* text align left */
.txt-center{text-align:center;}/* text align center */
.float-rt{float:right;}/* float right */
.float-lt{float:left;}/* float left */
.clear{clear:both;}/* clear float */
.pos-relative{position:relative;}/* Position Relative */
.pos-absolute{position:absolute;}/* Position Absolute */
.vertical-base{	vertical-align:baseline;}/* vertical align baseline */
.vertical-top{	vertical-align:top;}/* vertical align top */
nav.vertical ul li{	display:block;}/* vertical menu */
nav.horizontal ul li{	display: inline-block;}/* horizontal menu */
img{max-width:100%;}
.lb-close-btn {
    background: rgba(0, 0, 0, 0) url("images/into.png") no-repeat scroll -5px -2px;
    cursor: pointer;
    height: 27px;
    margin: 18px 18px 0 0;
    position: absolute;
    right: 10px;
    top: 18px;
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
<div id="chakri"></div>

		<%-- 	<form name="login" id="login" method="post">
			<a href="${link}" ><img src="images/close_red.png" align="right" style="top:19px;right:10px; position:relative" /></a>
					
						 <div class="adminLoginPan">
                  <div class="head"><strong>LOGIN</strong></div>
                  <div class ="clear"></div>
                  <div class="col1">Email Id</div>
                   <div class="col3">
                   <input  class="text" type="text" id="username" 
                   		name="username" 
                        autocomplete="off" /></div>
                   <div class ="clear"></div>
                   <div class="col1">Password</div>
                   <div class="col3">
                   <input  class="text"   type="password" id="txtPassword" 
                        autocomplete="off" oncopy="return false" ondrag="return false" 
                        ondrop="return false"
                        onpaste="return false"  name="txtPassword" />
                        
                        </div>
                         <div class ="clear">
                   </div>
                   		<div >
									
                                     

								</div>     
					
					</div>
					
					</form>	 --%>	
					
					
					
					
						<div class="login-01">
						
		<div class="one-login  hvr-float-shadow">
			<div class="one-login-head">
		 <div class="lb-close-btn" onclick="closeIt();"></div> 
					<img src="images/top-lock.png" alt=""/>
					<h1>LOGIN</h1> 
					<span></span>
			</div>
			<form  class="formA" id="loginX" name="loginX">
				<li>
					<input type="text"  id= "email" value="E-mail"   onfocus="if (this.value == 'E-mail') {this.value = '';}"  onblur="if (this.value == '') {this.value = 'E-mail';}" ><a href="#" class=" icon user"></a>
				</li>
				<li>
					<input type="password"  id="password" value="Password" onfocus="if (this.value == 'Password') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Password';}"><a href="#" class=" icon lock"></a>
				</li>
				<div id="emailInvalid">--</div>
			
				<div class="submit">
						<input type="button" onclick="loggedIn();" value="SIGN IN" >
				</div>
				
			<!-- 
					<h5>Don't have an account ?<a href="signup" rel="ibox"> Sign Up </a></h5>
		 -->		</form>
		</div>
	</div>		
				</div>
				
				</div>


			


		<div id="fade" class="black_overlay"></div>
</body>

