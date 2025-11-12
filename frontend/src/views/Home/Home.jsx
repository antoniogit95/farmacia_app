import React, { useState } from "react";
import './Home.css'
import { NavBar } from "../../componets/NavBar/NavBar";


export const Home = () => {
    
    const role = JSON.parse(localStorage.getItem('user_data')).role;
    //const buttons = showButtons();
    

    return(<>
        <NavBar />
        <div className="stylesContentHome">
            <p>agregar aqui cosas para el Home</p>
        </div>  
            
    </>)
}