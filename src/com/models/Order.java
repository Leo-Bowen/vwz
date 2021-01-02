package com.models;

import java.sql.Date;

public class Order {
    private int id;

    private String name;

    private int quantity;

    private Date orderdate;

    private String url;

    private boolean status;

    public Order(String name, int quantity, Date orderdate, String url, boolean status){
        this.name = name;
        this.quantity = quantity;
        this.orderdate = orderdate;
        this.url = url;
        this.status = status;
    }

    public Order(int id, String name, int quantity, Date orderdate, String url, boolean status){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orderdate = orderdate;
        this.url = url;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public String getUrl() {
        return url;
    }

    public boolean getStatus() {
        return status;
    }
}
