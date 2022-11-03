# Promises and fetch

### Duration: 60mins

Lesson objectives
- to understand how promises resolve problems associated with 'callback hell'
- to learn what a promise is
- use of the `async` and `await` keywords
- how to use `fetch()`

> Make sure the JSON Formatter is installed in Chrome for the students!

Before we start, let's create a project to work with:

```
# Terminal

mkdir promises_and_fetch
cd promises_and_fetch
touch index.html app.js
code .

```

Use the `html:5` snippet to generate boiler code in `index.html`.

## Asynchronity

We've done synchronous JS so far - every line of code is getting executed in order, and each function called will be finished before the next one is called. The only way to do multiple tasks at the same time within a language, is to use multi-threading.

However, on the user side, synchronous programming has huge drawbacks - once code is being executed, the user cannot interact with the page anymore

>[Show MDN synchronous prime generator](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Asynchronous/Introducing)

The solution is asynchronous programming - with callbacks! Going into the details would be a bit too in-depth right now, but just know that the way JavaScript operates in the browser and in Node, we can execute certain functions asynchonously. When we execute one of these functions, the rest of the code can keep running, other functions can be called - and when our asynchronous function finishes, it jumps to the top of the order of executables, and invokes the callback prepared for this occasion! This idea applies to most event listeners, some functions that have intentional delays, but most importantly - to functions that we do not know when they will finish executing - think of API calls, database connections, etc.

## Callback Hell

But therein lies the problem - if we have a function that we do not know how long it's going to take, what can we do? Add a callback to execute when the function finishes. However, that function might rely on something else which may take an unspecified amount of time - so we add another callback! And we keep going, adding callbacks within callbacks, thus reaching the dreaded *callback hell*. 

Let's say you hear about Promises in JavaScript - Sounds *promising*, right?! After spending some time online, you might happen across some articles, forums or videos talking about it, and the first thing those articles will talk about is probably the problem Promises were meant to solve - the Callback Hell! But what is the callback hell? Let's check out an example!

```js
const getBaguette = function(user, nextStep){
	console.log("Getting baguette from " + user);
	nextStep("baguette");
}
const sliceBaguette = function(baguette, nextStep){
	console.log("Slicing baguette in half");
	nextStep("butter", "baguette");
}
const butterBaguette = function(butter, baguette, nextStep){
	console.log("Buttering the baguette");
	nextStep("toppings", "buttered baguette");
}
const addToppingsToBaguette = function(butteredBaguette, toppings, nextStep){
	console.log("Adding toppings to buttered baguette");
}

```

Having these 4 functions, how would we call them in order, considering that all `nextStep` arguments are callbacks?

```js
getBaguette("Phil", (baguette) => {
	sliceBaguette(baguette, (slicedBaguette) => {
		butterBaguette(butter, slicedBaguette (butteredBaguette) => {
			addToppingsToBaguette(butteredBaguette, toppings, (finishdBaguette) => {
				console.log(Serving finishedBaguette);
			})
		})
	})
})
```

How easy does this look to understand, dissect, extend and modify? The process itself would take a long time, and there's no telling where the pyramid of callbacks would finish!

I can offer you a solution - and it looks *promising*. (sorry)


## Promises

Now that we understand that simply using callbacks is not a scale-able solution to creating asynchronous code, we can appreciate an alternative Javascript provides us with: Promises.

### What is a Promise?
A promise is an object that represents something that will happen in the future. This can be the completion or failure of the operation.

Promises allow us to write cleaner code; fewer callbacks are being passed from function to function, meaning our code looks more like synchronous code (much easier to read).

When we create a Promise object it will be pending until the asynchronous operations that we are wrapping has completed.

### Fetch
The `fetch()` method that we're going to use wraps the asynchronous functionality of a request inside a Promise. This means we can write code to handle the result of our request to our API without needing to worry about when our request will finish executing.

First, add a script tag to your `index.html`.

```html
// index.html

<head>
	<!--as before-->
    <script src="js/app.js"></script> //ADDED
</head>

```

Open `index.html` in your browser and open Chrome Dev Tools.

