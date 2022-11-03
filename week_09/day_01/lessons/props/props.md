# Props

#### Lesson duration: 90mins

So far we have been keeping all parts of our application entirely separate. We have created a nested structure and therefore *some* level of communication between our components but really all this amounts to is correct positioning within the DOM tree. And really we want more than that. We want to share not only *structural* information regarding placement wthin our page but attributes and data, and *functional* information on top of that. Say you had two components within one parent and they were both to use the same, single piece of information. Currently, we have no means of achieving this but this is where props come in. Sharing properties, or **passing props** is the key to making your application lean and interconnected. 


## What is a Prop and How Do I Use it?

We'll generally use the term *"props"*, which is short for *"properties"* They are effectively the **arguments to our functional components**. Defined at the level where the component is called and then utilised within the component itself, props take many different forms. Whether it be a function, an object, or a value, props are all passed between components in the same manner. Note that for all of the following examples, the `Child` component would be required to be imported to the parent file as we have seen in previous cahpters.

**Parent File**

```jsx
const Parent = () => {

	const number = 5;

    return (
        <div>
            <Child ourNumber={number} />
        </div>
    )
}
```

**Child Component**

```jsx
const Child = (props) => {

	return (
		<p>{props.ourNumber}</p>
	)
}
```

What's most important to recognise here is the declaration of "props" within the arrow function of the `Child` component. Like a plug and a socket, you need to provide your program with *both* sides of the connection. 

Props are passed as a single object where the keys are defined when we use the component. In our example above the key is `ourNumber` and it's value is set to `number`. We can access the value in teh child component using the `props.key` syntax, however when passing multiple props this can get difficult to keep track of. Instead we will generally destructure the `props` object and refer to them using the key only.

**Parent File**

```jsx
const Parent = () => {

	const number = 5;
	const string = "Hello!";

    return (
        <div>
            <Child ourNumber={number} ourString={string} />
        </div>
    )
}
```

**Child Component**

```jsx
const Child = ({ourNumber, ourString}) => {

	return (
		<>
			<p>{ourValue}</p>
			<p>{ourString}</p>
		</>
	)
}
```

## Props in Practice

Let's build an application which will list some users who have registered for a given service. It is helpful, when making a React app, to begin by looking at a wireframe and breaking it down into possible components.

![people directory wireframe](../../../assets/react/props/people_directory_wireframe.png)

Now we have a sense of how our application could be structured, we'll start by creating a new project using `create-react-app`

```sh title="Terminal"
npx create-react-app people_directory
cd people_directory
npm start
```

Once our project has been created we need to clear out the boilerplate so that our `App.js` component is left with only a heading with our application's title.

```jsx title="App.js"
const App = () => {
  return (
    <>
    </>
  );
}

export default App;
```


## Component vs Container

We have already been introduced to the idea of a components file. Let's consider another type of component and add how we might structure our files.

Alongside structural information, we can also house different functionality within our components. For components, this logic defines **structural information** only, such as how an input is mapped out into a list of `<li>` elements. 

Within this course, there is another type of file which we will be making use of called **containers**. Note that both "components" and "containers" are not official React terms. You may find later on that drawing a distinction between the two leads to a better, more maintanable application. While components hold structural logic, container files hold all of the state information for our app, alongside any other bespoke functionality. 

In summary:
- **Containers** are components which hold application state and define the functions used to update it. Any complex logic should be handled by a container.
- **Components** are purely presentational. They accept props and define the HTML to render it. Any logic in a component should be limited to what is necessary for rendering, eg. mapping an array to further components.


## MemberContainer

We need some data to represent our members. In a real-world application this would likely be loaded from a database, but we don't quite have all the tools in place to facilitate this yet. In view of the information above, it would make sense if this data lived in a container. Let's create a couple of folders for the components that will make up our application. We can also start by creating the component that will be our `MemberContainer.js`.

```sh
# Terminal

mkdir src/components
mkdir src/containers
touch src/containers/MemberContainer.js
```

Create a functional component, remembering to `export default`, and adding our array of members (remember, this is just some data to represent our members).


```jsx
// MemberContainer.js

const MemberContainer = () => {

	const members = [
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
	]
	
	return (
		
		<p>hello from MemberContainer<p>
	
	);
}

export default MemberContainer;

```

It would be a good idea at this stage to display some information on the page to ensure our set up is working as expected. Let's make `App.js` render our `MemberContainer` component.

```jsx title="App.js"
// App.js

import MemberContainer from './containers/MemberContainer'; // ADDED

const App = () => {
  return (
    <MemberContainer /> // ADDED
  );
}

export default App;
```
We should now see `Hello from MemberContainer` displayed in our browser.


## MemberList

Displaying the information of all our members will require a lot of repeated code, plus we need to account for the possibility of more being added later. That makes them prime candidates for being represented using components, saving us potentially lots of work! 

Remember the wireframe we discussed earlier - we have three components. We have just created `MemberContainer` (to hold our data) and we can now make the other two components: `Member` (whose purpose will be to receive data and render it to the screen) and `MemberList` (whose purpose will be to receive data from `MemberContainer` and render a collection of `Member` components). 

```sh title="Terminal"
touch src/components/Member.js
touch src/components/MemberList.js
```
Firstly, we can deal with `MemberList`. This component isn't storing state (more on this later, but in this case we are referring to our array of `members`), we just want to receive some data from the `MemberContainer` and render a collection of `Member` components.

We'll keep it simple to begin with and have our component display some text confirming that it's a `MemberList` component.

```jsx title="MemberList.js"
// MemberList.js

const MemberList = () => {

    return(
        <p>This is a MemberList!</p>
    )

}

export default MemberList;
```

