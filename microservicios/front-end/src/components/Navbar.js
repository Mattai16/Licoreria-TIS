import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <>
      <style>
        {`
          ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #6c757d;
          }
          li {
            display: inline-block;
          }
          li a {
            display: block;
            padding: 8px 16px;
            text-decoration: none;
            color: white;
            font-size: 20px; 
          }
          li a:hover {
            background-color: rgba(0, 0, 0, 0.1);
            color: white;
          }
        `}
      </style>

      <ul>
        <li><Link to="/" >Inicio</Link></li>
        <li><Link to="/licorerias" >Licorerias</Link></li>
        <li><Link to="/empleados" >Empleados</Link></li>
        <li><Link to="/productos" >Productos</Link></li>
{/*         <li><Link >
          <button type="button" className="btn btn-outline-light end-0">
            Carrito <span className="badge text-bg-light ">0</span>
          </button></Link>
        </li> */}

      </ul>
    </>
  );
}
