<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
 <!-- <link href="style/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="js/js-image-slider.js" type="text/javascript"></script>
    <link href="style/generic.css" rel="stylesheet" type="text/css" />
 -->
<style>
/* 
.productModule  {
    background-color: #fff;
    border: 1px solid #ccc;
    height: 260px;
    text-decoration: none;
}
.module {
	position: relative;

	background-color:#0a3151;
	
}

.pu-offer {
    background-color: #f44e4e;
    color: #fff;
    margin-bottom: 4px;
    overflow: hidden;
    padding: 4px 5px;
    text-overflow: ellipsis;
   white-space: nowrap;
margin-bottom: 4px;
}

.nam {
    background-color:blue;
    color: #fff;
    margin-bottom: 0px;
    overflow: hidden;
    padding: 4px 5px;
    text-overflow: ellipsis;
   white-space: nowrap;
margin-top: 20px;
}
 */

</style>



<script type="text/javascript">
window.history.forward();
window.onload =  function() {
	checkCookie();
	
};



</script>
</head>

<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>


<%@ include file="/WEB-INF/views/header_login.jsp"%>





<body  >

	<%
		long tLen = (long) Math.pow(10, 16 - 1) * 9;

		long number = (long) (Math.random() * tLen)
				+ (long) Math.pow(10, 16 - 1) * 1;

		String tVal = number + "";

		session.setAttribute("uuid", tVal);
	%>

	<input type="hidden" value="<%=tVal%>" id="joak">
	<form name="loginform" id="loginform" method="post" autocomplete="off">





 <div class="container"> 
 
 <div id="chakri"></div>
	 		<div class="shoes-grid">
	 

    
 <!--  	<div class="single_top">  <div id="sliderFrame" >
        <div id="slider">
            <a href="#" target="_blank">
                <img src="images/image-slider-1.jpg" alt="" />
            </a>
            <a class="lazyImage" href="images/image-slider-2.jpg" ></a>
            <a href="#"><b data-src="images/image-slider-3.jpg" ></b></a>
            
            <a class="lazyImage" href="images/image-slider-4.jpg" ></a>
            <a class="lazyImage" href="images/image-slider-5.jpg" ></a>
                  </div>
        thumbnails
       
        clear above float:left elements. It is required if above #slider is styled as float:left.
        <div style="clear:both;height:0;"></div>
    </div> -->
 
			<div class="wrap-in">
				<div class="wmuSlider example1 slide-grid">		 
				   <div class="wmuSliderWrapper">	
				   	  
			<c:forEach var="listItems" items="${map.slides}">
   
					   <article style="position: absolute; width: 100%; opacity: 0;">					
						<div class="banner-matter">
						<div class="col-md-5 banner-bag">
							<img class="img-responsive " src="data:image/png;base64, ${listItems[1]}" alt=" " />
							</div>
							<div class="clearfix"> </div>
						</div>
						
					 	</article>
					</c:forEach>
					<!--  	<article style="position: absolute; width: 100%; opacity: 0;">					
						<div class="banner-matter">
						<div class="col-md-5 banner-bag">
							<img class="img-responsive " src="images/image-slider-1.jpg" alt=" " />
							</div>
									<div class="clearfix"> </div>
						</div>
						
					 	</article>
					
					 	<article style="position: absolute; width: 100%; opacity: 0;">					
						<div class="banner-matter">
						<div class="col-md-5 banner-bag">
							<img class="img-responsive " src="images/image-slider-4.jpg" alt=" " />
							</div>		
							<div class="clearfix"> </div>
						</div>
						
					 	</article>
						
						 -->
						
					 </div>
					 </a>
	                <ul class="wmuSliderPagination">
	                <c:forEach  items="${map.slides}" >
   
	                	<li><a href="#" class=""></a></li>
	</c:forEach>
	                </ul>
					 <script src="js/jquery.wmuSlider.js"></script> 
				  <script>
	       			$('.example1').wmuSlider();         
	   		     </script> 
	            </div>
	          </div>


<!-- 
	<div class="module" > &nbsp; &nbsp;<font size="4px" color="white">Introduction</font></div>
 -->
<%-- <span style="margin-left:5px;">
<h3 class="mainPage">Kundan Jewellery</h3>
   <ul id="flexiselDemo1">
   		<c:forEach var="listItems" items="${map.firstGrid}">
   
			<li><img src="data:image/png;base64, ${listItems[7]}" /><div class="grid-flex"><a href="productInfo?productId=${listItems[0]}&categoryId=${listItems[3]}&subCategoryId=${listItems[4]}">${listItems[1]}</a><p>Rs ${listItems[5]}</p></div></li>
	
	</c:forEach>
					 </ul>

<h3 class="mainPage">Meena Jewellery</h3>
   <ul id="flexiselDemo2">
		
			<c:forEach var="listItems" items="${map.secondGrid}">
   
			<li><img src="data:image/png;base64, ${listItems[7]}" /><div class="grid-flex"><a href="productInfo?productId=${listItems[0]}&categoryId=${listItems[3]}&subCategoryId=${listItems[4]}">${listItems[1]}</a><p>Rs ${listItems[5]}</p></div></li>
	
	</c:forEach>
		</ul>

<h3 class="mainPage">Custom Jewellery</h3>
   <ul id="flexiselDemo3">
			
				<c:forEach var="listItems" items="${map.thirdGrid}">
   
			<li><img src="data:image/png;base64, ${listItems[7]}" /><div class="grid-flex"><a href="productInfo?productId=${listItems[0]}&categoryId=${listItems[3]}&subCategoryId=${listItems[4]}">${listItems[1]}</a><p>Rs ${listItems[5]}</p></div></li>
	
	</c:forEach>
					 </ul> --%>

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

			$("#flexiselDemo2").flexisel({
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
			$("#flexiselDemo3").flexisel({
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
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>





</span>
</div>

	<%@ include file="/WEB-INF/views/productMenu.jsp"%>
	
	
		</div>		
 <div class="clearfix"> </div>			
			<div class="clear"></div>




	
	</form>

	<%@ include file="/WEB-INF/views/footer.jsp"%>



</body>

</html>


