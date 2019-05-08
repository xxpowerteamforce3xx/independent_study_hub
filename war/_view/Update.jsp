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
    <title>Update</title>
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
        <h1>Update Account</h1>
			
        <p class="quote">YCP 2019 - <span class="italic">Update Account Page - Faculty</span></p>
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

	<br>
    <h2 class='h2'>Welcome, ${name}! Your current account information is below</h2>
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
	<br><br>
	<h2 class='h2'>Enter your new information below!</h2>
	<br><br>
	<c:if test="${! empty errorMessage}">
		<div class="alert">
	 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
		 		<strong>Error!</strong> ${errorMessage}
 		</div>
	</c:if>

	 <form class='form-update'action="${pageContext.servletContext.contextPath}/Update" method="post" enctype="multipart/form-data">
	   <label for="username">New Username</label>
	   <input type="text" id="new_username" name="new_name" placeholder="..." value="${new_name}">
	
	   <label for="password">New Password</label>
	   <input type="password" id="new_password" name="new_password" placeholder="..." value="${new_password}">
	   
	   <label for="password">Repeat New Password</label>
	   <input type="password" id="new_password2" name="new_password2" placeholder="..." value="${new_password2}">
	
	   <label for="email">New YCP Email</label>
	   <input type="text" id="new_email" name="new_email" placeholder="..." value="${new_email}">
	 	
	   <label for="fac_code">New Faculty Code</label>
	   <input type="text" id="new_fac_code" name="new_fac_code" placeholder="..." value="${new_fac_code}">
	   
	   <label for="fac_code">New Faculty Description</label>
	   <input type="text" id="desce" name="new_fac_description" placeholder="..." value="${new_fac_desc}">
	   
	   <label for="fac_code">New Faculty Interest</label>
	   <input type="text" id="new_fac_code" name="new_fac_interest" placeholder="..." value="${new_fac_interest}">
	   
	   <label for="fac_code">New Faculty Proffesional Title ;)</label>
	   <input type="text" id="new_fac_code" name="new_fac_title" placeholder="..." value="${new_fac_title}">
	   
	   <label>New Faculty Picture:</label>
	   <input type="file" name="image"/>
	   
	   <input type="submit" name='update' value="Update!">
	 </form>

</c:if>	


<c:if test="${type.equals('student')}">
	
		<header>
	        <h1>Update Account</h1>
	
	        <p class="quote">YCP 2019 - <span class="italic">Update Account Page</span></p>
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
	
	    <h2 class='h2'>Welcome, ${name}! Your current account information is below</h2>
	
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
	
	<br><br>
	<h2 class='h2'>Enter your new information below!</h2>
	<br><br>
	<c:if test="${! empty errorMessage}">
		<div class="alert">
	 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
		 		<strong>Error!</strong> ${errorMessage}
 		</div>
	</c:if>

	 <form class='form-update'action="${pageContext.servletContext.contextPath}/Update" method="post">
	   <label for="username">New Username</label>
	   <input type="text" id="new_username" name="new_name" placeholder="..." value="${new_name}">
	
	   <label for="password">New Password</label>
	   <input type="password" id="new_password" name="new_password" placeholder="..." value="${new_password}">
	   
	   <label for="password">Repeat New Password</label>
	   <input type="password" id="new_password2" name="new_password2" placeholder="..." value="${new_password2}">
	
	   <label for="email">New YCP Email</label>
	   <input type="text" id="new_email" name="new_email" placeholder="..." value="${new_email}">
	   
	   <input type="submit" name='update' value="Update!">
	 </form>	
</c:if>
      
</body>
</html>