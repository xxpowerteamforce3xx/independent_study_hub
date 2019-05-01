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
    <title>Independent Study Hub</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
				
		#cb_span{color:Gray;}
	</style>
	
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
</head>
<body>
    <header class="home">
        <h1>Independent Study Hub</h1>

        <p class="quote">Nothing in life is to be feared, it is only to be understood.  Now is the time to understand more, so that we may fear less. <span class="italic">-Marie Curie</span></p>
    </header>
	
	<!-- Main Nav Bar that runs across top of web page -->
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
	
	<!-- Main section of web page's body -->
    <section class="Description">
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Course Description</strong>
            </h2>
        </div>
        <p>
            Independent study is a semester long, student lead project to expand the knowledge of the <br />
            scientific community.  Students will select an advisor to work under and expand an area of<br />
            science.  Students will order their chemicals and design their own methodology (with the  <br />
            assistance of their advisor). <br />
        </p>
    </section>
    <!-- This section will contain all of the links to previous student work  -->
    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Previous Work</strong>
            </h2>
        </div>
        <p>
            See examples of previous student work, as well as, uploading you own work.  Students will <br />
            need to upload their files to the archive by the end of the semester.  A picture of your   <br />
            poster and your final study report are required at a minimum.  Additional pictures of lab <br />
            work or documentation is also welcomed. <br />
        </p>
        <form action="${pageContext.servletContext.contextPath}/Upload" method="doGet">
        <button type="submit">Upload!</button>
        </form>
        	<div class="pictures">
	            <!-- This creates the 4-square of images that will link to the Previous work page is you click on any of the pictures (due to wraping in <a>) -->
	            <a href="http://localhost:8081/independent_study_hub/Research" id="img1">
	                <img src="style/FurBall.jpg" />
	                <img src="style/FurBall.jpg" />
	                <img src="style/FurBall.jpg" />
	                <img src="style/FurBall.jpg" />
	            </a>
         
        	</div>
    </section>


    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Resources</strong>
            </h2>
        </div>
		<form action="${pageContext.servletContext.contextPath}/Resources" method="doGet">
        	<p>Details and examples on what is required for independent research can be found here</p>
        	<button type="submit">Click Here!</button>
        </form>
        
    </section>
    
    
    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Faculty</strong>
            </h2>
        </div>
		<form action="${pageContext.servletContext.contextPath}/Faculty" method="doGet">
        	<p>Description of Faculty's research interests and past experience</p>
        	<button type="submit">Click Here!</button>
        </form>
    </section>


    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Inventory</strong>
            </h2>
        </div>
        <form action="${pageContext.servletContext.contextPath}/Inventory" method="doGet">
        	<p>A list of all available chemicals within the chemistry department's storage</p>
        	<button type="submit">Click Here!</button>
        </form>
    </section>

</body>
</html>