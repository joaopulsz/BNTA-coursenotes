import NewChocolateForm from "../components/NewChocolateForm";
import ChocolateList from "../components/ChocolateList";
import { useEffect, useState } from "react";

const ChocolateContainer = () => {

    const [chocolates, setChocolates] = useState([])

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch("http://localhost:8080/chocolates");
            const data = await response.json();
            setChocolates(data);
        }
        fetchData()
    }, [])

    const [estates, setEstates] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/estates")
            .then(response => response.json())
            .then(data => setEstates(data))
    }, [])


    const postChocolate = (newChocolate) => {
        fetch("http://localhost:8080/chocolates", {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newChocolate)
        })
        .then(response => response.json())
        .then(savedChocolate => setChocolates([...chocolates, savedChocolate]))
    }

    const deleteChocolate = (id) => {
        // delete from db
        fetch("http://localhost:8080/chocolates/" + id, {
            method: "DELETE",
            headers: {'Content-Type': 'application/json'}
        })
        // delete locally
        setChocolates(chocolates.filter(chocolate => chocolate.id !== id))
    }

    return(
        <>
            <h1>Single Origin Chocolate</h1>
            <p>A resource for chocoholics</p>
            <ChocolateForm 
                    estates={estates}
                    postChocolate={postChocolate}/>
            <ChocolateList 
                    chocolates={chocolates}
                    deleteChocolate={deleteChocolate}
                    />
        </>
    
    );
}

export default ChocolateContainer;