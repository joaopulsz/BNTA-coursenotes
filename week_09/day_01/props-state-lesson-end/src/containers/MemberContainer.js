import { useState } from "react";
import MemberList from "../components/MemberList";
import NewMember from "../components/NewMember";

const MemberContainer = () => {
    const [members, setMembers] = useState([
        {
            name: "Joe",
            email: "joe@brightnetwork.co.uk",
            employeeNo: 567
        },
        {
            name: "Colin",
            email: "colin@brightnetwork.co.uk",
            employeeNo: 765
        },
        {
            name: "Richard",
            email: "richard@brightnetwork.co.uk"
        }
    ]);

    const [applicationsOpen, setApplicationOpen] = useState(true);

    const addNewMember = () => {
        const newMember = {
            name: "Anna",
            email: "anna@brightnetwork.co.uk",
            age: 39
        }

        const updatedMembers = [...members, newMember]

        if(applicationsOpen) {
            setMembers(updatedMembers);
            setApplicationOpen(false);
        }
    }


    return (
        <>
        <h2>People Directory</h2>
        <NewMember onClick={addNewMember} />
        <MemberList members={members} />
        </>
    )
}

export default MemberContainer;