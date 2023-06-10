import React, { useEffect } from 'react'
import Navbar from '../components/Navbar'
import { Form, Link, useNavigate, useParams } from 'react-router-dom'
import Swal from 'sweetalert2'
import axios from 'axios'
import { useState } from 'react'

export const EditLicoreria = () => {


    const navigate = useNavigate();


    const { id } = useParams()


    const [licoreria, setLicoreria] = useState({
        nombre: "",
        direccion: "",
    });


    const { nombre, direccion } = licoreria;


    const onInputChange = (e) => {
        setLicoreria({ ...licoreria, [e.target.name]: e.target.value });
    };


    useEffect(() => {
        loadLicoreria();

    }, []);


    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8080/licoreria/${id}`, licoreria);
        navigate("/licorerias");
    };


    const loadLicoreria = async () => {
        const result = await axios.get(`http://localhost:8080/licoreria/${id}`)
        setLicoreria(result.data)
    }


  return (
    <>
    <Navbar />
    <div class="container">
        <div class="row justify-content-center">
            
            <div class="col-6 m-5">

            <Form onSubmit={(e) => onSubmit(e)}>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Nombre de la licoreria</label>
                    <input 
                    name="nombre"
                    value={nombre}
                    onChange={(e) => onInputChange(e)}
                    type="text" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Direccion</label>
                    <input 
                    name="direccion"
                    value={direccion}
                    onChange={(e) => onInputChange(e)}
                    type="text" class="form-control" id="exampleFormControlInput1" />
                </div>

                <div class="mb-3">
                    <div className="d-flex align-items-end justify-content-end">
                        <button type="submit" className="btn btn-outline-secondary  me-2">Guardar</button>
                        <Link to="/licorerias" type="button" className="btn btn-outline-secondary ">Cancelar</Link>
                    </div>
                </div>
                </Form>
            </div>
            
        </div>
    </div>



</>
  )
}
