/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.service.implement;


import com.gnosoft.proyectgnosoft.DAO.FacturaDAO;
import com.gnosoft.proyectgnosoft.DAO.DetalleDAO;
import com.gnosoft.proyectgnosoft.VO.FacturaVO;
import com.gnosoft.proyectgnosoft.VO.DetalleVO;
import com.gnosoft.proyectgnosoft.services.FacturaServices;
import com.gnosoft.proyectgnosoft.util.Conn;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Service
public class FacturaServiceImplement implements FacturaServices {
     private FacturaDAO facturaDAO;
    private DetalleDAO detalleDAO;

    public FacturaServiceImplement(FacturaDAO facturaDAO, DetalleDAO detalleDAO) {
        this.facturaDAO = facturaDAO;
        this.detalleDAO = detalleDAO;
    }
     @Override
    public void guardar(FacturaVO factura) throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conn.getConnection();
            int idGenerado = facturaDAO.guardar(factura, conexion);
            System.out.println(idGenerado);
            factura.setIdFactura(idGenerado);
            List<DetalleVO> listaDetalle = factura.getListaDetalle();
            for (int x = 0; x < listaDetalle.size(); x++) {
                DetalleVO detalleVO = listaDetalle.get(x);
                detalleVO.setIdFactura(idGenerado);
                detalleDAO.guardar(detalleVO, conexion);
            }
            conexion.commit();
        } catch (SQLException e) {
            if (conexion != null){
                try{
                    conexion.rollback();
                }
                catch (SQLException exception){
                }
            }
            throw e;
        }
     }

     @Override
    public void eliminar(Integer idFactura) throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conn.getConnection();
            detalleDAO.eliminarPorFactura(idFactura, conexion);
            facturaDAO.eliminar(idFactura, conexion);
            conexion.commit();
        } catch (SQLException e) {
            if (conexion != null){
                try {
                    conexion.rollback();
                } catch (SQLException exception){
                }
            }
            throw e;
        }
    }
     @Override
    public void actualizar(FacturaVO factura) throws SQLException {
    Connection conexion = null;
    try {
        conexion = Conn.getConnection();
        facturaDAO.actualizar(factura, conexion);
        List<DetalleVO> listaDetalle = factura.getListaDetalle();
        for (int x = 0; x < listaDetalle.size(); x++) {
            DetalleVO detalleVO = listaDetalle.get(x);
            detalleDAO.actualizar(detalleVO, conexion);
        }
        conexion.commit();
    } catch (SQLException e) {
        if (conexion != null){
            try{
                conexion.rollback();
            }
            catch (SQLException exception){
            }
        }
        throw e;
    }
     }
     @Override
   public List<FacturaVO> listarTodos() throws SQLException {
         Connection conexion = null;
         try {
             conexion = Conn.getConnection();
             List<FacturaVO> listaFactura = facturaDAO.listarTodos(conexion);
             for (int x = 0; x < listaFactura.size(); x++) {
                 FacturaVO facturaVO = listaFactura.get(x);
                 facturaVO.setListaDetalle(detalleDAO.listarPorFactura(facturaVO.getIdFactura(), conexion));
             }
             return listaFactura;
         } catch (SQLException e) {
             if (conexion != null) {
                 try {
                     conexion.rollback();
                 } catch (SQLException exception) {
                 }
             }
             throw e;
         }
    }
}


