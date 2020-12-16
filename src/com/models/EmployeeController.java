package com.models;

import com.jdbc.VWZDao;

import java.sql.Date;
import java.sql.SQLException;

public class EmployeeController {
    private VWZDao vwzDao;

    public void addEmployee(String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        //Product product = new Product(3,"Apple",2, Date.valueOf("2020-12-03"));
        Employee entryemployee = new Employee(firstname, lastname, birthdate, entrydate, position, schedule);
        vwzDao.insertEmployeeData(entryemployee);
    }

}
