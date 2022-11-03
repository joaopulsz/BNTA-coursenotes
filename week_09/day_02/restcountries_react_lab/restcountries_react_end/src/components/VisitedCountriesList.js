import CountryListItem from "./CountryListItem";

const VisitedCountriesList = ({visitedCountries, selectCountry}) => {
    const visitedCountryListItems = visitedCountries.map((country) => {
        return <CountryListItem country={country} selectCountry={selectCountry}/>
    })
    return(
        <ul>
            {visitedCountryListItems}
        </ul>
    );
}

export default VisitedCountriesList;