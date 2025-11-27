import React from "react";


export const MedicamentRow = ({medicament}) => {
    
    return(<>
        <tr>
            <td>{medicament.comercialName}</td>
            <td>{medicament.genericName}</td>
            <td>{medicament.descrption}</td>
            <td>{medicament.presentation.name}</td>
            <td>{medicament.consetration}</td>
            <td>{medicament.pharmaceForm}</td>
            <td>{medicament.laboratory}</td>
        </tr>
    </>)
}