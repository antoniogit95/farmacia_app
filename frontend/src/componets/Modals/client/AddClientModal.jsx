import React from "react";
import './AddClientModal.css'
import { Modal} from "react-bootstrap";
import { Formik } from "formik";
import { toast, ToastContainer } from "react-toastify";
import { clientService } from "../../../services/clientServices";
import { useQueryClient } from "@tanstack/react-query";

export const AddClientModal = ({show, onHide}) => {
    const queryClient = useQueryClient();

    const ExistCi = async (ci) => {
        try {
            return await clientService.existCi(ci);
        } catch (error) {
            console.log(error);
            return false;
        }
    };

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
                            allergy: '', //Opcional
                            notifications: false, // solo si el cliente desee recivir notificaciones

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
                            }else if(!/^[a-zA-ZÀ-ÿ\s]{1,40}$/.test(values.name)){
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

                        onSubmit={async (values, { resetForm }) => {

                            console.log(values);

                            try {

                                await clientService.create({
                                    ci: values.ci,
                                    name: values.name,
                                    surname: values.surname,
                                    telefono: values.phone,
                                    allergy: values.allergy,
                                    notifications: values.notifications,
                                });

                                // Avisamos a React Query que la lista cambió
                                await queryClient.invalidateQueries({
                                    queryKey: ["clients"],
                                });

                                toast.success("Usuario registrado con éxito", {
                                    position: "top-right",
                                    autoClose: 3000,
                                });

                                resetForm();

                                setTimeout(() => {
                                    onHide();
                                }, 1000);

                            } catch (error) {

                                console.error(error);

                                toast.error(
                                    error.response?.data?.message ||
                                    "Error al registrar el cliente",
                                    {
                                        position: "top-right",
                                        autoClose: 3000,
                                    }
                                );
                            }
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
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}
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
                                        placeholder="Escribe su Nombre"
                                        value={values.name}
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}
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
                                        placeholder="Escribe sus Apellidos"
                                        value={values.surname}
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}
                                        onBlur={handleBlur}
                                    />
                                    {touched.surname && errors.surname && <div className="styleErrores">{errors.surname}</div>}
                                </div>
                                <div>
                                    <label htmlFor="phone"> Telefono </label>
                                    <input
                                        className="stylesInput"
                                        type="number"
                                        id="phone"
                                        name="phone"
                                        placeholder="Escribe su telefono"
                                        value={values.phone}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.phone && errors.phone && <div className="styleErrores">{errors.phone}</div>}
                                </div>
                                <div>
                                    <label htmlFor="phone"> Alergias </label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        id="allergy"
                                        name="allergy"
                                        placeholder="Escribe su alergia"
                                        value={values.allergy}
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                    />
                                    {touched.phone && errors.phone && <div className="styleErrores">{errors.phone}</div>}
                                </div>
                                <div>
                                    <label>¿Desea recibir notificaciones?</label>
                                    <select
                                        className="stylesInput"
                                        name="notifications"
                                        value={String(values.notifications)}
                                        onChange={(e) =>
                                            handleChange({
                                                target: {
                                                    name: "notifications",
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
                            </form>
                        )}
                    </Formik>
                    <ToastContainer/>
                </div>
            </Modal.Body>
        </Modal>
    </>);
}