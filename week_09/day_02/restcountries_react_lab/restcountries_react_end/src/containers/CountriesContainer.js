import { useState, useEffect } from "react";

import CountriesList from "../components/CountriesList";
import VisitedCountriesList from "../components/VisitedCountriesList";
import CountryDetail from "../components/CountryDetail";

const CountriesContainer = () => {

    const [countries, setCountries] = useState([]);
    const [visitedCountries, setVisitedCountries] = useState([]);
    const [selectedCountry, setSelectedCountry] = useState(null);

    const fetchCountries = async () => {
        // fetch("https://restcountries.com/v3.1/all")
        // .then((response) => {
        //     return response.json();
        // })
        // .then((jsonData) => {
        //     setCountries(jsonData)
        // })
        const response = await fetch("https://restcountries.com/v3.1/all");
        const jsonCountries = await response.json();

        setCountries(jsonCountries);
    }

    useEffect(() => {
        fetchCountries();
    }, [])

    const addVisitedCountry = (country) => {
        if(visitedCountries.includes(country)){
            alert("You've already added this country!");
        } else {
            setVisitedCountries([...visitedCountries, country])
        }
    }

    const selectCountry = (country) => {
        setSelectedCountry(country);
        // setVisitedCountries([...visitedCountries, country])
    }
 

    return(
        <div id="main-container">
            <CountriesList countries={countries} selectCountry={selectCountry}/>

            {selectedCountry ? 
                <CountryDetail 
                    selectedCountry={selectedCountry}
                    addVisitedCountry={addVisitedCountry}
                /> 
                : <div></div>
            }
            <VisitedCountriesList 
                visitedCountries={visitedCountries}
                selectCountry={selectCountry}
            />
        </div>
    );
}

export default CountriesContainer;