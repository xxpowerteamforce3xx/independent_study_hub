<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Resources</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
	</style>
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
</head>
<body>
    <header>
        <h1>Resources</h1>
    </header>
    
    <c:choose>
    	<c:when test="${user.equals('guest')}">
        	<nav class="navbar">
		<!-- Our side bar button that uses JavaScript to show the side bar menu -->
		    	<span class="open-slide">
		    		<a href="#" onclick="openSideMenu()">
		    			<!-- Creates our side bar icon that is 30 by 30 pixels -->
		    			<svg width="30" height="30">
		    				<!-- Draws two white lines (stroke) where d denotes what the left and right side of the lines being
		    					Each line is 5 pixels wide (stroke-width) -->
		    				<path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
		    				<path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
		    				<path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
		    			</svg>
		    		</a>
		    	</span>
		    	
		    	<ul class="navbar-nav">
		    		<li><a href="http://localhost:8081/independent_study_hub/Home">Home</a></li>
		    		<li><a href="#">Resources</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a></li>
		    	</ul>
			</nav>
			
			<!-- The side bar menu that is activated when the "open-slide" <a> is clicked -->
		    <div id="side-menu" class="side-nav">
		    	<div class="uName-div">
		    		<h2 class="uName">${user}</h2>
		    	</div>
		    	<!-- <a> that closes the side-bar menu. The &times; is what gives the "X" image for this anchor tag-->
		    	<a href="#" class="btn-close" onclick="closeSideMenu()">&times;</a>
		    	<a href="http://localhost:8081/independent_study_hub/Home">Home</a>
		        <a href="#">Resources</a>
		        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
		        <a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a>
		        
		        
		        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
					<br>
					<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
		        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
		    	</form>
		    </div>
    	</c:when>    
    		<c:otherwise>
        		<nav class="navbar">
		<!-- Our side bar button that uses JavaScript to show the side bar menu -->
		    	<span class="open-slide">
		    		<a href="#" onclick="openSideMenu()">
		    			<!-- Creates our side bar icon that is 30 by 30 pixels -->
		    			<svg width="30" height="30">
		    				<!-- Draws two white lines (stroke) where d denotes what the left and right side of the lines being
		    					Each line is 5 pixels wide (stroke-width) -->
		    				<path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
		    				<path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
		    				<path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
		    			</svg>
		    		</a>
		    	</span>
		    	
		    	<ul class="navbar-nav">
		    		<li><a href="http://localhost:8081/independent_study_hub/Home">Home</a></li>
		    		<li><a href="#">Resources</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Inventory">Inventory</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Upload">Upload</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a></li>
		    	</ul>
			</nav>
			
			<!-- The side bar menu that is activated when the "open-slide" <a> is clicked -->
		    <div id="side-menu" class="side-nav">
		    	<div class="uName-div">
		    		<h2 class="uName">${user}</h2>
		    	</div>
		    	<!-- <a> that closes the side-bar menu. The &times; is what gives the "X" image for this anchor tag-->
		    	<a href="#" class="btn-close" onclick="closeSideMenu()">&times;</a>
		    	<a href="http://localhost:8081/independent_study_hub/Home">Home</a>
		        <a href="#">Resources</a>
		        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
		        <a href="http://localhost:8081/independent_study_hub/Inventory">Inventory</a>
		        <a href="http://localhost:8081/independent_study_hub/Upload">Upload</a>
		        <a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a>
		        
		        
		        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
					<br>
					<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
		        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
		    	</form>
		    </div>
		    		</c:otherwise>
			</c:choose>
    <br>
    <c:if test="${!type.equals('guest')}">
    	<form action="${pageContext.servletContext.contextPath}/Resources" method="post">
    		<button class="w3-bar-item w3-button" type='submit' name ='upload' value = '1'>Upload a Help Card</button>
    	</form>
    </c:if>
    <div class="protector">
         <h2 class="ribbon">
             <strong class="ribbon-content">What it is All About</strong>
         </h2>
     </div>
     <p>
           On this page find links uploaded by faculty or other students that they found helpful <br> 
           when completing their research! This page will always be a work in progress, and if you <br>
           found something helpful when you were completing your research, upload it here!
        </p>
        <br>
	    <!-- Main section of web page's body -->   
	  <div class ="resources">
	      <div class="w3-bar w3-green">
			  <button class="w3-bar-item w3-button" onclick="displayContent('faculty')">Faculty</button>
			  <button class="w3-bar-item w3-button" onclick="displayContent('student')">Student</button>
			</div>
	
				<div id="faculty" class="w3-container city resource-fac w3-card-2" style="display:block">
				  <h2>Faculty Provided Help!</h2>
				  
					  <c:forEach  var="block" items="${f_blocks}">
		      			 <div class="w3-card-4 w3-green resource-cont">
						    <header class="w3-container w3-green resource-head">
						      <h3>From: lgartrell ${dude}</h3>
						    </header>
						
						    <div class="w3-container w3-white">
						      <br>
						      <p>This is where the description would go ${description}</p>
						      <br>
						    </div>
						
						    <div class="w3-container w3-green resource-head">
						      <h2>Link: <a href="${link}">${link}</a></h2>
						    </div>
						 </div>
					</c:forEach> 
				</div>					
    			  

				 
				
				<div id="student" class="w3-container city resource-stu w3-card-2" style="display:none">
					<h2>Student Provided Help!</h2>
					<c:forEach  var="block" items="${s_blocks}">
					<div class="w3-card-4 w3-green resource-cont">	
					   <header class="w3-container w3-green resource-head">
					      <h3>From: ${block.get_by()}</h3>
					    </header>
					
					    <div class="w3-container w3-white">
					      <br>
					      <p>${block.get_description()}</p>
					      <br>
					    </div>
					
					    <div class="w3-container w3-green resource-head">
					      <h5>Link: <a href="${block.get_link()}">${block.get_link()}</a></h5>
					    </div>
						<br>
					 </div>
					</c:forEach> 
				</div>
	</div>
</body>
</html>