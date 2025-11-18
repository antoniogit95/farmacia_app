import React from "react";
import { Formik, Field } from 'formik';
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import {ToastContainer, toast } from 'react-toastify';


export const FormsAddMedication = () => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private + "/medicament/add";
    const token = JSON.parse(personData).token;

    const sugesRole = [
        {id: 1, presentation: "CAPSULES"},//comprmidos
        {id: 2, presentation: "TABLETS"},//tabletas
        {id: 3, presentation: "SYRUP"},//jarabe
        {id: 4, presentation: "INJECTION"},//injeccion
        {id: 5, presentation: "DROPS"},//gotas
        {id: 6, presentation: "CREAM"},//crema
        {id: 7, presentation: "OINTMENT"},//pomada
        {id: 8, presentation: "SPRAY"},//aerosol
    ];

    const config = {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    };

    return(
        <div className=''>
            <Formik
                initialValues={{
                    genericName: '',
                    comercialName: '',
                    descrption: '',
                    presentation:'CAPSULES',
                    laboratory: '',
                }}

                validate={async (valores) => {
                    let errores = {};

                    //validacion generc name
                    if(!valores.genericName){
                        errores.genericName = 'el campo nombre generico es requerido obligatoriamente';
                    }

                    //validacion para ecomercial name
                    if(!valores.comercialName){
                        errores.comercialName = 'el campo nombre comercial es requerido obligatoriamente';
                    }

                    //validacion descrption
                    if(!valores.descrption){
                        errores.descrption = 'el campo descripcion es requerido obligatoriamente';
                    }

                    //validacion laboratory
                    if(!valores.laboratory){
                        errores.laboratory = 'el campo laboratorio es requerido obligatoriamente';
                    }
                    return errores;
                }}
                onSubmit={ (valores) => {
                    const store = async (e) => {
                        console.log(valores)
                        console.log("end point: "+endPoint)
                        console.log(config.headers)
                        e.preventDefault()
                        try {
                            const response = await axios.post(endPoint, {
                                genericName: valores.genericName,
                                comercialName: valores.comercialName,
                                descrption: valores.descrption,
                                presentation: valores.presentation,
                                laboratory: valores.laboratory
                        },{
                            headers: config.headers,
                        });
                            toast.success('dato guardado con exito', {
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
                {({values, errors, touched, handleSubmit, handleChange, handleBlur, resetForm}) => (
                    <form onSubmit={handleSubmit}>
                    
                    <div>
                        <label htmlFor='genericName'>Nombre generico</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='genericName'
                            name='genericName'
                            placeholder='escribe tu numero de carnet'
                            value={values.genericName}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.genericName && errors.genericName && <div className='styleErrores'>{errors.genericName}</div>}
                    </div>
                    <div>
                        <label htmlFor='comercialName'>Nombre Comercial</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='comercialName'
                            name='comercialName'
                            placeholder='Escribe tu nombre comercial'
                            value={values.comercialName}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.comercialName && errors.comercialName && <div className='styleErrores'>{errors.comercialName}</div>}
                    </div>
                    <div>
                        <label htmlFor='descrption'>Descripcion</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='descrption'    
                            name='descrption'
                            placeholder='Escribe una pequenia descripcion'
                            value={values.descrption}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.descrption && errors.descrption && <div className='styleErrores'>{errors.descrption}</div>}
                    </div>
                    
                    <div>
                        <label htmlFor='presentation'>Role</label>
                        <Field
                            as='select'
                            className='stylesInput'
                            id='presentation'
                            name='presentation'
                         >
                            <option value='' disabled>Selecciona un role</option>
                                {sugesRole.map((exposición) => (
                                    <option key={exposición.id} value={exposición.presentation}>
                                        {exposición.presentation}
                                    </option>
                                ))}
                        </Field>
                        {touched.role && errors.role && <div className='styleErrores'>{errors.role}</div>}
                    </div>
                    <div>
                        <label htmlFor='laboratory'>laboratorio</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='laboratory'
                            name='laboratory'
                            placeholder='Escribe tu laboratorio'
                            value={values.laboratory}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.laboratory && errors.laboratory && <div className='styleErrores'>{errors.laboratory}</div>}
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
    );
}