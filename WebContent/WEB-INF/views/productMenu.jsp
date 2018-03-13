<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script>

function show(url)
{
	window.location=url;
	}
</script>
	<div class="sub-cate">
				<div class=" top-nav rsidebar span_1_of_left">
					<h3 class="cate">CATEGORIES</h3>
		
		  
	<c:forEach var="listItems" items="${map.menu}">
		
	<c:choose>
	
	<c:when test ="${listItems.flag eq '1'}">
	  <ul class="menu">
	<li class="item1">
	<a href="#">		${listItems.categoryDesc}<img class="arrow-img" src="images/arrow1.png" alt=""/> </a>
	<ul class="cute">
		<c:forEach var="listItem" items="${listItems.memberList}">
		<li class="subitem1"><a href='productShowCase?categoryId=${listItems.categoryId}&subCategoryId=${listItem.subCategoryId}&count1=0&count2=10&name=${listItem.subCatDesc}'>	${listItem.subCatDesc} </a></li>
		
		</c:forEach>
							</ul> 
							</li>
							</ul>
	</c:when>
	<c:otherwise>
<ul class="menu">
	<li class="item1">
	<a  href='#' onclick="show('productShowCase?categoryId=${listItems.categoryId}&subCategoryId=0&count1=0&count2=10&name=${listItems.categoryDesc}')">	${listItems.categoryDesc}</a>
	</li>
	</ul>
	</c:otherwise>
	</c:choose>	
		
	
	
		
	<%-- 	<c:choose>
	
	<c:when test ="${listItems.flag eq '1'}">
	
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose> --%>	
	
			
		<%-- 
			<c:choose>
	
	<c:when test ="${listItems.flag eq '1'}">
		<ul class="cute">
		<c:forEach var="listItem" items="${listItems.memberList}">
		<li class="subitem1"><a href='productShowCase?categoryId=${listItems.categoryId}&subCategoryId=${listItem.subCategoryId}&count1=0&count2=10&name=${listItem.subCatDesc}'>	${listItem.subCatDesc} </a></li>
		
		</c:forEach>
							</ul> 
							
							
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose>	
			
		 --%>
	</c:forEach>
		  
	
	<!-- 	<li class="item2"><a href="#">Dignissim purus <img class="arrow-img " src="images/arrow1.png" alt=""/></a>
			<ul class="cute">
				<li class="subitem1"><a href="product.html">Cute Kittens </a></li>
				<li class="subitem2"><a href="product.html">Strange Stuff </a></li>
				<li class="subitem3"><a href="product.html">Automatic Fails </a></li>
			</ul>
		</li>
		<li class="item3"><a href="#">Ultrices id du<img class="arrow-img img-arrow" src="images/arrow1.png" alt=""/> </a>
			<ul class="cute">
				<li class="subitem1"><a href="product.html">Cute Kittens </a></li>
				<li class="subitem2"><a href="product.html">Strange Stuff </a></li>
				<li class="subitem3"><a href="product.html">Automatic Fails</a></li>
			</ul>
		</li>
		<li class="item4"><a href="#">Cras iacaus rhone <img class="arrow-img img-left-arrow" src="images/arrow1.png" alt=""/></a>
			<ul class="cute">
				<li class="subitem1"><a href="product.html">Cute Kittens </a></li>
				<li class="subitem2"><a href="product.html">Strange Stuff </a></li>
				<li class="subitem3"><a href="product.html">Automatic Fails </a></li>
			</ul>
		</li> -->
				<!-- <li> -->
			<!-- <ul class="kid-menu"> -->
				<!-- <li><a href="product.html">Tempus pretium</a></li>
				<li ><a href="product.html">Dignissim neque</a></li>
				<li ><a href="product.html">Ornared id aliquet</a></li> -->
			<!-- </ul>
		</li>
		<ul class="kid-menu "> -->
				<!-- <li><a href="product.html">Commodo sit</a></li>
				<li ><a href="product.html">Urna ac tortor sc</a></li>
				<li><a href="product.html">Ornared id aliquet</a></li>
				<li><a href="product.html">Urna ac tortor sc</a></li>
				<li ><a href="product.html">Eget nisi laoreet</a></li>
				<li><a href="product.html">Faciisis ornare</a></li>
				<li class="menu-kid-left"><a href="contact.html">Contact us</a></li> -->
		<!-- 	</ul> -->
		
	</ul>
					</div>
				<!--initiate accordion-->
		<script type="text/javascript">
			$(function() {
			    var menu_ul = $('.menu > li > ul'),
			           menu_a  = $('.menu > li > a');
			    menu_ul.hide();
			    menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });
			
			});
		</script>
				<%-- 	<div class=" chain-grid menu-chain">
					<h3 class="cate">PRODUCT OF THE DAY</h3>
					<c:forEach var="listItems" items="${map.productOfTheDay}">
	   		     		<a href="productInfo?productId=${listItems[0]}&categoryId=${listItems[3]}&subCategoryId=${listItems[4]}"><img class="img-pod chain" src="data:image/png;base64, ${listItems[7]}"  alt=" " /></a>	   		     		
	   		     		<div class="grid-chain-bottom chain-watch">
		   		     		<span class="actual dolor-left-grid">${listItems[5]}</span>
		   		     		<span class="reducedfrom">${listItems[6]}</span>  
		   		     		<h6>${listItems[1]}</h6>  		     			   		     										
	   		     		</div>
	   		     		</c:forEach>
	   		     	</div> --%>
	   		     
			</div>	