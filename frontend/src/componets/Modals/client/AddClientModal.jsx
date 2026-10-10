
import React from "react";
import "./AddClientModal.css";
import { Modal } from "react-bootstrap";
import { Formik, Form, Field } from "formik";
import { toast, ToastContainer } from "react-toastify";
import { clientService } from "../../../services/clientServices";
import { useQueryClient } from "@tanstack/react-query";
import * as Yup from "yup";

export const AddClientModal = ({ show, onHide }) => {

    const queryClient = useQueryClient();

    const ExistCi = async (ci) => {
        try {
            return await clientService.existCi(ci);
        } catch (error) {
            console.log(error);
            return false;
        }
    };

    const validationSchema = Yup.object({

        ci: Yup.string()
            .required("El campo Cédula de Identidad es obligatorio")
            .matches(
                /^[0-9\s]{1,9}$/,
                "El CI debe contener solamente números"
            )
            .test(
                "ci-existe",
                "El número de carnet ya fue registrado",
                async (value) => {

                    if (!value) {
                        return true;
                    }

                    const existe = await ExistCi(value);

                    return !existe;
                }
            ),

        name: Yup.string()
            .required("El campo nombre es obligatorio")
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El nombre no puede contener números ni caracteres especiales"
            ),

        surname: Yup.string()
            .required("El campo apellido es obligatorio")
            .matches(
                /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
                "El apellido no puede contener números ni caracteres especiales"
            ),

        phone: Yup.string()
            .matches(
                /^[0-9\s]{0,10}$/,
                "El teléfono no puede contener letras ni caracteres especiales"
            ),

        allergy: Yup.string(),

        notifications: Yup.boolean(),

    });

    return (
        <>
            <Modal show={show} onHide={onHide} centered>

                <Modal.Header closeButton className="modalHeader">
                    <Modal.Title>
                        Agregar Cliente
                    </Modal.Title>
                </Modal.Header>

                <Modal.Body className="modalBody">

                    <div className="stylesRegistroPersonal">

                        <Formik
                            initialValues={{
                                ci: "",
                                name: "",
                                surname: "",
                                phone: "",
                                allergy: "",
                                notifications: false,
                            }}

                            validationSchema={validationSchema}

                            onSubmit={async (
                                values,
                                { resetForm, setSubmitting }
                            ) => {

                                try {

                                    await clientService.create({
                                        ci: values.ci,
                                        name: values.name.toUpperCase(),
                                        surname: values.surname.toUpperCase(),
                                        telefono: values.phone,
                                        allergy: values.allergy,
                                        notifications: values.notifications,
                                    });

                                    await queryClient.invalidateQueries({
                                        queryKey: ["clients"],
                                    });

                                    toast.success(
                                        "Cliente registrado con éxito",
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
                                        "Error al registrar el cliente",
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

                            {({ values, errors, touched, isSubmitting }) => (

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
                                            placeholder="Escribe tu número de Carnet"
                                        />

                                        {touched.ci && errors.ci && (
                                            <div className="styleErrores">
                                                {errors.ci}
                                            </div>
                                        )}
                                    </div>


                                    {/* NOMBRE */}
                                    <div>
                                        <label htmlFor="name">
                                            Nombre
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="name"
                                            name="name"
                                            placeholder="Escribe su Nombre"
                                        />

                                        {touched.name && errors.name && (
                                            <div className="styleErrores">
                                                {errors.name}
                                            </div>
                                        )}
                                    </div>


                                    {/* APELLIDO */}
                                    <div>
                                        <label htmlFor="surname">
                                            Apellido
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="surname"
                                            name="surname"
                                            placeholder="Escribe sus Apellidos"
                                        />

                                        {touched.surname && errors.surname && (
                                            <div className="styleErrores">
                                                {errors.surname}
                                            </div>
                                        )}
                                    </div>


                                    {/* TELEFONO */}
                                    <div>
                                        <label htmlFor="phone">
                                            Teléfono
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="number"
                                            id="phone"
                                            name="phone"
                                            placeholder="Escribe su teléfono"
                                        />

                                        {touched.phone && errors.phone && (
                                            <div className="styleErrores">
                                                {errors.phone}
                                            </div>
                                        )}
                                    </div>


                                    {/* ALERGIAS */}
                                    <div>
                                        <label htmlFor="allergy">
                                            Alergias
                                        </label>

                                        <Field
                                            className="stylesInput"
                                            type="text"
                                            id="allergy"
                                            name="allergy"
                                            placeholder="Escribe su alergia"
                                        />

                                        {touched.allergy && errors.allergy && (
                                            <div className="styleErrores">
                                                {errors.allergy}
                                            </div>
                                        )}
                                    </div>


                                    {/* NOTIFICACIONES */}
                                    <div>
                                        <label htmlFor="notifications">
                                            ¿Desea recibir notificaciones?
                                        </label>

                                        <Field name="notifications">
                                            {({ field, form }) => (

                                                <select
                                                    {...field}
                                                    className="stylesInput"
                                                    id="notifications"
                                                    value={String(field.value)}
                                                    onChange={(e) =>
                                                        form.setFieldValue(
                                                            "notifications",
                                                            e.target.value === "true"
                                                        )
                                                    }
                                                >

                                                    <option value="false">
                                                        No
                                                    </option>

                                                    <option value="true">
                                                        Sí
                                                    </option>

                                                </select>

                                            )}
                                        </Field>

                                    </div>


                                    <br />


                                    {/* BOTON */}
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

