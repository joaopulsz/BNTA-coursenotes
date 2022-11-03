import './App.css';
import Title from './components/Title';
import NavBar from './components/NavBar';
import CakeForm from './components/CakeForm';
import RecipeList from './components/RecipeList';
import Search from './components/Search';
import { useState } from 'react';

function App() {

  let initialCakes = [
    {
        cakeName: "Lemon Drizzle",
        ingredients: ["eggs", "butter", "lemon  zest", "sugar", "self-raising flour"],
        rating: 5
    },
    {
        cakeName: "Tea Loaf",
        ingredients: ["eggs", "oil", "dried fruit", "sugar", "self-raising flour", "strong tea"],
        rating: 3
    },
    {
        cakeName: "Brownie",
        ingredients: ["chocolate", "eggs", "flour", "butter", "walnuts"],
        rating: 4
    },
    {
        cakeName: "Carrot Cake",
        ingredients: ["carrots", "walnuts", "oil", "cream cheese", "flour", "sugar"],
        rating: 5
    }
  ]

  const [cakes, setCakes] = useState(initialCakes);

  const addNewCake = (newCake) => {
    const updatedCakes = [...cakes, newCake]
    setCakes(updatedCakes)
  }

  const [filteredCakes, setfilteredCakes] = useState();

  const filterCakes = (searchTerm) => {
    // console.log("search term: ", searchTerm);
    const foundCakes = cakes.filter(cake => {
      return cake.cakeName.toLowerCase().includes(searchTerm.toLowerCase())
    })
    //console.log("found cakes: ", foundCakes);
    setfilteredCakes(foundCakes)
  }
  
  return (
    <div className="App overall__container">
      <header className="header">
        <NavBar />
        <Title />
        <Search filterCakes={filterCakes} />
      </header>
      <main>
        <RecipeList cakes={filteredCakes ? filteredCakes : cakes}/>
        <CakeForm addNewCake={addNewCake}/>
      </main>      
    </div>
  );
}

export default App;
