import { useState } from "react";

const NewMember = ({onSubmit})=> {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [employeeNo, setEmployeeNo] = useState(0);

    const handleNameChange = (event) => {
        setName(event.target.value);
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }

    const handleEmployeeNoChange = (event) => {
        setEmployeeNo(event.target.value);
    }

    const handleFormSubmission = (event) => {
        event.preventDefault();

        if (name == "" || email == "" || employeeNo == 0) {
            return
        }

        const newMember = {
            name: name,
            email: email,
            employeeNo: employeeNo
        }
        setName("");
        setEmail("");
        setEmployeeNo(0);
        onSubmit(newMember);
    }

    return (
        <form onSubmit={handleFormSubmission}>
            <label htmlFor="name">Name:</label>
            <input 
                type="text" 
                id="name"
                onChange={handleNameChange}
                value={name}
            />
            <label htmlFor="email">Email:</label>
            <input 
                type="email"
                id="email" 
                onChange={handleEmailChange}
                value={email}
            />
            <label htmlFor="employee-number">Employee Number:</label>
            <input 
                type="number" 
                id="employee-number"
                onChange={handleEmployeeNoChange}
                value={employeeNo}
            />
            <input type="submit" value="Add Member"/>
        </form>
    );
}

export default NewMember;