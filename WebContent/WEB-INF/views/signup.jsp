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

.two-login-head{
	background: #702c91;
	padding: 1em 1em;
	text-align:center;
	position: relative;
}
.two-login-head h2 {
font-size: 2em;
color: #fff;
font-weight: 500;
text-transform: uppercase;
}
.two-login-head lable{
	background: url('images/tip2.png') no-repeat 0px 0px;
	width: 30px;
	height: 13px;
	position: absolute;
	bottom: -11px;
	left: 203px;
	display: inline-block;
}
.two-login h5,.two-login h5 a{
	color: #848484;
	font-size: 16px;
}
.two-login h5 a{
	font-weight: 600;
}
.two-login h5 a:hover{
	text-decoration: underline;
}
.two-login{
	
width:100%;
margin:5% auto;
background: #fff;
text-align: center;
border-bottom: 3px solid#1c817c;
}
.two-login-head h1 {
font-size: 2em;
color: #fff;
font-weight:500;
}
form.two {
	padding: 7% 9%;
}
form.two li{
	border:none;
	list-style:none;
	margin-bottom:25px;
	width:100%;
	background:#dfdfdf;
}
.login-02 {
display: block;
	position: fixed;
	z-index: 1002;
margin-top: 9em;
 background: none repeat scroll;
}
.icon2{
height:45px;
width: 46px;
display: block;
float: left;
margin: 1px -13px 0px 0px;
}

.user2{
	background: url(images/icon2.png) no-repeat 0px -1px #702c91;
	
}
.lock2{
	background: url(images/icon2.png) no-repeat -49px 0px #702c91;
}
.mail{
	background: url(images/icon2.png) no-repeat -99px 0px #702c91;
}
form.two input[type="text"],form.two input[type="password"] {
	width: 60%;
	padding: 0.8em 4em 0.8em 1.7em;
	color: #858282;
	font-size: 16px;
	outline: none;
	background: none;
	font-weight: 500;
	border: none;
	}
	.submit.two{
		border: none;
		padding: 6px 0 20px 0;
	}
.submit.two input[type="button"]{
	font-size: 20px;
	font-weight: 400;
	color: #fff;
	cursor: pointer;
	outline: none;
	padding: 13px 10px;
	width: 100%;
	border: none;
	background: #702c91;
}
.submit.two input[type="button"]:hover{
	background:#ffc50c;
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
	padding: 7% 9%;
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
	width: 90%;
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
<div  class="alpha30">

					<div id="light" class="white_content">
				<div id="chakri"></div>

		<div class="two-login  hvr-float-shadow">
			<div class="two-login-head">
				<div class="lb-close-btn" onclick="closeIt();"></div>
					<img src="images/top-note.png" alt=""/>
					<h2>register</h2>
					<lable></lable>
			</div>
	<div id ="main"	>	
				<form class="formA" name="login" id="login" method="post">
				
				<li>
					<input type="text" autocomplete="off" id="email" maxlength="100" value="E-mail"   onfocus="if (this.value == 'E-mail') {this.value = '';}" onblur="if (this.value == '') {this.value = 'E-mail';} else{signUp('checkIfEmailIdExists','emailInva','chakri','email='+this.value);}" ><a href="#" class=" icon2 mail"></a>
				
				</li>
			
				<li>
					<input type="password" autocomplete="off" id="password" value="Password" maxlength="50"  onfocus="if (this.value == 'Password') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Password';}"><a href="#" class=" icon2 lock2"></a>
				</li>
				<li>
					<input type="text" id="userName"  autocomplete="off" maxlength="40" value="UserName"  onfocus="if (this.value == 'UserName') {this.value = '';}" onblur="if (this.value == '') {this.value = 'UserName';}" ><a href="#" class=" icon2 user2"></a>
				</li>

				<div id="emailInvalid">--</div>
				<div id="emailInva">--</div>
				<!-- <div class="p-container">
					<label class="checkbox two"><input type="checkbox" name="checkbox" checked><i></i>I agree to the <a href="#">Terms of Servicee</a></label>
				</div> -->
				<div class="submit two">
				<input type="button" onclick="signItUp();" value="SIGN UP" >
				</div>

					<!-- <h5>Already a member ?<a href="loginup" rel="ibox"> Login Here</a></h5>
 -->			</form>	
			</div>		
		</div>
	</div>
					
						
				</div>
				
		<div id="fade" class="black_overlay"></div>
</body>

