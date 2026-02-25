import { Formik } from "formik";
import "./AddLoteModal.css"
import React, { useEffect, useState } from "react";
import { Modal } from "react-bootstrap";
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const AddLoteModal = ({show, onHide, medication, onSuccess}) => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private+"/lote/add";
    const endPointList = URL_API_private+"/lote";
    const token = JSON.parse(personData).accessToken;
    const [lotes, setLotes] = useState([]);

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    useEffect(() => {
        if (show && medication?.id) {
            getLotes();
        }
    }, [show, medication]);

    const getLotes = async () => {
        try {
            const response = await axios.get(`${endPointList}/${medication.id}`, config);
            setLotes(response.data);
        } catch (error) {
            console.log(error);
        }
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
                            salePrice:'',
                            status: 'false'
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
                                console.log(valores)
                                try {
                                    const response = await axios.post(endPoint, {
                                        medicamentId: medication.id,
                                        lotNomber: valores.lotNomber,
                                        expirationTime: valores.expirationTime,
                                        unitPrice: valores.unitPrice,
                                        quantity: valores.quantity,
                                        salePrice: valores.salePrice,
                                        status: valores.status,
                                },{
                                    headers: config.headers,
                                });
                                    toast.success('dato guardado con exito', {
                                        position: 'top-right',
                                        autoClose: 3000,      
                                    });
                                    //if (onSuccess) onSuccess();
                                    setTimeout(() => {
                                        onHide();
                                    }, 1000) 
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
                                {lotes.length > 0 ? (
                                    <div className="lotesList">
                                        <strong>Lotes registrados:</strong>
                                        {lotes.map((lote) => (
                                            <div key={lote.id} className="loteItem">
                                                <span><strong>Lote:</strong> {lote.lotNomber}</span>
                                                <span><strong> Cantidad:</strong> {lote.quantity}</span>
                                                <span><strong> Expira:</strong> {lote.expirationTime}</span>
                                            </div>
                                        ))}
                                    </div>
                                ) : (
                                    <div className="noLotes">
                                        ⚠️ No hay lotes disponibles para este medicamento
                                    </div>
                                )}
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
                            <div>
                                <label>Tiene Factura?</label>

                                <select
                                    className="stylesInput"
                                    name="status"
                                    value={values.status}
                                    onChange={(e) =>
                                        handleChange({
                                            target: {
                                                name: "status",
                                                value: e.target.value === "true",   
                                            }
                                        })
                                    }
                                >
                                    <option value="false">No</option>
                                    <option value="true">Sí</option>
                                </select>
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