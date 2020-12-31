package com.jdbc;

import com.models.Employee;
import com.models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class VWZDao {
    private DbController dbctrl;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection conn;

    public VWZDao() throws ClassNotFoundException {
        init();
    }

    //DefaultDAO
    public void init() throws ClassNotFoundException {
        if (dbctrl == null) {
            dbctrl = DbController.getInstance();
        }
        Locale.setDefault(Locale.US);
        conn = dbctrl.getConnection();
    }

    public void closeConnection() {
        dbctrl.closeConnection();
    }


    //Product
    public void insertProductData(Product p) throws SQLException {
        //executeQuery() is used for SELECT sql operation
        //executeUpdate() is used for INSERT, UPDATE and DELETE sql operation.
        preparedStatement = conn.prepareStatement("INSERT INTO product_db (product_name,product_quantity,product_entrydate) VALUES (?,?,?)");
        preparedStatement.setString(1, p.getName());
        preparedStatement.setInt(2, p.getQuantity());
        preparedStatement.setDate(3, p.getEntrydate());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void loadProduct(JTable table) throws SQLException {
        //set Table Layout
        DefaultTableModel DTM = new DefaultTableModel();

        DTM.addColumn("ID");
        DTM.addColumn("Name");
        DTM.addColumn("Quantity");
        DTM.addColumn("Entry Date");

        preparedStatement = conn.prepareStatement("SELECT * FROM product_db");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            DTM.addRow(new Object[]{
                    resultSet.getInt("product_id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("product_quantity"),
                    resultSet.getDate("product_entrydate")
            });
        }
        table.setModel(DTM);
        table.getColumn("ID").setPreferredWidth(50);
        table.getColumn("Name").setPreferredWidth(450);
        table.getColumn("Quantity").setPreferredWidth(100);
        table.getColumn("Entry Date").setPreferredWidth(100);

        resultSet.close();
        preparedStatement.close();
    }

    public void updateProduct(int id, Product p) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE product_db SET product_name=?,product_quantity=?,product_entrydate=? WHERE product_id=?");

        preparedStatement.setString(1, p.getName());
        preparedStatement.setInt(2, p.getQuantity());
        preparedStatement.setDate(3, p.getEntrydate());
        preparedStatement.setInt(4, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void deleteProduct(int id) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM product_db WHERE product_id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }


    //Employee
    public void insertEmployeeData(Employee e) throws SQLException {
        //executeQuery() is used for SELECT sql operation
        //executeUpdate() is used for INSERT, UPDATE and DELETE sql operation.
        preparedStatement = conn.prepareStatement("INSERT INTO employee_db (employee_firstname,employee_lastname,employee_birthdate,employee_entrydate,employee_position,employee_schedule) VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, e.getFirstname());
        preparedStatement.setString(2, e.getLastname());
        preparedStatement.setDate(3, e.getBirthdate());
        preparedStatement.setDate(4, e.getEntrydate());
        preparedStatement.setString(5, e.getPosition());
        preparedStatement.setString(6, e.getSchedule());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void loadEmployee(JTable table) throws SQLException {
        //set Table Layout
        DefaultTableModel DTM = new DefaultTableModel();

        DTM.addColumn("ID");
        DTM.addColumn("First Name");
        DTM.addColumn("Last Name");
        DTM.addColumn("Birthdate");
        DTM.addColumn("Entry Date");
        DTM.addColumn("Position");
        DTM.addColumn("Schedule");

        preparedStatement = conn.prepareStatement("SELECT * FROM employee_db");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            DTM.addRow(new Object[]{
                    resultSet.getInt("employee_id"),
                    resultSet.getString("employee_firstname"),
                    resultSet.getString("employee_lastname"),
                    resultSet.getDate("employee_birthdate"),
                    resultSet.getDate("employee_entrydate"),
                    resultSet.getString("employee_position"),
                    resultSet.getString("employee_schedule")
            });
        }
        table.setModel(DTM);
        table.getColumn("ID").setPreferredWidth(50);

        resultSet.close();
        preparedStatement.close();
    }

    public void updateEmployee(int id, Employee e) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE employee_db SET employee_firstname=?,employee_lastname=?,employee_birthdate=?,employee_entrydate=?,employee_position=?,employee_schedule=? WHERE employee_id=?");

        preparedStatement.setString(1, e.getFirstname());
        preparedStatement.setString(2, e.getLastname());
        preparedStatement.setDate(3, e.getBirthdate());
        preparedStatement.setDate(4, e.getEntrydate());
        preparedStatement.setString(5, e.getPosition());
        preparedStatement.setString(6, e.getSchedule());
        preparedStatement.setInt(7, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void deleteEmployee(int id) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM employee_db WHERE employee_id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
