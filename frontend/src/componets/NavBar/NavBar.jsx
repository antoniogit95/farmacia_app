import React, { useState, useEffect } from "react";
import "./NavBar.css"
import { NavLink, useNavigate } from "react-router-dom";
import { useAuth } from "../../providerContext/AuthProvider";
import { GiHamburgerMenu } from "react-icons/gi";
import { FaUserCircle } from "react-icons/fa"
import { ModalsUserMenu } from "../Modals/ModalsUserMenu/ModalUserMenu"
import logoFarmacia from "../../images/logoFarmacia.png"

export const NavBar = () => {
    const [showModal, setShowModal] = useState(false);
    const [isNavExpanded, setIsNavExpanded] = useState(false);
    const userRole = JSON.parse(localStorage.getItem('user_data')).role;
    const isAdmin = userRole === 'ADMIN';
    const isPharmacist = userRole === 'PHARMACIST';
    const isCustomer = userRole === 'CUSTOMER';
    const { deletToken } = useAuth();
    const navigate = useNavigate();
    const auth = useAuth();
    const [currentTime, setCurrentTime] = useState(new Date());


    useEffect(() => {
        // Actualiza la hora cada segundo
        const intervalId = setInterval(() => {
          setCurrentTime(new Date());
        }, 1000);
    
        // Limpia el intervalo cuando el componente se desmonta
        return () => clearInterval(intervalId);
      }, []); // El segundo argumento vacío significa que este efecto solo se ejecutará una vez al montar el componente

    if(!auth.isAuthenticated){
        navigate('/login');
    }


    const handleVerUsuario = () => {
      // Lógica para mostrar la información del usuario
      console.log('Ver Usuario');
      setShowModal(false);
    };
  
    const handleEditarUsuario = () => {
      // Lógica para editar el usuario
      console.log('Editar Usuario');
      setShowModal(false);
    };
  
    const handleChangeUsuario = () => {
      // Lógica para cambiar de usuario
      console.log('Cambiar de Usuario');
      setShowModal(false);
    };
  
    const handleCerrarSesion = () => {
        console.log("eliminando Token")
        deletToken();
        navigate('/login');
    };  

    return(<>
      <nav className="stylesNavBar">
        <div className="stylesLogoContainer">
          <img className = "stylesImgLogo" src={logoFarmacia} alt="logo" />
        </div>
        <button className="stylesImgContainerNavBar" onClick={() => {setIsNavExpanded(!isNavExpanded)}}>
            <GiHamburgerMenu className="stylesIcon"/>
        </button>
          <ul className={isNavExpanded? "stylesUl-expanded": "stylesUl"}>
              {(isAdmin /**|| isPharmacist*/ ) && ( <li className="stylesLi">
                  <NavLink className={({ isActive }) => (isActive ? 'stylesActive' : 'stylesA')}
                  to="/home">Home</NavLink></li>
              )}
              
              {(isAdmin || isPharmacist || isCustomer) && ( <li className="stylesLi">
                  <NavLink className={({ isActive }) => (isActive ? 'stylesActive' : 'stylesA')}
                  to="/medication">Medicamentos</NavLink></li>
              )}
              

              {isAdmin && ( <li className="stylesLi">
                  <NavLink className={({ isActive }) => (isActive ? 'stylesActive' : 'stylesA')}
                  to="/personal">Personal</NavLink></li>
              )}

              {(isAdmin ) && ( <li className="stylesLi">
                  <NavLink className={({ isActive }) => (isActive ? 'stylesActive' : 'stylesA')}
                  to="/addmedication">Agregar Medicamentos</NavLink></li>
              )}

              {(isAdmin) && ( <li className="stylesLi">
                      <NavLink className={({ isActive }) => (isActive ? 'stylesActive' : 'stylesA')}
                      to="/reportes">Reportes</NavLink></li>
                  )}
          </ul>
          <div>
                  <button className="stylesIconContainer" onClick={() => setShowModal(true)}>
                      <FaUserCircle className="stylesIcon"/>
                  </button>
              </div>
    </nav>
    <ModalsUserMenu
        onVerUsuario={handleVerUsuario}
        onEditarUsuario={handleEditarUsuario}
        onChangeUsuario={handleChangeUsuario}
        onCerrarSesion={handleCerrarSesion}
        show={showModal}
        onHide={() => setShowModal(false)}
    />
    </>);
}