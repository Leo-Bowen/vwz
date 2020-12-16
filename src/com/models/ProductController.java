package com.models;

import com.jdbc.VWZDao;

import java.sql.Date;
import java.sql.SQLException;


public class ProductController {
    private VWZDao vwzDao;

    public void addProduct(String name, int quantity, Date date) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        //Product product = new Product(3,"Apple",2, Date.valueOf("2020-12-03"));
        Product entryproduct = new Product(name, quantity, date);
        vwzDao.insertProductData(entryproduct);
    }

/*
    public List<Product> loadProduct() {


    }

    public void updateProduct(Integer id){

    }

    public void deleteProduct(Integer id) {
    }

 */
}
