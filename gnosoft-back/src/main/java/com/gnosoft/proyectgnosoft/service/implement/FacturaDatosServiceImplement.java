/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.service.implement;


import com.gnosoft.proyectgnosoft.DAO.FacturaDatosDAO;
import com.gnosoft.proyectgnosoft.DAO.FacturacionDAO;
import com.gnosoft.proyectgnosoft.VO.FacturaDatosVO;
import com.gnosoft.proyectgnosoft.services.FacturaDatosServices;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Usuario
 */
@Service
public class FacturaDatosServiceImplement implements FacturaDatosServices{
     private FacturaDatosDAO facturaDatosDAO;
    public FacturaDatosServiceImplement(FacturaDatosDAO facturaDatosDAO) {
        this.facturaDatosDAO = facturaDatosDAO;
    }
     @Override
    public void guardar(FacturaDatosVO facturacion){
      facturaDatosDAO.guardar(facturacion);
    }
    
     @Override
    public void eliminar(Integer idDato){
    facturaDatosDAO.eliminar(idDato);
}
     @Override
    public void actualizar(FacturaDatosVO facturacion){
    facturaDatosDAO.actualizar(facturacion);
}
  
     @Override
   public List<FacturaDatosVO> listaSeleccionar(){
   return (List<FacturaDatosVO>) facturaDatosDAO.listaSeleccionar();
}
}


