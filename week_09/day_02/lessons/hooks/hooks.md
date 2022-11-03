# Hooks

We've made a lot of progress over the last few topics, forming the foundation from which we can now build. Thus far, we have covered the basics of React and we've started to make some exciting developments, however there is still great scope for additional learning. Our next topic is **React Hooks** which involves bringing together many of the subjects introduced in previous chapters. For the sake of clarity later in the document, we'll reintroduce those topics now.

## A Brief Recap

### Containers

The past few chapters have only made use of **components** which strictly house structural information. **Containers** are a type of component that house any logic for a section of your webpage which isn't specifically defining the form of some element(s). Containers hence handle the storing of **state** within your application alongside their associated functionality.

- **Containers** are components which hold application state and define the functions used to update it. Any complex logic should be handled by a container.
- **Components** are purely presentational. They accept props and define the HTML to render it. Any logic in a component should be limited to what is necessary for rendering, eg. mapping an array to further components.

### State

State is the term used to describe the **configuration of our application**. The "state" of your application may actually be an amalgamation of many different "states", all defined using separate declarations of the `useState` hook (introduced below). Each piece of state holds one piece of information, such as a boolean defining whether the application is in Dark Mode, or the returned object from an API.

## File Organisation

As you build out an app, especially once you start abstracting out functionality and creating many components, you may find that you need to reorganise your project's file structure to be a bit neater. There are a few common practices for how folk organise their React projects:

1. Create a folder for each component which houses a separate `component` (as needed), `container` and CSS file for each distinct region of your site
2. Create a `components` and `containers` folder which houses all of each
3. Collect together each region of your site into folders named after the relevant page (*e.g.* "Home_Page" or "About_Page")

We would recommend that you use the first method here as while it does mean you will have a lot of folders, it means also that each file, or selection of files, are organised to the greatest extent.

## A High-Level View of Hooks

React's un-opinionated nature is great for developers when it comes to designing an app. As we've seen already we can mix and match the different styles of writing components but with the tools at our disposal currently we have some limitations. If a component is purely presentational we can use either a functional or class-based approach as both can receive props and render JSX, but as soon as we need to make use of state we are limited to class components. That's because we need a **constructor function** in which to initialise the state object, which we don't have with a functional component.

Recent versions of React have begun to implement features which make it possible to create stateful functional components, however. **Hooks** are functions which form a core part of the React library and enable us to handle state, lifecycle and other features outside of the structure of a class. By using hooks in our applications we can build them entirely with functional components, leading to more streamlined and consistent code.

### A History Lesson

Historically, React components were all class-based. This makes them akin to much of the application classes you have already seen in the initial Java teaching, with a selection of bespoke functions, some initialisation steps and the `this` keyword. Each React class component starts with a `constructor()` and `render()` method, the former largely defining any initial state variables and the latter, that which is passed up the application to construct the DOM. In fact, if a component didn't make use of any state variables or `bind()` methods (`bind()` allows you to specify what the `this` keyword refers to), then it wouldn't need a `constructor()` method at all, leaving only a `render()` function.

Before outlining why React slowly moved away from class-based components, towards functional components, let's compare how the same component may look from each of the two approaches:

**Functional**

```jsx
const Functional = (props) => {

    const x = 2;
    const ourString = props.ourString;

    function addToX(y) {
        return (x + y)
    }

    return (
        <div>
            <h1>FUNCTIONAL</h1>
            <p>variable x: {x}</p>
            <p>{addToX(4)}</p>
            <p>{ourString}</p>
        </div>
    )
}

export default Functional;
```

**Class-Based**

```jsx
import React, { Component } from 'react'

export default class ExampleClass extends Component {

    constructor(props) {
        super();
        this.x = 2;
        this.ourString = props.ourString;
    }

    addToX(y) {return this.x + y}

    render() {

        return (
            <div>
                <h1>CLASS</h1>
                <p>variable x: {this.x}</p>
                <p>{this.addToX(4)}</p>
                <p>{this.ourString}</p>
            </div>
        )
    }
}
```
As you can see from the examples above, both approaches to creating React components are fairly similar. Note however that there are greater differences between the two than can be exemplified in such a simple example, especially once you start considering React's Lifecycle Hooks.