We should continue our best practise of checking to what is displayed on our page by making `MemberContainer` render `MemberList`. We can also add a title for our page.

```jsx
// MemberContainer.js

import MemberList from '../components/MemberList';  // ADDED

const MemberContainer = () => {

	const members = [
		{...},
		{...},
		{...},
		{...}
	]
	
	return (
		<>
		    <h1>People Directory<h1>   // MODIFIED
		    <MemberList />   //ADDED
		</>
	);
}

export default MemberContainer;
```

## Member
Last on our list is the `Member` component. We have already created the file, now we can add some code to it.

```jsx
// Member.js

const Member = () => {
	
	return (
		<>
		    <p>Greetings from Member!</p>   // ADDED
		</>
	);
}

export default Member;
```
Again we should make `MemberList` render a `Member` component (or two!) to check everything is working.

```jsx title="MemberList.js"
// MemberList.js
import Member from './Member';   // ADDED

const MemberList = () => {

    return(
        <>
            <Member />
	    <Member />
	</>
	
    )

}

export default MemberList;
```

## Passing Down Props
Remember that the direction of travel for props is down. We can now use this ability to pass data down through our components to display the people in our people directory. You will need to recall your lesson on destructuring in Javascript for this section.

Firstly, we want `MemberContainer` to pass our list of `members` as a prop to our `MemberList` component. We can do this by naming our prop and assigning it a value within the `MemberList` tag. It can be helpful to name your prop the same thing as your data.

```jsx
// MemberContainer.js

import MemberList from '../components/MemberList';

const MemberContainer = () => {

	const members = [
		{...},
		{...},
		{...},
		{...}
	]
	
	return (
		<>
		    <h1>People Directory<h1>   
		    <MemberList members={members} />   // MODIFIED
		</>
	);
}
export default MemberContainer;
```

Now that we have access to `members` in MemberList, we can generate a component for each item in our `members` array by mapping them then adding the resulting array to the JSX. We need to get the information for each member in to the corresponding `Member` component, which we can do using props.

```jsx title="MemberList.js"
// MemberList.js

import Member from './Member';   

const MemberList = ({members}) => { 	// MODIFIED

    const memberComponents = members.map((member, index) => {	// ADDED
    	return <Member
		   key={index}
		   member={member} />		   
    }

    return(
        <>
            {memberComponents}	// MODIFIED
	</>	
    );
}

export default MemberList;
```

The `Member` component now has access to the object and can do whatever it needs to with the information. We can access it by destructuring and using dot notation.

```jsx title="App.js"
// Member.js

const Member = ({member}) => {

    return(
        <div className="person-card">
            <h3>{member.name}</h3>
            <p>{member.email}</p>
            <p>{member.employeeNumber}</p>
            <hr/>
        </div>
    )

}

export default Member;
```

## The `key` prop

Checking the browser console will show a warning teling us that "each child in a list should have a unique key". React's efficiency comes from knowing exactly what needs to be updated at any given time, meaning it needs to be able to identify specific components. With hard-coded components this is handled internally, but when we add dynamic content we need to address this.

When we map our members into components we do it in such a way that we generate as many components as necessary. React doesn't know how many we'll have until run time. As we'll see later in this course, it's likely that the application will already be running before the data is even requested. 

The `key` prop is an important tool for us to help React out and give each component we generate during the mapping a unique identifier. There are no rules around *what* we use as a key, so long as it is unique. In this example we will use each member's position in the array.

```jsx title="App.js"
// MemberList.js

const memberComponents = members.map((member, index) => {
    return <Member member={member} key={index}/>
})
```

We will never access the `key` prop ourselves, it is only for React's use. Since the index of a given member could theoretically change we would usually try to find something more permanent, such as a database ID associated with the object..

## Passing Functions As Props

Recall that functions are first-order objects in JavaScript, so we can treat them in the same way as any other object. That includes passing them between React components using props!

Ultimately our app will have functionality to add a new member. For now we'll add a new component to handle this functionality and give it a simple button to click.

```sh title="Terminal"
touch src/components/NewMember.js
```

```jsx title="NewMember.js"
// NewMember.js

const NewMember = () => {

    return (
        <button>Register new member</button>
    )

}

export default NewMember;
```

Ultimately this component will update our list of members, so the function needs to be defined somewhere it can access the array. That means keeping it in `MemberContainer.js`. We also need `MemberContainer` to render our `NewMember` component.

```jsx title="MemberContainer.js"
// MemberContainer.js
import NewMember from '../components/NewMember';     // ADDED

// ...

const addNewMember = () => {		// ADDED
	console.log("new member added!");
}

return (
	<>
	    <h1>People Directory</>
	    <NewMember />	// ADDED
	    <MemberList members={members} />
	    
	);
}

```

We pass the function as a prop to `NewMember.js` in the same way as we would pass any other value.

```jsx title="MemberContainer.js"
// MemberContainer.js

//...

return (
    <>
    	<h1>People Directory</h1>
    	<NewMember handleButtonClick={addNewMember}/>	// MODIFIED
	<MemberList members={members} />
    </>
 );
```

We destructure the props and set the `button`'s `onClick` listener to the function passed down.

```jsx title="NewMember.js"
const NewMember = ({handleButtonClick}) => {

    return (
        <button onClick={handleButtonClick}>Register new member</button>
    )

}

export default NewMember;
```

Clicking the button now calls the function defined in the parent component and prints the message to the console. By passing functionality in this way we can, if we need to, pass data from a component into a function defined in the component's parent. This preserves the one-directional data flow of React.
