const CountryListItem = ({country, selectCountry}) => {

    const handleClick = () => {
        selectCountry(country);
    }

    return (
        <li onClick={handleClick}>{country.name.common} - {country.flag}</li>
    );
}

export default CountryListItem;