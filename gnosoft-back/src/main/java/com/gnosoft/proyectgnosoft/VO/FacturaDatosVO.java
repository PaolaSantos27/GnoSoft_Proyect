/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.VO;

import java.io.Serializable;
import java.sql.Date;



public class FacturaDatosVO implements Serializable {
    private Integer idDato;
    private Integer idFactura;
    private String nombre;
    private String cliente; 
    private Date fecha; 
    private Integer subtotal; 
    private Integer iva;
    private Integer total; 
    
    public FacturaDatosVO(){}
    
    public FacturaDatosVO(Integer idDato, Integer idFactura, String nombre, String cliente,
            Date fecha, Integer subtotal, Integer iva, Integer total){
        this.idDato= idDato;
        this.idFactura = idFactura;
        this.nombre = nombre;
        this.cliente = cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }
    

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    
    
}


