/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.controller;


import com.gnosoft.proyectgnosoft.VO.FacturaDatosVO;
import com.gnosoft.proyectgnosoft.services.FacturaDatosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/facturaDatos")
public class FacturaDatosController {
     @Autowired
    private FacturaDatosServices facturaDatosService;
     
    @PostMapping(value = "/")
    public ResponseEntity<FacturaDatosVO> guardar(@RequestBody FacturaDatosVO facturacion) {
        facturaDatosService.guardar(facturacion);
        return new ResponseEntity<>(facturacion, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{idDato}")
    public ResponseEntity<FacturaDatosVO> eliminar(@PathVariable Integer idDato) {

        if (idDato != null) {
            facturaDatosService.eliminar(idDato);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    @PutMapping(value = "/")
    public ResponseEntity<FacturaDatosVO> actualizar(@RequestBody FacturaDatosVO facturacion) {
        if (facturacion != null) {
            facturacion.setIdDato(facturacion.getIdDato());
            facturaDatosService.actualizar(facturacion);
        } else {
            return new ResponseEntity<>(facturacion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(facturacion, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<FacturaDatosVO> listaSeleccionar() {
        return facturaDatosService.listaSeleccionar();
    }
}

