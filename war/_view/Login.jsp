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

        <p class="quote">YCP 2019 - <span class="italic">Login Page</span></p>
    </header>


    <form class="box" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">Login</h1>
        <input type="text" name="name" placeholder="Username" id="name" value="${name}"/>
        <input type="password" name="pass" placeholder="Password" id="password" value="${pass}"/>
        <input id =Mycheckbox type="checkbox" name ="check" value="1"><span id="cb_span"> Login as a Guest</span>
        <input type="submit" name="button" value="Login" id="log"/>
    </form>
    
     <form class="box_ycp_only" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">York College of Pennsylvania</h1>
    </form>
    
      <form class="box_checkbox_new_student" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">Create a New Account</h1>
    	<input id =Mycheckbox type="checkbox" name ="check_new" value="1"><span id="cb_span"> Create a New Account</span>
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