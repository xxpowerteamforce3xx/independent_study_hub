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
        <h1>Create a New Student Account</h1>

        <p class="quote">YCP 2019 - <span class="italic">Account Creation Page</span></p>
    </header>


    <form class="box" action="${pageContext.servletContext.contextPath}/NewStudent" method="post">
        <h1 class="log_header">Your information below</h1>
        <input type="text" name="name" placeholder="Username" id="name" value="${name}"/>
        <input type="text" name="pass" placeholder="Password" id="password" value="${pass}"/>
        <input type="text" name="email" placeholder="Email" id="email" value="${email}"/>
        <input type="text" name="fac_code" placeholder="Faculty Code" id="fac_code" value="${fac_code}"/>
        <input type="submit" name="button" value="Create!" id="create"/>
    </form>
    
     <form class="box_new_student_ycp" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">York College of Pennsylvania</h1>
    </form>
    
    <form class="box_blank0" action="${pageContext.servletContext.contextPath}/Login" method="post">
    </form>
    <form class="box_blank1" action="${pageContext.servletContext.contextPath}/Login" method="post">
    </form>
    <form class="box_blank2" action="${pageContext.servletContext.contextPath}/Login" method="post">
    </form>
  
      
      <c:if test="${! empty errorMessage}">
			<div class="alert">
 		 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		 		<strong>Error!</strong> ${errorMessage}
	  		</div>
	  </c:if>
      
</body>
</html>