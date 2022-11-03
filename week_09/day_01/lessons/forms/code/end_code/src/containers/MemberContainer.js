import MemberList from '../components/MemberList';
import NewMember from '../components/NewMember';
import UpdateStatus from '../components/UpdateStatus';
import {useState} from 'react';

const MemberContainer = () => {

    const [members, setMembers] = useState([
        {
          name: "Colin",
          email: "colin@brightnetwork.co.uk",
          employeeNumber: 123
        },
        {
          name: "Anna",
          email: "anna@brightnetwork.co.uk",
          employeeNumber: 234
        },
        {
          name: "Phil",
          email: "phil@brightnetwork.co.uk",
          employeeNumber: 345
        },
        {
          name: "Valeria",
          email: "valeria@brightnetwork.co.uk",
          employeeNumber: 456
        },
      ])
    
    const addNewMember = () => {
      console.log("new member added");
      const newMember = {
        name: "Joe",
        email: "joe@brightnetwork.co.uk",
        employeeNumber: 567
      }
      const updatedMembers = [...members, newMember];
      
      if(applicationsOpen){
        setMembers(updatedMembers);
      }
    }

    const [applicationsOpen, setApplicationsOpen] = useState(true);

    const updateApplicationsOpen = () => {
      setApplicationsOpen(!applicationsOpen);
  }

    return (
      <>
        <h1>People Directory</h1>
        <NewMember 
              handleButtonClick={addNewMember} />
        <UpdateStatus 
              applicationsOpen={applicationsOpen}
              handleClick={updateApplicationsOpen} />
        <MemberList members={members} />
      </>
    );
}

export default MemberContainer;