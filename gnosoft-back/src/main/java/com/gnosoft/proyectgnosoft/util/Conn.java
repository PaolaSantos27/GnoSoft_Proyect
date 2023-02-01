package com.gnosoft.proyectgnosoft.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
        private static HikariConfig config = new HikariConfig();
        private static HikariDataSource ds;
        static {
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
            config.setUsername("postgres");
            config.setPassword("27062004");
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.setAutoCommit(false);
            ds = new HikariDataSource(config);

        }
        public static Connection getConnection () throws SQLException {
            return ds.getConnection();
        }
}
