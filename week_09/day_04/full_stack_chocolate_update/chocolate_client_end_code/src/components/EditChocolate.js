import {useState} from 'react';
import { useParams, useNavigate } from 'react-router-dom';

const EditChocolate = ({estates, chocolates, updateChocolate}) => {

    const navigate = useNavigate();

    const {id} = useParams();

    const chocolate = chocolates.find((chocolate) => {
        const chocolateId = parseInt(id)
        return chocolate.id === chocolateId
    });

    // set up state for this controlled component
    const [stateChocolate, setStateChocolate] = useState(
        {
            name: chocolate.name,
            cocoaPercentage: chocolate.cocoaPercentage,
            estate: chocolate.estate,
            id: chocolate.id
        }
    )

    const handleChange = (event) => {
        // console.log(event)
        let propertyName = event.target.name; //'name' is the name of the target that triggered the event, will return 'name'/'cocoaPercentage'
        
        // we want to take the values of the inputs and set them to the values of chocolate we have in this form's state: stateChocolate
        // can't do stateChocolate[propertyName] = event.target.value as we're updating state. So we have to make a copy and set that to state
        let copiedChocolate = {...stateChocolate}
        copiedChocolate[propertyName] = event.target.value;
        setStateChocolate(copiedChocolate);
    }
    

    const estateOptions = estates.map((estate) => {
        return <option key={estate.id} value={estate.id}>{estate.name}</option>
    })

    const handleEstate = (event) => {
        const estateId = parseInt(event.target.value)
        const selectedEstate = estates.find(estate => estate.id === estateId)
        let copiedChocolate = {...stateChocolate}
        copiedChocolate.estate = selectedEstate
        setStateChocolate(copiedChocolate)
    }

    const handleFormSubmit = (event) => {
        event.preventDefault()
        updateChocolate(stateChocolate)
        navigate("/all-chocolates")
    }

    return(
            <form onSubmit={handleFormSubmit}>
                <h3>Update chocolate</h3>
                
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
                    value={stateChocolate.estate.id}>
                    <option disabled-value="select-estate">Select an estate</option>
                    {estateOptions}
                </select>
            
                <button type="submit">OK</button>
            </form>
    
    )
}

export default EditChocolate;
