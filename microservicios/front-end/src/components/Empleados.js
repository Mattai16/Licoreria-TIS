import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom'

export const Empleados = () => {


    const [empleados, setEmpleados] = useState([])

    const {id} = useParams()

    useEffect(() => {
        getEmpleados();
    }, []);


    const getEmpleados = async () => {
        const result = await axios.get("http://localhost:8084/empleados");
        setEmpleados(result.data)
    }

    const deleteEmpleado = async (id) =>{
        await axios.delete(`http://localhost:8084/empleado/${id}`);
        getEmpleados()
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

                                <div className="card-header text-start">{empleado.nombre+" "+empleado.apellidoP}</div>
                                <div className="card-body text-start">
                                    <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis officiis, eius maiores nulla repellat dolor ut illo quod.</p>
                                    <h5 className="card-title">{"No. trabajador: " + empleado.numTrabajador}</h5>
                                    <div className="d-flex align-items-end justify-content-between">
                                        <Link onClick={() => deleteEmpleado(empleado.numTrabajador)} type="button" className="btn btn-outline-light flex-fill me-2">Eliminar</Link>
                                        <Link to={`/editarEmpleado/${empleado.numTrabajador}`} type="button" className="btn btn-outline-light flex-fill">Editar</Link>
                                    </div>

                                </div>

                            </div>
                        </div>
                    ))}




                </div>

            </div>

        </>
    )
}
