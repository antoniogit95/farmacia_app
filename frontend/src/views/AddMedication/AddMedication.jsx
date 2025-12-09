import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
import './AddMedication.css'
import { SaveFileMedicament } from "../../componets/saveFiles/saveFileMedicament/SaveFileMedicament";
 
export const AddMedication = () => {


    return (<>
        <NavBar></NavBar>
        <div className="stylesAddMedicament">
            <div className="stylesAddMedication">
                <FormsAddMedication></FormsAddMedication>
            </div>
            <div>
                <SaveFileMedicament/>
            </div>
        </div>
    </>);
}