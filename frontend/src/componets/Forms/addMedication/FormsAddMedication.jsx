import React, { useEffect, useState } from "react";
import { Formik, Field } from 'formik';
import { URL_API_private } from "../../../providerContext/EndPoint";
import axios from 'axios';
import {ToastContainer, toast } from 'react-toastify';


export const FormsAddMedication = () => {

    const personData = localStorage.getItem('user_data');
    const endPoint = URL_API_private + "/medicament/add";
    const token = JSON.parse(personData).token;
    const [presentations, setPresentations] = useState([]);
    const [showSuggestions, setShowSuggestions] = useState(false);
    const [filtered, setFieltered] = useState([]);
    const sugesRole = [];

    useEffect(() =>{
        const fetchData = async () => {
            const response = await axios.get(URL_API_private+"/presentation/list", {
                headers: config.headers
            });
            setPresentations(response.data);
        }
        fetchData();
    }, [])

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
                    presentation:'',
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
                onSubmit={ (valores, {resetForm}) => {
                    const store = async (e) => {
                        e.preventDefault()
                        try {
                            const response = await axios.post(endPoint, {
                                genericName: valores.genericName,
                                comercialName: valores.comercialName,
                                descrption: valores.descrption,
                                consetration: valores.concentration,
                                pharmaceForm: valores.farmaciForm,
                                presentation: valores.presentation,
                                laboratory: valores.laboratory,
                        },{
                            headers: config.headers,
                        });
                            toast.success('dato guardado con exito', {
                                position: 'top-right',
                                autoClose: 3000,      
                            });
                            resetForm();  
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
                            onChange={(e) => {
                                e.target.value = e.target.value.toUpperCase();
                                handleChange(e);
                            }}
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
                            onChange={(e) => {
                                e.target.value = e.target.value.toUpperCase();
                                handleChange(e);
                            }}
                            onBlur={handleBlur}
                        />
                        {touched.descrption && errors.descrption && <div className='styleErrores'>{errors.descrption}</div>}
                    </div>
                    
                    <div>
                        <label htmlFor='presentation'>Presentacion</label>
                        <input  
                            className='stylesInput'
                            type='text'
                            id='presentation' 
                            name='presentation'
                            placeholder="escribe la presentacion"
                            value={values.presentation}
                            onChange={(e) => {
                                const val = e.target.value.toUpperCase();
                                setShowSuggestions(true);

                                setFieltered(
                                    presentations.filter(p => 
                                        p.name.toUpperCase().includes(val)));
                                handleChange({
                                    target: {name: "presentation", value: val}
                                });
                            }}
                            onBlur={() => {
                                setTimeout(() => {
                                   setShowSuggestions(false) 
                                }, 200);
                            }}
                        />
                        {showSuggestions && filtered.length > 0 && (
                            <ul className="suggestion-box">
                                {filtered.map(p => (
                                    <li
                                        key={p.id}
                                        onClick={() => {
                                            handleChange({
                                                target: { name: "presentation", value: p.name }
                                            });
                                            setShowSuggestions(false);
                                        }}
                                    >
                                        {p.name}
                                    </li>
                                ))}
                            </ul>
                        )} 
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