### Lifecycle Hooks

The reason behind the shift from class-based to functional components largely relates to a topic we've already touched on within the last few chapters: developer experience. The tangled mess of a large, class-based React application is difficult to get across without writing out many blocks of code so we'll introduce it graphically instead. The main point worth recognising here is that class-based components hold a selection of **Lifecycle Hooks**. These hooks were used to define different functionality under different circumstances, such as when the component initially loads (*"mounts"*) or is removed from the DOM (*"unmounts"*). The three main lifecycle hooks are outlined below:

- **ComponentDidMount**
	- Initialisation functionality for a component. Setting up the framework for the component. Initial state set here.
- **ComponentDidUpdate**
	- Functionality which runs when some part of the component changes. State-updating functions here.
- **ComponentWillUnmount**
	- Cleanup functions housed here. Stopping any continually-running events, clearing set variables as needed.

![Lifecycle hooks explanation](../../../assets/react/hooks/lifecycleHooks.png)

In the above image, related functions share background colour and numbering. Note how each distinct "Effect" is split over each of the lifecycle hooks. Also, some effects, such as Effect 1 and Effect 4, don't have any "Update" functionality. You can take this to mean that the effect runs once on-load of the component, and hence that it is not affected by any changing information elsewhere—unless that change requires the whole component to be re-rendered. A full re-render would again trigger the "Did Mount" functionality.

### Collected Code

From the previous diagram, it's pretty easy to envision why this approach begins to lead to issues with maintainability. Related code is not collected together and thus, it is difficult to follow through the logic of the program, especially when you are viewing a large component for the first time. So what if there was a means to collecting together this code? Logical organisation of our logical operators would significantly boost the developer experience, and as we stated earlier, this is what React aims to champion. Functional components and the introduction of two new hooks, `useState` and `useEffect`, is React's answer to our question.

We will delve into the `useEffect` hook more towards the end of this chapter, but for now, all you need to know is that a `useEffect` hook houses some functionality which runs under certain circumstances, such as the component loading or a specified state variable being updated.

![Lifecycle Hooks Example with code collected by colour](../../../assets/react/hooks/colourCollected.png)

Already, this is easier to parse. The different stages of our functions are still kept separate (parts A through C of each Effect), but they are all defined within one block and so it is far easier to follow through the entire **lifecycle** of each effect. This greater level of organisation, alongside the deprecation of the `this` keyword, are largely what defines the boost in developer experience with the movement toward functional components. One last point to make here is that most functionality previously defined across the `componentDidMount` and `componentDidUpdate` lifecycle hooks, can now be collected together and hence we can further tidy our code:

![Lifecycle Hooks Example with code collected by colour and tidied](../../../assets/react/hooks/codeCollected.png)


### How it has changed

Confusingly, React's feature which followed on from class-based *lifecycle hooks* was functional component *hooks*. The word **hook** is used to specify a piece of functionality which allows you to "hook into" underlying React features. As people began to make greater use of functional components, many programs became a mix of class-based and functional components, owning to functional components' inability to declare and manage state variables. This changed with the introduction of the `useState` hook. You should recognise that these functional hooks were only introduced in early 2019 and hence it is possible that you will encounter class-based react applications when joining other tech teams throughout your career.

There were a selection of other hooks introduced within the same update as the `useState` hook, such as `useMemo` and `useContent` however within this course we will only be covering one other: the `useEffect` hook. 



## The `useState` Hook

We have a functional component. We want some state. But functional components don't have a constructor to initialise any state variables. This is where the `useState` hook comes in. This hook will provide two things for us: firstly, a variable within which we can store a piece of state, and secondly, a function which we can use to update it. Each piece of state within a functional component is held it its own variable and has to be updated individually. This is at odd to class-based React which held all state for each component within a single object. You are hence managing a number of distinct variables and update methods, instead of a few properties of a single object. This sounds like a more expensive operation, but thanks to the virtual DOM the impact is minimised.

