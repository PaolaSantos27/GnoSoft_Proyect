/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.service.implement;
import com.gnosoft.proyectgnosoft.DAO.FacturacionDAO;
import com.gnosoft.proyectgnosoft.VO.FacturacionVO;
import com.gnosoft.proyectgnosoft.services.FacturacionServices;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Usuario
 */
@Service
public class FacturacionServiceImplement implements FacturacionServices {
    private FacturacionDAO facturacionDAO;

    public FacturacionServiceImplement(FacturacionDAO facturacionDAO) {
        this.facturacionDAO = facturacionDAO;
    }
    
    @Override
    public void guardar(FacturacionVO facturacion){
      facturacionDAO.guardar(facturacion);
    }
    
    @Override
    public void eliminar(Integer idFactura){
    facturacionDAO.eliminar(idFactura);
}
    @Override
    public void actualizar(FacturacionVO facturacion){
    facturacionDAO.actualizar(facturacion);
}
  
   public List<FacturacionVO> listarTodos(){
   return (List<FacturacionVO>) facturacionDAO.listarTodos();
}
}

