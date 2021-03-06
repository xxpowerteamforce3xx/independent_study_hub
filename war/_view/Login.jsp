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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
		cb_span{color:white;}
	</style>
	
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
	
	

</head>

<body class="login">
	<header>
        <h1>Independent Study Hub</h1>

        <p class="quote">YCP 2019 - <span class="italic">Login Page</span></p>
    </header>


    <form class="box w3-card-4" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">Login</h1>
        <input type="text" name="name" placeholder="Username" id="name" value="${name}"/>
        <input type="password" name="pass" placeholder="Password" id="password" value="${pass}"/>
		 <label class="switch">        	
  			<input type="checkbox" name="check" value="1">
  			<span class="slider round"></span>
		</label>
		<span>Login as a Guest</span>
        <input type="submit" name="button" value="Login" id="log"/>
        <a class="log-link" href="http://localhost:8081/independent_study_hub/ResetPassword">Forgot Password?</a>
    </form>
    
     <form class="box_ycp_only w3-card-4" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">York College of Pennsylvania</h1>
    </form>
    
      <form class="box_checkbox_new_student w3-card-4" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">Create a New Account</h1>
        <br>
    	<label class="switch">
  			<input type="checkbox" name="check_stdnt" value="1">
  			<span class="slider round"></span>
		</label>
		<span> Create a new Student Account...</span>
    	<label class="switch">
  			<input type="checkbox" name="check_fac" value="1"> 
  			<span class="slider round"></span>
		</label>
		<span> Create a new Faculty Account...</span>
        <input type="submit" name="button" value="Create" id="log"/>
      </form>
     
      <c:if test="${! empty errorMessage}">
			<div class="alert">
 		 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		 		<strong>Error!</strong> ${errorMessage}
	  		</div>
	  </c:if>
      
      <!-- For future reference when I
      <script src="url"></script>
       -->
</body>
</html>