package com.models;

import com.jdbc.VWZDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class ProductController {
    private VWZDao vwzDao;
    private List<Product> productList;

    public void addProduct(String name, int quantity, Date date) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        //Product product = new Product("Apple",2, Date.valueOf("2020-12-03"));
        Product entryproduct = new Product(name, quantity, date);
        vwzDao.insertProductData(entryproduct);
    }


    public JList loadProduct(JList list) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.loadProduct(list);

        return list;
    }

    public void updateProduct(int id){

    }

    public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        vwzDao = new VWZDao();
        vwzDao.deleteProduct(id);
    }


}
