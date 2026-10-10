import { Field, Formik } from "formik";
import React from "react";
import { Modal } from "react-bootstrap";
import { toast, ToastContainer } from "react-toastify";
import { URL_API_public } from "../../../providerContext/EndPoint";
import axios from "axios";
import { useQueryClient } from "@tanstack/react-query";
import { personalService } from "../../../services/personalService";
import * as Yup from "yup";

export const PersonalModal = ({ show, onHide }) => {

    const queryClient = useQueryClient();

     const existCi = async (ci) => {
            try {
                return await personalService.existCi(ci);
            } catch (error) {
                console.log(error);
                return false;
            }
    };

    const existUser = async (user) => {
        try {
            return await personalService.existUsername(user)
        } catch (error) {
            console.log(error)
            return false;
        }
    }

    const emailExistente = async (dato) => {
        try {
            const response = await axios.post(endPointP+"/checkusername", 
                {
                    username : dato,
                    password : ""
                })
            return response.data;
        } catch (e) {
            console.error(e)
            return true;
        }
    }


    const sugesRole = [
        {id: 1, role: "ADMIN"},
        {id: 2, role: "PHARMACIST"},
    ];

    const validationScheme = Yup.object({

        ci: Yup.string()
            .required( "El campo Cedula de Identidad es obligatorio" )
            .matches( /^[0-9\s]{1,9}$/, "El CI debe contener solo numeros")
            .test(
                "ci-existe",
                "El numero de carnet ya fue registrado",
                async (value) => {
                    if (!value){
                        return true;
                    }
                    const existe = await existCi(value);
                    return !existe;
                }
            ) ,

        nombre: Yup.string() 
            .required( "El campo nombre es obligatorio" ) 
            .matches( /^[a-zA-ZÀ-ÿ\s]{1,40}$/, 
                "El nombre no puede contener números ni caracteres especiales" 
            ),

        apellidos: Yup.string() 
            .required( "El campo apellido es obligatorio" ) 
            .matches( /^[a-zA-ZÀ-ÿ\s]{1,40}$/, 
                    "El apellido no puede contener números ni caracteres especiales" 
            ), 

        telefono: Yup.string() 
            .matches( /^[0-9\s]{0,10}$/, 
                "El teléfono no puede contener letras ni caracteres especiales" 
            ),

        user: Yup.string()
            .required("El usuario es obligatorio")
            .test(
                "username-existente",
                "El nombre de usuario ya fue registrado",
                async (value) => {

                    if (!value) {
                        return true;
                    }

                    const existe = await existUser(value);

                    return !existe;
                }
        ),

        /**email: Yup.string()
            .required(
                "El campo Correo Electrónico es obligatorio"
            )
            .email(
                "Ingrese un correo electrónico válido"
            )
            .test(
                "email-existente",
                "El correo electrónico ya fue registrado",
                async (value) => {
                    if (!value) {
                        return true;
                    }

                const existe = await emailExistente(value);

                return !existe;
            }
        ),**/

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
    })

    return(<>
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton className="modalHeader">
                <Modal.Title>Crear Usuario</Modal.Title>
            </Modal.Header>
            <Modal.Body className="modalBody">
                <div className='stylesRegistroPersonal'>
                    <Formik
                        initialValues={{
                            ci: '',
                            nombre: '',
                            apellidos: '',
                            telefono: '',
                            role:'PHARMACIST',
                            //fecha_nacimiento: '',
                            user: '',
                            email: '',
                            password: '',
                            confirmar_password: '',  
                        }}

                        validationSchema={validationScheme}

                        onSubmit={ async (valores, {resetForm, setSubmitting}) => {
                            console.log("imprimir mensaje que llego aqui");
                            try {

                                await personalService.create({
                                    username: valores.user,
                                    password: valores.password,
                                    name: valores.nombre.toUpperCase(),
                                    surname: valores.apellidos.toUpperCase(),
                                    ci: valores.ci,
                                    email: valores.user,
                                    telefono: valores.telefono,
                                    role: valores.role,
                                });
                                    
                                await queryClient.invalidateQueries({
                                    queryKey: ["personal"],
                                });

                                toast.success('Usuario registrado con éxito', {
                                    position: 'top-right',
                                    autoClose: 3000,      
                                });

                                resetForm();

                                setTimeout(() => {
                                    onHide();
                                }, 1000);

                            } catch (error) {
                                console.log(error)
                                console.log("mensaje")
                                toast.error(error.code, {
                                    position: 'top-right', 
                                    autoClose: 3000,  
                                });
                            } finally {
                                setSubmitting(false);
                            }
                                
                        }}

                    >
                        {({values, errors, touched, handleSubmit, handleChange, handleBlur, resetForm}) => (
                            <form onSubmit={handleSubmit}>
                            
                            <div>
                                <label htmlFor='ci'>Celula de Identidad</label>
                                <input 
                                    className='stylesInput'
                                    type='text'
                                    id='ci'
                                    name='ci'
                                    placeholder='escribe tu numero de carnet'
                                    value={values.ci}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.ci && errors.ci && <div className='styleErrores'>{errors.ci}</div>}
                            </div>
                            <div>
                                <label htmlFor='nombre'>nombres</label>
                                <input 
                                    className='stylesInput'
                                    type='text'
                                    id='nombre'
                                    name='nombre'
                                    placeholder='Escribe tu nombre'
                                    value={values.nombre}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.nombre && errors.nombre && <div className='styleErrores'>{errors.nombre}</div>}
                            </div>
                            <div>
                                <label htmlFor='apellidos'>Apellidos</label>
                                <input 
                                    className='stylesInput'
                                    type='text'
                                    id='apellidos'    
                                    name='apellidos'
                                    placeholder='Escribe tu apellido paterno y materno'
                                    value={values.apellidos}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.apellidos && errors.apellidos && <div className='styleErrores'>{errors.apellidos}</div>}
                            </div>
                            <div>
                                <label htmlFor='telefono'>Telefono</label>
                                <input 
                                    className='stylesInput'
                                    type='text'
                                    id='telefono'
                                    name='telefono'
                                    placeholder='Escribe tu numero de Telefono Corporativo'
                                    value={values.telefono}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.telefono && errors.telefono && <div className='styleErrores'>{errors.telefono}</div>}
                            </div>
                            {/** 
                            <div>
                                <label htmlFor='fecha_nacimiento'>Fecha nacimiento</label>
                                <input 
                                    className='stylesInput'
                                    type='date'
                                    id='fecha_nacimiento'
                                    name='fecha_nacimiento'
                                    placeholder='dd/mm/aaaa'
                                    value={values.fecha_nacimiento}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.fecha_nacimiento && errors.fecha_nacimiento && <div className='styleErrores'>{errors.fecha_nacimiento}</div>}
                            </div>
                            */}
                            <div>
                                <label htmlFor='role'>Role</label>
                                <Field
                                    as='select'
                                    className='stylesInput'
                                    id='role'
                                    name='role'
                                >
                                    <option value='' disabled>Selecciona un role</option>
                                        {sugesRole.map((cargo) => (
                                            <option key={cargo.id} value={cargo.role}>
                                                {cargo.role}
                                            </option>
                                        ))}
                                </Field>
                                {touched.role && errors.role && <div className='styleErrores'>{errors.role}</div>}
                            </div>
                            <div>
                                <label htmlFor='user'>Usuario</label>
                                <input 
                                    className='stylesInput'
                                    type='text'
                                    id='user'
                                    name='user'
                                    placeholder='Escribe tu Usuario'
                                    value={values.user}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.user && errors.user && <div className='styleErrores'>{errors.user}</div>}
                            </div>
                            <div>
                                <label htmlFor='password'>Contraseña</label>
                                <input 
                                    className='stylesInput'
                                    type='password'
                                    id='password'
                                    name='password'
                                    placeholder='Escribe tu Contraseña'
                                    value={values.password}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.password && errors.password && <div className='styleErrores'>{errors.password}</div>}
                            </div>
                            <div>
                                <label htmlFor='confirmar_password'>Confirmar contraseña</label>
                                <input 
                                    className='stylesInput'
                                    type='password'
                                    id='confirmar_password'
                                    name='confirmar_password'
                                    placeholder='Vuelva a escribir su Contraseña'
                                    value={values.confirmar_password}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                                {touched.confirmar_password && errors.confirmar_password && <div className='styleErrores'>{errors.confirmar_password}</div>}
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
                    <ToastContainer />
                </div>
            </Modal.Body>
        </Modal>
    </>)
}     