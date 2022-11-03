# Updating via React

Updating is one of the core CRUD actions - most apps involved with an API will need a way to edit existing records/entities. We've already seen how we can do an update through Spring - now we just need to connect it to our React front end! Back to chocolates we go!

## Put or Patch?

Generally speaking we have 2 distinct HTTP verbs if we want to update a record - Put and Patch. Only one of them is the correct one in most situations! So how do we decide which one to use?

Put is meant to be an update which, when sent from the client, includes and updates the entire resource, and all its fields. Think of editing your Instagram or Twitter profile, including profile pictures, name, nickname, etc.

Patch, on the other hand, includes only partial data to update a resource with. This usually is done to update only a single field in most cases. Examples include marking a task as done in a to-do list, or adding a single ingredient to a recipe.

In our case, we want to (potentially) update all attributes of a resource - so we will use a Put request!

> Hand out the start code, and set up the apps - run the Spring API, and `npm i` + `npm start` in the client folder

## Put endpoint in Spring

Just for convenience, the update route is already added to the Spring back end, but let's inspect it just as a refresher!

```java
    @PutMapping(value = "/{id}")
    public ResponseEntity<Chocolate> putChocolate(
            @RequestBody Chocolate updatedChocolate,
            @PathVariable Long id){
        chocolateRepository.save(updatedChocolate);
        return new ResponseEntity<>(updatedChocolate, HttpStatus.OK);
    }
```
We might not need the ID pathvariable depending on how we write our code, but it is conventional to keep the url like this for patch requests.

> Demonstrate updating a resource via Postman - use the following sample payload: 
```json
{
        "id": 1,
        "name": "Salted Dark",
        "cocoaPercentage": 100,
        "estate": {
            "id": 1,
            "name": "Rabot Estate",
            "country": "St Lucia"
        }
    }
```

Our back end is up and running - we now need to take a look at the client start code!

> Give the students 10 minutes to explore the start code - focus on the `ChocolateContainer.js`, and the addition of React Router!
> Talk about the way we pass down props to the components in the router.


Let's get to work!

## The edit form

Our edit form is going to be fairly similar to our new form - in fact, most behaviour will be shared. But there will be enough differences to warrant giving it its own component! Again, for convenience, the `EditChocolate.js` is already created, and is more or less a copy of the form - we just need to modify it to suit our needs!

> Talk through the Edit form start code

Before we get started with writing the code, we should think through the process of adding this feature.

The link to access the edit form for a chocolate should probably not be part of our main navigation out in the container - I want to only update specific chocolates, and the navigation does not have a way of giving me easy access to those items.
Luckily we do have individual `Chocolate` components, where the `delete` button already exist! That would be the perfect place to add our link that points to the update form. The link needs to be added our React Router as well.

Once the link is clicked, it should take us to the edit form, find our selected chocolate, and populate the edit form with all its existing details - so we know what are we changing values from!

Finally, the edit form will need to get a function that will be invoked when all details are changed, which will call our API with the payload of the updated chocolate.

So our steps are as follows:

1. Add our Edit route to the React Router
2. Add a link to the Edit component inside the Chocolate component
3. Find out a way to find the chocolate entity to be updated
4. Using this chocolate, prepopulate the edit form
5. Write an update function that will be passed down to the Edit component
6. Call the update function on the form's `onSubmit` event

Let's get started!

### 1. Adding the Edit route

First we need to go to our `ChocolateContainer.js`, and add the route to the `<BrowserRouter>` component! Don't forget to import it at the top of the file.

> Talk through what data you might need for the editing - estates, way to find a chocolate, updateChocolate function.

```js
<BrowserRouter>
            <div className="App">
                <h1>Single Origin Chocolate</h1>
                <ul>
                    <li>
                        <Link to="/all-chocolates">All Chocolates</Link>
                    </li>
                    <li>
                        <Link to="/new-chocolate">Add new chocolate</Link>
                    </li>
                </ul>
                <Routes>
                    <Route path="/new-chocolate" element={
                        <ChocolateForm 
                            estates={estates}
                            postChocolate={postChocolate}
                        />}
                    />
                    <Route path="/all-chocolates" element={
                        <ChocolateList 
                            chocolates={chocolates}
                            deleteChocolate={deleteChocolate}
                        />} 
                    />
                    <Route path="/edit-chocolate/:id" element={ // Added
                        <EditChocolate                          // Added
                            estates={estates}                   // Added
                            chocolates={chocolates}             // Added
                            updateChocolate={updateChocolate}   // Added
                        />}                                     // Added
                    />                                          // Added
                </Routes>
            </div>
</BrowserRouter>
```

We will need all the estates, chocolates, and the `updateChocolate` function as props.

* The estates to pick any one of them when we update
* The chocolates to be able to find the one we need to update
* And finally, the `updateChocolate` function will call the API for us

The `:id` works similar to how we used dynamic params in Spring with `{id}` - it will take the value of what we are adding at the end of the URL when we link it.

### 2. Adding a link to the Chocolate component

Inside our `Chocolate.js` we want to add the following:

```js
          //as before
          <button onClick={handleDeleteChocolate}>
                delete
            </button>
            <button>                                                       // Added
                <Link to={`/edit-chocolate/${chocolate.id}`}>Edit</Link>   // Added
            </button>                                                      // Added
            <hr />
        </>
        //as before
```

