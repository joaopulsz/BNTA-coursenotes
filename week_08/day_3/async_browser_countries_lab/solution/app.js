window.addEventListener("DOMContentLoaded", ()=> {
    console.log("DOM loaded!");

    const createCountryList = (countries) => {
        const countryUl = document.querySelector("ul");
        countries.forEach((country) => {
            const countryLi = document.createElement("li");
            countryLi.textContent = country.name.common;

            const countryFlag = document.createElement("img");
            countryFlag.src = country.flags.png;
            countryFlag.classList.add("flag");

            countryLi.appendChild(countryFlag);
            countryUl.appendChild(countryLi);
        })
    }

    const calculateTotalPopulation = (countries) => {
        return countries.reduce((total, country) => total + country.population, 0)
    }

    const displayTotalPopulation = (totalPopulation) => {
        const populationHeader = document.querySelector("h2");
        populationHeader.textContent = totalPopulation;
    }

    const fetchCountries = async () => {
        const response = await fetch("https://restcountries.com/v3.1/all");
        const jsonCountries = await response.json();

        createCountryList(jsonCountries);
        const totalPopulation = calculateTotalPopulation(jsonCountries);
        displayTotalPopulation(totalPopulation);
    }

    const button = document.querySelector("button");
    button.addEventListener("click", fetchCountries);

})