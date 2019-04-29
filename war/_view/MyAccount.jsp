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
		
	</style>
	
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>

</head>

<body class="login">

<div class="fixed">
		Logged in as "${user}"
		<form action="${pageContext.servletContext.contextPath}/MyAccount" method="post">
			<br>
			<input type='submit' name ='account' value = 'Back to Home'>
        	<input type='submit' name ='logout' value = 'Log out'>
    	</form>
	</div>
	<header>
        <h1>My Account</h1>

        <p class="quote">YCP 2019 - <span class="italic">Account Page</span></p>
    </header>


    <h2 class='h2'>Welcome, ${name}!</h2>

<table class='table'>
  <tr>
    <th>Username</th>
    <th>Password</th>
    <th>Email</th>
  </tr>
  <tr>
    <td>${name}</td>
    <td>${pw}</td>
    <td>${email}</td>
  </tr>
</table>

<h2 class='h2'>Projects:</h2>
<table class='table'>
	<tr>
		<th>Project Title</th>
		<th>Project Description</th>
		<th>Date Uploaded</th>
	</tr>

	<c:forEach  var="project" items="${projects}">
        <tr>
            <td>${project.get_title()}</td>
            <td>${project.get_description()}</td>
            <td>${project.get_year()}</td>		            
        </tr>
    </c:forEach>
		
</table>
  
      
      <c:if test="${! empty errorMessage}">
			<div class="alert">
 		 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		 		<strong>Error!</strong> ${errorMessage}
	  		</div>
	  </c:if>
      
</body>
</html>