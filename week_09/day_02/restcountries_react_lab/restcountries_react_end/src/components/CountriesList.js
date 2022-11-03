import CountryListItem from "./CountryListItem";

const CountriesList = ({countries, selectCountry}) => {

    const countryListItems = countries.map((country)=>{
        return <CountryListItem 
                    country={country} 
                    selectCountry={selectCountry}
                />
    })

    return(
        <ul>
            {countryListItems}
        </ul>
    );
}

export default CountriesList;