/* ***** Global variables ***** */

let search_by = 0;


function show_button(num){
  let table = document.getElementById("inventory_table");
  let row = table.rows[1];
  row.cells[4].style.display="inline";
}

function openSideMenu(){
	//Changes the side-menu's width to 250px.  Note, the side-menu's width is initially set to 0px in its CSS
	document.getElementById("side-menu").style.width = "250px";
	
	//Moves the contents of the page over to the right 250px.  This give the illusion that the side-bar menu is moving things over
	document.getElementById("main").style.marginLeft= "250px";
}

function closeSideMenu(){
	//Changes the side-menu's width to 250px.  Note, the side-menu's width is initially set to 0px in its CSS
	document.getElementById("side-menu").style.width = "0px";
	
	//Moves the contents of the page over to the right 250px.  This give the illusion that the side-bar menu is moving things over
	document.getElementById("main").style.marginLeft= "0px";
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
        textValue = table.rows[i].cells[search_by].textContent;

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

//searchBy() toggles the dropdown menu on the inventory page to be displayed (or not) each time it is called
function searchBy() {
    document.getElementById("dropList").classList.toggle("show");
}

//An anonymous function that takes in an event (i.e. clicking). If the event occurred on an element that doesn't
//have id='dropbtn' then we get the a list of elements whose class name is dropdown-content.  We iterate across this
//list and remove the id show from any that have it
window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) { //checks if event occurred on element without id=dropbtn
        let dropdowns = document.getElementsByClassName("dropdown-content"); //get our list of elements
        let i;
        for (i = 0; i < dropdowns.length; i++) { //iterate list
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) { //checks if item has show id
                openDropdown.classList.remove('show'); //removes show id from item
            }
        }
    }
}

//Changes global variable search_by to integer passed as num (0, 1, or 2).  This will modify searching behavior
//of inventory_search() and change placeholder text in search bar on inventory page
function setSearch(num) {
    search_by = num;
    let place_hold = document.getElementById('user_input');
    if (search_by == 1) { //user wants to search by use (class or research)
        place_hold.placeholder = "Search by use";
    } else if (search_by == 2) { //user wants to search by date
        place_hold.placeholder = "Search by date";
    } else { //user wants to search by name (default search)
        place_hold.placeholder = "Search by name";
    }
}


