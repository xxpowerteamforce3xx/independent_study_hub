<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Previous Work</title>
	<style type="text/css">
		<%@ include file="./../style/style.css" %>
		div.fixed {
		  position: fixed;
		  bottom: 0;
		  right: 0;
		  width: 200px;
		  background-color: forestgreen;
		  border: 3px solid #73AD21;
		}		
	</style>
</head>
<body>
    <header>
        <h1>Previous Work</h1>
    </header>
    
    <div class="fixed">
		Logged in as "${user}"
	</div>

    <div class="navbar">
        <a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="#" class="active">Previous Work</a>
        <a href="http://localhost:8081/independent_study_hub/Inventory" class="right">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload" class="right">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty" class="right">Faculty</a>
    </div>    


    <div class="table">
        <table>
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Graduating Year</th>
                </tr>
            </thead>
            <tr>
                <td>Ben Yanick</td>
                <td><a href="./Home.html">Synthesizing Qunatum Dots</a></td>
                <td>Synthesizing cadmium-free quantum dots using water based chemistry</td>
                <td>2019</td>
            </tr>
            <tr>
                <td>Cole Rohrbaugh</td>
                <td>Lipid Extraction from Bee Pollen</td>
                <td>Extraction of lipids from bee pollen.  Characterization of lipids using HPLC</td>
                <td>2019</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
            <tr>
                <td>---</td>
                <td>---</td>
                <td>---</td>
                <td>---</td>
            </tr>
        </table>
    </div>
</body>
</html>