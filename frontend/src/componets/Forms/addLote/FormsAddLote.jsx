import React from "react";
import { Formik, Field } from 'formik';
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import {ToastContainer, toast } from 'react-toastify';


export const FormsAddLote = ({ item }) => {

    const personData = localStorage.getItem('user_data');
    const token = JSON.parse(personData).token;
    const endPoint = URL_API_private + "/lote/add"

    if(!item) return <h2 className="stylesH2Subtitule"> Selecciona un producto</h2>

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    return(
        <div className=''>
            <h2 className="stylesH2Subtitule">Agregar stock de productos</h2>
            <p>{item.genericName} {item.consentration} {item.laboratory}</p>

            <Formik
                initialValues={{
                    unitPrice: '',
                    numberLote: '',
                    expirationTime: '',
                    quantity:'',
                }}

                validate={async (valores) => {
                    let errores = {};

                    //validacion precio Unitario
                    if(!valores.unitPrice){
                        errores.unitPrice = 'el campo precio Unitario es requerido obligatoriamente';
                    }

                    //validacion para quantity
                    if(!valores.quantity){
                        errores.quantity = 'el campo cantidad es requerido obligatoriamente';
                    }

                    //validacion expirationTime
                    if(!valores.expirationTime){
                        errores.expirationTime = 'el campo fecha de expiracion es requerido obligatoriamente';
                    }

                    return errores;
                }}
                onSubmit={ (valores, {resetForm}) => {
                    const store = async (e) => {
                        console.log(valores, item)
                        e.preventDefault()
                        try {
                            const response = await axios.post(endPoint, {
                                medicamentId: item.id,
                                lotNomber: valores.numberLote,
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
                        } catch (error) {
                            console.log(error)
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
                        <label htmlFor='numberLote'>Numero de Lote</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='numberLote'
                            name='numberLote'
                            placeholder='Escribe el numero de lote'
                            value={values.numberLote}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.numberLote && errors.numberLote && <div className='styleErrores'>{errors.numberLote}</div>}
                    </div>
                    <div>
                        <label htmlFor='expirationTime'>Fecha de expiracion</label>
                        <input 
                            className='stylesInput'
                            type='date'
                            id='expirationTime'    
                            name='expirationTime'
                            placeholder='Escribe una pequenia descripcion'
                            value={values.expirationTime}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.expirationTime && errors.expirationTime && <div className='styleErrores'>{errors.expirationTime}</div>}
                    </div>
                    
                    <div>
                        <label htmlFor='quantity'>Cantidad</label>
                        <input 
                            className='stylesInput'
                            type='number'
                            id='quantity'
                            name='quantity'
                            placeholder='Escribe tu laboratorio'
                            value={values.quantity}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.quantity && errors.quantity && <div className='styleErrores'>{errors.quantity}</div>}
                    </div>
                    <div>
                        <label htmlFor='unitPrice'>Precio Unitario</label>
                        <input 
                            className='stylesInput'
                            type='number'
                            id='unitPrice'
                            name='unitPrice'
                            placeholder='Escribe tu laboratorio'
                            value={values.unitPrice}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.unitPrice && errors.unitPrice && <div className='styleErrores'>{errors.unitPrice}</div>}
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
    );
}