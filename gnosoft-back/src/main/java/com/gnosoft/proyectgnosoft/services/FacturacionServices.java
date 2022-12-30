/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gnosoft.proyectgnosoft.services;

import com.gnosoft.proyectgnosoft.VO.FacturacionVO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FacturacionServices {
    public void guardar(FacturacionVO facturacion);
    public void eliminar(Integer idFactura);
    public void actualizar(FacturacionVO facturacion);
    public List<FacturacionVO> listarTodos();    
}
