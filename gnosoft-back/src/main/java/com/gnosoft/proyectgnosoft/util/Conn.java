package com.gnosoft.proyectgnosoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Connection c = null;
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "27062004");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        return c;
    }
}
