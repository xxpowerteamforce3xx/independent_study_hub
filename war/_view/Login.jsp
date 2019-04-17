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
    
    <form action="${pageContext.servletContext.contextPath}/Login" method="post">
			<table>
				<tr>
					<td class="label">User Name:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${password}" /></td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login">
		</form>
    
    <!-- 
    <form class="box" action="${pageContext.servletContext.contextPath}/Login" method="post">
        <h1 class="log_header">Login</h1>
        <input type="text" name="uname" placeholder="Username" id="name" value="${username}"/>
        <input type="password" name="pass" placeholder="Password" id="password" value="${password}"/>
        <input type="submit" name="" value="Login" id="log"/>
    </form>
     -->
    
</body>
</html>