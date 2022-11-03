// responsible for mapping through data (creating the list)
import Member from './Member.js';

const MemberList = ({members}) => {

    const memberComponents = members.map((member, index) => {
        return <Member  key={index} 
                        member={member} />
    })
    
    return (
        <>
            {memberComponents}
        </>
    )
}

export default MemberList;