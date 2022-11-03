import MemberList from '../components/MemberList';
import NewMember from '../components/NewMember';

const MemberContainer = () => {

    const members = [
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
      ]
    
    const addNewMember = () => {
      console.log("new member added");
    }

    return (
      <>
        <h1>People Directory</h1>
        <NewMember handleButtonClick={addNewMember}/>
        <MemberList members={members} />
      </>
    );
}

export default MemberContainer;