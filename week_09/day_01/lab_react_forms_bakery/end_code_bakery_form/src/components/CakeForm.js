import { useState } from "react";

const CakeForm = ({ addNewCake }) => {

  const [newCake, setNewCake] = useState("");
  const [newIngredients, setNewIngredients] = useState();
  const [newRating, setNewRating] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    const newCakeInput = {
      cakeName: newCake,
      ingredients: newIngredients.split(","),
      rating: newRating
    };
    addNewCake(newCakeInput);
  }

  return (
    <section className="newCakeForm container">
      <h2>New Cake Form:</h2>
      <form className="newCakeForm__form" onSubmit={handleSubmit}>

          <label className="newCakeForm__label" htmlFor="nameField">Cake Name:</label>
          <input 
            type="text" className="newCakeForm__input" id="nameField" 
            required
            value={newCake}
            onChange={(event) => setNewCake(event.target.value)}/>

          <label className="newCakeForm__label" htmlFor="ingredientField">Cake Ingredients: (comma-separated)</label>
          <textarea 
            type="text" className="newCakeForm__input" id="ingredientField" 
            required
            value={newIngredients}
            onChange={(event) => setNewIngredients(event.target.value)}
          ></textarea>

          <label className="newCakeForm__label" htmlFor="ratingField">Cake Rating:</label>
          <input 
            type="number" 
            min="1" max="5" 
            className="newCakeForm__input" 
            id="ratingField" 
            required
            value={newRating}
            onChange={(event) => setNewRating(event.target.value)} />

          <input className="newCakeForm__submit" type="submit" value="Submit" id="submitButton" />
      </form>
    </section>
  )
}

export default CakeForm;