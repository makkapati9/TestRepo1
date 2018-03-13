<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/header_login.jsp"%>

<title></title>

<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
 --><!--//fonts-->
<script src="js/jquery.min.js"></script>

<script src="js/jquery.etalage.min.js"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						//alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>


<style type="text/css">

.btn1.btn-primary1 {
    background: #f54d56 none repeat scroll 0 0;
    border: medium none;
    box-shadow: none;
    color: #fff;
    display: inline-block;
    font-size: 0.8125em;
    letter-spacing: 0;
    padding: 12px 35px;
    position: relative;
    text-decoration: none !important;
    text-shadow: none;
    text-transform: uppercase;
    transition: all 0.3s ease 0s;
   
}

a.now-already {
    color: #fff;
    font-size: 1.1em;
    padding: 0.6em 0.8em;
    text-decoration: none;
    border:1px solid;
    border-color:black; 
   
}

</style>
</head>
<body> 
	<!--header-->
	
	<!---->
	
	 <div class="container"> 
	 	
	 	<div class=" single_top">
	      <div class="single_grid">
				<div class="grid images_3_of_2">
						<ul id="etalage">
					
										<c:forEach var="listItems" items="${map.images}">
								<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="data:image/png;base64, ${listItems[2]}"  class="img-responsive" />
									<img class="etalage_source_image" src="data:image/png;base64, ${listItems[1]}"  class="img-responsive" title="" />
								</a>
							</li>
							</c:forEach>
						<!-- 	<li>
								<img class="etalage_thumb_image" src="images/s2.jpg" class="img-responsive" />
								<img class="etalage_source_image" src="images/si2.jpg" class="img-responsive" title="" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="images/s3.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="images/si3.jpg"class="img-responsive"  />
							</li>
						    <li>
								<img class="etalage_thumb_image" src="images/s1.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="images/si1.jpg"class="img-responsive"  />
							</li> -->
						</ul>
						 <div class="clearfix"> </div>		
				  </div> 
				  <div class="desc1 span_3_of_2">
				  
				<c:forEach var="listItems" items="${map.info}">
			<form id="common" name="common" method="post">
				<input type="hidden" id="productId" name="productId" value="${listItems.productId}">
			
			 </form>
										<h4>${listItems.productName}</h4>
				<div class="cart-b">
					<div class="left-n ">Rs. ${listItems.discountedPrice}</div>
					
					
					<c:choose>
					<c:when test="${map.cartExistFlag eq '1'}">
					  <a class="now-already get-cart-in" href="#"><span onclick=""><font color='black'>ADDED TO CART</font></span></a> 
				 
					</c:when>
					<c:otherwise>
					
					  <a class="now-get get-cart-in" href="#" id='bef'  onclick="addCart('${listItems.productId}');"><span>ADD TO CART</span></a> 
				 
				 
					  <a class="now-already get-cart-in" href="#" id='af'  style="display:none"><font color='black'>ADDED TO CART</font></a> 
				 
					</c:otherwise>
					</c:choose>
				     <div class="clearfix"></div>
				 </div>
				
			   	<p>${listItems.productDescription}</p>
			   	 <h6>${listItems.quantity} items in stock   </h6>
			   		 <h6>Delivery in ${listItems.deliveryTime} days  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Delivery Charges: Rs.${listItems.deliveryCharges}</h6>
			   		  <h6>Return Policy:
			   		  <c:choose>
			   		  <c:when test="${listItems.returnPolicy eq 'Y'}">
			   		  ${listItems.returnPolicyDays} days
			   		  </c:when>
			   		  <c:otherwise>
			   		  No
			   		  </c:otherwise> 
			   		  </c:choose>
			   		
			   		      </h6>
			   		  <h6>
			   		  <c:if test="${listItems.giftWrap eq 'Y'}">  Gift Wrap Charges: Rs.${listItems.giftWrapCharges}</c:if>
			   		  <!-- 
			   		  <c:if test=""></c:if><c:if test=""></c:if> Cash on Delivery:&nbsp;&nbsp;   One Day Delivery:&nbsp; &nbsp; --> 
			   		    </h6>
			   		       
			   	
			   	
			 
			
			 <a href="buyNow?flag=1&productId=${listItems.productId}&totalAmount=${listItems.discountedPrice}&returnPolicy=${listItems.returnPolicy}&returnDays=${listItems.returnPolicyDays}" rel="ibox" class="btn1 btn2 btn-primary1" ><span>BUY NOW</span></a>
	  	</c:forEach>
			
			   <!-- 	<div class="share">
							<h5>Share Product :</h5>
							<ul class="share_nav">
								<li><a href="#"><img src="images/facebook.png" title="facebook"></a></li>
								<li><a href="#"><img src="images/twitter.png" title="Twiiter"></a></li>
								<li><a href="#"><img src="images/rss.png" title="Rss"></a></li>
								<li><a href="#"><img src="images/gpluse.png" title="Google+"></a></li>
				    		</ul>
						</div> -->
			  	
				 
				</div>
				
				 	
			
				
          	    <div class="clearfix"> </div>
          	   </div>
          	   
          	   <div class="toogle">
				     	<h3 class="m_3">Product Details</h3>
				     	<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
				     </div>
				     
				     
				     
				     
          	<!--    <ul id="flexiselDemo1">
			<li><img src="images/pi.jpg" /><div class="grid-flex"><a href="#">Bloch</a><p>Rs 850</p></div></li>
			<li><img src="images/pi1.jpg" /><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li>
			<li><img src="images/pi2.jpg" /><div class="grid-flex"><a href="#">Zumba</a><p>Rs 850</p></div></li>
			<li><img src="images/pi3.jpg" /><div class="grid-flex"><a href="#">Bloch</a><p>Rs 850</p></div></li>
			<li><img src="images/pi4.jpg" /><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li>
		 </ul>
	    <script type="text/javascript">
		 $(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/ javascript" src="js/jquery.flexisel.js"></script>-->


	<h3 class="m_3"><a href='review?product_id=${pId}'>Reviews</a></h3>
 <div class="toogle">
				     	<h6>Reviews</h6>
				     	<p class="m_text">Lorem ipsum dolor sit amet,dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
				     </div>


          	    		
          	   </div>
          	   
          	   <!---->

	<%@ include file="/WEB-INF/views/productMenu.jsp"%>
	
<div class="clearfix"> </div>			
		</div>
	<!---->
	<%@ include file="/WEB-INF/views/footer.jsp"%>

</body>
</html>