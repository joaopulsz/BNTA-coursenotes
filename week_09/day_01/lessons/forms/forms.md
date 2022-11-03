# React Forms

## Introduction

User input not only ensures that your user is engaged, but also paves the way to functional, not only informational, webpages. Think online shops, surveys and games. Each of these examples are common on the web and they all have the shared requirement for **user input**. As we've seen previously, HTML itself includes the `<form>` element alongside `<input>` with its many `type` attributes as well as other means of input such as `<textarea>`. These elements handle their own piece of state, which is then collected together and sent on submission of the form, but within React we tend to override this system somewhat. 

By creating our own `onSubmit` functionality and by handling the pieces of state explicitly with the `useState` hook, we grant ourselves slightly easier control.

## HTML Forms

Let's quickly recap how we build and utilise HTML forms. Back during the JavaScript content, we made use of the RESTCountries API during one of the afternoon activities. We'll borrow some of the example solution code from there for this section.

Now, a form begins with a `<form>` element, which acts as a wrapper. For our RESTCountries example, we had a simple form with only two constituent parts: a text box-type input and a submit button.

```html
 <form id="newCountryForm">
    <input type="text" id="inputField" />
    <input type="submit" value="Submit" id="submitButton" />
</form>

```

Note here that both our text input field and our submit button are `<input>` elements; they simply have differing `type` attributes. How this appears on the front-end is shown below:

![Basic form](../../../assets/react/forms/basic_form.png)

This is simple as we can get: a variable input method (variable here meaning the user can vary it in some way) and some means for submission. For the RESTCountries exercise, this form was used to afford the user a means for filtering the displayed countries by the provided search-term. Because of how the API was built on the back-end, where partial matches were returned, this worked well.

How this functioned was much akin to how we associate any event-driven process to some event on the front-end—by the use of JavaScript. By first creating a new function for handling this more-specific `fetch()` request, we then associate it to the form itself, tying the function to the `"submit"` event.

```javascript
function fetchSpecificCountry(inputCountry) {
    const countryURL = "https://restcountries.com/v2/name/" + inputCountry;
    fetch(countryURL)
    .then(response => response.json())
    
    // ...
    
}

function handleSubmit(e) {
    e.preventDefault();
    const input = document.getElementById("inputField");
    fetchSpecificCountry(input.value);
}

const newCountryForm = document.getElementById("newCountryForm")

newCountryForm.addEventListener("submit", handleSubmit)

```

We've cut down some of the code here for clarity. As you can see, there's a lot of interplay here between the HTML and JavaScript code. We have used the `.getElementById()` method not only so we can add in our event listener, but also so that we can access, and hence utilise, the value within the input field of the form (within the `handleSubmit()` function). Within this function, we are accessing the `input` text element and then in turn making use of the `value` property. This is the piece of state we alluded to earlier.

## React Forms

Now, let's have a look at the same form but within React. With the use of JSX, there is first the obvious difference in relationship between the `<form>` element and it's associated functionality. Housing this all within one file means that we can more easily envision how our form exists as a single part of our webpage.

To simplify the example of how to we can use a form within React, we're going to use an example akin to that we'll ask you to create within the associated exercise to this chapter — one which doesn't deal with an external API. Do note that the general process is the same, however. Going forwards, assume that `collectedValues` is simply the data-set you are making use of elsewhere in your application. It is a list of values. This could conceivably be gained from an external source (an external API).

First, let's create our basic form. Same as we had before, we have some structural code (now within our `return()` statement) and a `handleSubmit()` function. We've ensured that we've prevented the default behaviour of the `submit` event as this would cause the page to refresh and we're currently not saving our new data in an external location.

```javascript

const NewValueForm = ({collectedValues, setCollectedValues}) => {

  function handleSubmit(e) {
    e.preventDefault();
  }

  return (
    <section className="container">
      <form onSubmit={handleSubmit}>

          <input type="text" id="nameField" />
          <input type="submit" value="Submit" id="submitButton" />

      </form>
    </section>
  )
}

export default NewValueForm
```

