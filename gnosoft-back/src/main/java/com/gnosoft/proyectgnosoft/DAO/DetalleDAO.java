/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.DAO;

import com.gnosoft.proyectgnosoft.VO.DetalleVO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Service
public class DetalleDAO {
    public List<DetalleVO> listarPorFactura(Integer idFactura, Connection conexion) throws SQLException{
        List<DetalleVO> lista = new ArrayList();
        Statement stmt = null;
        String sql = ("SELECT * FROM DETALLE WHERE ID_FACTURA = ?;");
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idFactura);
            ResultSet rs = statement.executeQuery();
            while ((rs.next())) {
                DetalleVO detalle = new DetalleVO();
                detalle.setIdDetalle(rs.getInt("id_detalle"));
                detalle.setArticulo(rs.getString("articulo"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setValor(rs.getInt("valor"));
                detalle.setIdFactura(rs.getInt("id_factura"));
                lista.add(detalle);
            }
            return lista;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public void actualizar(DetalleVO detalle, Connection conexion) throws SQLException {
        Statement stmt = null;
        try {
            String sql = "UPDATE DETALLE set ARTICULO = ?, CANTIDAD = ?, VALOR = ?, ID_FACTURA = ?" +
                    " WHERE ID_DETALLE = ?;";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, detalle.getArticulo());
            statement.setInt(2, detalle.getCantidad());
            statement.setInt(3, detalle.getValor());
            statement.setInt(4, detalle.getIdFactura());
            statement.setInt(5, detalle.getIdDetalle());
            statement.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    public void eliminar(Integer idDetalle, Connection conexion) throws SQLException {
        PreparedStatement detallesql = null;
        try {
            String DetalleSQL = "DELETE FROM DETALLE WHERE ID_DETALLE = ?;";
            detallesql = conexion.prepareStatement(DetalleSQL);
            detallesql.setInt(1, idDetalle);
            detallesql.executeUpdate();
        }finally {
            if (detallesql != null) {
                detallesql.close();
            }
        }
    }

    public void eliminarPorFactura(Integer idFactura, Connection conexion) throws SQLException {
        PreparedStatement detalleFacsql = null;
        try {
            String DetalleFacSQL = "DELETE FROM DETALLE WHERE ID_FACTURA = ?;";
            detalleFacsql = conexion.prepareStatement(DetalleFacSQL);
            detalleFacsql.setInt(1, idFactura);
            detalleFacsql.executeUpdate();
        }finally {
            if (detalleFacsql != null) {
                detalleFacsql.close();
            }
        }
    }

    public void guardar(DetalleVO detalle, Connection conexion) throws SQLException{
        Statement stmt = null;
      try {
          String sql = "INSERT INTO DETALLE (ARTICULO,CANTIDAD,VALOR,ID_FACTURA) "
                  + "VALUES (?, ?, ?, ?);";
          PreparedStatement statement = conexion.prepareStatement(sql);
          statement.setString(1, detalle.getArticulo());
          statement.setInt(2, detalle.getCantidad());
          statement.setInt(3, detalle.getValor());
          statement.setInt(4, detalle.getIdFactura());

          statement.executeUpdate();
      } finally {
          if (stmt != null) {
              stmt.close();
          }
      }
   
    }
}

