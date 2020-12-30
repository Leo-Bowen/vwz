package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbController {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/vwz_db";
    private String username = "root";
    private String password = "";

    private Connection conn;
    private static DbController instance;

    public DbController() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            System.out.println("JDBC_DRIVER loaded!");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: JDBC_DRIVER");
            throw new ClassNotFoundException("ClassNotFoundException: JDBC_DRIVER");
        }

        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.getCatalog());
        } catch (Exception e) {
            System.err.println("Connection to database failed!");
            System.err.println("Try closing other sessions!");
            System.exit(11);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DbController getInstance() throws ClassNotFoundException {
        if (instance == null) {
            setInstance(new DbController());
        }
        return instance;
    }

    private static void setInstance(DbController instance) {
        DbController.instance = instance;
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            System.err.println("Close Connection Failed!");
        }

    }
}
