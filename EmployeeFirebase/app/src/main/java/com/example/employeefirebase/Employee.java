package com.example.employeefirebase;

public class Employee {

    private String l_name, f_name;

    Employee(){

        this.f_name = "empty";
        this.l_name = "empty";

    }

    Employee(String fname, String lname){
        this.f_name = fname;
        this.l_name = lname;
    }

    public String getFirstName() {
        return f_name;
    }

    public String getLastName() {
        return l_name;
    }

    public void setFirstName(String firstname) {
        this.f_name = firstname;
    }

    public void setLastName(String lastname) {
        this.l_name = lastname;
    }

    public String toString(String ID) {
        return "ID: " + ID + "\n" + "First Name: " + f_name + "\n" + "Last Name: " + l_name + "\n" + "\n";

    }
}