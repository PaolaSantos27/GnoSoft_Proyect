import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import React, { useEffect, useState } from 'react';
import { obtenerFacturaDatos, guardarFacturaDatos, actualizarFacturaDatos, eliminarFacturaDatos } from './services/facturacionDatos';
import {Table, Button, Container,Modal, ModalBody, ModalHeader, FormGroup, ModalFooter} from 'reactstrap';
import { toast } from 'react-toastify';

const FacturacionDatos = () => {
  const [facturaDatos, setFacturaDatos] = useState([]);
  const [modalInsertar, setModalInsertar] = useState(false);
  const [modalActualizar, setModalActualizar] = useState(false);
  const [actualizarState, setActualizarState] = useState({
    idDato: "",
    idFactura: "",
    nombre: "",
    cliente: "",
    fecha: "",
    subtotal: "",
    iva: "",
    total: "",
  })

  useEffect(() => {
        obtenerFacturaDatos().then(setFacturaDatos)
    }, []);

    return (
      <Container>
          <br />
          <a href='/'>
            <Button color="success">Factura</Button>{"     "}</a>
            <a href='/datos'>
            <Button color="success">Datos De Factura</Button></a>
            <br />
            <br />
            <Table>
              <thead>
                <tr>
                  <th>Id Dato</th>
                  <th>Id Factura</th>
                  <th>Nombre</th>
                  <th>Cliente</th>
                  <th>Fecha</th>
                  <th>Subtotal</th>
                  <th>Iva</th>
                  <th>Total</th>
                </tr>
              </thead>
  
              <tbody>
                {facturaDatos.map((dato) => (
                  <tr key={dato.idDato}>
                    <td>{dato.idDato}</td>
                    <td>{dato.idFactura}</td>
                    <td>{dato.nombre}</td>
                    <td>{dato.cliente}</td>
                    <td>{dato.fecha}</td>
                    <td>{dato.subtotal}</td>
                    <td>{dato.iva}</td>
                    <td>{dato.total}</td>
                    <td>
                      <Button
                        color="primary"
                        onClick={() => {
                          setActualizarState(dato)
                          setModalActualizar(true)
                          }}
                      >
                        Editar
                      </Button>{"   "}
                      <Button color="danger" onClick={()=> eliminarFacturaDatos(dato.idDato).then(() => {
                        toast("Datos de facturación eliminados exitosamente.")
                        obtenerFacturaDatos().then(setFacturaDatos)
                      })}>Eliminar</Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <br />
            <Button color="success" onClick={()=>setModalInsertar(true)}>Crear Factura</Button>
            <br />
            <Modal isOpen={modalInsertar}>
            <form onSubmit={(ev) => {
                ev.preventDefault()
                const data = Object.fromEntries(new FormData(ev.target));
                console.log(data);
                guardarFacturaDatos(data).then(() => {
                  toast("Datos de facturación guardada exitosamente.")
                  obtenerFacturaDatos().then(setFacturaDatos)
                })
                
            }}>
            <ModalHeader>
             <div><h3>Insertar Factura Datos</h3></div>
            </ModalHeader>
  
            <ModalBody>
              <FormGroup>
                <label>
                 Id Dato:
                </label>
              
                <input
                  className="form-control"
                  name="idDato"
                  type="number"
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                 Id factura:
                </label>
              
                <input
                  className="form-control"
                  name="idFactura"
                  type="number"
                />
              </FormGroup>

              <FormGroup>
                <label>
                  Nombre:
                </label>
                <input
                  className="form-control"
                  name="nombre"
                  type="text"
                />
              </FormGroup>

              <FormGroup>
                <label>
                  Cliente:
                </label>
                <input
                  className="form-control"
                  name="cliente"
                  type="text"
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                  Fecha: 
                </label>
                <input
                  className="form-control"
                  name="fecha"
                  type="date"
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Subtotal: 
                </label>
                <input
                  className="form-control"
                  name="subtotal"
                  type="number"
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Iva: 
                </label>
                <input
                  className="form-control"
                  name="iva"
                  type="number"
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Total: 
                </label>
                <input
                  className="form-control"
                  name="total"
                  type="number"
                />
              </FormGroup>
            </ModalBody>
  
            <ModalFooter>
              <Button
                color="primary"
                onClick={() => setModalInsertar(false)}
                type="submit">
                Guardar
              </Button>
              <Button
                color="danger"
                onClick={() => setModalInsertar(false)}
              >
                Cancelar
              </Button>
            </ModalFooter>
            </form>
          </Modal>
          <Modal isOpen={modalActualizar}>
            <form onSubmit={(ev) => {
                ev.preventDefault()
                const data = Object.fromEntries(new FormData(ev.target));
                actualizarFacturaDatos(data).then(() => {
                  toast("Datos de facturación Actualizados exitosamente.")
                  obtenerFacturaDatos().then(setFacturaDatos)
                  setActualizarState({
                    idDato: "",
                    idFactura: "",
                    nombre: "",
                    cliente: "",
                    fecha: "",
                    subtotal: "",
                    iva: "",
                    total: "",
                  })
                })
            }}>
            <ModalHeader>
             <div><h3>Editar Datos de Factura </h3></div>
            </ModalHeader>
  
            <ModalBody>
            <FormGroup>
                <label>
                 Id Dato:
                </label>
              
                <input
                  className="form-control"
                  name="idDato"
                  readOnly
                  type="number"
                  defaultValue={actualizarState.idDato}
                />
              </FormGroup>
              <FormGroup>
                <label>
                 Id factura:
                </label>
              
                <input
                  className="form-control"
                  name="idFactura"
                  readOnly
                  type="number"
                  defaultValue={actualizarState.idFactura}
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                  Nombre:
                </label>
                <input
                  className="form-control"
                  name="nombre"
                  defaultValue={actualizarState.nombre}
                  type="text"
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                  Cliente: 
                </label>
                <input
                  className="form-control"
                  name="cliente"
                  type="text"
                  defaultValue={actualizarState.cliente}
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Fecha: 
                </label>
                <input
                  className="form-control"
                  name="fecha"
                  type="date"
                  defaultValue={actualizarState.fecha}
                />
              </FormGroup>
              <FormGroup>
                <label>
                 Subtotal:
                </label>
              
                <input
                  className="form-control"
                  name="subtotal"
                  type="number"
                  defaultValue={actualizarState.subtotal}
                />
              </FormGroup>
              <FormGroup>
                <label>
                 Iva:
                </label>
              
                <input
                  className="form-control"
                  name="iva"
                  type="number"
                  defaultValue={actualizarState.iva}
                />
              </FormGroup>
              <FormGroup>
                <label>
                 Total:
                </label>
              
                <input
                  className="form-control"
                  name="total"
                  type="number"
                  defaultValue={actualizarState.total}
                />
              </FormGroup>
            </ModalBody>
  
            <ModalFooter>
              <Button
                color="primary"
                onClick={() => setModalActualizar(false)}
                type="submit">
                Guardar
              </Button>
              <Button
                color="danger"
                onClick={() => setModalActualizar(false)}>
                Cancelar
              </Button>
            </ModalFooter>
            </form>
          </Modal>
          </Container> 
    ) 
}
  
export default FacturacionDatos;
