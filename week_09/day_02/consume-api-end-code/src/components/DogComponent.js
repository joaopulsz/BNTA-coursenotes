

const DogComponent = ({dogSrc})=> {
    return dogSrc ? <img src={dogSrc} alt="a random dog image" /> : <p>Loading image...</p>
}

export default DogComponent;