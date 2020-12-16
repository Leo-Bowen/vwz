package com.models;

import com.jdbc.VWZDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private VWZDao vwzDao;
    private List<Employee> employeeList;

    public void addEmployee(String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        //Product product = new Product(3,"Apple",2, Date.valueOf("2020-12-03"));
        Employee entryemployee = new Employee(firstname, lastname, birthdate, entrydate, position, schedule);
        vwzDao.insertEmployeeData(entryemployee);
    }

    public List<Employee> loadProduct() throws ClassNotFoundException, SQLException {
        vwzDao = new VWZDao();
        employeeList = vwzDao.loadEmployee();
        return employeeList;
    }


}