So far, this is looks almost identical to the example we had before, we've simply moved all of our code into one React component. Note, however, that our form isn't quite functioning yet. We are still missing two pieces:

- Some means of accessing the value within the text input field
- Some functionality which adds this new value to our overarching `collectedValues` list

The former is handled with the `useState` hook, the latter is housed within the `handleSubmit()` function.

Let's take them one at a time:

### Using `useState` for our input field values

We know that we handle state within our React applications using the `useState` hook. By simply creating a state variable which is updated `onChange()` of the input field, we create a variable we can use across our application:

```javascript
// ...

	const [newValue, setNewValue] = useState("");

	return (
	
		...
		
		<input type="text" id="nameField"
      	onChange={(e) => {setNewValue(e.target.value)}}/>
      	
		...
		
	)

// ...
```

Here, we create a temporary variable `e` meaning "event" so that we can access the same value we were using previously as in our RESTCountries example above. Because this event is directly tied to the `<input>` field, we can access the value directly.

### Building out our `handleSubmit()` function

This part is as easy as providing our new value to the `setCollectedValues` function, which itself is being passed in as a prop. Because we know that our `collectedValues` variable is a list, and remembering that we cannot directly mutate our state, only assign new values, we make use of a spread operator `...` so we don't lose our initial values within the list:

```javascript
import { useState } from "react";

const NewValueForm = ({collectedValues, setCollectedValues}) => {

  const [newValue, setNewValue] = useState("");

  function handleSubmit(e) {
    e.preventDefault();
    setCollectedValues([...collectedValues, newValue]);
  }

// ...
```

### Example Code


```javascript
import { useState } from "react";

const NewValueForm = ({collectedValues, setCollectedValues}) => {

  const [newValue, setNewValue] = useState("");

  function handleSubmit(e) {
    e.preventDefault();
    setCollectedValues([...collectedValues, newValue]);
  }

  return (
    <section className="container">
      <form onSubmit={handleSubmit}>

          <input type="text" id="nameField"
          onChange={(e) => {setNewValue(e.target.value)}}/>

          <input type="submit" value="Submit" id="submitButton" />

      </form>
    </section>
  )
}

export default NewValueForm
```


## Adding complexity

There are two obvious ways to add some more intricate behaviour to your forms:

- Input Validation
- Input Modulation

Sometimes we want our form to do something with our data before it is passed around our application. This is very common when you are handling data being passed to-and-from an external database, as you will likely want all your data within a consistent format, a format that you couldn't necessarily expect a user to adhere to. This can also often include the association of additional pieces of data to the input from a form. A timestamp is the most obvious example. We may want to include this data within our database but it's not something we're going to ask the user to input themselves.

In the below examples, we're going to assume that you simply have a list of usernames associated with the timestamp of when they were inputted (as shown below). However, before we look at how we could modulate our received input, creating this more involved object, let us first have a quick discussion about **input validation**.


```javaScript
const currentUsernames = [
    {name: "appleBird", signupDate: "8/06/2022"}, 
    {name: "orangeCat", signupDate: "8/06/2022"}, 
    {name: "bananaDog", signupDate: "9/06/2022"}
];
```    


### Input Validation

HTML `<input>` elements have a good few neat features which you can use for some types of input validation. Features include the `required` keyword for if a value **needs** to be specified within a field before submission, alongside `min` and `max` which define the bounds in character length. 

Because of how common the want for input validation is, most checks, including whether an input includes only alphabetical characters (look at the how you can use the `pattern` attribute with a Regular Expression), already exist. There will be times when you do want to create some bespoke validation, however do first have a look at what HTML offers out of the box as there's a lot more there than you may expect!

