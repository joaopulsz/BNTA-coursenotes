// get the html elements by their ID
const button = document.getElementById("btn");
const text = document.getElementById("text");
let count = 0;

// listen for a button click
button.addEventListener("click", function () {
  count++;
  // make the <p> display it
  text.innerText = `Button was pressed ${count} times`;
});
