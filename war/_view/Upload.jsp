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
		<form action="${pageContext.servletContext.contextPath}/Login" method="post">
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
    
    <form class="upload-box">
        <input type="text" name="" placeholder="First Name" />
        <input type="text" name="" placeholder="Last Name" />
        <input type="text" name="" placeholder="Graduation Year" />
        <input type="text" name="" placeholder="Research Title" />

        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>    
</body>
</html>