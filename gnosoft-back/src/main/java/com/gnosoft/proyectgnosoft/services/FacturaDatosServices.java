/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gnosoft.proyectgnosoft.services;

import com.gnosoft.proyectgnosoft.VO.FacturaDatosVO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FacturaDatosServices {
    public void guardar(FacturaDatosVO facturacion);
    public void eliminar(Integer idDato);
    public void actualizar(FacturaDatosVO facturacion);
    public List<FacturaDatosVO> listaSeleccionar(); 
}
