package com.models;

import com.jdbc.VWZDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;

public class OrderController {
    private VWZDao vwzDao;

    public String getDate() {
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }

    public void addOrder(String name, int quantity, Date orderdate, String url, boolean status) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Order entryorder = new Order(name, quantity, orderdate, url, status);
        vwzDao.insertOrderData(entryorder);
    }

    public void loadOrder(JTable table) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.loadOrderData(table);
    }

    public void searchOrder(JTable table, String searchinput) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.searchOrderData(table, searchinput);
    }

    public void updateOrder(int id, String name, int quantity, Date orderdate, String url, boolean status) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Order entryorder = new Order(name, quantity, orderdate, url, status);
        vwzDao.updateOrderData(id, entryorder);
    }

    public void deleteOrder() throws SQLException, ClassNotFoundException {
            vwzDao = new VWZDao();
            vwzDao.deleteOrderData();
    }


}
