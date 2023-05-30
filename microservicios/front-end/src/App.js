import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { Empleados } from './components/Empleados';
import { Menu } from './components/Inicio';
import { Licorerias } from './components/Licorerias';
import Navbar from './components/Navbar';
import { Productos } from './components/Productos';
import './estilos/global.css'

const router = createBrowserRouter([

  {
    path: '/',
    element: <Menu/>,
  },

  {
    path: '/licorerias',
    element: <Licorerias/>,
  },

  {
    path: '/empleados',
    element: <Empleados/>,
  },

  {
    path: '/productos',
    element: <Productos/>,
  },

])

function App() {
  return (
    <>
     <React.StrictMode>
      <RouterProvider router={router}/>
     </React.StrictMode>
    </>
  );
}

export default App;