`useState` takes an argument to denote the initial value for the state and returns an array with the variable as its first value and the function as its second, which we can destructure into separate variables for easier use. Note that to make use of the `useState` hook, that we need to import it at the top of our JavaScript file.

`import { useState } from "react";`

`const [stateName, setStateName] = useState("value");`

### Booleans, Strings and Numbers

As introduced earlier, the overall "configuration" or **state** of our application is often actually a combination of many smaller state variables. These variables can be assigned any value. Often, our initial value is either a boolean value (if the variable is to manage some boolean state), `0` (when *e.g.* initialising some form of counter) or `null`. Each of these examples are shown below:

```jsx
import { useState } from "react";

const ComponentName = () => {

	const [toggle, setToggle] = useState(false);
	const [counter, setCounter] = useState(0);
	const [promise, setPromise] = useState(null);

	return ()
	
}
```

You can also initialise your state as either an array or an object, which you can later add to:

```jsx
import { useState } from "react";

const ComponentName = () => {

	const [array, setArray] = useState([]);
	const [object, setObject] = useState({});

	return ()
	
}
```

### Updating State

**Setting a new value** to our state variable as is easy as passing a value to the relevant `set—` function as its argument. Let's make a simple component which simply returns a `<p>` element displaying our current `counter` state value, and a `<button>` for adding incrementing that value:

```jsx
import { useState } from 'react';

const Counter = () => {

    const [counter, setCounter] = useState(0);

    return (
        <>
            <p>Our counter: {counter}</p> 
            <button onClick={() => setCounter(counter + 1)}>Plus 1</button>
        </>
    )
}

export default Counter
```

By modifying the example above, and because state variables are JavaScript objects in their own right, it is incredibly easy to create a **toggle button** in React:

```jsx
import { useState } from 'react';

const Toggle = () => {

    const [toggle, setToggle] = useState(true);

    return (
        <>
            <p>Current Toggle State: {String(toggle)}</p> 
            <button onClick={() => setToggle(!toggle)}>Toggle!</button>
        </>
    )
}

export default Toggle
```

Here, we are making use of the logical NOT operator `!`.

### Separation of Logic and Presentation

So far in this chapter we have collected together all our code within one file. There is no separation of logic from our presentational information which is at odds to the structure of containers and components proposed earlier. At this point, when we have created only a simple section of our webpage, separating this code may seem needless. Note however that when our application grows, this is as a function of the JSX and logic growing so in the interest of **maintainability**, we separate our code.

This **container** file houses the **logic**:

```jsx
// ToggleContainer.js

import { useState } from 'react'
import ToggleComponent from './ToggleComponent';

const ToggleContainer = () => {

    const [toggle, setToggle] = useState(true);

    return (
        <ToggleComponent toggle={toggle} setToggle={setToggle} />
    )
}

export default ToggleContainer
```

This **component** file houses the **structural information**:

```jsx
// ToggleComponent.js

import React from 'react'

const ToggleComponent = ({toggle, setToggle}) => {
  return (
    
    <>
        <p>Current Toggle State: {String(toggle)}</p> 
        <button onClick={() => setToggle(!toggle)}>Toggle!</button>
    </>
  )
}

export default ToggleComponent
```

Note how this example makes use of destructured prop arguments at the top of the component file. 



## The `useEffect` Hook

Harking back to the the lifecycle hooks from earlier, the basis of our `useEffect` understanding comes from `componentDidMount` and `componentDidUpdate`—it is the combination of functionality relating to the **loading** and **updating** of our component. 

The `useEffect` hook is as easy to implement as the `useState` hook. First, we need to import it at the top of the document, then we declare a new `useEffect` with two arguments. As with all functionality housed within our components, the `useEffect` is positioned *within* the component itself but before the final `return` statement where we house our JSX. The first argument within our hook is a callback function which houses our functionality, and the second is an array known as the **dependancy array**. This array contains the *inputs* of our function which in turn specifies *when* an effect is to re-run—as it watches each input for changes. When any of the variables in the array are updated, the callback is called. The general form of a `useEffect` is as follows:

