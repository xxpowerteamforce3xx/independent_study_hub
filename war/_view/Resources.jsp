<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Resources</title>
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
    
    <!-- Log out box for user to sign out -->
    <div class="fixed">
		Logged in as "${user}"
		<form action="${pageContext.servletContext.contextPath}/Resources" method="post">
        <input type='submit' name ='leave' value = 'Log out'>
    </form>
	</div>
    
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
    	<h2 class="uName">${user}</h2>
    	
    	<!-- <a> that closes the side-bar menu. The &times; is what gives the "X" image for this anchor tag-->
    	<a href="#" class="btn-close" onclick="closeSideMenu()">&times;</a>
    	<a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="#">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a>
    </div> 
    
	    <!-- Main section of web page's body -->   
	    <div>
	    	<!--  <a href="/style/roughdraft_CR_Graded.pdf">Example of a Research Proposal</a> -->
	    	<embed src="style/roughdraft_CR_Graded.pdf" type="application/pdf" width="100%" height ="600px" />
	    </div>
</body>
</html>