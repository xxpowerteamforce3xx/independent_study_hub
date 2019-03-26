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
        <h1>Faculty</h1>
    </header>
    
    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory" class="right">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload" class="right">Upload</a>
        <a href="#" class="right active">Faculty</a>
    </div>    
    <form class="upload-box">
        <input type="text" name="" placeholder="Faculty Member" />
        <input type="text" name="" placeholder="Research Students" />
        <input type="text" name="" placeholder="Research Interests" />
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
    </form>   
    <div class="table">
        <table>
            <thead>
                <tr>
                    <th scope="col">Faculty Member</th>
                    <th scope="col">Research Students</th>
                    <th scope="col">Research Interest</th>
                </tr>
            </thead>
            <tr>
                <td>Dr. Foy</td>
                <td>Cole Rohrbaugh, Christina Hall</td>
                <td>Analytical Chemistry</td>
            </tr>
            <tr>
                <td>Dr. Steel</td>
                <td>Ben Yanick</td>
                <td>Inorganic Chemistry</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
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