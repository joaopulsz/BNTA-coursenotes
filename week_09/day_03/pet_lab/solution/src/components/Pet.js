const Pet = ({pet, onDelete}) => {

    return (
        <div className="pet-tile">
            <h4>{pet.name} the {pet.type}</h4>
            <p>{pet.breed}</p>
            <p>{pet.age} years old</p>
            <button onClick={() => onDelete(pet.id)}>Remove Pet</button>
        </div>
    )

}

export default Pet;