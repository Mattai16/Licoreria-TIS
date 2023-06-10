import React, { useEffect } from 'react'
import Navbar from '../components/Navbar'
import { Form, Link, useNavigate, useParams } from 'react-router-dom'
import Swal from 'sweetalert2'
import axios from 'axios'
import { useState } from 'react'

export const EditProducto = () => {
    const navigate = useNavigate();


    const { id } = useParams()


    const [producto, setProducto] = useState({
        nombre: "",
        marca: "",
        precio: "",
        cantidad: "",
        licoreria_asignada: "",
    });


    const { nombre, marca, precio, cantidad, licoreria_asignada } = producto;


    const onInputChange = (e) => {
        setProducto({ ...producto, [e.target.name]: e.target.value });
    };


    useEffect(() => {
        loadProducto();

    }, []);


    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8080/producto/${id}`, producto);
        navigate("/productos");
    };


    const loadProducto = async () => {
        const result = await axios.get(`http://localhost:8080/producto/${id}`)
        setProducto(result.data)
    }


  return (
    <>
    <Navbar />
    <div class="container">
        <div class="row justify-content-center">
            
            <div class="col-6 m-5">

            <Form onSubmit={(e) => onSubmit(e)}>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Nombre del producto</label>
                    <input 
                    name="nombre"
                    value={nombre}
                    onChange={(e) => onInputChange(e)}
                    type="text" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Marca del producto</label>
                    <input 
                    name="marca"
                    value={marca}
                    onChange={(e) => onInputChange(e)}
                    type="text" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Precio del producto</label>
                    <input 
                    name="precio"
                    value={precio}
                    onChange={(e) => onInputChange(e)}
                    type="int" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Cantidad del producto</label>
                    <input 
                    name="cantidad"
                    value={cantidad}
                    onChange={(e) => onInputChange(e)}
                    type="int" class="form-control" id="exampleFormControlInput1" />
                </div>
                
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Licoreria asignada</label>
                    <input 
                    name="licoreria_asignada"
                    value={licoreria_asignada}
                    onChange={(e) => onInputChange(e)}
                    type="int" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <div className="d-flex align-items-end justify-content-end">
                        <button type="submit" className="btn btn-outline-secondary  me-2">Guardar</button>
                        <Link to="/productos" type="button" className="btn btn-outline-secondary ">Cancelar</Link>
                    </div>
                </div>

                
                </Form>
            </div>
            
        </div>
    </div>



</>
  )
}
