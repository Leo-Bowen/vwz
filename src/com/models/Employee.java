package com.models;

import java.sql.Date;

public class Employee {
    private int id;

    private String firstname;

    private String lastname;

    private Date birthdate;

    private Date entrydate;

    private String position;

    private String schedule;


    public Employee(String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.entrydate = entrydate;
        this.position = position;
        this.schedule = schedule;
    }

    public Employee(int id,String firstname, String lastname, Date birthdate, Date entrydate, String position, String schedule) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.entrydate = entrydate;
        this.position = position;
        this.schedule = schedule;
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public String getPosition() {
        return position;
    }

    public String getSchedule() {
        return schedule;
    }

}
