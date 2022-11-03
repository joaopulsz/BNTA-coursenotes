import { useEffect, useState } from "react";
import DogComponent from "../components/DogComponent";
import GetDogComponent from "../components/GetDogComponent";

const DogContainer = ()=> {
    const [dog, setDog] = useState(null);

    const getRandomImage = ()=> {
        fetch("https://dog.ceo/api/breeds/image/random")
        .then((response)=> response.json())
        .then((response)=> setDog(response.message));
    }

    useEffect(()=> {
       getRandomImage();
    }, []);

    return (
        <>
            <GetDogComponent onClick={getRandomImage} />
            <DogComponent dogSrc={dog} />
        </>
    )
}

export default DogContainer;
