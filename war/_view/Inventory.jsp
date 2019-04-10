<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Inventory</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
	</style>
</head>
<body>
    <header>
        <h1>Inventory</h1>
    </header>
    
    <!-- The navigation bar for the web page -->
    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="#" class="right active">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload" class="right">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty" class="right">Faculty</a>
    </div>
    
       
    <form class="upload-box">
        <input type="text" name="" placeholder="Chemical Name" />
        <input type="text" name="" placeholder="For Research or Class" />
        <input type="text" name="" placeholder="Year Purchased" />
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>
    
    <div class="table">
        <table>
            <thead>
                <tr>
                    <th scope="col">Chemical</th>
                    <th scope="col">Chemical Use</th>
                    <th scope="col">Date Purchased</th>
                </tr>
            </thead>
            <tr>
                <td>Stearic Acid</td>
                <td>Research</td>
                <td>2019</td>
            </tr>
            <tr>
                <td>Triglyceride Mix</td>
                <td>Research</td>
                <td>2019</td>
            </tr>
            <tr>
                <td>Methanol</td>
                <td>Class</td>
                <td>2019</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
           <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
        </table>
    </div>
</body>
</html>