import React, { useEffect } from 'react'
import Navbar from '../components/Navbar'
import { Form, Link, useNavigate, useParams } from 'react-router-dom'
import Swal from 'sweetalert2'
import axios from 'axios'
import { useState } from 'react'

export const EditEmpleado = () => {

    const navigate = useNavigate();

    const { id } = useParams()

    const [empleado, setEmpleado] = useState({
        nombre: "",
        apellidoP: "",
        apellidoM: "",
        licoreria_asignada: "",
    });

    const { nombre, apellidoP, apellidoM, licoreria_asignada } = empleado;

    const onInputChange = (e) => {
        setEmpleado({ ...empleado, [e.target.name]: e.target.value });
    };

    useEffect(() => {
        loadEmpleado();

    }, []);

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8080/empleado/${id}`, empleado);
        navigate("/empleados");
    };


    const loadEmpleado = async () => {
        const result = await axios.get(`http://localhost:8080/empleado/${id}`)
        setEmpleado(result.data)
    }

    return (
        <>
            <Navbar />
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-6 m-5">

                        <Form onSubmit={(e) => onSubmit(e)}>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Nombre del trabajador</label>
                                <input
                                    name="nombre"
                                    value={nombre}
                                    onChange={(e) => onInputChange(e)}
                                    type="text" class="form-control" id="exampleFormControlInput1" />
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Apellido paterno</label>
                                <input
                                    name="apellidoP"
                                    value={apellidoP}
                                    onChange={(e) => onInputChange(e)}
                                    type="text" class="form-control" id="exampleFormControlInput1" />
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Aepllido materno</label>
                                <input
                                    name="apellidoM"
                                    value={apellidoM}
                                    onChange={(e) => onInputChange(e)}
                                    type="text" class="form-control" id="exampleFormControlInput1" />
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Licoreria asignada</label>
                                <input
                                    name="licoreria_asignada"
                                    value={licoreria_asignada}
                                    onChange={(e) => onInputChange(e)}
                                    type="int s" class="form-control" id="exampleFormControlInput1" />
                            </div>


                            <div class="mb-3">
                                <div className="d-flex align-items-end justify-content-end">
                                    <button type="submit" className="btn btn-outline-secondary  me-2">Guardar</button>
                                    <Link type="button" className="btn btn-outline-secondary ">Cancelar</Link>
                                </div>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>



        </>
    )
}
