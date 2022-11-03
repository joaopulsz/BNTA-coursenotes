

const Member = ({name, email, employeeNo}) => {
    return (
        <div className="employee">
            <header>Employee: {name} </header>
            <main>
                <ul>
                    <li>Email: {email}</li>
                    <li>Employee No: {employeeNo}</li>
                </ul>
            </main>
        </div>
    )
}

export default Member;