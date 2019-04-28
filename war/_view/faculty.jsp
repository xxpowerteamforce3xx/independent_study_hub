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
    
    <div class="fixed">
		Logged in as "${user}"
		<form action="${pageContext.servletContext.contextPath}/Faculty" method="post">
        <input type='submit' name ='leave' value = 'Log out'>
    </form>
	</div>
    
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
    
    <section id="dub_col">
    
    	<!-- 
	    <div class="row">
			<div class="column">
		  		<img class="faculty" src="style/Steel.jpg"/>
		  		<h2>William</h2>
		  		
		  		<p class="description"><strong>Interests:</strong> Material science and computational chemistry. <br><br>
		  		The focus of my research has been around altering material properties such as, conductivity
		  		and elasticity, to allow for sophisticated components to be manufactured.  I am also fascinated with incorporating 
		  		computers into the study of chemistry, whether it be simulations of an experiment 
		  		or using AI to support work being done.</p>
		  	</div>
		 	<div class="column">
		    	<img class="faculty" src="style/MacPherson.jpg"/>
		  		<h2>Amanda</h2>
		  		
		  		<p class="description"><strong>Interests:</strong> Material science and computational chemistry. <br><br>
		  		The focus of my research has been around altering material properties such as, conductivity
		  		and elasticity, to allow for sophisticated components to be manufactured.  I am also fascinated with incorporating 
		  		computers into the study of chemistry, whether it be simulations of an experiment 
		  		or using AI to support work being done.</p>
		  	</div>
		</div>
		
		<div class="row">
			<div class="column">
			    <img class="faculty" src="style/Howard.jpg"/>
		  		<h2>Kyle</h2>
		  		
		  		<p class="description"><strong>Interests:</strong> Material science and computational chemistry. <br><br>
		  		The focus of my research has been around altering material properties such as, conductivity
		  		and elasticity, to allow for sophisticated components to be manufactured.  I am also fascinated with incorporating 
		  		computers into the study of chemistry, whether it be simulations of an experiment 
		  		or using AI to support work being done.</p>
		  	</div>
		  	<div class="column" >
		    	<img class="faculty" src="style/ring.png"/>
		  		<h2>Benjamin T. Yanick</h2>
		  		
		  		<p class="description"><strong>Interests:</strong> Material science and computational chemistry. <br><br>
		  		The focus of my research has been around altering material properties such as, conductivity
		  		and elasticity, to allow for sophisticated components to be manufactured.  I am also fascinated with incorporating 
		  		computers into the study of chemistry, whether it be simulations of an experiment 
		  		or using AI to support work being done.</p>
		  	</div>
		</div>
		<div class="row">
			<div class="column" >
			    <h2>Column 5</h2>
			    <p>Some text..</p>
			 </div>
			 <div class="column" >
			    <h2>Column 5</h2>
			    <p>Some text..</p>
			 </div>
		 </div>
		  -->
    </section>
</body>
</html>