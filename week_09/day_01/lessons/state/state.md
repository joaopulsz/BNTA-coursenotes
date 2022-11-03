# Intro to State

### Duration: 45mins

## Learning Objectives

* To be able to use state to hold onto data
* To be able to use `useState` to change state

## Tracking the State of our Application

In the previous lesson we saw how to pass data between React components. However, that data was hard-coded with no way to update it. That's obviously not very practical when building a website, so in this lesson we will demonstrate how to store that data in a way which can be managed by React. This is know as the application's **state** and the way in which it is handled plays a large part in how our application is updated.

Let's add a boolean to indicate whether we are accepting new applications and pass it to the `NewMember` component.

```jsx
// src/MemberContainer.js

const applicationsOpen = true;    // ADDED

return (
    <>
    	<h1>People Directory</h1>
    	<NewMember 
      		handleButtonClick={addNewMember} 
		applicationsOpen={applicationsOpen} />	// ADDED
	<MemberList member={members}/>
    </>
);
```

```jsx 
// NewMember.js

const NewMember = ({handleButtonClick, applicationsOpen}) => {

    return (
        <>
            <p>Applications are currently {applicationsOpen ? "open" : "closed"}</p>
            <button onClick={handleButtonClick}>Register new member</button>
        </>
    )

}

export default NewMember;
```

That works, but our data on the page is very static and not doing very much. If we want to make it more dynamic and change the satus, we will need to introduce state.

One of the most important things to understand about a React app is that as developers we need to understand how the our data is being stored or passed between components. State is our component storing data.

Let's create out first piece of state in `MemberContainer.js`.

To help us manage our state, we are going to use a hook. Hooks are a fairly new feature of React, but caught on in popularity quickly; mainly because they streamline many processes that used to require many lines of code. There are many hooks in React and we will discuss them further later in the week.

We will use a hook called `useState`. `useState` comes from 'react' and so we will need to import it.

```jsx
// MemberContainer.js

import {useState} from 'react';  
```
Remember destructuring? We are going to use this ES6 feature to make use of our hook.

When the `useState` hook is invoked, it returns us an array of 2 elements.

* the first represents the value of our state
* the second is a function to update it

Thanks to destructuring, we can unpack both of these values into variables, which we can then  use throughout our application.

```jsx
// MemberContainer.js

import {useState} from 'react';

const MemberContainer = () => {

    const [applicationsOpen, setApplicationsOpen] = useState(); // MODIFIED
    
    // ...
}

export default MemberContainer;
```
So we are calling our variable with the current state value `applicationsOpen` and the function to update the `applicationsOpen` value is called `setApplicationsOpen`. These variables could be named anything, but it is convention/good practice, to prefix the function name with `set` to make clear what it will be used for:  `[variableName, setVariableName]`.


`useState` can take an argument of an inital value. This could be anything: a string, a number or even an object. Lets set the initial value of greeting to `true`.

```jsx
const [applicationsOpen, setApplicationsOpen] = useState(true); // MODIFIED
```
## Update the State

Let's create a button to update the application status. We want to maintain a separation of concerns as far as possible, so we'll add a new component here for this. We'll move the `<p>` tage displaying the information over here from `NewMember` as well.

```sh title="Terminal"
touch src/components/UpdateStatus.js
```

```jsx title="UpdateStatus.js"
// UpdateStatus.js

const UpdateStatus = ({applicationsOpen}) => {

    return (
        <>
            <p>Applications are currently {applicationsOpen ? "open" : "closed"}</p>
        </>
    )

}

export default UpdateStatus;
```


```jsx title="MemberContainer.js"
// MemberContainer.js
import UpdateStatus from '../components/UpdateStatus';	// ADDED
//...

return (
    <>
      <h1>People Directory</h1>
      <NewMember handleButtonClick={addNewMember}/>    // MODIFIED
      <UpdateStatus applicationsOpen={applicationsOpen} />	// ADDED
      <MemberList members={members} />
    </>
  );

```

First, let's define a function to update `applicationsOpen`. We'll pass this to `UpdateStatus` and hook it up to a button with an `onClick` event listener.

```jsx title="MemberContainer.js"
// MemberContainer.js

const updateApplicationsOpen = () => {		// ADDED
    applicationsOpen = !applicationsOpen;
}

return (
    <>
      <h1>People Directory</h1>
      <NewMember handleButtonClick={addNewMember}/>
      <UpdateStatus 
        applicationsOpen={applicationsOpen} 
        handleClick={updateApplicationsOpen}  // ADDED
      />
      <MemberList members={members} />
    </>
  );
```

