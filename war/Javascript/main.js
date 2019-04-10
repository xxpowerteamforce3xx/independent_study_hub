//method="doGet"
let log = document.getElementById("log");


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


