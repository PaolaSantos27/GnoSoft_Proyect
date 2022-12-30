import React from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table, Button, Container,Modal, ModalBody, ModalHeader, FormGroup, ModalFooter} from 'reactstrap';


const data = [
  {id_factura: 1, articulo: "Tarjeta Netflix (Plan Básico)", cantidad: 2, valor: 40 },
  {id_factura: 2, articulo: "Tarjeta Spotify (Plan Premium)", cantidad: 1, valor: 15 },
  {id_factura: 3, articulo: "Subcripcion Youtube (Plan Premium)", cantidad: 1, valor: 18 },
  {id_factura: 4, articulo: "Tarjeta HBO MAX (Plan Básico)", cantidad: 2, valor: 30 }
  ]

  class Facturacion extends React.Component {
    state = {
      data: data,
      modalActualizar: false,
      modalInsertar: false,
      form: {
        id_factura: "",
        articulo: "",
        cantidad: "",
        valor: "",
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
        if (dato.id_factura == registro.id_factura) {
          arreglo[contador].articulo = dato.articulo;
          arreglo[contador].cantidad = dato.cantidad;
          arreglo[contador].valor = dato.valor;
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
          if (dato.id_factura == registro.id_factura) {
            arreglo.splice(contador, 1);
          }
          contador++;
        });
        this.setState({ data: arreglo, modalActualizar: false });
      }
    };
  
    insertar= ()=>{
      var valorNuevo= {...this.state.form};
      valorNuevo.id_factura=this.state.data.length+1;
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
                  <th>Id Factura</th>
                  <th>Articulo</th>
                  <th>Cantidad</th>
                  <th>Valor</th>
                  <th>Acción</th>
                </tr>
              </thead>
  
              <tbody>
                {this.state.data.map((dato) => (
                  <tr key={dato.id_factura}>
                    <td>{dato.id_factura}</td>
                    <td>{dato.articulo}</td>
                    <td>{dato.cantidad}</td>
                    <td>{dato.valor}</td>
                    <td>
                      <Button
                        color="primary"
                        onClick={() => this.mostrarModalActualizar(dato)}>
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
                 Id factura:
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
                  Articulo:
                </label>
                <input
                  className="form-control"
                  name="articulo"
                  type="text"
                  onChange={this.handleChange}
                  value={this.state.form.articulo}
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
                  onChange={this.handleChange}
                  value={this.state.form.cantidad}
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
                  onChange={this.handleChange}
                  value={this.state.form.valor}
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
             <div><h3>Insertar Factura</h3></div>
            </ModalHeader>
  
            <ModalBody>
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
                  Articulo: 
                </label>
                <input
                  className="form-control"
                  name="articulo"
                  type="text"
                  onChange={this.handleChange}
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
                  onChange={this.handleChange}
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
export default Facturacion;
