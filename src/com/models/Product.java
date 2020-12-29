package com.models;

import java.sql.Date;

public class Product {
    private int id;

    private String name;

    private int quantity;

    private Date entrydate;

    @Override
    public String toString() {
        return "id=" + id +
                " name='" + name + '\'' +
                " quantity=" + quantity +
                " entrydate=" + entrydate;
    }

    public Product(String name, int quantity, Date date) {
        this.name = name;
        this.quantity = quantity;
        this.entrydate = date;
    }

    public Product(int id, String name, int quantity, Date date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.entrydate = date;
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

    public Date getEntrydate() {
        return entrydate;
    }

    public void setId() {
        this.id = id;
    }

    public void setName() {
        this.name = name;
    }

    public void setQuantity() {
        this.quantity = quantity;
    }

    public void setDate() {
        this.entrydate = entrydate;
    }
}
