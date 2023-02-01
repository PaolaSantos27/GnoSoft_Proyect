/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.controller;


import com.gnosoft.proyectgnosoft.VO.FacturaVO;
import com.gnosoft.proyectgnosoft.services.FacturaServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/factura")
public class FacturaController {
     @Autowired
    private FacturaServices facturaService;
     
    @PostMapping(value = "/")
    public ResponseEntity guardar(@RequestBody FacturaVO factura) throws SQLException {
        try {
            facturaService.guardar(factura);
            return new ResponseEntity<>(factura, HttpStatus.OK);
        } catch (SQLException e){
            Map<String, String> errorResponse = new HashMap<String, String>();;
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/{idFactura}")
    public ResponseEntity eliminar(@PathVariable Integer idFactura) throws SQLException {
        try {
             if (idFactura != null) {
                facturaService.eliminar(idFactura);
        }
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (SQLException e) {
            Map<String, String> errorResponse = new HashMap<String, String>();;
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/")
    public ResponseEntity actualizar(@RequestBody FacturaVO factura) throws SQLException {
       try {
           if (factura != null) {
               facturaService.actualizar(factura);
           }
           return new ResponseEntity<>(factura, HttpStatus.OK);
       } catch (SQLException e){
           Map<String, String> errorResponse = new HashMap<String, String>();;
           errorResponse.put("message", e.getMessage());
           return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("/list")
    public ResponseEntity listarTodos() throws SQLException {
        try {
            return new ResponseEntity(facturaService.listarTodos(), HttpStatus.OK);
        } catch (SQLException e){
            Map<String, String> errorResponse = new HashMap<String, String>();;
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