This way, when the button gets clicked, it will take us to the `EditChocolate` component - and more importantly, will give us a tool to access the chocolate's id! Without it we wouldn't be able to find the chocolate we want to change.

The `<button>` tag makes the styling of the link more consistent - this can be changed of course, and is not crucial.

### 3. Finding the chocolate in our Edit form

Now comes the hard part - how can we access our chocolate object?

There are several ways to do it, some of which might require us some packages to be installed. However, we will use the tools at our disposal to solve this problem.

First, we will need access to all chocolates in the Edit component - luckily we passed it down before, so it is accessible as a prop!

Second, we need to grab the ID of the chocolate we want to edit. When we clicked on the link on the Chocolate component, we actually got access to the ID through a function available via React Router - the `useParams()`!

In `EditChocolate.js`:

```js
import {useState} from 'react';
import { useParams } from 'react-router-dom'; // Added

const EditChocolate = ({estates, chocolates, updateChocolate}) => {

const {id} = useParams(); // Added

// as before

```

This will give us the id from the URL of the link we clicked on!

Next, we need to find the chocolate itself - we can use the `find()` enumerator on our chocolates!

```js
    //as before
    
    const {id} = useParams();

    const chocolate = chocolates.find((chocolate) => {  // Added
        const chocolateId = parseInt(id)                // Added
        return chocolate.id === chocolateId             // Added
    });                                                 // Added
    
    //as before

```

Fantastic, now we have access to the chocolate object as soon as we load up the component!

### 4. Prepopulate the form

Using the existing `useState` hook, we can easily modify and populate the form with chocolate data!

```js
	// as before

    const chocolate = chocolates.find((chocolate) => {
        const chocolateId = parseInt(id)
        return chocolate.id === chocolateId
    });

    const [stateChocolate, setStateChocolate] = useState(
        {
            name: chocolate.name,                         // Modified
            cocoaPercentage: chocolate.cocoaPercentage,   // Modified
            estate: chocolate.estate,                     // Modified
            id: chocolate.id                              // Modified
        }
    )
    
    // as before
```

Because the `value=` attributes in our JSX elements are directly connected to this state, we will immediately see that our form is filled with the chocolate's current data!

One thing is not nice yet though - it would be amazing to pre-select the estate from the dropdown, so we know which one it belonged to originally. Luckily this is a simple fix - we can use the `value=` attribute of the `select` tag instead of the `defaultValue`: if we connect it to the chocolate's estate's `id`, we should have it selected in no time!

```js
				// as before
                <select 
                    name="estate" 
                    onChange={handleEstate}
                    value={stateChocolate.estate.id}>                   // Modified
                    <option disabled-value="select-estate">Select an estate</option>
                    {estateOptions}
                </select>
            
                <button type="submit">OK</button>
            </form>
    
    )
```

Fantastic! Now if we submit the form, we should invoke the `updateChocolate` function in our container! Right now it's just logging out the chocolate we clicked on, but it's still pretty fantastic! Let's change it so it will update the actual value in our API.

### 5. Writing the update

In our `ChocolateContainer`, the `updateChocolate` method need to be modified to do its job. Let's write our update statement!

```js

    const updateChocolate = async (updatedChocolate) => {
		 console.log("Update called with:" + updatedChocolate)
        // Update in db                                                           //Added
        await fetch("http://localhost:8080/chocolates/" + updatedChocolate.id, {  //Added
            method: "PUT",                                                        //Added  
            headers: {'Content-Type': 'application/json'},                        //Added
            body: JSON.stringify(updatedChocolate)                                //Added
        })
    }
```

This will only update our API though - not the actual local list stored in our React state

> Demonstrate this by calling the function, and checking the result via Postman/Postico

We also want to change the local list of chocolates, and replace the existing chocolate with the updated one!

```js
    const updateChocolate = async (updatedChocolate) => {
        // Update in db
        await fetch("http://localhost:8080/chocolates/" + updatedChocolate.id, {
            method: "PUT",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(updatedChocolate)
        })
        // update locally                                                 //Added
        const updatedChocolatesList = chocolates.map((chocolate) => {     //Added
            if(chocolate.id === updatedChocolate.id){                     //Added
                return updatedChocolate;                                  //Added
            } else {                                                      //Added
                return chocolate;                                         //Added
            }                                                             //Added
        })                                                                //Added
        setChocolates(updatedChocolatesList)                              //Added
    }

```
Since we need a new array to trigger the re-render, we will use a map - this will give us back the exact list, but if we iterate through the old version of the updated chocolate, we will replace it with the new!

> Try updating a chocolate

One final thing before we can call it a day!

When we update an entity, it is not great user experience that we stay on the exact same page. It would be great that as soon as the update happens, we get redirected to the main list of chocolates - to see the changes taking place. We can use the `useNavigate` React Router hook for this!

In `EditChocolate.js`:

```js
import {useState} from 'react';
import { useParams, useNavigate } from 'react-router-dom'; // Modified

const EditChocolate = ({estates, chocolates, updateChocolate}) => {

    const navigate = useNavigate(); // Added

	// as before
	
	const handleFormSubmit = (event) => {
        event.preventDefault()
        updateChocolate(stateChocolate)
        navigate("/all-chocolates")            // modified
    }
    
    //as before

```

Now if we click on the submission, it should update and redirect us at the same time!