```jsx
useEffect(() => {

        // effect
        
        return () => {
            // cleanup
        }
        
    }, [inputs])
```

The callback can be defined as an anonymous function as we have done here or it can be defined elsewhere and passed in. The callback will always be called at least once after the component loads, even if we don't specify any variables to track. Note that if we don't provide a second argument to our `useEffect`, that the callback will fire after *every* state change in our application, leading to potential infinite loops if the function is updating some state itself. If we provide an empty array, however, the callback fires after the initial render but then not again until the next full render of the component.

### Cleanup

Within the `return` statement of our effect, you will notice that we have a section dedicated to **cleanup** of our function. This functionality runs after each time our effect executes and gives us the **chance to clean up our code**. This helps us suppress any unintended behaviours which could impact our applications' performance. A good example of said unintended behaviour is when you add an EventListener to a component. This listener will continue to run, regardless of whether the component is still present on the webpage, unless cleared. If you don't clear these listeners then it's possible to get to the point where you have tens or hundreds of functions attempting to run *e.g.* on-scroll of the page—which can significantly impact site performance. Further, if these functions refer to any HTML elements that are no longer present on the page then each could be dispatching multiple errors. The cleanup function is great because it allows us to *e.g.* clear these extra listeners.

### Secondary Effects

Perhaps the most straightforward way of thinking about a `useEffect` hook is to consider it as a **side effect** to a different change within your app. Specifically, it is a side effect of a change to one of the inputs placed within the dependancy array. That said, you can also declare a `useEffect` with an empty dependancy array as mentioned earlier. In this case, the `useEffect` will run on each re-render of the component. This is the simplest form of a `useEffect` hook and is effectively defining a side effect to our component loading, hence replicating the `componentDidMount()` method from class-based components. Functions which are housed within the component and are not dependant on any inputs, such as general API calls or initialisation steps, can be declared in this fashion. We'll explore how we can include an API call this way a little later.

### Toggle Count Example

Let's expand our `Toggle` component from earlier to include a simple `useEffect` which counts how many times the `toggle` state has been changed. We are introducing a **secondary effect** to our `toggle` **state changing**. We'll keep this as a single block of code for easier visualisation of the entire component. We would ideally, have this code block split into *component* and *container* as we had above.

```jsx
const Toggle = () => {

    const [toggle, setToggle] = useState(true);
    const [count, setCount] = useState(-1);

    useEffect(() => {

        setCount(count => count+1)

        return
        
    }, [toggle])

    return (
        <>
            <p>Current Toggle State: {String(toggle)}</p> 
            
            <button onClick={() => setToggle(!toggle)}>Toggle!</button>
            
            <p>Times Clicked: {count}</p>
        </>
    )
}

export default Toggle
```

There are a couple things of note here. The first is that the initial value of our `count` state is set as `-1`. Each `useEffect` within a component will **run once on load** and hence our `setCount(count => count+1)` line is going to run once on page load, before then running again on every update of the `toggle` state. This functionality is often behind a lot of bugs you may face as a new React developer, as it can incite race conditions when you begin drawing relationships between many components. This is especially true when these components contain calls to external resources, where your loading process is hence no longer strictly following through your code (unless you tell your code to only run synchronously).

### Be wary of `useEffect`-state loops!

The other thing of note here within our example above is that within our `setCount()` function, we've had to create an arrow function, rather than just specifying `count + 1`. But why? 

This requirement relates to our **dependancy array**. 

Remember how we said this array contains all the inputs of our functionality? Well, if we were to just have `count + 1` within our simple increment function, then React would notify us to say that we have a missing dependancy for our `useEffect` called `count`, as it recognises it as a key part of our functionality. Your app may run, but you are going to consistently get a warning message in the console.

It may seem like a fix to this warning would be to simply add `count` to our dependancy array. However, once you do this, you've created an infinite loop as defined below:

1. The `useEffect` re-renders on each change of `toggle` or `count`
2. The `useEffect` itself updates `count`
3. Return to Step 1.

By placing the reference to the variable **within** an arrow function, and hence a nested function, we tell  our `useEffect` that it needn't worry about re-running when `count` changes—as the `useEffect` now contains reference to our anonymous function, rather than the state `count`.

