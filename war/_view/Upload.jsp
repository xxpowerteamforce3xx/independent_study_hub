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
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
</head>
<body>
    <header>
        <h1>Upload</h1>
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
    		<li><a href="#">Upload</a></li>
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
        <a href="#">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a>
        
        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
			<br>
			<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
    	</form>
    </div>
    <c:if test="${! empty errorMessage}">
			<div class="alert">
 		 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		 		<strong>Error!</strong> ${errorMessage}
	  		</div>
	  </c:if>
	 <div class="upload-container">
        	<p>Upload your independent study! When picking a 
    		description, don't worry about writing like 
    		it is your research paper. Be descriptive and 
    		general so future students can have an idea of
    		where to start!</p>
    
    
    
    <div class="upload-box2">
        	<form class="upload-form" action="${pageContext.servletContext.contextPath}/Upload" method="post" enctype="multipart/form-data">
      		  
      		    <div class="form-row">
      		    	<div class="form-field">
      		    		<label>Title:</label> 
      		    		<input class="input-field input-upload" type="text" name="t" placeholder="title" value="${t}"/>
      		    	</div>
      		    </div>
              
              
              <div class="form-row">
        	    <div class="form-field">
                  <label>Date Completed:</label> 
                  <input class="date"type="date" name="date" placeholder="month/day/year" value="${date}"/>
                </div>
              </div>
        	    
      		    <div class="form-row">
                <div class="form-field">
            		    <label>Description:</label>
            		    <textarea class="input-field input-upload" name="desc" placeholder="Write something.." rows="4" cols="50" style="font-style:arial;" >${desc}</textarea>
   
                  </div>
      		    </div>
      		    
      		    <div class="form-row">
	      		    <div class="form-field">
		      		    <label>Abstract:</label>
		      		    <input id="spacing" type="file" name="image"/>
	      		    </div>
      		    </div>
      		    
      		    <div class="form-row">
      		    	<div class="form-field">
      		    		<button type="submit" name="button" id="log">Submit</button>
      		    	</div>
      		    </div>
      		    
    		  </form>
    		  <br>
      	</div>
      </div>
    <!-- 
      	<div class="upload-box2">
      		<form class="upload-form" action="${pageContext.servletContext.contextPath}/Upload" method="post" enctype="multipart/form-data">
      		  
      		    <div class="inline"><strong>Title: &nbsp;&nbsp;&nbsp;&emsp;</strong> <input class="input-field input-upload" type="text" name="t" placeholder="title" value="${t}"/>
      		    </div>
              
              <div class="inline">
              <strong>Name:</strong>  
              	<input class="input-field input-upload" type="text" name="n" placeholder="name" value="${t}"/>
      		    </div>
              <br>
              <div class="inline"><strong>Date Completed:</strong> <input type="date" name="date" placeholder="month/day/year" value="${date}"/></div>
        	    
      		    
      		    <p>Description:</p>
      		    <textarea class="input-field input-upload" name="desc" placeholder="Write something.." rows="4" cols="50" style="font-style:arial;" >${desc}</textarea>
      		    <br><br>
      		    
      		    
      		    <p>Picutre of Your Abstract</p>
      		    <input type="file" name="image"/>
      		    
      		    <input type="submit" name="button" value="Login" id="log"/>
    		  </form>
    		  <br>
      	</div>
      </div>
      -->
	
	<!-- 
    <div class="upload-container">
    	<div class="upload-box1">
    		Upload your independent study! When picking a<br><br> 
			description, don't worry about writing like <br><br>
			it is your research paper. Be descriptive and<br><br> 
			general so future students can have an idea of<br><br>
			where to start! 
    	</div>
    
    	<div class="upload-box2">
    		<form class="upload-form" action="${pageContext.servletContext.contextPath}/Upload" method="post" enctype="multipart/form-data">>
    		  <fieldset>
    		    <legend>Upload a Project!</legend>
    		    Title:<br>
    		    <input type="text" name="t" placeholder="title" value="${t}"/>
    		    <br><br>
    		    Description:<br>
    		    <textarea name="desc" placeholder="Write something.." rows="4" cols="50" style="font-style:arial;" >${desc}</textarea>
    		    <br><br>
    		    Date Completed: <br>
    		    <input type="date" name="date" placeholder="month/day/year" value="${date}"/>
    		    <br><br>
    		    Picutre of Your Abstract<br>
    		    <input type="file" name="image"/>
    		    <br><br>
    		    <input type="submit" name="button" value="Login" id="log"/>
    		  </fieldset>
			  </form>
    	</div>
    </div>
    -->
    <!--  
    <div class="upload-container">
    	<div class="upload-box1">
    		Upload your independent study! When picking a<br><br> 
			description, don't worry about writing like <br><br>
			it is your research paper. Be descriptive and<br><br> 
			general so future students can have an idea of<br><br>
			where to start! 
    	</div>
    
    	<div class="upload-box2 upload-form">
    		<form action="${pageContext.servletContext.contextPath}/Upload" method="post">
		  <fieldset>
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
    	</div>
    </div>
    
    -->
    
    <!-- 
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
		 
		  -->
</body>
</html>