import React from "react";
import { Formik, Field } from 'formik';
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import {ToastContainer, toast } from 'react-toastify';


export const FormsAddLote = () => {

    const personData = localStorage.getItem('user_data');
    const token = JSON.parse(personData).token;
    const endPoint = URL_API_private + "/lote/add"

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    return(
        <div className=''>
            <Formik
                initialValues={{
                    medicament: '',
                    numberLote: '',
                    expirationTime: '',
                }}

                validate={async (valores) => {
                    let errores = {};

                    //validacion medicament
                    if(!valores.medicament){
                        errores.medicament = 'el campo nombre generico es requerido obligatoriamente';
                    }

                    //validacion para numberLote
                    if(!valores.numberLote){
                        errores.numberLote = 'el campo nombre comercial es requerido obligatoriamente';
                    }

                    //validacion expirationTime
                    if(!valores.expirationTime){
                        errores.expirationTime = 'el campo descripcion es requerido obligatoriamente';
                    }

                    return errores;
                }}
                onSubmit={ (valores) => {
                    const store = async (e) => {
                        console.log(valores)
                        console.log("end point: "+endPoint)
                        console.log(config.headers)
                        e.preventDefault()
                        try {
                            const response = await axios.post(endPoint, {
                                medicament: valores.medicament,
                                lotNomber: valores.numberLote,
                                expirationTime: valores.expirationTime,
                        },{
                            headers: config.headers,
                        });
                            toast.success('dato guardado con exito', {
                                position: 'top-right',
                                autoClose: 3000,      
                            });
                            navigate('/login');  
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
                        <label htmlFor='medicament'>Medicamento</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='medicament'
                            name='medicament'
                            placeholder='Escribe tu nombre del medicamento'
                            value={values.medicament}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.medicament && errors.medicament && <div className='styleErrores'>{errors.medicament}</div>}
                    </div>
                    <div>
                        <label htmlFor='numberLote'>Numero de lote</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='numberLote'    
                            name='numberLote'
                            placeholder='Escribe una pequenia descripcion'
                            value={values.numberLote}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.numberLote && errors.numberLote && <div className='styleErrores'>{errors.numberLote}</div>}
                    </div>
                    
                    <div>
                        <label htmlFor='expirationTime'>fecha de expiracion</label>
                        <input 
                            className='stylesInput'
                            type='date'
                            id='expirationTime'
                            name='expirationTime'
                            placeholder='Escribe tu laboratorio'
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
    );
}