### Colour-Picker Example

Our `toggle` counter example above isn't the most exciting and it has one pretty major flaw: you wouldn't do it this way. If you were wanting to count how many times a button had been clicked, it would be far easier to create a separate function which changes both the `toggle` and `count` states when invoked on-click. In fact, we could achieve this by including both of our initial on-click functions, from the `useState` section above, under one named function.

Below, we have a different example which is a bit more involved. Again, there are other ways which you could approach this functionality, some of which wouldn't require the use of a `useEffect` hook, however this example is far closer to what you could expect to see within a React application than the first.

![Three input elements, red, green, blue with percentage values and a banner below of the combined colour in RGB](../../../assets/react/hooks/RGB_sliders.png)

As with when we introduced **containers** and **components** earlier, we'll break our following code into two sections; one for structural information and the other for logic.

**Logic - Container**

```
import { useState, useEffect } from 'react'
import ColourPickerComponent from './ColourPickerComponent';

const ColourPickerContainer = () => {

    const [red, setRed] = useState(50);
    const [green, setGreen] = useState(50);
    const [blue, setBlue] = useState(50);

    const [RGB, setRGB] = useState(0);

    useEffect(() => {
        // turns our 0-100 values to 0-255
        let red255 = Math.ceil(red*2.55);
        let green255 = Math.ceil(green*2.55);
        let blue255 = Math.ceil(blue*2.55);
        
        // creates a string value from the other values above
        setRGB(`rgb(${red255}, ${green255}, ${blue255})`)

        return

    }, [red, green, blue])

    return (
        <ColourPickerComponent 
            red={red}
            setRed={setRed}
            green={green}
            setGreen={setGreen}
            blue={blue}
            setBlue={setBlue}
            RGB={RGB}
        />
    )
}

export default ColourPickerContainer;
```

We have 4 different state variables here called `red`, `green`, `blue` and `RGB`. The first three hold a value between 0 and 100 which are set on-change of our `input` sliders shown in the initial image above. The final `RGB` state is a string which is set by our `useEffect` function. This string is passed down to our component and is used to define the content of a `h1` element and its `background-color` CSS property (using an in-line `style` attribute).

The `useEffect` functionality runs whenever the `red`, `green` or `blue` states are updated, hence whenever any of our `input` slider elements are interacted with.

**Structural - Component**

```jsx
const ColourPickerComponent = (props) => {

    return (
        <>
            <label htmlFor="red">Red</label>
            <input type="range" id="red" onInput={(e) => props.setRed(e.target.value)}></input>
            <p>Red: {props.red}%</p>

            <label htmlFor="green">Green</label>
            <input type="range" id="green" onInput={(e) => props.setGreen(e.target.value)}></input>
            <p>Green: {props.green}%</p>

            <label htmlFor="blue">Blue</label>
            <input type="range" id="blue" onInput={(e) => props.setBlue(e.target.value)}></input>
            <p>Blue: {props.blue}%</p>

            <h1 style={{"backgroundColor": props.RGB}}>{props.RGB}</h1>
        </>
    )
}

export default ColourPickerComponent;
```

The reason behind why this is a good example of when to use a `useEffect` hook is partly due to the maths we have housed within the hook itself, which turns our 0-100 values to 0-255 values. Because a value between 0 and 255 is fairly arbitrary outwith part of an `rgb` value, it doesn't make sense for us to create state variables for *e.g.* `red255` in addition to our `red` state variable. With the variables housed within the `useEffect` itself, we ensure that we have minimised our number of state variables and have also kept our variables as close as possible to the functionality they are involved in.

### Chaining Effects

As you may expect, it is possible to chain `useEffect` hooks if your application calls for it. By creating a secondary effect to another side-effect, we effectively create a tertiary effect to our first change. This chaining can occur between props and hence across your whole application. This power, however, comes at the cost of greater complexity and so if you are looking to affect a great change across your site based off of a single change, consider what you are doing and whether it can be created through different means (such as by moving the relevant state variable higher up in your react application).