Let us start by looking at the API we are going to be using for this lesson: [RandomDog API](https://dog.ceo/dog-api/).

> short demo of API for students

Now we are familiar with the documentation, we can start building our app - we want to get some random dog images through the API, and it will need a JS file to be loaded in with!

In our `app.js`, let's see if we can actually get a function called when the DOM loads - always start with this:

```js

window.addEventListener('DOMContentLoaded', () => {
    console.log("DOM Content Loaded...");

})
```

Return to the browser and check that this listener is working.

We can now write a function that uses `fetch()`, our request wrapped in a Promise.

```js
// app.js

window.addEventListener('DOMContentLoaded', () => {
    console.log("DOM Content Loaded...");

    
    const fetchDogImage = () => { // ADDED 
        const request = fetch("https://dog.ceo/api/breeds/image/random");
        console.log(request);
    }

    fetchDogImage(); // ADDED 

})
```
Refresh the browser and look at the console.

We use the `fetch()` to make a request to the DogAPI which returns a promise. Promises are nothing magical - just another datatype, which starts off pending, but as soon as the request comes back with a response, it will have a `resolved` or `rejected` status.

We can now think about interacting with the Promise through the `then()` method. The `then()` method registers callbacks to receive a Promise's eventual value (or reason for failure). We can think of it like the following:

* We make a request
* JS promises it will come back with something
* When it does, `.then()` we can execute some other code, with the values returned.

```js
// app.js

window.addEventListener('DOMContentLoaded', () => {
    console.log("DOM Content Loaded...");

    
    const fetchDogImage = () => { 
        fetch("https://dog.ceo/api/breeds/image/random") // MODIFIED
        // console.log(request) // REMOVED
        .then(response => console.log(response)) // ADDED
        
    }

    fetchDogImage(); 

})
```

If we refresh and view our console again, we can now see the response object being logged out. This contains the JSON body we're looking for, but to access it, we need to call the `json()` method on it. `json()` is also asynchronous! This means we are returned ANOTHER Promise. 

Chaining another `then()` allows us to continue to work with the object until we have what we want.

```js
// app.js

window.addEventListener('DOMContentLoaded', () => {
    console.log("DOM Content Loaded...");

    
    const fetchDogImage = () => { 
        fetch("https://dog.ceo/api/breeds/image/random")
        .then(response => response.json()) // MODIFIED
        .then(data => console.log(data)) // ADDED
    }

    fetchDogImage(); 

})
```

Once you inspect the log, we can see that the response finally takes the shape of the JSON data that we were expecting!

Let us add a `<button>` and an `<img>` tag to our `index.html`. The button's job is going to be used to call the method, and the `img` tag will get its `src` attribute populated.

```html
// index.html

<body>
    <h1>Promises and Fetch</h1>

    <button>Click for an image of a random dog!</button>

    <img src="" alt="A dog"> //ADDED
</body>

```

Check your browser to see if these items are rendering. 

**TASK:** modify your code in `app.js` to see if you can render a new random dog image every time you click the button. Think carefully about what you want your 'end_code' to look like before you start.

Possible solution:

```js
// app.js

document.addEventListener('DOMContentLoaded', () => {
    console.log("DOM Content Loaded...");

    
    const fetchDogImage = () => { 
        fetch("https://dog.ceo/api/breeds/image/random")
        .then(response => response.json()) 
        .then(data => document.querySelector("img").src = data.message) // MODIFIED
    }

    document.querySelector("button").addEventListener("click", fetchDogImage); //ADDED

})
```

>Take a break!

## Promise.all (optional)

Let's imagine that we want to go absolutely crazy with our newfound powers - let's try to display on our screen every Disney character ever!
Luckily I've got just the API for you!

>[Demonstrate the Disney API](https://api.disneyapi.dev/characters)

At the very bottom of the response, we can see the problem at hand: Each and every response returns us 50 characters, and there are 149 extra pages, each with 50 further characters. This is called pagination.

WHat would be a reasonable solution to return all of the characters? We can write 149 fetch requests, but that's not realistic or scalable. We should still use promises, but I don't want to keep refreshing the screen every time a new request finishs - ideally we would wait until the last request finishes, collate the results, then generate let's say `<li>` elements with character names in one go.

Enter `Promises.all()`.

`Promises.all()` is a special method - it's first argument needs to be an Array of promises. When each and every promise finished and resolved, it will actually give us back a promise, for which we can call a single callback, with all responses from all callbacks available for us.

Let's start writing this in our `app.js`!

First we create an array of promises (let's go for only 10 pages now, to not keep hitting the API thousands of times). We need to get the second promise from our fetch, the one coming back from our `.json()` call:

```js

document.addEventListener("DOMContentLoaded", ()=>{
	
	//as before

    const allPromises = [];
    for (let i = 1; i < 11; i++) {
	    allPromises.push(
		    fetch(`https://api.disneyapi.dev/characters?page={i}`)
		    .then((response) => response.json())
	    )
    }
})

```

Now we can call `Promise.all()`, with our list of promises. This will be able to handle all responses with a single callback in a `.then()` call.

```js
document.addEventListener("DOMContentLoaded", ()=>{
	
	//as before

    const allPromises = [];
    for (let i = 1; i < 11; i++) {
	    allPromises.push(
		    fetch(`https://api.disneyapi.dev/characters?page={i}`)
		    .then((response) => response.json())
	    )
    }
    Promise.all(allPromises)
    .then((allResults) => {
        const allCharacters = allResults.map((result) => result.data).flat();
        console.log(allCharacters);
    })    
})
```

In the callbacks first line, we are only getting back 10 objects. The value we need is inside the `data` key of each object. Mapping through the results we end up with an array of arrays - each array containing 50 different characters' details, including their names. We first must flatten the array to end up with an array of 500 objects.

Once we have this, we can map through these objects, only accessing their names - like we did in the last week!

```js
document.addEventListener("DOMContentLoaded", ()=>{
	
	//as before

    const allPromises = [];
    for (let i = 1; i < 11; i++) {
	    allPromises.push(
		    fetch(`https://api.disneyapi.dev/characters?page={i}`)
		    .then((response) => response.json())
	    )
    }
    Promise.all(allPromises)
    .then((allResults) => {
        const allCharacters = allResults.map((result) => result.data).flat();
        const allCharacterNames = allCharacters.map((characterObject) => characterObject.name) //added
        console.log(allCharacters);
    })    
})
```

Fantastic, 500 character names!

**TASK:** (optional) modify your code in `app.js` to see if you can render a `ul` element, and an `li` element for each character name!

Possible solution:

```js
document.addEventListener("DOMContentLoaded", ()=>{
	
	//as before

    const allPromises = [];
    for (let i = 1; i < 11; i++) {
	    allPromises.push(
		    fetch(`https://api.disneyapi.dev/characters?page={i}`)
		    .then((response) => response.json())
	    )
    }
    Promise.all(allPromises)
    .then((allResults) => {
        const allCharacters = allResults.map((result) => result.data).flat();
        const allCharacterNames = allCharacters.map((characterObject) => characterObject.name)
        
        const ulElement = document.createElement("ul");
        allCharacterNames.forEach((name) => {
            const liElement = document.createElement("li");
            liElement.textContent = name;
            ulElement.appendChild(liElement);
        })
        document.querySelector("body").appendChild(ulElement);
    })    
})
```

