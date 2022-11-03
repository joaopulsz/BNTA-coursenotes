const RGBDisplay = ({rgbValue}) => {

    return(
        <h2 style={{"backgroundColor": rgbValue}}>{rgbValue}</h2>
    )

}

export default RGBDisplay;