import { Formik } from "formik";
import React from "react";
import { Modal } from "react-bootstrap";
import axios from "axios";
import { URL_API_private } from "../../../providerContext/EndPoint";
import { toast, ToastContainer } from "react-toastify";
import "./AddLaboratoryModal.css"

export const AddLaboratoryModal = ({ show, onHide, onSuccess }) => {

    const personData = localStorage.getItem("user_data");
    const token = JSON.parse(personData).accessToken;
    const endPoint = URL_API_private+ "/laboratory/add"

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    return (
        <>
            <Modal show={show} onHide={onHide} centered>
                <Modal.Header closeButton className="modalHeader">
                    <Modal.Title>Crear Laboratorio</Modal.Title>
                </Modal.Header>

                <Modal.Body className="modalBody">
                    <div className="stylesRegistroPersonal">
                        <Formik
                            initialValues={{
                                name: "",
                                nameDistributor: "",
                                phone: "",
                                email: "",
                                address: "",
                            }}

                            validate={(values) => {
                                let errors = {};

                                if (!values.name) {
                                    errors.name = "Nombre requerido";
                                }

                                if (!values.phone) {
                                    errors.phone = "Teléfono requerido";
                                }

                                return errors;
                            }}

                            onSubmit={async (values, { resetForm }) => {
                                try {
                                    console.log(endPoint+" - "+config.headers.Authorization)
                                    await axios.post(
                                        endPoint,
                                        {
                                            name: values.name,
                                            distributorName: values.nameDistributor,
                                            phone: values.phone,
                                            email: values.email,
                                            address: values.address,
                                        },
                                        config
                                    );

                                    toast.success("Laboratorio creado");

                                    if (onSuccess) onSuccess();

                                    resetForm();

                                    setTimeout(() => {
                                        onHide();
                                    }, 1000);

                                } catch (error) {
                                    toast.error(
                                        error?.response?.data?.message || "Error"
                                    );
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
                                        {touched.name && errors.name && (
                                            <p>{errors.name}</p>
                                        )}
                                    </div>

                                    <div>
                                        <label>Distribuidor</label>
                                        <input
                                            className="stylesInput"
                                            type="text"
                                            name="nameDistributor"
                                            value={values.nameDistributor}
                                            onChange={handleChange}
                                        />
                                    </div>

                                    <div>
                                        <label>Teléfono</label>
                                        <input
                                            className="stylesInput"
                                            type="text"
                                            name="phone"
                                            value={values.phone}
                                            onChange={handleChange}
                                        />
                                        {touched.phone && errors.phone && (
                                            <p>{errors.phone}</p>
                                        )}
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

                                    <br />

                                    <button className="stylesButoon" type="submit">
                                        Guardar
                                    </button>

                                </form>
                            )}
                        </Formik>

                    </div>
                    
                    <ToastContainer />
                </Modal.Body>
            </Modal>
        </>
    );
};