import React from 'react';
import './App.css';
import Facturacion from './Facturacion';
import FacturacionDatos from './FacturacionDatos';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: "/datos",
    element: <FacturacionDatos />,
  },
  {
    path: "/",
    element: <Facturacion />,
  },
 
]);



function App(){

  return (
    <>
      <ToastContainer />
      <RouterProvider router={router} />
    </>
  )
}

export default App;
