/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.controller;

import com.gnosoft.proyectgnosoft.VO.FacturacionVO;
import com.gnosoft.proyectgnosoft.services.FacturacionServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/facturacion")
public class FacturacionController {
    private FacturacionServices facturacionService;

    public FacturacionController(FacturacionServices facturacionService) {
        this.facturacionService = facturacionService;
    }
     
    @PostMapping(value = "/")
    public ResponseEntity<FacturacionVO> guardar(@RequestBody FacturacionVO facturacion) {
        facturacionService.guardar(facturacion);
        return new ResponseEntity<>(facturacion, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{idFactura}")
    public ResponseEntity<FacturacionVO> eliminar(@PathVariable Integer idFactura) {

        if (idFactura != null) {
            facturacionService.eliminar(idFactura);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    @PutMapping(value = "/")
    public ResponseEntity<FacturacionVO> actualizar(@RequestBody FacturacionVO facturacion) {
        if (facturacion != null) {
            facturacion.setIdFactura(facturacion.getIdFactura());
            facturacionService.actualizar(facturacion);
        } else {
            return new ResponseEntity<>(facturacion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(facturacion, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<FacturacionVO> listarTodos() {
        return facturacionService.listarTodos();
    }
    
}
