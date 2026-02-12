import React from "react";
import './AddClientModal.css'
import { URL_API_private, URL_API_public } from "../../../providerContext/EndPoint";
import { Modal} from "react-bootstrap";
import { Formik } from "formik";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

export const AddClientModal = ({show, onHide}) => {

    const endPointPrivate = URL_API_private;
    const endPointPublic = URL_API_public;

    const ExistCi = async (data) => {
        try {
            return false;
        } catch (e) {
            return true;
        }
    }

    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title> Agregar Cliente</Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <div className="stylesRegistroPersonal">
                    <Formik
                        initialValues={{
                            ci: '',
                            name: '',
                            surname: '',
                            phone: '', //Opcinal
                            Notification: 'fasle', // solo si el cliente desee recivir notificaciones

                        }}

                        validate={async (values) => {
                            
                            let errors = {};

                            //validacion Celula de Identidad
                            if(!values.ci){
                                errors.ci = 'el campo Celula de Intentidad es requerido obligatoriamente';
                            }else if(!/^[0-9\s]{1,9}$/.test(values.ci)){
                                errors.ci = 'no es un numero';
                            }else if( await ExistCi(values.ci)){
                                errors.ci = 'el numero de carnet ya fue registrado';
                            }

                            //validacion para el nombre
                            if(!values.name){
                                errors.name = 'el campo nombre es requerido obligatoriamente';
                            }else if(!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(values.anme)){
                                errors.name = 'el campo no pude tener numeros';
                            }

                            //validacion apellidos
                            if(!values.surname){
                                errors.surname = 'el campo Apellido Paterno es requerido obligatoriamente';
                            }else if(!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(values.surname)){
                                errors.surname = 'el campo no pude tener numeros';
                            }

                            //validacion Telefono
                            if(!/^[0-9\s]{1,10}$/.test(values.phone)){
                                errors.phone = 'el campo no pude tener letras o caracteres especiales';
                            }

                            return errors;
                        }}

                        onSubmit={(values) => {
                            const store = async (e) => {
                                console.log(values)
                                console.log("end point: "+endPointPrivate)
                                e.preventDefault()
                                try {
                                    await axios.post(endPointPrivate, {
                                        username: values.email,
                                        password: values.password,
                                        name: values.nombre,
                                        surname: values.apellido,
                                    });
                                    toast.success('Usuario registrado con éxito', {
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
                        {({values, errors, touched, handleSubmit, handleChange, handleBlur}) => (
                            <form onSubmit={handleSubmit}>
                                <div>
                                    <label htmlFor="ci"> Celulda de Identidad </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="ci"
                                        name="ci"
                                        placeholder="Escribe tu numero de Carnet"
                                        value={values.ci}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.ci && errors.ci && <div className="styleErrores">{errors.ci}</div>}
                                </div>
                                <div>
                                    <label htmlFor="name"> Nombre </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="name"
                                        name="name"
                                        placeholder="Escribe tu numero de Carnet"
                                        value={values.name}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.name && errors.name && <div className="styleErrores">{errors.name}</div>}
                                </div>
                                <div>
                                    <label htmlFor="surname"> Apellido </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="surname"
                                        name="surname"
                                        placeholder="Escribe tu numero de Carnet"
                                        value={values.surname}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.surname && errors.surname && <div className="styleErrores">{errors.surname}</div>}
                                </div>
                                <div>
                                    <label htmlFor="phone"> Telefono </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="phone"
                                        name="phone"
                                        placeholder="Escribe tu numero de Carnet"
                                        value={values.phone}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.phone && errors.phone && <div className="styleErrores">{errors.phone}</div>}
                                </div>
                                <div>
                                    <label htmlFor="Notification"> Desea Recibir notificaciones </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="Notification"
                                        name="Notification"
                                        placeholder="Escribe tu numero de Carnet"
                                        value={values.Notification}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.Notification && errors.Notification && <div className="styleErrores">{errors.Notification}</div>}
                                </div>
                                <br></br>
                                <div className="stylesContenedorButton">
                                    <button  className='stylesButoon' type="submit">
                                        Guardar
                                    </button>
                                    
                                </div>
                            </form>
                        )}
                    </Formik>
                    <ToastContainer/>
                </div>
            </Modal.Body>
        </Modal>
    </>);
}