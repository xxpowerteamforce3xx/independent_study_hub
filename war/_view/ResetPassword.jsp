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

        <p class="quote">YCP 2019 - <span class="italic">Reset Password</span></p>
    </header>


    <form class="reset_pass" action="${pageContext.servletContext.contextPath}/ResetPassword" method="post">
        <h1>York College of Pennsylvania</h1>
        <h2>Please enter your YCP email associated with<br>
        	your IndependentStudyHub account below</h2>
        <input type="text" name="name" placeholder="user@ycp.edu" id="name" value="${email}"/>

        <input type="submit" name="button" value="Reset Password" id="log"/>
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