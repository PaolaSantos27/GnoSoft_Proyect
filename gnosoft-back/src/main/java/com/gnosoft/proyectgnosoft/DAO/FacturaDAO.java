/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.DAO;

import com.gnosoft.proyectgnosoft.VO.FacturaVO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
@Service
public class FacturaDAO {
    public List<FacturaVO> listarTodos(Connection conexion) throws SQLException {
        List<FacturaVO> lista = new ArrayList();
        Statement stmt = null;
        try {
            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FACTURA;");
            while (rs.next()) {
                FacturaVO facturaVO = new FacturaVO();
                facturaVO.setIdFactura(rs.getInt("id_factura"));
                facturaVO.setNombre(rs.getString("nombre"));
                facturaVO.setCliente(rs.getString("cliente"));
                facturaVO.setFecha(rs.getDate("fecha"));
                facturaVO.setSubtotal(rs.getInt("subtotal"));
                facturaVO.setIva(rs.getInt("iva"));
                facturaVO.setTotal(rs.getInt("total"));
                lista.add(facturaVO);
            }
        return lista;
    }   finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        }

    public void actualizar(FacturaVO factura, Connection conexion) throws SQLException{
        Statement stmt = null;
        try {
            String sql = "UPDATE FACTURA set NOMBRE = ?, CLIENTE = ?, FECHA = ?, SUBTOTAL = ?, IVA = ?, TOTAL = ? " +
                    "WHERE ID_FACTURA = ?;";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, factura.getNombre());
            statement.setString(2, factura.getCliente());
            statement.setDate(3, factura.getFecha());
            statement.setInt(4, factura.getSubtotal());
            statement.setInt(5, factura.getIva());
            statement.setInt(6, factura.getTotal());
            statement.setInt(7, factura.getIdFactura());
            statement.executeUpdate();
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void eliminar(Integer idFactura, Connection conexion) throws SQLException {
        PreparedStatement facturasql = null;
        try {
            String FacturaSQL = "DELETE from FACTURA where ID_FACTURA = ?;";
            facturasql = conexion.prepareStatement(FacturaSQL);
            facturasql.setInt(1, idFactura);
            facturasql.executeUpdate();
        }
        finally {
            if (facturasql != null) {
                facturasql.close();
            }
        }
    }
    public int guardar(FacturaVO factura, Connection conexion) throws SQLException {
      Statement stmt = null;
      try {
          String sql = "INSERT INTO FACTURA (NOMBRE,CLIENTE,FECHA,SUBTOTAL,IVA,TOTAL) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
          PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          statement.setString(1, factura.getNombre());
          statement.setString(2, factura.getCliente());
          statement.setDate(3, (Date) factura.getFecha());
          statement.setInt(4, factura.getSubtotal());
          statement.setInt(5, factura.getIva());
          statement.setInt(6, factura.getTotal());
          statement.executeUpdate();
          ResultSet generatedKeys = statement.getGeneratedKeys();
          generatedKeys.next();
          return generatedKeys.getInt(1);
      }
      finally {
          if (stmt != null) {
              stmt.close();
          }
      }

    }

    }



