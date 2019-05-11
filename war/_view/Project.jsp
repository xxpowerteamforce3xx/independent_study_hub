<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Project</title>

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
	</style>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js" defer></script>
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
		
		
	</script>
</head>
<body>
	
	   <header>
	       <h1>Independent Study Hub</h1>
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
		    		<li><a href="http://localhost:8081/independent_study_hub/Resources">Resources</a></li>
		    		<li><a href="http://localhost:8081/independent_study_hub/PreviousWork">Previous Work</a></li>
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
		        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
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
		    		<li><a href="http://localhost:8081/independent_study_hub/Resources">Resources</a></li>
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
		        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
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
			
		<!-- Main section of web page's body -->
		
		<!-- Displays CSS card <div>'s below and centers them  -->
		<section class="project-body">
			<!-- W3 schools has their own class to make <div> (or other sections) look like cards
				 project-card is styling for spacing, background color, and font color  -->
			<div class="w3-card-4 project-card">
				<!-- project-title-div gives underline, which is just a bottom border -->
	    		<div class="project-title-div">
	    			<!-- project-h1-title gives a few minor spacing adjustments and changes font size -->
	  				<h1 id="project-h1-title">${title}</h1>
	  			</div>
	  			<div class="project-subtitle">
	  				<h2 class="project-h2-title">${name}</h2>
	  				<h2 class="project-h2-title">${date}</h2>
	  			</div>
	  		</div>
			
			<div class="w3-card-4 project-card">
				<h2 class="description-title">Description</h2>
				<p>${desc}</p>
			</div>
			
			<img src="style/ring.png">
			<br>
		</section>
		
		
</body>
</html>