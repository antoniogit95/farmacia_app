
import { useQueryClient } from "@tanstack/react-query";
import React from "react";
import { Modal } from "react-bootstrap";
import * as Yup from "yup";
import { Form, Formik, Field } from "formik";
import { toast, ToastContainer } from "react-toastify";
import { personalService } from "../../../services/personalService";


export const EditPersonModal = ({ show, onHide, person }) => {

    const queryClient = useQueryClient();

    console.log(person)

    // Valores iniciales
    const initialValues = {
        ci: person?.person?.ci || "",
        name: person?.person?.name || "",
        surname: person?.person?.surname  || "",
        telefono: person?.person?.telefono || "",
        username: person?.username || "",
    };


    // Validaciones
    const validationSchema = Yup.object({

        name: Yup.string()
            .required(
                "El campo nombre es obligatorio"
            )
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El nombre no puede contener números ni caracteres especiales"
            ),

        surname: Yup.string()
            .required(
                "El campo apellido es obligatorio"
            )
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El apellido no puede contener números ni caracteres especiales"
            ),

        telefono: Yup.string()
            .matches(
                /^[0-9\s]{0,10}$/,
                "El teléfono no puede contener letras ni caracteres especiales"
            ),

        username: Yup.string()
            .required(
                "El campo usuario es obligatorio"
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
                                            name: values.name.toUpperCase(),
                                            surname: values.surname.toUpperCase(),
                                            telefono: values.telefono,
                                            username: values.username,
                                        }

                                    });


                                    // Actualizar la lista de usuarios
                                    await queryClient.invalidateQueries({
                                        queryKey: ["users"],
                                    });


                                    toast.success(
                                        "Personal actualizado con éxito",
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


                                    {/* CI */}

                                    <div>

                                        <label htmlFor="ci">
                                            Cédula de Identidad
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="ci"
                                            name="ci"
                                            placeholder="Escriba el número de carnet"
                                        />

                                        {touched.ci &&
                                            errors.ci && (

                                                <div className="styleErrores">
                                                    {errors.ci}
                                                </div>

                                            )}

                                    </div>


                                    {/* NOMBRES */}

                                    <div>

                                        <label htmlFor="name">
                                            Nombres
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="name"
                                            name="name"
                                            placeholder="Escriba los nombres"
                                        />

                                        {touched.name &&
                                            errors.name && (

                                                <div className="styleErrores">
                                                    {errors.name}
                                                </div>

                                            )}

                                    </div>


                                    {/* APELLIDOS */}

                                    <div>

                                        <label htmlFor="surname">
                                            Apellidos
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="surname"
                                            name="surname"
                                            placeholder="Escriba los apellidos"
                                        />

                                        {touched.surname &&
                                            errors.surname && (

                                                <div className="styleErrores">
                                                    {errors.surname}
                                                </div>

                                            )}

                                    </div>


                                    {/* TELEFONO */}

                                    <div>

                                        <label htmlFor="telefono">
                                            Teléfono
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="telefono"
                                            name="telefono"
                                            placeholder="Escriba el teléfono"
                                        />

                                        {touched.telefono &&
                                            errors.telefono && (

                                                <div className="styleErrores">
                                                    {errors.telefono}
                                                </div>

                                            )}

                                    </div>


                                    {/* USUARIO */}

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

                                    <br />

                                    {/* BOTÓN */}

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
