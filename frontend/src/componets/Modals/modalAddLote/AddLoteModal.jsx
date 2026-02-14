import { Formik } from "formik";
import "./AddLoteModal.css"
import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const AddLoteModal = ({show, onHide, medication}) => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private+"/lote/add";
    const token = JSON.parse(personData).token;

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };


    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Crear Lote</Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <div className='stylesRegistroPersonal'>
                    <Formik
                        initialValues={{
                            lotNomber: '',
                            expirationTime: '',
                            quantity: '',
                            unitPrice:'',
                            salePrice:''
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
                                        medicamentId: medication.id,
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
                        {({values, errors, touched, handleSubmit, handleChange, handleBlur, resetForm, setFieldValue}) => (
                            <form onSubmit={handleSubmit}>
                            <div>
                                <strong>{medication.comercialName + " " + medication.presentation.name + " "+ medication.consetration}</strong>
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
                                    onChange={(e) => {
                                        e.target.value = e.target.value.toUpperCase();
                                        handleChange(e);
                                    }}
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
                                    type='number'
                                    id='unitPrice'    
                                    name='unitPrice'
                                    placeholder='Escribe el precio Unitario'
                                    value={values.unitPrice}
                                    onChange={(e) => {
                                        const value = parseFloat(e.target.value) || 0;

                                        // Guardar precio de compra
                                        setFieldValue('unitPrice', value);

                                        // Calcular precio de venta con 30%
                                        const sale = value * 1.3;

                                        // Redondear a 2 decimales (opcional)
                                        setFieldValue('salePrice', sale.toFixed(2));
                                    }}
                                    onBlur={handleBlur}
                                />
                                {touched.unitPrice && errors.unitPrice && <div className='styleErrores'>{errors.unitPrice}</div>}
                            </div>

                            <div>
                                <label htmlFor='salePrice'>Precio de Venta</label>
                                <input 
                                    className='stylesInput'
                                    type='number'
                                    id='salePrice'    
                                    name='salePrice'
                                    placeholder='Escribe el precio Unitario'
                                    value={values.salePrice}
                                />
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
            </Modal.Body>
        </Modal>
    </>)
}     