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
        {id: 7, presentation: "OVULOS_VAGINALES"},
        {id: 8, presentation: "OINTMENT"},//pomada
        {id: 9, presentation: "SPRAY"},//aerosol
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
                    concentration: '',
                    farmaciForm: '',
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

                    //validacion Concentration
                    if(!valores.concentration){
                        errores.concentration = 'el campo Concentracion es requerido obligatoriamente';
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
                            placeholder='escribe el nombre generico'
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
                            onChange={(e) => {
                                e.target.value = e.target.value.toUpperCase();
                                handleChange(e);
                            }}  
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
                            placeholder='Escribe una pequeña descripcion'
                            value={values.descrption}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.descrption && errors.descrption && <div className='styleErrores'>{errors.descrption}</div>}
                    </div>
                    
                    <div>
                        <label htmlFor='presentation'>Presentacion</label>
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
                        {touched.presentation && errors.presentation && <div className='styleErrores'>{errors.presentation}</div>}
                    </div>
                    <div>
                        <label htmlFor='concentration'>Consentracion</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='concentration'
                            name='concentration'
                            placeholder='Escribe la consentracion'
                            value={values.concentration}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.concentration && errors.concentration && <div className='styleErrores'>{errors.concentration}</div>}
                    </div>
                    <div>
                        <label htmlFor='farmaciForm'>Forma farmaceutica</label>
                        <input 
                            className='stylesInput'
                            type='text'
                            id='farmaciForm'
                            name='farmaciForm'
                            placeholder='Escribe tu laboratorio'
                            value={values.farmaciForm}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.farmaciForm && errors.farmaciForm && <div className='styleErrores'>{errors.farmaciForm}</div>}
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