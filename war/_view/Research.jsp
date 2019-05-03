<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Previous Work</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
	</style>
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
</head>
<body>
    <header>
        <h1>Previous Work</h1>
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
		    		<li><a href="#">Previous Work</a></li>
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
		    	<a href="#">Home</a>
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
		    		<li><a href="#">Home</a></li>
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
		    	<a href="#">Home</a>
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
	    <div class="table">
	        <table>
	            <thead>
	                <tr>
	                    <th scope="col">Name</th>
	                    <th scope="col">Title</th>
	                    <th scope="col">Description</th>
	                    <th scope="col">Graduating Year</th>
	                </tr>
	            </thead>
	            <tr>
	                <td>Ben Yanick</td>
	                <td><a href="./Home.html">Synthesizing Qunatum Dots</a></td>
	                <td>Synthesizing cadmium-free quantum dots using water based chemistry</td>
	                <td>2019</td>
	            </tr>
	            <tr>
	                <td>Cole Rohrbaugh</td>
	                <td>Lipid Extraction from Bee Pollen</td>
	                <td>Extraction of lipids from bee pollen.  Characterization of lipids using HPLC</td>
	                <td>2019</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	            <tr>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	                <td>---</td>
	            </tr>
	        </table>
	    </div>
</body>
</html>