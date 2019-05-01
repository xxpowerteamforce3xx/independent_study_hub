<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
response.setHeader("Cache-Control","no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <meta charset="utf-8" />
    <title>Login</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
		
	</style>
	
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>

</head>

<body class="login">

<c:if test="${type.equals('faculty')}">
	
	<header>
        <h1>My Account</h1>

        <p class="quote">YCP 2019 - <span class="italic">Account Page - Faculty</span></p>
    </header>
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
    		<li><a href="#">Faculty</a></li>
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
        <a href="#">Faculty</a>
        
        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
			<br>
			<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
    	</form>
    </div>   

	<br>
    <h2 class='h2'>Welcome, ${name}!</h2>
	<br>
<table class='table'>
  <tr>
    <th>Username</th>
    <th>Password</th>
    <th>Email</th>
    <th>Your Faculty Code</th>
  </tr>
  <tr>
    <td>${name}</td>
    <td>${pw}</td>
    <td>${email}</td>
    <td>${code}</td>
  </tr>
</table>
<br>
<h2 class='h2'>Students Who Made Accounts with Your Code:</h2>
<table class='table'>
	<tr>
		<th>Student Username</th>
		<th>Student Email</th>
	</tr>

	<c:forEach  var="student" items="${students}">
        <tr>
            <td>${student.get_name()}</td>
            <td>${student.get_email()}</td>	            
        </tr>
    </c:forEach> 
		
</table>
</c:if>

<c:if test="${type.equals('student')}">
	
		<header>
	        <h1>My Account</h1>
	
	        <p class="quote">YCP 2019 - <span class="italic">Account Page</span></p>
	    </header>
	
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
    		<li><a href="#">Faculty</a></li>
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
        <a href="#">Faculty</a>
        
        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
			<br>
			<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
    	</form>
    </div>   
	
	    <h2 class='h2'>Welcome, ${name}!</h2>
	
	<table class='table'>
	  <tr>
	    <th>Username</th>
	    <th>Password</th>
	    <th>Email</th>
	  </tr>
	  <tr>
	    <td>${name}</td>
	    <td>${pw}</td>
	    <td>${email}</td>
	  </tr>
	</table>
	
	<h2 class='h2'>Projects:</h2>
	<table class='table'>
		<tr>
			<th>Project Title</th>
			<th>Project Description</th>
			<th>Date Uploaded</th>
		</tr>
	
		<c:forEach  var="project" items="${projects}">
	        <tr>
	            <td>${project.get_title()}</td>
	            <td>${project.get_description()}</td>
	            <td>${project.get_year()}</td>		            
	        </tr>
	    </c:forEach>
			
	</table>
</c:if>
      
</body>
</html>