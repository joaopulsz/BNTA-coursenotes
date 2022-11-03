window.addEventListener("DOMContentLoaded", () => {
    const image = document.getElementById("image");
    const button = document.querySelector("button");

    // async/await
    // syntactic sugar -> just aliases for the same thing

    const fetchRandomDog = async () => {

        const response = await fetch("https://random.dog/woof.json");
        const jsonData = await response.json();
        image.src = jsonData.url;

        // fetch("https://random.dog/woof.json")
        // .then( (response) => {
        //     return response.json();
        // })
        // .then((jsonData) => {
        //     image.src = jsonData.url;
        // })

    }
    button.addEventListener("click",fetchRandomDog);


    const getDisneyCharacters = async () => {
        // Promise.all()
        const disneyUrls = [];
        for(let i = 1; i < 150; i++){
            disneyUrls.push(`https://api.disneyapi.dev/characters?page=${i}`);
        }

        const characterPromises = disneyUrls.map( async (url) => {
            const response = await fetch(url);
            return response.json();
        })

        Promise.all( characterPromises )
        .then((allResults) => {

            const charactersData = allResults.map( (result) => result.data ).flat();
            
            const characterNames = charactersData.map((character) => character.name);

            const disneyUl = document.querySelector("ul");   
    
            characterNames.forEach((characterName) => {
                const nameLi = document.createElement("li");
                nameLi.textContent = characterName;
                disneyUl.appendChild(nameLi);
            })

        })
        



    }

    const disneyButton = document.querySelector("#disney-button");
    disneyButton.addEventListener("click", getDisneyCharacters);

})
