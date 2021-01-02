package com.models;

import com.jdbc.VWZDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;


public class ProductController {
    private VWZDao vwzDao;

    public String getDate(){
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }

    public void addProduct(String name, int quantity, Date date) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Product entryproduct = new Product(name, quantity, date);
        vwzDao.insertProductData(entryproduct);
    }

    public void loadProduct(JTable table) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.loadProduct(table);
    }

    public void searchProduct(JTable table, String searchinput) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.searchProduct(table, searchinput);
    }

    public void updateProduct(int id, String name, int quantity, Date date) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Product entryproduct = new Product(name, quantity, date);
        vwzDao.updateProduct(id,entryproduct);
    }

    public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        vwzDao = new VWZDao();
        vwzDao.deleteProduct(id);
    }


}
