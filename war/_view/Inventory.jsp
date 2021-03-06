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
    <br>
	<c:if test="${type.equals('faculty')}">
	    
	    <form>
	        <div class="inventory-form">
	        <div class="divider">  
	          <input type="text" name="chemical" placeholder="Chemical" id="chemical" value="${chemical}"/>
	          <input type="text" name="use" placeholder="Research or Class" id="use" value="${use}"/>
	       		<input type="text" name="year_purchased" placeholder="MM/DD/YY" id="year_purchased" value="${year_purchased}"/>
	       		<input type="text" name="initialAmount" placeholder="Amount Bought" id="initialAmount" value="${initialAmount}"/>
	       		<input type="text" name="initMediaType" placeholder="Media Type" id="initMediaType" value="${initMediaType}"/>
	        </div>
	        <div class="divider">
	           <input type="text" name="cas" placeholder="Cas Number" id="cas" value="${cas}"/>
	       		<input type="text" name="room" placeholder="Room ID" id="room" value="${room}"/>
	       		<input type="text" name="loc" placeholder="Location ID" id="loc" value="${loc}"/>
	       		<input type="text" name="supplier" placeholder="Supplier" id="supplier" value="${supplier}"/>
	       		<input type="text" name="catalogue" placeholder="Catalogue Number" id="catalogue" value="${catalogue}"/>
	       </div>
	       </div>
		   
		   <button type="reset">Reset</button>
		   <button type="submit" name="button" value="Insert!" id="create"/>Insert</button>
    	</form>
    	<br>
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
	            <!-- These buttons will change a global variable in the JS file, which modifies which column 
	            the search bar sorts table info by -->
	            <div id="dropList" class="dropdown-content">
	                <button type="button" onclick="setSearch(0)">Name</button>
	                <button type="button" onclick="setSearch(1)">Use</button>
	                <button type="button" onclick="setSearch(2)">Date</button>
	                <button type="button" onclick="setSearch(5)">CAS #</button>
	                <button type="button" onclick="setSearch(9)">Cat #</button>
	            </div>
	        </div>
	
	        <!-- Dynamic HTML table to display chemicals -->
	        <div class="table">
		 <form class="buttons" action="${pageContext.servletContext.contextPath}/Inventory" method="post">
	            <table id="inventory_table">
	                <thead>
	                    <tr>
	                        <th scope="col">Chemical</th>
	                        <th scope="col">Chemical Use</th>
	                        <th scope="col">Date Purchased</th>
	                        <th scope="col">Amount</th>
	                        <th scope="col">Media</th>
	                        <th scope="col">CAS #</th>
	                        <th scope="col">Room Number</th>
	                        <th scope="col">Location</th>
	                        <th scope="col">Supplier</th>
	                        <th scope="col">Catalogue #</th> 
	                        
	                    </tr>
	                </thead>
	                
	                <tbody id="inventory_body">
	    			
	                	<!-- For each loop will have an array list of ChemicalInventory objects in inventory page
	                		It will iterate across each item in the array and insert the appropriate information as seen below -->

		                <c:forEach items="${pending}" var="inventory">
		                	<tr>
		                		<!-- Directly calling methods associated with ChemicalInventory class -->
		            			<c:if test="${type.equals('faculty')}">
		                			<td>${inventory.getChemical()} <input type="checkbox" name='drugs' value="${inventory.getChemical()}"></td>
		                		</c:if>
		                		<c:if test="${type.equals('student')}">
		                			<td>${inventory.getChemical()}</td>
		                		</c:if>
		                		<td>${inventory.getUseOfChemical()}</td>
		                		<td>${inventory.getDom()}</td>
		                		<td>${inventory.getAmount()}</td>
		                		<td>${inventory.getMedia()}</td>
		                		<td>${inventory.getCAS()}</td>
		                		<td>${inventory.getRoom()}</td>
		                		<td>${inventory.getLoc()}</td>
		                		<td>${inventory.getSup()}</td>
		                		<td>${inventory.getCat()}</td>
		                	</tr>
		                	
		                </c:forEach>
	                <br>
 
					<br>
					<c:if test="${type.equals('faculty')}">
						<button class="side-bar-form-btn" type='submit' name ='delete' value = 'delete'>Delete Chemical(s)</button>
					</c:if>
    				
	                </tbody>
	            </table>
	            </form>
	        </div>
	    </section>
</body>
</html>