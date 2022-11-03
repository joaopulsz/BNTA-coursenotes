const Member = ({member}) => {
    return (
        <div className="person-card">
            <h3>name: {member.name}</h3>
            <p>email: {member.email}</p>
            <p>employee number: {member.employeeNumber}</p>
            <hr />
        </div>
    )
}

export default Member;