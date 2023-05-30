import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { Link } from 'react-router-dom';

export const Productos = () => {

    const [productos, setProductos] = useState([])

    useEffect(() => {
        getProductos();
    }, []);


    const getProductos = async () => {
        const result = await axios.get("http://localhost:8084/productos");
        setProductos(result.data)
    }




    return (
        <>
            <Navbar />
            <br />
            <div class="container text-center">
                <div class="row row-cols-3">


                    {productos.map((producto, index) => (
                        <div className="col">
                            <div className="card text-bg-secondary w-75 mb-5 shadow-lg rounded">

                                <div className="card-header text-start">{producto.nombre}</div>
                                <div className="card-body text-start">
                                    <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis officiis, eius maiores nulla repellat dolor ut illo quod.</p>
                                    <div className="d-flex align-items-end justify-content-between">
                                        <span className="card-title ">{"Precio: $" + producto.precio}</span>
                                        <Link type="button" className="btn btn-outline-light">Comprar</Link>
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
