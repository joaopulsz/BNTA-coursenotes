import {useState} from 'react';

const StateToggleExample = () => {
    let [loggedIn, setLoggedIn] = useState(true);
    let [toggleCount, setToggleCount] = useState(0);

    const toggleLoggedIn = ()=> {
        setLoggedIn(!loggedIn);

        setToggleCount((current) => {
            return current++;
        });
    }
    
    return (
        <>
        <button onClick={toggleLoggedIn}>Toggle Login Status</button>
        <h4>Logged in: {loggedIn.toString()}</h4>
        <p>Number of times toggled: {toggleCount.toString()}</p>
        </>
    );
}

export default StateToggleExample;
