import React from 'react';
import logo from './logo.svg';
import './App.css';
import Facturacion from './Facturacion';
import FacturacionDatos from './FacturacionDatos';
import ReactDOM from "react-dom/client";
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

const App = () => {
  return (
    <RouterProvider router={router} />
  )
}


export default App;
