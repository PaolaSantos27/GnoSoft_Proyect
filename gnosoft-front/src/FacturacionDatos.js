import React from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table, Button, Container,Modal, ModalBody, ModalHeader, FormGroup, ModalFooter} from 'reactstrap';


const data = [
  {id_dato: 1, id_factura: 1, nombre: "Paola", cliente: "Ava", fecha: "2022-09-18", subtotal: 40, iva:2, total:42},
  {id_dato: 2, id_factura: 3, nombre: "Paola", cliente: "Miguel", fecha: "2022-12-06", subtotal: 18, iva:1, total:19},
  {id_dato: 3, id_factura: 2, nombre: "Paola", cliente: "Beatriz", fecha: "2022-11-09", subtotal: 15, iva:0, total:15},
  {id_dato: 4, id_factura: 4, nombre: "Paola", cliente: "Camila", fecha: "2022-11-14", subtotal: 30, iva:0, total:30},
  ]

  class FacturacionDatos extends React.Component {
    state = {
      data: data,
      modalActualizar: false,
      modalInsertar: false,
      form: {
        id_dato: "",
        id_factura: "",
        nombre: "",
        cliente: "",
        fecha: "",
        subtotal:"",
        iva:"",
        total:"",
      },
    };
  
    mostrarModalActualizar = (dato) => {
      this.setState({
        form: dato,
        modalActualizar: true,
      });
    };
  
    cerrarModalActualizar = () => {
      this.setState({ modalActualizar: false });
    };
  
    mostrarModalInsertar = () => {
      this.setState({
        modalInsertar: true,
      });
    };
  
    cerrarModalInsertar = () => {
      this.setState({ modalInsertar: false });
    };
  
    editar = (dato) => {
      var contador = 0;
      var arreglo = this.state.data;
      arreglo.map((registro) => {
        if (dato.id_dato == registro.id_dato) {
          arreglo[contador].nombre = dato.nombre;
          arreglo[contador].cliente = dato.cliente;
          arreglo[contador].fecha = dato.fecha;
          arreglo[contador].subtotal = dato.subtotal;
          arreglo[contador].iva = dato.iva;
          arreglo[contador].total = dato.total;
        }
        contador++;
      });
      this.setState({ data: arreglo, modalActualizar: false });
    };
  
    eliminar = (dato) => {
      var opcion = window.confirm("Estás Seguro que deseas Eliminar el elemento "+dato.id_factura);
      if (opcion == true) {
        var contador = 0;
        var arreglo = this.state.data;
        arreglo.map((registro) => {
          if (dato.id_dato == registro.id_dato) {
            arreglo.splice(contador, 1);
          }
          contador++;
        });
        this.setState({ data: arreglo, modalActualizar: false });
      }
    };
  
    insertar= ()=>{
      var valorNuevo= {...this.state.form};
      valorNuevo.id_dato=this.state.data.length+1;
      var lista= this.state.data;
      lista.push(valorNuevo);
      this.setState({ modalInsertar: false, data: lista });
    }
  
    handleChange = (e) => {
      this.setState({
        form: {
          ...this.state.form,
          [e.target.name]: e.target.value,
        },
      });
    };
  
    render() {
      
      return (
        <>
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
                {this.state.data.map((dato) => (
                  <tr key={dato.id_dato}>
                    <td>{dato.id_dato}</td>
                    <td>{dato.id_factura}</td>
                    <td>{dato.nombre}</td>
                    <td>{dato.cliente}</td>
                    <td>{dato.fecha}</td>
                    <td>{dato.subtotal}</td>
                    <td>{dato.iva}</td>
                    <td>{dato.total}</td>
                    <td>
                      <Button
                        color="primary"
                        onClick={() => this.mostrarModalActualizar(dato)}
                      >
                        Editar
                      </Button>{"   "}
                      <Button color="danger" onClick={()=> this.eliminar(dato)}>Eliminar</Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <br />
            <Button color="success" onClick={()=>this.mostrarModalInsertar()}>Crear Factura</Button>
            <br />
          </Container>
  
          <Modal isOpen={this.state.modalActualizar}>
            <ModalHeader>
             <div><h3>Editar Factura</h3></div>
            </ModalHeader>
            <ModalBody>
            <FormGroup>
                <label>
                 Id Dato:
                </label>
              
                <input
                  className="form-control"
                  readOnly
                  type="number"
                  value={this.state.form.id_dato}
                />
              </FormGroup>
              <FormGroup>
                <label>
                 Id Factura:
                </label>
              
                <input
                  className="form-control"
                  readOnly
                  type="number"
                  value={this.state.form.id_factura}
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
                  onChange={this.handleChange}
                  value={this.state.form.nombre}
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
                  onChange={this.handleChange}
                  value={this.state.form.cliente}
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
                  onChange={this.handleChange}
                  value={this.state.form.fecha}
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
                  onChange={this.handleChange}
                  value={this.state.form.subtotal}
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
                  onChange={this.handleChange}
                  value={this.state.form.iva}
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
                  onChange={this.handleChange}
                  value={this.state.form.total}
                />
              </FormGroup>
            </ModalBody>
  
            <ModalFooter>
              <Button
                color="primary"
                onClick={() => this.editar(this.state.form)}
              >
                Editar
              </Button>
              <Button
                color="danger"
                onClick={() => this.cerrarModalActualizar()}
              >
                Cancelar
              </Button>
            </ModalFooter>
          </Modal>
  
  
  
          <Modal isOpen={this.state.modalInsertar}>
            <ModalHeader>
             <div><h3>Crear Factura</h3></div>
            </ModalHeader>
  
            <ModalBody>
            <FormGroup>
                <label>
                  Id Dato: 
                </label>
                
                <input
                  className="form-control"
                  readOnly
                  type="number"
                  value={this.state.data.length+1}
                />
              </FormGroup>
              <FormGroup>
                <label>
                  Id Factura: 
                </label>
                
                <input
                  className="form-control"
                  readOnly
                  type="number"
                  value={this.state.data.length+1}
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
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
                />
              </FormGroup>
            </ModalBody>
  
            <ModalFooter>
              <Button
                color="primary"
                onClick={() => this.insertar()}
              >
                Insertar
              </Button>
              <Button
                className="btn btn-danger"
                onClick={() => this.cerrarModalInsertar()}
              >
                Cancelar
              </Button>
            </ModalFooter>
          </Modal>
        </>
      );
    }
  }
export default FacturacionDatos;
