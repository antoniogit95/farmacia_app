import React from "react";
import "./AddClientModal.css";
import { Modal } from "react-bootstrap";
import { Formik } from "formik";
import { toast, ToastContainer } from "react-toastify";
import { useQueryClient } from "@tanstack/react-query";
import * as Yup from "yup";

import { clientService } from "../../../services/clientServices";


export const EditClientModal = ({ show, onHide, client }) => {

    const queryClient = useQueryClient();

    const initialValues = {
        ci: client?.nit || "",
        name: client?.person?.name || "",
        surname: client?.person?.surname || "",
        phone: client?.person?.telefono || "",
        allergy: client?.allergy || "",
        notifications: client?.notifications ?? false,
    };

    const validationSchema = Yup.object({

        ci: Yup.string()
            .required(
                "El campo Cédula de Identidad es obligatorio"
            )
            .matches(
                /^[0-9\s]{1,9}$/,
                "El CI debe contener solamente números"
            ),

        name: Yup.string()
            .required(
                "El campo nombre es obligatorio"
            )
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El nombre no puede contener números"
            ),

        surname: Yup.string()
            .required(
                "El campo apellido es obligatorio"
            )
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El apellido no puede contener números"
            ),

        phone: Yup.string()
            .matches(
                /^[0-9\s]{0,10}$/,
                "El teléfono no puede contener letras o caracteres especiales"
            ),

        allergy: Yup.string(),

        notifications: Yup.boolean(),

    });

    if (!client) {
        return null;
    }

    return (<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header
                closeButton
                className="modalHeader"
            >

            <Modal.Title> Editar Cliente </Modal.Title>
            
            </Modal.Header>

                <Modal.Body className="modalBody">

                    <div className="stylesRegistroPersonal">

                        <Formik

                            enableReinitialize={true}
                            initialValues={initialValues}
                            validationSchema={validationSchema}

                            onSubmit={async (
                                values,
                                {
                                    resetForm,
                                    setSubmitting
                                }
                            ) => {

                                try {

                                    console.log(
                                        "Datos a actualizar:",
                                        values
                                    );

                                    await clientService.update({

                                        id: client.id,

                                        client: {
                                            ci: values.ci,
                                            name: values.name,
                                            surname: values.surname,
                                            telefono: values.phone,
                                            allergy: values.allergy,
                                            notifications: values.notifications,
                                        },

                                    });

                                    await queryClient.invalidateQueries({
                                        queryKey: ["clients"],
                                    });

                                    toast.success(
                                        "Cliente actualizado con éxito",
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
                                        "Error al actualizar el cliente",
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
                                values,
                                errors,
                                touched,
                                handleSubmit,
                                handleChange,
                                handleBlur,
                                isSubmitting
                            }) => (

                                <form
                                    onSubmit={handleSubmit}
                                >

                                    <div>

                                        <label htmlFor="ci">
                                            Cédula de Identidad
                                        </label>

                                        <input
                                            className="stylesInput"
                                            type="text"
                                            id="ci"
                                            name="ci"
                                            placeholder="Escribe tu número de Carnet"

                                            value={values.ci}

                                            onChange={(e) => {

                                                e.target.value =
                                                    e.target.value.toUpperCase();

                                                handleChange(e);

                                            }}

                                            onBlur={handleBlur}
                                        />


                                        {touched.ci &&
                                            errors.ci && (
                                                <div className="styleErrores">
                                                    {errors.ci}
                                                </div>
                                            )
                                        }

                                    </div>

                                    <div>

                                        <label htmlFor="name">
                                            Nombre
                                        </label>

                                        <input
                                            className="stylesInput"
                                            type="text"
                                            id="name"
                                            name="name"
                                            placeholder="Escribe su Nombre"

                                            value={values.name}

                                            onChange={(e) => {

                                                e.target.value =
                                                    e.target.value.toUpperCase();

                                                handleChange(e);

                                            }}

                                            onBlur={handleBlur}
                                        />


                                        {touched.name &&
                                            errors.name && (
                                                <div className="styleErrores">
                                                    {errors.name}
                                                </div>
                                            )
                                        }

                                    </div>

                                    <div>

                                        <label htmlFor="surname">
                                            Apellido
                                        </label>

                                        <input
                                            className="stylesInput"
                                            type="text"
                                            id="surname"
                                            name="surname"
                                            placeholder="Escribe sus Apellidos"

                                            value={values.surname}

                                            onChange={(e) => {

                                                e.target.value =
                                                    e.target.value.toUpperCase();

                                                handleChange(e);

                                            }}

                                            onBlur={handleBlur}
                                        />


                                        {touched.surname &&
                                            errors.surname && (
                                                <div className="styleErrores">
                                                    {errors.surname}
                                                </div>
                                            )
                                        }

                                    </div>

                                    <div>

                                        <label htmlFor="phone">
                                            Teléfono
                                        </label>

                                        <input
                                            className="stylesInput"
                                            type="text"
                                            id="phone"
                                            name="phone"
                                            placeholder="Escribe su teléfono"

                                            value={values.phone}

                                            onChange={handleChange}

                                            onBlur={handleBlur}
                                        />


                                        {touched.phone &&
                                            errors.phone && (
                                                <div className="styleErrores">
                                                    {errors.phone}
                                                </div>
                                            )
                                        }

                                    </div>

                                    <div>

                                        <label htmlFor="allergy">
                                            Alergias
                                        </label>

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

                                    </div>

                                    <div>

                                        <label>
                                            ¿Desea recibir notificaciones?
                                        </label>


                                        <select
                                            className="stylesInput"
                                            name="notifications"

                                            value={String(
                                                values.notifications
                                            )}

                                            onChange={(e) =>
                                                handleChange({
                                                    target: {
                                                        name: "notifications",
                                                        value:
                                                            e.target.value ===
                                                            "true",
                                                    },
                                                })
                                            }

                                            onBlur={handleBlur}
                                        >

                                            <option value="false">
                                                No
                                            </option>

                                            <option value="true">
                                                Sí
                                            </option>

                                        </select>

                                    </div>


                                    <br />

                                    <div className="stylesContenedorButton">

                                        <button
                                            className="stylesButoon"
                                            type="submit"
                                            disabled={isSubmitting}
                                        >

                                            {isSubmitting
                                                ? "Guardando..."
                                                : "Guardar"
                                            }

                                        </button>

                                    </div>


                                </form>

                            )}

                        </Formik>

                    </div>

                </Modal.Body>


            </Modal>


            <ToastContainer />

        </>
    );
};