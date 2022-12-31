/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.DAO;

import com.gnosoft.proyectgnosoft.VO.FacturaDatosVO;
import com.gnosoft.proyectgnosoft.util.Conn;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
@Service
public class FacturaDatosDAO {
    public List<FacturaDatosVO> listaSeleccionar() {
        List<FacturaDatosVO> lista = new ArrayList();
        Statement stmt = null;
        try {
            Connection c = Conn.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FACTURA_DATOS;");
            while (rs.next()) {
                FacturaDatosVO facturacion = new FacturaDatosVO();
                facturacion.setIdDato(rs.getInt("id_dato"));
                facturacion.setIdFactura(rs.getInt("id_factura"));
                facturacion.setNombre(rs.getString("nombre"));
                facturacion.setCliente(rs.getString("cliente"));
                facturacion.setFecha(rs.getDate("fecha"));
                facturacion.setSubtotal(rs.getInt("subtotal"));
                facturacion.setIva(rs.getInt("iva"));
                facturacion.setTotal(rs.getInt("total"));
                lista.add(facturacion);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return lista;
    }

    public void actualizar(FacturaDatosVO facturacion) {

        try {
            Connection c = Conn.getConnection();
            String sql = "UPDATE FACTURA_DATOS set ID_FACTURA = ?, NOMBRE = ?, CLIENTE = ?, FECHA = ?, SUBTOTAL = ?, IVA = ?, TOTAL = ? where ID_DATO =?;";
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, facturacion.getIdFactura());
            statement.setString(2, facturacion.getNombre());
            statement.setString(3, facturacion.getCliente());
            statement.setDate(4, facturacion.getFecha());
            statement.setInt(5, facturacion.getSubtotal());
            statement.setInt(6, facturacion.getIva());
            statement.setInt(7, facturacion.getTotal());
            statement.setInt(8, facturacion.getIdDato());
            int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");
                    }
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void eliminar(Integer idDato) {
        try {
            Connection c = Conn.getConnection();
            String sql = "DELETE from FACTURA_DATOS where ID_DATO = ?;";
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, idDato);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
                }
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

    }
    public void guardar(FacturaDatosVO facturacion){
      Statement stmt = null;
      try {
          Connection c = Conn.getConnection();
          String sql = "INSERT INTO FACTURA_DATOS (ID_DATO,ID_FACTURA,NOMBRE,CLIENTE,FECHA,SUBTOTAL,IVA,TOTAL) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
          PreparedStatement statement = c.prepareStatement(sql);
          statement.setInt(1, facturacion.getIdDato());
          statement.setInt(2, facturacion.getIdFactura());
          statement.setString(3, facturacion.getNombre());
          statement.setString(4, facturacion.getCliente());
          statement.setDate(5, (Date) facturacion.getFecha());
          statement.setInt(6, facturacion.getSubtotal());
          statement.setInt(7, facturacion.getIva());
          statement.setInt(8, facturacion.getTotal());
          int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                 System.out.println("A new user was inserted successfully!");
                }
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   
    }
    
}

