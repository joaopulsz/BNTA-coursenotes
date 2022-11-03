const CountryDetail = ({selectedCountry, addVisitedCountry}) => {
    const handleClick = () => {
        addVisitedCountry(selectedCountry)
    }
    return(
        <div id="country-detail">
            <h2>{selectedCountry.name.common}</h2>
            <ul>
                <li>Total population: {selectedCountry.population}</li>
                <li>Area: {selectedCountry.population} km<sup>2</sup></li>
                <li>Capital: {selectedCountry.capital}</li>
            </ul>
            <button onClick={handleClick}>Add to visited!</button>
        </div>
    )
}

export default CountryDetail;