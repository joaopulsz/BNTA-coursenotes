import Member from "./Member";

const MemberList = ({members})=> {
    //console.log(members);
    return (
        <>
            <h3>Hello from MemberList</h3>
            {
                // <Member name={"foo"} email={"foo@bar.com"} employeeNo={123} />
                members.map((member, index)=> {
                    return <Member key={index} name={member.name} email={member.email} employeeNo={member.employeeNo} />
                })
            }
        </>
    );
}

export default MemberList;