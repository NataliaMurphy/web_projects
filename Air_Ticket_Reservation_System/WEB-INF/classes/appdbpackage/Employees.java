/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

/**
 *
 * @author Arj
 */
public class Employees {
        private String Employeeid, password,firstname,lastname,emailaddress;
        private int employeetype;


public Employees() {
    Employeeid = "";
    password = "";
    firstname = "";
    lastname = "";
    emailaddress= "";
    employeetype = 0;
}

    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String Employeeid) {
        this.Employeeid = Employeeid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public int getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(int employeetype) {
        this.employeetype = employeetype;
    }
}
