import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import axios from 'axios'

export const Empleados = () => {

    
    const [empleados, setEmpleados] = useState([])

    useEffect(() => {
        getEmpleados();
    }, []);


    const getEmpleados = async () => {
        const result = await axios.get("http://localhost:8084/empleados");
        setEmpleados(result.data)
    }


    return (
        <>
            <Navbar />
            <br />
            <div className="container text-center">
                <div className="row row-cols-3">


                {empleados.map((empleado, index) => (
                        <div class="col">
                            <div className="card text-bg-secondary w-75 mb-5 shadow-lg rounded">
                        
                            <div className="card-header text-start">{empleado.nombre}</div>
                            <div className="card-body text-start">
                            <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis officiis, eius maiores nulla repellat dolor ut illo quod.</p>
                                <h5 className="card-title">{"No. trabajador: "+ empleado.numTrabajador}</h5>
                            </div>
                        
                        </div>
                        </div>
                    ))}




                </div>

            </div>

        </>
    )
}
