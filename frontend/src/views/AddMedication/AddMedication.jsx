import React, { useState } from "react";
import { NavBar} from "../../componets/NavBar/NavBar";
import { FormsAddMedication } from "../../componets/Forms/addMedication/FormsAddMedication";
import './AddMedication.css'
import { SaveFileMedicament } from "../../componets/saveFiles/saveFileMedicament/SaveFileMedicament";
 
export const AddMedication = () => {


    return (<>
        <NavBar></NavBar>
        <div className="stylesAddMedicament">
            <div className="stylescontendAddMedicaton-two">
                <div className="styleWindowsColumn">
                    <FormsAddMedication></FormsAddMedication>
                </div>
                <div className="styleWindowsColumn">
                    <SaveFileMedicament/>
                </div>
            </div>
        </div>
    </>);
}