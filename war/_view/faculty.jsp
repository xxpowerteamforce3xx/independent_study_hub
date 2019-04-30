<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" content="width=device-width, initial-scale=1"/>
    <title>Faculty</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
	</style>
</head>
<body>
    <header>
        <h1>Faculty</h1>
    </header>
    
    <!-- Logout box for page -->
    <div class="fixed">
		Logged in as "${user}"
		<form action="${pageContext.servletContext.contextPath}/Faculty" method="post">
        <input type='submit' name ='leave' value = 'Log out'>
    </form>
	</div>
    
    <!-- Navigation bar for page -->
    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory" class="right">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload" class="right">Upload</a>
        <a href="#" class="right active">Faculty</a>
    </div>
    
    
    <form class="upload-box">
        <input type="text" name="" placeholder="Faculty Member" />
        <input type="text" name="" placeholder="Research Students" />
        <input type="text" name="" placeholder="Research Interests" />
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>   
    
    <!-- Count variable that will work alongside our for each loop below -->
    <c:set var="count" value="0" scope="page" />
    
    <section id="dub_col">
    	<!-- The for each loop where the servlet will store the array list of references to faculty objects -->
    	<c:forEach items="${faculty}" var="faculty">
    		<!-- Checks if the count variable above is even, if so, then we know to start a new "row" -->
	 		<c:if test="${count % 2 == 0}">
	        	<div class="row">
	        </c:if>
	        	<!-- In each "column", we insert the faculty member's information by calling methods associated with faculty objects -->
	        	<div class="column">
	        		<img class="faculty" src="${faculty.get_img()}">
	        		<h2 class="title">${faculty.get_title()}</h2>
	        		<p class="description"><strong>Interests: </strong>${faculty.get_interest()} <br><br>
	        		${faculty.get_description()}</p>
	        	</div>
	        	
	        <!-- If count variable is odd, then we are finishing a row and close it off -->
	        <c:if test="${count % 2 != 0}">
	        	</div>
	        </c:if>
	        
	        <!-- Increment our count variable by one for each iteration of our for each loop -->
	        <c:set var="count" value="${count + 1}" scope="page"/>
	    </c:forEach>
    	
    </section>
</body>
</html>