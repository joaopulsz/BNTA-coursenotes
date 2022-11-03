import Chocolate from './Chocolate';

const ChocolateList = ({chocolates, deleteChocolate, selectChocolate}) => {

    const chocolateComponents = chocolates.map(chocolate => {
        return <Chocolate 
                key={chocolate.id} 
                chocolate={chocolate} 
                deleteChocolate={deleteChocolate}
                selectChocolate={selectChocolate} />
    })

    
    
    return (
        <>
            <h3>List of Chocolates</h3>
            <hr />
            {chocolateComponents}
        </>
        

    )
}

export default ChocolateList;