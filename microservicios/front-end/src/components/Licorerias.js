import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom'

export const Licorerias = () => {

    const [licorerias, setLicorerias] = useState([])

    const {id} = useParams()

    useEffect(() => {
        getLicorerias();
    }, []);


    const getLicorerias = async () => {
        const result = await axios.get("http://localhost:8084/licorerias");
        setLicorerias(result.data)
    }

    const deleteLicoreria = async (id) =>{
        await axios.delete(`http://localhost:8084/licoreria/${id}`);
        getLicorerias();
    }

    const deleteEmpleado = async (id) =>{
        await axios.delete(`http://localhost:8084/licoreria/${id}`);
        getLicorerias()
    }



    return (
        <>
            <Navbar />
            <br />
            <div className="container">
                <div className="row row-cols-3">


                    {licorerias.map((licoreria, index) => (
                        <div className="col">
                            <div className="card text-bg-secondary w-75 mb-5 shadow-lg rounded">

                                <div className="card-header text-start">{licoreria.nombre}</div>
                                <div className="card-body text-start">
                                    <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis officiis, eius maiores nulla repellat dolor ut illo quod.</p>
                                    <h5 className="card-title">{"Dirección: " + licoreria.direccion}</h5>
                                    <div className="d-flex align-items-end justify-content-between">
                                        <Link onClick={() => deleteLicoreria(licoreria.idTienda)} type="button" className="btn btn-outline-light flex-fill me-2">Eliminar</Link>
                                        <Link to={`/editarLicoreria/${licoreria.idTienda}`} type="button" className="btn btn-outline-light flex-fill">Editar</Link>
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
