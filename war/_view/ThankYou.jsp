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


    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Thank you for your submission</strong>
            </h2>
        </div>
        <br><br>
        <p>
           A faculty member will review your submission, and if applicable, will okay your account to become an administrator account
           on the site. Please keep in contact with staff and they will update you when they verify your credentials.
           Thank you! <br />
        </p>
	</section>

</body>
</html>