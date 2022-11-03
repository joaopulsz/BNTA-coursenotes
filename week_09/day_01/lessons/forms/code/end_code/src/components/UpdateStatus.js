const UpdateStatus = ({applicationsOpen, handleClick}) => {
    return(
        <>
            <p>Applications are currently {applicationsOpen ? "open" : "closed"}</p>
            <button onClick={handleClick}>Change Application Status</button>
        </>
    )
}

export default UpdateStatus;