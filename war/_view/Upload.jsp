<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Upload</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
	</style>
</head>
<body>
    <header>
        <h1>Upload</h1>
    </header>
    
    <div class="fixed">
		Logged in as "${user}"
		<br>
		<form action="${pageContext.servletContext.contextPath}/Upload" method="post">
        <input type='submit' name ='leave' value = 'Log out'>
    </form>
	</div>
    
    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory" class="right">Inventory</a>
        <a href="#" class="right active">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty" class="right">Faculty</a>
    </div>
    
    <div class="upload_bg"></div>
    
    <form class="upload" action="${pageContext.servletContext.contextPath}/Upload" method="post">
	  <fieldset class="upload">
	    <legend>Upload a Project!</legend>
	    Title:<br>
	    <input type="text" name="tile" placeholder="title" value="${title}">
	    <br><br>
	    Description:<br>
	    <textarea name="desc" placeholder="Write something.." style="height:150px; width:350px;, font-style:arial;" >${desc}</textarea>
	    <br><br>
	    Date Completed: <br>
	    <input type="text" name="date" placeholder="month/day/year" value="${date}">
	    <br><br><br>
	    <input type="submit" name="button" value="Login" id="log"/>
	  </fieldset>
	</form>
	<div class="upload_txt">
		Upload your independent study! When picking a<br><br> 
		description, don't worry about writing like <br><br>
		it is your research paper. Be descriptive and<br><br> 
		general so future students can have an idea of<br><br>
		where to start! 
	 </div>
</body>
</html>