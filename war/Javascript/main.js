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

//Search function for our inventory page.  Dynamically changes inventory page
//each time this function is called
function inventory_search() {
  let input, filter, table, i, n, textValue;

  //input references the input field for the user
  //filter stores the value that the user gave
  input = document.getElementById("user_input");
  filter = input.value.toUpperCase();

  //table stores a reference to our inventory table which we got by the table's ID
  table = document.getElementById("inventory_table");

  //n is equal to the number of rows in our table
  n = table.rows.length;

  //we iterate over each row, skipping the first row since that is our header row
  for (i = 1; i < n; i++) {
      //We are only searching by name (the first cell value in each row).
      //.textContent returns the text in between the data tags (<td> textContent </td>)
      textValue = table.rows[i].cells[0].textContent;

      //indexOf() returns the first instance of filter it finds in textValue
      //so if filter is equal to "Me" than it will return a value greater than -1 for things
      //such as Me, Mean, Methanol.  toUpperCase() allows us to ignore case-sensitive situations
      if (textValue.toUpperCase().indexOf(filter) > -1) {
          table.rows[i].style.display = "";
          //indexOf() returned a -1, meaning it couldn't find a phrase similar to our filter one
      } else {
          table.rows[i].style.display = "none";
      }
  }
}


