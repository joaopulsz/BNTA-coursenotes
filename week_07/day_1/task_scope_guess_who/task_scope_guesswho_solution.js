
// GUESS 1 ///////////////////
let guess = {
    hair_colour: "red",
    eye_colour: "blue",
    hat: false,
    glasses: true,
    firstName: "Joseph"
};

const guessWho = function(){
    return `Guess who is ${guess.firstName}`;
};

const finalAnswer = guessWho();
console.log(finalAnswer);

// RESULT: 'Guess Who is Joseph'

// GUESS 2 ///////////////////

let firstName = "Donna";

const guessWho = function(){
    const glasses = false;
    let firstName = "Liz";
    return `Guess Who is ${firstName}`;
}

const guess1 = guessWho();
console.log("guess1: ", guess1);

const guess2 = `Guess Who is ${firstName}`;
console.log("guess2: ", guess2);

// RESULT: guess1: 'Guess Who is Liz' / guess2: 'Guess Who is Donna'
// Note that 'firstName' (Liz) is a new variable and does not alter the first 'firstName' (Donna)

// GUESS 3 ///////////////////

const guess = {
    hair_colour: "black",
    eye_colour: "brown",
    hat: false,
    glasses: false,
    firstName: "Andy"
}

const changeHat = function(){
    guess.hat = !guess.hat;
}

const changeGuess = function(newName){
    guess.firstName = newName;
}

const guessWho = function(){
    return `Guess Who is ${guess.firstName}`
}

changeHat();

if(guess.hat){
    changeGuess("Chris");
}

const finalAnswer = guessWho();
console.log(finalAnswer);

// RESULT: 'Guess Who is Chris'

// GUESS 4 ///////////////////
let firstName = "Gail";

if ( firstName === "Gail"){
    let firstName = "Ashley";
}

const guessWho = function(){
    return `Guess Who is ${firstName}`
}

const finalAnswer = guessWho();
console.log(finalAnswer);

// RESULT: 'Guess Who is Gail'
// The if statement instantiates a new variable (we know this, because the keyword 'let' is used), also called 'firstName' (Ashley). This 'firstName' (Ashley) is only visible within the scope of that if statement.
// The function 'GuessWho' therefore accesses 'firstName'(Gail)

// GUESS 5 ///////////////////

const guess = {
    hair_colour: "blonde",
    eye_colour: "brown",
    hat: false,
    glasses: false,
    firstName: "Jennifer"
}

const changeGuess = function(){
    guess = {
        hair_colour: "blonde",
        eye_colour: "blue",
        hat: false,
        glasses: false,
        firstName: "Kyle"
    }
}

changeGuess();
console.log(`Guess Who is ${guess.firstName}`);

// RESULT: TypeError: Assignment to constant variable.
// 'changeGuess()' tries to reassign 'guess', but cannot as it is a constant variable.

