import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import React, { useEffect, useState } from 'react';
import { obtenerFacturacion, guardarFacturacion, actualizarFacturacion, eliminarFacturacion } from './services/facturacion';
import {Table, Button, Container,Modal, ModalBody, ModalHeader, FormGroup, ModalFooter} from 'reactstrap';
import { toast } from 'react-toastify';

const Facturacion = () => {
    const [facturas, setFacturas] = useState([]);
    const [modalInsertar, setModalInsertar] = useState(false);
    const [modalActualizar, setModalActualizar] = useState(false);
    const [actualizarState, setActualizarState] = useState({
      idFactura: "",
      articulo: "",
      cantidad: "",
      valor: "",
    })
    useEffect(() => {
        obtenerFacturacion().then(setFacturas)
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
                  <th>Id Factura</th>
                  <th>Articulo</th>
                  <th>Cantidad</th>
                  <th>Valor</th>
                  <th>Acción</th>
                </tr>
              </thead>
  
              <tbody>
                {facturas.map((dato) => (
                  <tr key={dato.idFactura}>
                    <td>{dato.idFactura}</td>
                    <td>{dato.articulo}</td>
                    <td>{dato.cantidad}</td>
                    <td>{dato.valor}</td>
                    <td>
                      <Button
                        color="primary"
                        onClick={() => {
                          setActualizarState(dato)
                          setModalActualizar(true)
                          }}>
                        Editar
                      </Button>{"   "}
                      <Button color="danger" onClick={()=> {
                        eliminarFacturacion(dato.idFactura).then(() => {
                          toast("La factura se ha eliminado exitosamente.")
                          obtenerFacturacion().then(setFacturas)
                        })
                      }}>Eliminar</Button>
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
                guardarFacturacion(data).then(() => {
                  toast("La factura se ha guardado exitosamente.")
                    obtenerFacturacion().then(setFacturas)
                })
                
                
            }}>
            <ModalHeader>
             <div><h3>Insertar Factura</h3></div>
            </ModalHeader>
  
            <ModalBody>
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
                  Articulo:
                </label>
                <input
                  className="form-control"
                  name="articulo"
                  type="text"
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                  Cantidad: 
                </label>
                <input
                  className="form-control"
                  name="cantidad"
                  type="number"
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Valor: 
                </label>
                <input
                  className="form-control"
                  name="valor"
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
                onClick={() => setModalInsertar(false)}>
                Cancelar
              </Button>
            </ModalFooter>
            </form>
          </Modal>
          <Modal isOpen={modalActualizar}>
            <form onSubmit={(ev) => {
                ev.preventDefault()
                const data = Object.fromEntries(new FormData(ev.target));
                actualizarFacturacion(data).then(() => {
                  toast("La factura se ha actualizado exitosamente.")
                  obtenerFacturacion().then(setFacturas)
                  setActualizarState({
                    idFactura: "",
                    articulo: "",
                    cantidad: "",
                    valor: "",
                  })
                })
            }}>
            <ModalHeader>
             <div><h3>Editar Factura</h3></div>
            </ModalHeader>
  
            <ModalBody>
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
                  Articulo:
                </label>
                <input
                  className="form-control"
                  name="articulo"
                  defaultValue={actualizarState.articulo}
                  type="text"
                />
              </FormGroup>
              
              <FormGroup>
                <label>
                  Cantidad: 
                </label>
                <input
                  className="form-control"
                  name="cantidad"
                  type="number"
                  defaultValue={actualizarState.cantidad}
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Valor: 
                </label>
                <input
                  className="form-control"
                  name="valor"
                  type="number"
                  defaultValue={actualizarState.valor}
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
 
export default Facturacion;
