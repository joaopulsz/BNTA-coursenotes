import { useState, useEffect } from "react";
import Slider from "../components/Slider";
import RGBDisplay from "../components/RGBDisplay";

const ColourPickerContainer = () => {

    const [redPosition, setRedPosition] = useState(0);
    const [greenPosition, setGreenPosition] = useState(0);
    const [bluePosition, setBluePosition] = useState(0);
    const [rgbValue, setRgbValue] = useState("rgb(0,0,0)");

    useEffect(() => {
        const red255 = Math.ceil(redPosition * 2.55);
        const green255 = Math.ceil(greenPosition * 2.55);
        const blue255 = Math.ceil(bluePosition * 2.55);

        setRgbValue(`rgb(${red255}, ${green255}, ${blue255})`);
    },[redPosition, greenPosition, bluePosition]);

    return(
        <>
            <header>
                <h1>ColourPicker</h1>
            </header>
            <main>
                <Slider 
                    position={redPosition} 
                    onPositionChange={setRedPosition}
                    identifier="red"
                />
                <Slider
                    position={greenPosition}
                    onPositionChange={setGreenPosition}
                    identifier="green"
                />
                <Slider
                    position={bluePosition}
                    onPositionChange={setBluePosition}
                    identifier="blue"
                />
                <RGBDisplay rgbValue={rgbValue}/>
            </main>
        </>
    )

}

export default ColourPickerContainer;