```jsx title="UpdateStatus.js"
// UpdateStatus.js

const UpdateStatus = ({applicationsOpen, handleClick}) => {	// MODIFIED

    return (
        <>
            <p>Applications are currently {applicationsOpen ? "open" : "closed"}</p>
            <button onClick={handleClick}>Changed Application Status</button>	// ADDED
        </>
    )

}

export default UpdateStatus;
```

The logic seems sound, but when we test the code in the browser the text doesn't change. In fact we see an error in the console telling us we're trying to reasssign a constant variable.

React is *very* particular about how we update state - we need to use the `setState` function provided when we use the hook. Calling this `setState` function is what triggers a re-render of the page, so even if we weren't getting an error about reassigning a constant the browser wouldn't reload.

```jsx title="MemberContainer.js"
// MemberContainer.js

const updateApplicationsOpen = () => {
    setApplicationsOpen(!applicationsOpen);	// MODIFIED
}

return (
    <>
      <h1>People Directory</h1>
      <NewMember handleButtonClick={addNewMember}/>
      <UpdateStatus 
        applicationsOpen={applicationsOpen} 
        handleClick={updateApplicationsOpen}  
      />
      <MemberList members={members} />
    </>
  );
```

Now the value in the dev tools and on the page updates as we click the button.

## Updating a Complex Data Structure in State

Often we will have data in state which is more complex than a boolean, for example an array of objects loaded from a database. We can refactor our application to store our array of members in state.

```jsx title="app.js"
// App.js

const [members, setMembers] = useState([
    {
      name: "Colin",
      email: "colin@brightnetwork.co.uk",
      employeeNumber: 123
    },
    {
      name: "Anna",
      email: "anna@brightnetwork.co.uk",
      employeeNumber: 234
    },
    {
      name: "Phil",
      email: "phil@brightnetwork.co.uk",
      employeeNumber: 345
    },
    {
      name: "Valeria",
      email: "valeria@brightnetwork.co.uk",
      employeeNumber: 456
    },
  ]);

```

This doesn't affect the functionality of our app, but brings it more in line with how it would work in the real world. 

## Adding a New Member
We are also missing functionality to add a new member. In the next lesson we'll see how to gather user input from a form, but for now we'll add a pre-defined object into our `members` array. With `applicationsOpen` we ran into an error when we tried to reassign a constant variable, but we know that mutating an array doesn't fall under that umbrella.

```jsx title="MemberContainer.js"
// MemberContainer.js

const addNewMember = () => {
	console.log("new member added");
	const newMember = {		// ADDED
		name: "Joe",
		email: "joe@brightnetwork.co.uk",
		employeeNumber: 567
	}
	
	members.push(newMember)
}
```

Our application doesn't update, however we still see the message being logged. As before we need to use the `setMembers` function to trigger the rerender.

```jsx title="MemberContainer.js"
// MemberContainer.js

const addNewMember = () => {
	console.log("new member added");
	const newMember = {
		name: "Joe",
		email: "joe@brightnetwork.co.uk",
		employeeNumber: 567
	}
	
	members.push(newMember);
	setMembers(members);
}
```

This still doesn't work - but why not? Recall that when we store an array or an object in a variable we don't store the values, we store the reference to the object's memory location. When we call `setMembers(members)` we are trying to update the variable with the value it already holds. 

React is wise to this and won't trigger the re-render in this case, since as far as it can tell nothing has changed. We need to show it that we are passing in a different array, which we can do by using the spread operator to make a copy of the array, then update and pass that to the setter.

```jsx title="MemberContainer.js"
// MemberContainer.js

const addNewMember = () => {
	console.log("new member added");
	const newMember = {
		name: "Joe",
		email: "joe@brightnetwork.co.uk",
		employeeNumber: 567
	}
	
	const updatedMembers = [...members, newMember];	  // MODIFIED
  	setMembers(updatedMembers); 	// MODIFIED
}
```

Now the page re-renders when we click the button.

As a final "nice to have" we can incorporate both pieces of state into the function, preventing the new member being added without applications being open.

```jsx title="MemberContainer.js"
// MemberContainer.js

const addNewMember = () => {
	console.log("new member added");
	const newMember = {
		name: "Joe",
		email: "joe@brightnetwork.co.uk",
		employeeNumber: 567
	}
	
	const updatedMembers = [...members, newMember];
  	
  	if (applicationsOpen) {		// MODIFIED
      setMembers(updatedMembers);
   }
}
```
