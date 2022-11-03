import { useState } from 'react';

const Search = ({ filterCakes }) => {

    const [searchTerm, setsearchTerm] = useState("");
  
    const handleSubmit = (event) => {
      event.preventDefault();
      filterCakes(searchTerm);
    }
  
    return (
        
        <form className="search" role="search" onSubmit={handleSubmit}>
          <label className="search__label" htmlFor="search__input">Search for a cake:</label>
          <input 
            type="search" 
            placeholder="Please type here..." id="search__input" 
            value={searchTerm}
            onChange={event => setsearchTerm(event.target.value)} />
          <input type="submit" value="Submit" className="search__submit"/>
        </form>

    )
  }
  
export default Search;