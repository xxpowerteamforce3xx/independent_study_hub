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

	<nav class="navbar">
		<!-- Our side bar button that uses JavaScript to show the side bar menu -->
    	<span class="open-slide">
    		<a href="#" onclick="openSideMenu()">
    			<!-- Creates our side bar icon that is 30 by 30 pixels -->
    			<svg width="30" height="30">
    				<!-- Draws two white lines (stroke) where d denotes what the left and right side of the lines being
    					Each line is 5 pixels wide (stroke-width) -->
    				<path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
    				<path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
    				<path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
    			</svg>
    		</a>
    	</span>
    	
    	<ul class="navbar-nav">
    		<li><a href="http://localhost:8081/independent_study_hub/Home">Home</a></li>
    		<li><a href="http://localhost:8081/independent_study_hub/Resources">Resources</a></li>
    		<li><a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a></li>
    		<li><a href="#">Inventory</a></li>
    		<li><a href="http://localhost:8081/independent_study_hub/Upload">Upload</a></li>
    		<li><a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a></li>
    	</ul>
	</nav>
	
	<!-- The side bar menu that is activated when the "open-slide" <a> is clicked -->
    <div id="side-menu" class="side-nav">
    	<div class="uName-div">
    		<h2 class="uName">${user}</h2>
    	</div>
    	
    	<!-- <a> that closes the side-bar menu. The &times; is what gives the "X" image for this anchor tag-->
    	<a href="#" class="btn-close" onclick="closeSideMenu()">&times;</a>
    	<a href="http://localhost:8081/independent_study_hub/Home">Home</a>
        <a href="http://localhost:8081/independent_study_hub/Resources">Resources</a>
        <a href="http://localhost:8081/independent_study_hub/Research">Previous Work</a>
        <a href="#">Inventory</a>
        <a href="http://localhost:8081/independent_study_hub/Upload">Upload</a>
        <a href="http://localhost:8081/independent_study_hub/Faculty">Faculty</a>
        
        <form class="side-bar-form" action="${pageContext.servletContext.contextPath}/Home" method="post">
			<br>
			<button class="side-bar-form-btn" type='submit' name ='account' value = 'myAccount'>My Account</button>
        	<button class="side-bar-form-btn" type='submit' name ='leave' value = 'Log out'>Log Out</button>
    	</form>
    </div>
	<c:if test="${type.equals('faculty')}">
	    <form action="${pageContext.servletContext.contextPath}/Inventory" method="post">
	        <input type="text" name="chemical" placeholder="Chemical" id="chemical" value="${chemical}"/>
       	    <input type="text" name="use" placeholder="Research or Class" id="use" value="${use}"/>
       		<input type="text" name="year_purchased" placeholder="Purchased" id="year_purchased" value="${year_purchased}"/>
       		<input type="text" name="initialAmount" placeholder="Amount Bought" id="initialAmount" value="${initialAmount}"/>
       		<input type="text" name="initMediaType" placeholder="Media Type" id="initMediaType" value="${initMediaType}"/>
	        <button type="reset">Reset</button>
	        <button type="submit" name="button" value="Insert!" id="create"/>Insert</button>
	    </form>
	</c:if>
	<c:if test="${type.equals('faculty')}">
	    <form action="${pageContext.servletContext.contextPath}/Inventory" method="post">
	        <input type="text" name="deleteChemical" placeholder="Chemical" id="deleteChemical" value="${deleteChemical}"/>
	        <input type="text" name="deleteUse" placeholder="Research or Class" id="deleteUse" value="${deleteUse}"/>
	        <input type="text" name="delete_year_purchased" placeholder="Purchased" id="delete_year_purchased" value="${delete_year_purchased}"/>
	        <button type="reset">Reset</button>
	        <button type="submit" name="button" value="Delete!" id="create"/>Delete</button>
	    </form>
	</c:if>
		<c:if test="${! empty errorMessage}">
			<div class="alert">
 		 		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		 		<strong>Error!</strong> ${errorMessage}
	  		</div>
	  </c:if>
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
	                        <th scope="col">Amount</th>
	                        <th scope="col">Media</th>
	                        <th scope="col">Remove Amount</th>
	                        
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
		                		<td>${inventory.getAmount()}</td>
		                		<td>${inventory.getMedia()}</td>
          						<td>Amount:<input type="text"><button type="button">OK</button></td>
		                	</tr>
		                	
		                </c:forEach>
	                
	                </tbody>
	            </table>
	        </div>
	    </section>
</body>
</html>