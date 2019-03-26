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
</head>
<body>
    <header>
        <h1>Resources</h1>
    </header>
    
    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="#" class="active">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory" class="right">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload" class="right">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty" class="right">Faculty</a>
    </div>    
    <div>
    	<!--  <a href="war/_view/roughdraft_CR_Graded.pdf">Example of a Research Proposal</a> -->
    	<embed src="style/roughdraft_CR_Graded.pdf" type="application/pdf" width="100%" height ="600px" />
    </div>
</body>
</html>