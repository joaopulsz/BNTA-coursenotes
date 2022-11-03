# React Hooks II

Before we round off the React chapters, there is another use-case of the `useEffect` hook which we want to introduce. The below pattern relates to how we can use a `useEffect` hook to make an API call, which then sets (part of) the gained response to a state variable.



## API Call Use-Case

As with any JavaScript application, loading data into a React app isn't quite as straight-forward as it sounds. Regardless of where we're loading the data from, it will take time which means we can't make use of the response straight away. We also need to make sure that our app is ready to receive that data. Instead of delving into the processes of `async` and `await`, we can use the `useEffect` hook to manage both of these problems by letting us decide exactly **when** to load the data.

In the previous chapter we saw some examples of how to use the `useEffect` and `useState` hooks. The following code introduces nothing new, it simply makes use of these same examples in addition to a `fetch` request. We have a state variable `dog` who's initial value is `null` and then a `useEffect` which houses our `fetch` request. The API we are using returns a random URL of an image of a dog.

Note that the dependency array is empty and hence this functionality runs after every time the component loads.

Our container houses all the logic, which in turn passes the state information to the component.

```jsx
// DogContainer.js

import { useState, useEffect } from "react";

const DogContainer = () => {

    const [dog, setDog] = useState(null);
    
    useEffect(() => {
 		fetch("https://dog.ceo/api/breeds/image/random")
        .then(response => response.json())
        .then(response => setDog(response.message))
    }, []);

    return (
		<DogComponent dog={dog} />
    )

}

export default DogContainer;

```
The component houses the structural information. Here, this is simply an `img` who's `src` attribute is defined by the `dog` state above.

```jsx
// DogComponent.js

const DogComponent = (props) => {
  return (
    <img src={props.dog} alt="Randomly selected dog"/>
  )
}

export default DogComponent
```



### Conditional Rendering

This code block works okay for this example as the `<img>` is fine having it's `src` attribute equal to `null` in the interim before the result from the `fetch()` request is received. This does mean though, that for a brief moment, dependant on the internet speed of the user, a broken image is displayed. Without strategically assigning empty space using CSS, it is hence likely that our page will suddenly change length on load of the image.

There is, however, a more significant problem with our component than a brief broken image icon. Say we wanted to save the entirity of the API response to our state variable, rather than just the `message`. We can do this easily by simply changing the last line of our `fetch()` request to pass the entire `response` to our `setDog` function. But then when we next change the `src` attribute in our component file to instead make use of `props.dog.message`, we run into an issue:

![](../../../assets/react/hooks_api/dog_message_null_error.png)

**"Cannot read properties of null (reading 'message')"** - What's this?

Remember: fetch requests take time to return their response.

When our container code loads, every line including the return function within the then-nested component file is run significantly before our API response is recieved. So what's happening here, is that our `dog` state has a default value of `null` from which the `message` property is trying to be read. This value is only going to be returned on the front-end for a brief moment, however because we are attempting to access a value which does not exist, we have created an application-blocking error. 

Ignoring the jarring extension of our page on image load (as this can be solved by using CSS), and instead on this more significant error, we can introduce some **conditional rendering** to solve our issue. For large loads, such as objects gained from APIs or a selection of many, high-quality images, it is common practise to add in a component which tells the user that we are still waiting on some information, rather than displaying a section which seems to be broken. 

This **conditional** piece of information also allows us to introduce a gate which ensures our application isn't, for instance, looking to grab the `message` property of a `null` value, hence ensuring again our application failing.

The way we introduce some conditional rendering is as simple as adding in some logic to our JSX. Most commonly, this logic is a ternary operator conditional to a state variable:

```jsx
// DogContainer.js

const DogContainer = () => {

    // ...

    return (
    	dog ?
   		<DogComponent dog={dog} />
   		:
   		<p>Loading dog picture...</p>
    )

}
```

Since we've broken up this example code onto a few lines here which might look odd, as a refresher, please see the general form of a ternary operator below:

`condition ? exprIfTrue : exprIfFalse`

Instead of simply asking React to render our component we are adding in some sort of **condition** to our code which must be satisfied first. Putting it into words, our `DogContainer` is returning a paragraph element if the `dog` state doesn't have a value (is `null`), and the `DogComponent` if it does.




## Passing Functions

Before we wrap up the React notes, we're going to look at one last example which takes our previous dog image component one step further. Let's see how we could add some user input for requesting another dog image from the same API. We *could* add the functionality to an existing component, but that would mean *every* instance of that component would have the functionality associated with it, which we may not want. For instance, we may want this component to be interactable on an "About" page but not on the "Home" page of a site. So instead, let's create `NewDogButton` as a separate component of our site.

```sh
touch src/components/NewDogButton.js
```

```jsx
// NewDogButton.js

const NewDogButton = () => {

    return (
        <button>Fetch!</button>
    )

}

export default NewDogButton;
```

```jsx
// DogContainer.js

import NewDogButton from "../components/NewDogButton";

const DogContainer = () => {

    // ...

    return (
    	dog ?
    	<>
   			<DogComponent dog={dog} />
   			<NewDogButton />
   		</>
   		:
   		<p>Loading dog picture...</p>
    )

}
```

Above we have defined the structural information needed for our `NewDogButton` but we still need to define the behaviour we want for when the button is clicked. For now we'll simply log something to the console to confirm that the event is being picked up correctly.

```jsx
// NewDogButton.js

const NewDogButton = () => {

    const handleClick = () => {
        console.log("button clicked");
    }

    return (
        <button onClick={handleClick}>Fetch!</button>
    )

}

export default NewDogButton;
```

Note that here we are passing the **name of the variable** assigned to the function to our button element. 

![Browser console with 'button clicked!' message](../../../assets/react/hooks_api/console_button_clicked.png)

We can see from our image above that by clicking the button logs *"button clicked!"* to the console, so our event handler is set up correctly. Now we need to modify it so that we get a new dog photo. We already have the functionality to update the `dog` value in state, so how do we get it down to `NewDogButton`?

Recall that functions in JavaScript are first-class objects. This means that we can have a **variable storing a function** just like one storing any other value. This in turn means that we can also pass around a function as a prop akin to any other variable. To test this make another function called `updateDogData` within our `DogContainer` file, before then passing it back down to `NewDogButton` as a prop:


```jsx
// DogContainer.js

const DogContainer = () => {

    // ...
    
    const updateDogData = () => {
        console.log("updating dog data from DogContainer");
    }

    return (
    	dog ?
    	<>
   			<DogViewer dog={dog} />
   			<NewDogButton onClick={updateDogData}/>
   		</>
   		:
   		<p>Loading dog picture...</p>
    )

}

```

In `NewDogButton` we can now access the `onClick` prop and call the function within our existing event handler:

```jsx
// NewDogButton.js

const NewDogButton = ({onClick}) => {

    const handleClick = () => {
        console.log("button clicked");
        onClick();
    }

    // ...

}
```

Now when we click the button we see both `console.log` messages being printed:

![Browser console with 'button clicked!' and 'updating dog data from DogContainer' messages](../../../assets/react/hooks_api/console_button_clicked_2.png)

Now all that remains is for us to modify the function in `DogContainer` so that it updates the state. We already have this functionality within this same file, within our `useEffect`. Let's abstract out our `fetch()` request, placing it within a function so that we can easily make use of the same functionality:

```jsx
// DogContainer.js

const DogContainer = () => {

    // ...
    
    const updateDogData = () => {
        console.log("updating dog data from DogContainer");
        fetch("https://dog.ceo/api/breeds/image/random")
        .then(response => response.json())
        .then(response => setDog(response))
    }
    
    useEffect(() => {
        updateDogData();
    }, []);

    // ...

}

```

Hey presto! We now have a finished React app (apart from any styling) with components which could easily be reused if we wanted to extend its functionality!
