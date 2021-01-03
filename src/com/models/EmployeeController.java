package com.models;

import com.jdbc.VWZDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;

public class EmployeeController {
    private VWZDao vwzDao;

    public String getDate() {
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }

    public void addEmployee(String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Employee entryemployee = new Employee(firstname, lastname, birthdate, entrydate, position, schedule);
        vwzDao.insertEmployeeData(entryemployee);
    }

    public void loadEmployee(JTable table) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.loadEmployeeData(table);
    }

    public void searchEmployee(JTable table, String searchinput) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        vwzDao.searchEmployeeData(table, searchinput);
    }

    public void updateEmployee(int id, String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Employee entryemployee = new Employee(firstname, lastname, birthdate, entrydate, position, schedule);
        vwzDao.updateEmployeeData(id,entryemployee);
    }

    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        vwzDao = new VWZDao();
        vwzDao.deleteEmployeeData(id);
    }

}
