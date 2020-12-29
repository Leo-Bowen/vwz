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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
