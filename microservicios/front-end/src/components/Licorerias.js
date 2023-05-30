import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import axios from 'axios'

export const Licorerias = () => {
    
    const [licorerias, setLicorerias] = useState([])

    useEffect(() => {
        getLicorerias();
    }, []);


    const getLicorerias = async () => {
        const result = await axios.get("http://localhost:8084/licorerias");
        setLicorerias(result.data)
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
                                <h5 className="card-title">{"Dirección: "+ licoreria.direccion}</h5>
                            </div>
                        
                        </div>
                        </div>
                    ))}





                </div>

            </div>

        </>
    )
}
