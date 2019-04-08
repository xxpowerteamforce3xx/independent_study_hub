//method="doGet"

/* XMLHttpRequest object, will exchange data with a server behind the scenes.  
 * This allows parts of a web page to be updated without reloading the whole page. */
//let xhttp = new XMLHttpRequest();
let log = document.getElementById("log");

/* onreadystatechange will execute our anonymous function whenever the readyState property of our XMLHttpRequest
 * object changes. readyState property holds the status of the XMLHttpRequest and status property holds the 
 * status of the XMLHttpRequest object*/

/*
xhttp.onreadystatechange = function() {
	let password = document.getElementById("password").value;
	
	/* readyState == 4 means the request is finished and response is ready.
	 * status == 200 means the XMLHttpRequest object's is "ok" 
	if (this.readyState == 4 && this.status == 200){
		let username = document.getElementById("name").value;
	}
	xhttp.open('GET', './../_view/Home.jsp', true);
	xhttp.send());
} */

// A JavaScript function that takes no arguments
function check(){
	let username = document.getElementById("name").value;
	let password = document.getElementById("password").value;
	
	if (username == "Ben" && password == "password"){
		alert("Login sucessful");
		let method = document.getElementById("form");
		method.setAttribute("method", "doGet");
	} else {
		alert("Login fail");
	}
}

