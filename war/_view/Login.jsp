<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
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
    <form class="box" action="${pageContext.servletContext.contextPath}/Home" method="doGet">
        <h1 class="log_header">Login</h1>
        <input type="text" name="uname" placeholder="Username" id="name"/>
        <input type="password" name="pass" placeholder="Password" id="password"/>
        <input type="submit" name="" value="Login" id="log"/>
    </form>
    
</body>
</html>