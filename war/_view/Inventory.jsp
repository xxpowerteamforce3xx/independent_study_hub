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

<!-- When our Inventory JSP finished loading, we call generate_table() -->
<body>
    <header>
        <h1>Inventory</h1>
    </header>
	
	<!-- Log out box for user to sign out -->
	<div class="fixed">
		Logged in as "${user}"
		<form action="${pageContext.servletContext.contextPath}/Inventory" method="post">
        <input type='submit' name ='leave' value = 'Log out'>
    </form>
	</div>
	
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
                
                <tbody id="inventory_body">	
                	<!-- For each loop will have an array list of ChemicalInventory objects in inventory page
                		It will iterate across each item in the array and insert the appropriate information as seen below -->
	                <c:forEach items="${inventory}" var="inventory">
	                	<tr>
	                		<!-- Directly calling methods associated with ChemicalInventory class -->
	                		<td>${inventory.getChemical()}</td>
	                		<td>${inventory.getUseOfChemical()}</td>
	                		<td>${inventory.getDom()}</td>
	                	</tr>
	                </c:forEach>
                
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>