/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gnosoft.proyectgnosoft.DAO;

import com.gnosoft.proyectgnosoft.VO.FacturacionVO;
import com.gnosoft.proyectgnosoft.util.Conn;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Service
public class FacturacionDAO {
    public List<FacturacionVO> listarTodos() {
        List<FacturacionVO> lista = new ArrayList();
        Statement stmt = null;
        try {
            Connection c = Conn.getConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FACTURACION;");
            while (rs.next()) {
                FacturacionVO facturacion = new FacturacionVO();
                facturacion.setIdFactura(rs.getInt("id_factura"));
                facturacion.setArticulo(rs.getString("articulo"));
                facturacion.setCantidad(rs.getInt("cantidad"));
                facturacion.setValor(rs.getInt("valor"));
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

    public void actualizar(FacturacionVO facturacion) {

        try {
            Connection c = Conn.getConnection();
            String sql = "UPDATE FACTURACION set ARTICULO = ?, CANTIDAD = ?, VALOR = ? where ID_FACTURA =?;";
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, facturacion.getArticulo());
            statement.setInt(2, facturacion.getCantidad());
            statement.setInt(3, facturacion.getValor());
            statement.setInt(4, facturacion.getIdFactura());
            int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");}
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void eliminar(Integer idFactura) {
        try {
            Connection c = Conn.getConnection();
            String sql = "DELETE from FACTURACION where ID_FACTURA = ?;";
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, idFactura);
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
    public void guardar(FacturacionVO facturacion){
      try {
          Connection c = Conn.getConnection();
          String sql = "INSERT INTO FACTURACION (ID_FACTURA,ARTICULO,CANTIDAD,VALOR) "
            + "VALUES (?, ?, ?, ?);";
         PreparedStatement statement = c.prepareStatement(sql);
         statement.setInt(1, facturacion.getIdFactura());
         statement.setString(2, facturacion.getArticulo());
         statement.setInt(3, facturacion.getCantidad());
         statement.setInt(4, facturacion.getValor());
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

