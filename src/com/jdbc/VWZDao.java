package com.jdbc;

import com.models.Employee;
import com.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VWZDao {
    private DbController dbctrl;
    private PreparedStatement preparedStatement;
    private ResultSet productset;
    private List<Product> productlist = new ArrayList<>();
    private ResultSet employeeset;
    private List<Employee> employeelist = new ArrayList<>();
    Connection conn;
    private Product product;

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

    public int insertProductData(Product p) throws SQLException {
        //executeQuery() is used for SELECT sql operation
        //executeUpdate() is used for INSERT, UPDATE and DELETE sql operation.
        preparedStatement = conn.prepareStatement("INSERT INTO product_db (product_name,product_quantity,product_entrydate) VALUES (?,?,?)");
        preparedStatement.setString(1, p.getName());
        preparedStatement.setInt(2, p.getQuantity());
        preparedStatement.setDate(3, p.getEntrydate());

        preparedStatement.execute();

        return 0;
    }


    public List<Product> loadProduct() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM product_db");
        productset = preparedStatement.executeQuery();

        while (productset.next()) {
            Product product = new Product(productset.getInt("employee_id"), productset.getString("product_name"), productset.getInt("product_quantity"), productset.getDate("product_entrydate"));
            productlist.add(product);
        }
        return productlist;
    }
/*
        public int deleteProduct(int id) throws SQLException {
            statement.executeUpdate(String.format("DELETE FROM QUOTES WHERE ASSET_ID = '%s';", id));
            statement.executeUpdate(String.format("DELETE FROM ASSETS WHERE ID = '%s';", id));
            System.out.println("ID " + id + " deleted successfully");
            return 0;
        }
     */

    public int insertEmployeeData(Employee e) throws SQLException {
        //executeQuery() is used for SELECT sql operation
        //executeUpdate() is used for INSERT, UPDATE and DELETE sql operation.
        preparedStatement = conn.prepareStatement("INSERT INTO employee_db (employee_firstname,employee_lastname,employee_birthdate,employee_entrydate,employee_position,employee_schedule) VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, e.getFirstname());
        preparedStatement.setString(2, e.getLastname());
        preparedStatement.setDate(3, e.getBirthdate());
        preparedStatement.setDate(4, e.getEntrydate());
        preparedStatement.setString(5, e.getPosition());
        preparedStatement.setString(6,e.getSchedule());

        preparedStatement.execute();

        return 0;
    }

    public void closeConnection() {
        dbctrl.closeConnection();
    }


}
