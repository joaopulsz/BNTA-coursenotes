import ChocolateForm from "../components/ChocolateForm";
import ChocolateList from "../components/ChocolateList";
import EditChocolate from "../components/EditChocolate";
import { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

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
        const fetchEstatesData = async () => {
            const response = await fetch("http://localhost:8080/estates");
            const data = await response.json();
            setEstates(data);
        }
        fetchEstatesData()
    }, [])


    const postChocolate = async (newChocolate) => {
        const response = await fetch("http://localhost:8080/chocolates", {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newChocolate)
        })
        const savedChocolate = await response.json()
        setChocolates([...chocolates, savedChocolate])
    }

    const deleteChocolate = async (id) => {
        // delete from db
        await fetch("http://localhost:8080/chocolates/" + id, {
            method: "DELETE",
            headers: {'Content-Type': 'application/json'}
        })
        // delete locally
        setChocolates(chocolates.filter(chocolate => chocolate.id !== id))
    }

    const updateChocolate = async (updatedChocolate) => {
        console.log("Updating a chocolate!");
    }

    return(
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
                </Routes>
            </div>
        </BrowserRouter>   
    );
}

export default ChocolateContainer;