If you are going to create your own novel validation then note that when using the React library **we already have a chain of events here that we can easily tap into**: The user typing into the input field triggers some on-change functionality; this functionality then involves the setting of some state; the submission of the form is then tied to another function, which in turn holds further functionality.

When we add validation, we will likely want it to stop our form from being submitted until some set of requirements are met. We would, hence, add extra steps to our chain **before** the form is submitted, specifically tied to the `onChange` event.

Let's have a look at an example of when we may want to add in our own form of validation. You're signing up for a cool new plant subscription service and the sign-up form is asking you for a unique username. The information of what usernames are already taken is known to the internal system as they would be stored within an accessible database, assume that this is reflected by the list shown earlier (`currentUsernames`).

```javascript
import { useState } from 'react'

const UsernameForm = ({ currentUsernames, setcurrentUsernames }) => {

    const [uniqueUsername, setuniqueUsername] = useState(false);
    const [username, setusername] = useState();

    function checkIfUnique(inputUsername) {
        let taken = false;
        for (let user of currentUsernames) {
            if (inputUsername === user.name) {
                taken = true;
                break;
            }
        }
        setuniqueUsername(!taken);
    }

    function handleSubmit() {
		...
    }

...

```

Here, we have a new function called `checkIfUnique()` which simply loops through our current list of usernames to determine whether the name is already taken. If it finds that the username is not unique, then it sets out `uniqueUsername` state variable to `false`. This same piece of state is then used within the `return` function of the component to change the background colour of the `<input>` to `"red"` if the username isn't unique:


```javascript
// ...

  return (
    <div>
        <form className="newUserForm" onSubmit={handleSubmit}>

        <input type="text" id="usernameField" required
        onChange={(e) => {
            checkIfUnique(e.target.value);
            if (uniqueUsername) {
                setusername(e.target.value)
            }
        }}
        style={uniqueUsername ? {backgroundColor: "white"} : {backgroundColor: "red"}}/>

        <input type="submit" value="Submit" id="submitButton" />

        </form>

    </div>
  )
}

export default UsernameForm
```

Note here that our `onChange()` function has become a little more involved: We have a call to our new `checkIfUnique()` function, followed by the `setusername()` function similar to what we had in our earlier examples. The setState function is wrapped in an `if` statement so that our state is only ever set if the inputted value is valid. From only a few lines of code, we've created a system of providing the user with information about whether their proposed username is unique or not. The form doesn't need to be submitted to get this information and hence we're saving both time for the user and load for our system!



### Input Modulation

Let's now look at how we could add a new user to our `currentUsernames` list. We have a list of users, each with a `username` and `signupDate` for when they signed up. As we said before, it wouldn't make sense for us to have the user input the current date and time themselves, so this is something we're going to handle within our application. Again, it is common that you'll want to modify your data somewhat ahead of inputting it to your database, so let's look at how we can create this object, **ahead of adding it to our `currentUsernames` list**.

```javascript
// ...

function handleSubmit(e) {
    e.preventDefault();
    if (uniqueUsername) {
        let currentDate = new Date().toLocaleDateString();
        let newUser = {username: username, signupDate: currentDate}
        setcurrentUsernames([...currentUsernames, newUser]);
    }
    else {
        window.alert("Please enter a unique username")
    }
}
    
// ...    
```

Everything we're changing here is within the `handleSubmit()` function. We already have a state variable to tell us whether the current username is valid (`uniqueUsername`), so we create our functionality to be conditional on this. By making use of JavaScript's included `Date` object it's easy to find the current date and so creating our object before adding it to our list is easy too!

Because we are placing this functionality within the `handleSubmit()` function, we are therefore inserting it **later in the chain of events than with the validation functionality** above. This functionality activates only on submission of the form and hence really the `if (uniqueUsername)` is a further example of input validation.



## Accessibility

Note that within your `<form>` elements, you should have a `<label>` associated with each non-`type="submit"` `<input>` element.



