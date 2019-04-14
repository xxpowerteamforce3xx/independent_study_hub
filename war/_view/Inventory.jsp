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
	
	<script type="text/javascript">
		<%@ include file="./../Javascript/main.js" %>
	</script>
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

    <section>

        <!-- Search bar to type in phrase to search for in table below -->
        <input type="text" id="user_input" onkeyup="inventory_search()" placeholder="Search by name">

        <!-- Dropdown menu to select which column from table search is done by -->
        <div class="dropdown">
            <button onclick="searchBy()" class="dropbtn">Search by..</button>
            <div id="dropList" class="dropdown-content">
                <button type="button" onclick="setSearch(0)">Name</button>
                <button type="button" onclick="setSearch(1)">Use</button>
                <button type="button" onclick="setSearch(2)">Date</button>
            </div>
        </div>

        <!-- Dynamic HTML table to display chemicals -->
        <div class="table">
            <table id="inventory_table">
                <thead>
                    <tr>
                        <th scope="col">Chemical</th>
                        <th scope="col">Chemical Use</th>
                        <th scope="col">Date Purchased</th>
                    </tr>
                </thead>

                <tr>
                    <td>Acetone</td>
                    <td>Class</td>
                    <td>12/27/18</td>
                </tr>
                <tr>
                    <td>Ethanol</td>
                    <td>Class</td>
                    <td>01/01/19</td>
                </tr>
                <tr>
                    <td>Indium chloride</td>
                    <td>Research</td>
                    <td>01/23/19</td>
                </tr>
                <tr>
                    <td>Methanol</td>
                    <td>Class</td>
                    <td>11/20/18</td>
                </tr>
                <tr>
                    <td>Nitric acid</td>
                    <td>Class</td>
                    <td>02/06/19</td>
                </tr>
                <tr>
                    <td>Sodium hydroxide</td>
                    <td>Class</td>
                    <td>01/08/19</td>
                </tr>
                <tr>
                    <td>Sodium sulfide</td>
                    <td>Research</td>
                    <td>03/11/19</td>
                </tr>
                <tr>
                    <td>Stearic Acid</td>
                    <td>Research</td>
                    <td>09/18/18</td>
                </tr>
                <tr>
                    <td>Triglyceride Mix</td>
                    <td>Research</td>
                    <td>12/14/18</td>
                </tr>
            </table>
        </div>
    </section>
</body>
</html>