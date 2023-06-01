import React, { useEffect, useState } from 'react'
import Navbar from './Navbar'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';

export const Productos = () => {

    const [productos, setProductos] = useState([])

    const {id} = useParams()

    useEffect(() => {
        getProductos();
    }, []);


    const getProductos = async () => {
        const result = await axios.get("http://localhost:8084/productos");
        setProductos(result.data)
    }


    const deleteProducto = async (id) =>{
        await axios.delete(`http://localhost:8084/producto/${id}`);
        getProductos()
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
                                        <Link onClick={() => deleteProducto(producto.idProducto)} type="button" className="btn btn-outline-light flex-fill me-2 ms-3">Eliminar</Link>
                                        <Link to={`/editarProducto/${producto.idProducto}`} type="button" className="btn btn-outline-light flex-fill">Editar</Link>
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
