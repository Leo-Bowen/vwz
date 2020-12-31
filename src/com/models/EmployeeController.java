package com.models;

import com.jdbc.VWZDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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
        vwzDao.loadEmployee(table);
    }

    public void updateEmployee(int id, String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        Employee entryemployee = new Employee(firstname, lastname, birthdate, entrydate, position, schedule);
        vwzDao.updateEmployee(id,entryemployee);
    }

    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        vwzDao = new VWZDao();
        vwzDao.deleteEmployee(id);
    }

}
