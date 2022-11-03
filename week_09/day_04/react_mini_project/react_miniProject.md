# React Mini-Project

It's time to put some of your learning into practice! This afternoon and most of tomorrow morning, we are looking for each person to put together a simple front-end React app which interfaces with a supplied API. This lab exists for you to consolidate your learning ahead of the larger proper Client-Side Project starting tomorrow. 

This lab is due **tomorrow (Friday 7th October) at 12noon**, when we will, be **randomly selecting some two or three students to present their work**, so make sure you're present and contributing to your project!

You may use any API you wish, with the proviso that it is free and you are able to use it easily. As a start point, a selection of suitable APIs are listed below. If you decide to use an API outside of this brief, spend some time ensuring that it's going to work for you. Consider:
- Do you need an API key? Sometimes the API key is emailed immediately. Sometimes it takes 24/48 hours.
- Is there a limit to how many times you can access the API? The limit may be workable, but it's something to be aware of.
- Are there suitable end-points?
- Are you spending too long messing around with APIs?

As this is an external API, you may not be able to implement full CRUD functionality (you are unlikely to be able to post/delete for example). In general, you should be able to:

- Load the data into your app
- Save the loaded data using React's State management system
- Render the data in some meaningful way
- Adjust what the user can see, perhaps with a search or a filter
- Have a way to display more specific details of a selected item

Attempt to work your way through the points set out above but also *feel free to experiment and work in other areas that you feel you need practise with*. 

## Technology & Pointers

This project requires the use of **React**, which in turn will require you to utilise JSX, JavaScript, HTML and CSS.

## Next Steps

You have a lot to do, in not much time, please take 10mins to plan your time. You'll need to make time for:

- looking at APIs
- brain-storming
- wireframing
- Draw a component and dataflow diagram
- Start building!


## API Suggestions

### Random Pictures of Animals

[shibe.online](https://shibe.online/)

**Example Endpoint:** http://shibe.online/api/shibes?count=1&urls=true&httpsUrls=true

This API simply returns URL string to a random picture of a Shiba Inu, Cat or Bird

---

### Pokemon Data

[pokeAPI](https://pokeapi.co/)

**Example Endpoint:** https://pokeapi.co/api/v2/pokemon-species/25/

This API has many different endpoints where you can recieve many different JSONs, all relating to Pokemon. The example above returns all the data about a specific pokemon (id 25: Pikachu)

---

### The Metropolitan Museum of Art Collection

[MMoA API](https://metmuseum.github.io/)

**Example Endpoint:** https://collectionapi.metmuseum.org/public/collection/v1/objects/1

Returns a JSON about different museum pieces, including links to relavent Wikipedia articles and different characteristics such as period and artist information

---

### Open Library

[Open Library](https://openlibrary.org/dev/docs/api/books)

**Example Endpoint:** https://openlibrary.org/books/OL33891821M.json

Can use the identifier value (as gotten from the endpoint below) to then grab data about different books

**Example of Search:** http://openlibrary.org/search.json?q=the+lord+of+the+rings

Having the two requests could make for an interesting project where you input a search term and then display the search. Could then generate a page with more details for a specific book on selection

---

### Random Pictures of Food

[Foodish](https://github.com/surhud004/Foodish#readme)

**Example Endpoint:** https://foodish-api.herokuapp.com/

Returns a random picture

---

### Animal Crossing Data

[Animal Crossing New Horizons API](http://acnhapi.com/doc)

**Example Endpoint:** https://acnhapi.com/v1/fish/2

Has lots of different information about different ACNH items including translated names, item sell price, catching phrase and an image URI

---

### Random Movie Quotes

[Movie Quote API](https://github.com/F4R4N/movie-quote/)

**Example Endpoint:** https://movie-quote-api.herokuapp.com/v1/quote/

Returns either a random movie quote or a quote from a specified movie

---

### Rest Countries

[RESTcountries API - end-points](https://restcountries.com/#api-endpoints-v3)

Why not re-visit a familiar API and use it in a new way? For example, building a travel bucket list.
