/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gnosoft.proyectgnosoft.services;

import com.gnosoft.proyectgnosoft.VO.FacturaVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FacturaServices {
    public void guardar(FacturaVO factura) throws SQLException;
    public void eliminar(Integer idFactura) throws SQLException;
    public void actualizar(FacturaVO factura) throws SQLException;
    public List<FacturaVO> listarTodos() throws SQLException;

}
