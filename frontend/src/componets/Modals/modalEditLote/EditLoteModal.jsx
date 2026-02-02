import { Formik } from "formik";
import "./EditLoteModal.css"
import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const EditLoteModal = ({show, onHide, lote}) => {

    
    const userData = JSON.parse(localStorage.getItem("user_data"));
    const endPoint = URL_API_private+"/lote/edit";
    const token = userData?.token;
    const userRole = userData?.role;
    const isAdmin = userRole === "ADMIN";

    console.log(lote)
    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Editar Lote / Stock</Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                {!isAdmin? (
                    <div className="noPermissionBox">
                        <h4>🚫 Acceso restringido</h4>
                        <p>
                            Necesitas permisos de <strong>Administrador</strong> para editar
                            el stock o lote.
                        </p>
                        <p>Por favor, contacta a un administrador.</p>

                        <div className="stylesContenedorButton">
                            <button className="stylesButoon" onClick={onHide}>
                                Cerrar
                            </button>
                        </div>
                    </div>
                ):(
                    <div className='stylesRegistroPersonal'>
                        <Formik
                            initialValues={{
                                lotNomber: lote.lotNomber,
                                expirationTime: lote.expirationTime,
                                quantity: lote.quantity,
                                unitPrice: lote.unitPrice,
                            }}

                            validate={async (valores) => {
                                let errores = {};

                                //validacion LotNumber
                                if(!valores.lotNomber){
                                    errores.lotNomber = 'el campo Lote es requerido Obligadoriamente';
                                }

                                //validacion expirationTime
                                if(!valores.expirationTime){
                                    errores.expirationTime = 'el campo fecha de expiracion es requerido obligatoriamente';
                                }

                                //validacion quantity
                                if(!valores.quantity){
                                    errores.quantity = 'el campo cantidad es requerido obligatoriamente';
                                }

                                //validacion unitPrice
                                if(!valores.unitPrice){
                                    errores.unitPrice = 'el campo precio Unitario es requerido obligatoriamente';
                                }
                                return errores;
                            }}

                            onSubmit={ (valores, {resetForm}) => {
                                const store = async (e) => {
                                    e.preventDefault()
                                    try {
                                        const response = await axios.post(endPoint, {
                                            id:lote.id,
                                            medicamentId: lote.medicament.id,
                                            lotNomber: valores.lotNomber,
                                            expirationTime: valores.expirationTime,
                                            unitPrice: valores.unitPrice,
                                            quantity: valores.quantity,
                                    },{
                                        headers: config.headers,
                                    });
                                        toast.success('dato guardado con exito', {
                                            position: 'top-right',
                                            autoClose: 3000,      
                                        });
                                        resetForm();
                                        onHide();
                                    } catch (error) {
                                        console.log(error)
                                        console.log("mensaje")
                                        toast.error(error.code, {
                                            position: 'top-right', 
                                            autoClose: 3000,  
                                        });
                                    }
                                    
                                }
                                store(event);

                            }}

                        >
                            {({values, errors, touched, handleSubmit, handleChange, handleBlur, resetForm}) => (
                                <form onSubmit={handleSubmit}>
                                <div>
                                    <strong>{lote.medicament?.comercialName + " " + lote.medicament?.presentation.name + " "+ lote.medicament?.consetration}</strong> 
                                </div>
                                <div>
                                    <label htmlFor='lotNomber'>Numero de Lote</label>
                                    <input 
                                        className='stylesInput'
                                        type='text'
                                        id='lotNomber'
                                        name='lotNomber'
                                        placeholder='escribe el numero de Lote'
                                        value={values.lotNomber}
                                        /**onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}*/
                                        onBlur={handleBlur}
                                    />
                                    {touched.lotNomber && errors.lotNomber && <div className='styleErrores'>{errors.lotNomber}</div>}
                                </div>
                                <div>
                                    <label htmlFor='quantity'>Cantidad</label>
                                    <input 
                                        className='stylesInput'
                                        type='number'
                                        id='quantity'
                                        name='quantity'
                                        placeholder='Escribe la cantidad'
                                        value={values.quantity}
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}  
                                        onBlur={handleBlur}
                                    />
                                    {touched.quantity && errors.quantity && <div className='styleErrores'>{errors.quantity}</div>}
                                </div>
                                <div>
                                    <label htmlFor='unitPrice'>Precio Unitario</label>
                                    <input 
                                        className='stylesInput'
                                        type='text'
                                        id='unitPrice'    
                                        name='unitPrice'
                                        placeholder='Escribe el precio Unitario'
                                        value={values.unitPrice}
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}
                                        onBlur={handleBlur}
                                    />
                                    {touched.unitPrice && errors.unitPrice && <div className='styleErrores'>{errors.unitPrice}</div>}
                                </div>

                                <div>
                                    <label htmlFor='expirationTime'>Fecha de Expiracion</label>
                                    <input 
                                        className='stylesInput'
                                        type='date'
                                        id='expirationTime'
                                        name='expirationTime'
                                        placeholder=''
                                        value={values.expirationTime}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.expirationTime && errors.expirationTime && <div className='styleErrores'>{errors.expirationTime}</div>}
                                </div>
                            
                                <br></br>
                                <div className="stylesContenedorButton">
                                    <button  className='stylesButoon' type="submit">
                                        Guardar
                                    </button>
                                    
                                </div>
                                <br />
                            </form>
                            )}
                        </Formik>
                        <ToastContainer />
                    </div>
                )}
            </Modal.Body>
        </Modal>
    </>)
}     