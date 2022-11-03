import Pet from "./Pet";

const PetList = ({pets, onDelete}) => {

    const petComponents = pets.map(
        pet => <Pet pet={pet} onDelete={onDelete} key={pet.id}/>
    );

    return (
        <div className="pet-layout">
            <h2>All My Pets:</h2>
            <div className="pet-tile-container">
                {petComponents}
            </div>
        </div>
    );

}

export default PetList;