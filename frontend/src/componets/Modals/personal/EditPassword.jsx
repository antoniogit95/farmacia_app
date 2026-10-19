
import { useQueryClient } from "@tanstack/react-query";
import React from "react";
import { Modal } from "react-bootstrap";
import * as Yup from "yup";
import { Form, Formik, Field } from "formik";
import { toast, ToastContainer } from "react-toastify";
import { personalService } from "../../../services/personalService";


export const EditPassword = ({ show, onHide, person }) => {

    const queryClient = useQueryClient();

    const initialValues = {
        ci: person?.person?.ci || "",
        username: person?.username || "",
    };

    // Validaciones
    const validationSchema = Yup.object({
        password: Yup.string()
            .required(
                "El campo Contraseña es obligatorio"
                )
            .min(
                6,
                    "La contraseña debe tener al menos 6 caracteres"
                ),
        
        confirmar_password: Yup.string()
            .required(
                "El campo Confirmar Contraseña es obligatorio"
            )
            .oneOf(
                [Yup.ref("password")],
                "Las contraseñas no coinciden"
            ),
        
    });


    // Si no hay una persona seleccionada
    if (!person) {
        return null;
    }


    return (
        <>
            <Modal
                show={show}
                onHide={onHide}
                centered
            >

                <Modal.Header
                    closeButton
                    className="modalHeader"
                >

                    <Modal.Title>
                        Editar Personal
                    </Modal.Title>

                </Modal.Header>


                <Modal.Body className="modalBody">

                    <div className="stylesRegistroPersonal">

                        <Formik

                            enableReinitialize={true}

                            initialValues={initialValues}

                            validationSchema={validationSchema}

                            onSubmit={async (
                                values,
                                { resetForm, setSubmitting }
                            ) => {

                                try {

                                    await personalService.update({

                                        id: person.id,

                                        person: {
                                            ci: values.ci,
                                            username: values.username,
                                            password: values.password,
                                        }

                                    });

                                    // Actualizar la lista de usuarios
                                    await queryClient.invalidateQueries({
                                        queryKey: ["users"],
                                    });

                                    toast.success(
                                        "Contrasenia actualizado con éxito",
                                        {
                                            position: "top-right",
                                            autoClose: 3000,
                                        }
                                    );

                                    resetForm();

                                    setTimeout(() => {
                                        onHide();
                                    }, 1000);


                                } catch (error) {

                                    console.error(error);

                                    toast.error(
                                        error.response?.data?.message ||
                                        "Error al actualizar el personal",
                                        {
                                            position: "top-right",
                                            autoClose: 3000,
                                        }
                                    );

                                } finally {

                                    setSubmitting(false);

                                }

                            }}

                        >

                            {({
                                errors,
                                touched,
                                isSubmitting
                            }) => (

                                <Form>
                                    <div>

                                        <label htmlFor="ci">
                                            Cédula de Identidad
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="ci"
                                            name="ci"
                                            readOnly
                                        />

                                    </div>

                                    <div>

                                        <label htmlFor="username">
                                            Usuario
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="username"
                                            name="username"
                                            placeholder="Escriba el usuario"
                                        />

                                        {touched.username &&
                                            errors.username && (

                                                <div className="styleErrores">
                                                    {errors.username}
                                                </div>

                                            )}

                                    </div>

                                    <div>
                                        <label htmlFor='password'>Contraseña</label>
                                        <Field 
                                            className='stylesInput'
                                            type='password'
                                            id='password'
                                            name='password'
                                            placeholder='Escribe tu Contraseña'
                                        />
                                        {touched.password && errors.password &&(
                                            <div className='styleErrores'>{errors.password}</div>
                                        )}
                                    </div>
                                    <div>
                                        <label htmlFor='confirmar_password'>Confirmar contraseña</label>
                                        <Field 
                                            className='stylesInput'
                                            type='password'
                                            id='confirmar_password'
                                            name='confirmar_password'
                                            placeholder='Vuelva a escribir su Contraseña'
                                        />
                                        {touched.confirmar_password && errors.confirmar_password &&(
                                            <div className='styleErrores'>{errors.confirmar_password}</div>
                                        ) }
                                    </div>
                                    <br></br>                                           
                                    <div className="stylesContenedorButton">

                                        <button
                                            className="stylesButoon"
                                            type="submit"
                                            disabled={isSubmitting}
                                        >

                                            {isSubmitting
                                                ? "Actualizando..."
                                                : "Actualizar"
                                            }

                                        </button>

                                    </div>


                                </Form>

                            )}

                        </Formik>


                        <ToastContainer />

                    </div>

                </Modal.Body>

            </Modal>
        </>
    );
};
