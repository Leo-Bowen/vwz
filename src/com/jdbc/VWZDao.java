package com.jdbc;

import com.models.Employee;
import com.models.Order;
import com.models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    private DefaultTableModel DTM = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private TableRowSorter<DefaultTableModel> TRS = new TableRowSorter<>(DTM);

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

    public void loadProductData(JTable table) throws SQLException {
        //set Table Layout
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
        table.setRowSorter(TRS);
        table.setModel(DTM);
        table.getColumn("ID").setPreferredWidth(50);
        table.getColumn("Name").setPreferredWidth(450);
        table.getColumn("Quantity").setPreferredWidth(100);
        table.getColumn("Entry Date").setPreferredWidth(100);

        resultSet.close();
        preparedStatement.close();
    }

    public void searchProductData(JTable table, String query) throws SQLException {
        loadProductData(table);
        TRS.setRowFilter(RowFilter.regexFilter("(?i)" + query)); //(?i) = case-insensitiv
    }

    public void updateProductData(int id, Product p) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE product_db SET product_name=?,product_quantity=?,product_entrydate=? WHERE product_id=?");

        preparedStatement.setString(1, p.getName());
        preparedStatement.setInt(2, p.getQuantity());
        preparedStatement.setDate(3, p.getEntrydate());
        preparedStatement.setInt(4, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void deleteProductData(int id) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM product_db WHERE product_id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }


    //Employee
    public void insertEmployeeData(Employee e) throws SQLException {
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

    public void loadEmployeeData(JTable table) throws SQLException {
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
        table.setRowSorter(TRS);
        table.setModel(DTM);
        table.getColumn("ID").setPreferredWidth(20);

        resultSet.close();
        preparedStatement.close();
    }

    public void searchEmployeeData(JTable table, String query) throws SQLException {
        loadEmployeeData(table);
        TRS.setRowFilter(RowFilter.regexFilter("(?i)" + query)); //(?i) = case-insensitiv
    }

    public void updateEmployeeData(int id, Employee e) throws SQLException {
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

    public void deleteEmployeeData(int id) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM employee_db WHERE employee_id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    //Order
    public void insertOrderData(Order o) throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO order_db (order_name,order_quantity,order_orderdate,order_url,order_status) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, o.getName());
        preparedStatement.setInt(2, o.getQuantity());
        preparedStatement.setDate(3, o.getOrderdate());
        preparedStatement.setString(4, o.getUrl());
        preparedStatement.setBoolean(5, o.getStatus());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public TableRowSorter loadOrderData(JTable table) throws SQLException {
        DefaultTableModel OrderDTM = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                return column == 5 ? Boolean.class : super.getColumnClass(column); //override 5th column(Status) to boolean.type
            }
        };
        TableRowSorter<DefaultTableModel> TRS = new TableRowSorter<>(OrderDTM);

        OrderDTM.addColumn("ID");
        OrderDTM.addColumn("Name");
        OrderDTM.addColumn("Quantity");
        OrderDTM.addColumn("Order Date");
        OrderDTM.addColumn("URL");
        OrderDTM.addColumn("Status");

        preparedStatement = conn.prepareStatement("SELECT * FROM order_db");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            OrderDTM.addRow(new Object[]{
                    resultSet.getInt("order_id"),
                    resultSet.getString("order_name"),
                    resultSet.getInt("order_quantity"),
                    resultSet.getDate("order_orderdate"),
                    resultSet.getString("order_url"),
                    resultSet.getBoolean("order_status")
            });
        }

        //Open URL
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int row = table.getSelectedRow();

                if (table.getSelectedColumn() == 4) { //if URL column is selected
                    String url = (String) table.getModel().getValueAt(row, 4); //url = value of url column
                    if (url.isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame(), "There is no URL!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            Desktop.getDesktop().browse(new URI(url)); //open with browser
                        } catch (URISyntaxException | IOException err) {
                        }
                    }
                }
            }
        });

        table.setRowSorter(TRS);
        table.setModel(OrderDTM);
        table.getColumn("ID").setPreferredWidth(20);
        table.getColumn("Name").setPreferredWidth(220);
        table.getColumn("Quantity").setPreferredWidth(80);
        table.getColumn("Order Date").setPreferredWidth(100);
        table.getColumn("URL").setPreferredWidth(250);
        table.getColumn("Status").setPreferredWidth(50);
        resultSet.close();
        preparedStatement.close();

        return TRS;
    }

    public void searchOrderData(JTable table, String query) throws SQLException {
        loadOrderData(table).setRowFilter(RowFilter.regexFilter("(?i)" + query)); //(?i) = case-insensitiv
    }

    public void updateOrderData(int id, Order o) throws SQLException {
        preparedStatement = conn.prepareStatement("UPDATE order_db SET order_name=?,order_quantity=?,order_orderdate=?,order_url=?,order_status=? WHERE order_id=?");

        preparedStatement.setString(1, o.getName());
        preparedStatement.setInt(2, o.getQuantity());
        preparedStatement.setDate(3, o.getOrderdate());
        preparedStatement.setString(4, o.getUrl());
        preparedStatement.setBoolean(5, o.getStatus());
        preparedStatement.setInt(6, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void deleteOrderData() throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM order_db WHERE order_status=?");
        preparedStatement.setBoolean(1, true); //delete all where status is true

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
