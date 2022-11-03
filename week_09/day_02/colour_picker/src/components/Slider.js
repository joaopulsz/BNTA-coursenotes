const Slider = ({position, onPositionChange, identifier}) => {

    return (
        <>
            <label htmlFor={identifier}>{identifier}</label>
            <input 
                type="range" 
                id={identifier} 
                onInput={(event) => onPositionChange(event.target.value)}
            />
            <p>{identifier}: {position}</p>
        </>
    )

}

export default Slider;