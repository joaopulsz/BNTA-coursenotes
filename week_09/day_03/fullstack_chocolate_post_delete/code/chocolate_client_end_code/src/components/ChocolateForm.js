import {useState} from 'react';

const ChocolateForm = ({estates, postChocolate}) => {

    const estateOptions = estates.map((estate) => {
        return <option key={estate.id} value={estate.id}>{estate.name}</option>
    })

    // set up state for this controlled component
    const [stateChocolate, setStateChocolate] = useState(
        {
            name: "",
            cocoaPercentage: 0,
            estate: null
        }
    )

    const handleChange = (event) => {
        console.log(event)
        let propertyName = event.target.name; //'name' is the name of the target that triggered the event, will return 'name'/'cocoaPercentage'/'estate'
        
        // we want to take the values of the inputs and set them to the values of chocolate we have in this form's state: stateChocolate
        // can't do statePirate[propertyName] = event.target.value as we're updating state. So we have to make a copy and set that to state
        let copiedChocolate = {...stateChocolate}
        copiedChocolate[propertyName] = event.target.value;
        setStateChocolate(copiedChocolate);
    }

    const handleEstate = (event) => {
        const estateId = parseInt(event.target.value)
        const selectedEstate = estates.find(estate => estate.id === estateId)
        let copiedChocolate = {...stateChocolate}
        copiedChocolate.estate = selectedEstate
        setStateChocolate(copiedChocolate)
    }

    const handleFormSubmit = (event) => {
        event.preventDefault();
        postChocolate(stateChocolate)
        console.log("hello from form");
    }

    return(
        <>
            <form onSubmit={handleFormSubmit}>
                <h3>Add a new chocolate</h3>
                
                <input 
                    type="text" 
                    placeholder="chocolate name" 
                    name="name"
                    onChange={handleChange}
                    value={stateChocolate.name} />

                <input 
                    type="text" 
                    placeholder="cocoa percentage" 
                    name="cocoaPercentage"
                    onChange={handleChange}
                    value={stateChocolate.cocoaPercentage} />
                
                <select 
                    name="estate" 
                    onChange={handleEstate} 
                    defaultValue="select-estate">
                    <option disabled-value="select-estate">Select an estate</option>
                    {estateOptions}
                </select>
            
                <button type="submit">OK</button>
            </form>
        </>
    )
}

export default NewChocolateForm;