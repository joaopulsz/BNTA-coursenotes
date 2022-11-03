const Chocolate = ({chocolate, deleteChocolate}) => {


    const handleDeleteChocolate = () => {
        deleteChocolate(chocolate.id);
    }

    return (
        <>
            <h4>{chocolate.name}</h4>
            <p>Estate: {chocolate.estate.name}</p>
            <p>Cocoa %: {chocolate.cocoaPercentage}</p>
            <button onClick={handleDeleteChocolate}>
                DeleteChocolate
            </button>
            <hr />
        </>
    )
}

export default Chocolate;