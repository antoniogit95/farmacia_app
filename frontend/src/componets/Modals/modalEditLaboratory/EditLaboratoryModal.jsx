import { Formik } from "formik";
import React from "react";
import { Modal } from "react-bootstrap";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";
import { URL_API_private } from "../../../providerContext/EndPoint";

export const EditLaboratoryModal = ({ show, onHide, laboratory, onSuccess }) => {

    const personData = JSON.parse(localStorage.getItem('user_data'));
    const token = personData?.accessToken;

    const endPoint = URL_API_private + "/laboratory/update/" + laboratory?.id;

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    if (!laboratory) return null;

    return (
        <>
            <Modal show={show} onHide={onHide} centered>
                <Modal.Header closeButton className="modalHeader">
                    <Modal.Title>Editar Laboratorio</Modal.Title>
                </Modal.Header>

                <Modal.Body className="modalBody">
                    <Formik
                        enableReinitialize
                        initialValues={{
                            name: laboratory.name || "",
                            nameDistribuidor: laboratory.distributorName || "",
                            telefono: laboratory.phone || "",
                            address: laboratory.address || "",
                            email: laboratory.email || "",
                        }}

                        validate={(values) => {
                            let errors = {};

                            if (!values.name) {
                                errors.name = "Nombre es obligatorio";
                            }

                            return errors;
                        }}

                        onSubmit={async (values) => {
                            try {
                                await axios.put(endPoint, {
                                    name: values.name,
                                    distributorName: values.nameDistribuidor,
                                    phone: values.telefono,
                                    address: values.address,
                                    email: values.email,
                                }, config);

                                toast.success("Laboratorio actualizado", {
                                    autoClose: 2000,
                                });

                                if (onSuccess) onSuccess();

                                setTimeout(() => {
                                    onHide();
                                }, 1000);

                            } catch (error) {
                                console.error(error);
                                toast.error("Error al actualizar");
                            }
                        }}
                    >
                        {({
                            values,
                            errors,
                            touched,
                            handleSubmit,
                            handleChange,
                            handleBlur
                        }) => (
                            <form onSubmit={handleSubmit}>

                                <div>
                                    <label>Nombre</label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        name="name"
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
                                    <label>Distribuidor</label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        name="nameDistribuidor"
                                        value={values.nameDistribuidor}
                                        onChange={(e) => {
                                            e.target.value = e.target.value.toUpperCase();
                                            handleChange(e);
                                        }}
                                    />
                                </div>

                                <div>
                                    <label>Teléfono</label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        name="telefono"
                                        value={values.telefono}
                                        onChange={handleChange}
                                    />
                                </div>

                                <div>
                                    <label>Dirección</label>
                                    <input
                                        className="stylesInput"
                                        type="text"
                                        name="address"
                                        value={values.address}
                                        onChange={handleChange}
                                    />
                                </div>

                                <div>
                                    <label>Email</label>
                                    <input
                                        className="stylesInput"
                                        type="email"
                                        name="email"
                                        value={values.email}
                                        onChange={handleChange}
                                    />
                                </div>

                                <br />

                                <div className="stylesContenedorButton">
                                    <button className="stylesButoon" type="submit">
                                        Actualizar
                                    </button>
                                </div>

                            </form>
                        )}
                    </Formik>

                    <ToastContainer />
                </Modal.Body>
            </Modal>
        </>
    );
};