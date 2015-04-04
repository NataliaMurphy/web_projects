/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

import java.io.Serializable;

/**
 *
 * @author Arj
 */
public class Login implements Serializable {

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    private String userID, password,firstname,lastname,emailaddress,SSN,address,city,state,zipcode,Date_Of_birth,Gender,
           question1, answer1;
    private String Phone_Number;
    int Role;
  
   public Login() 
   {
        userID = "";
        password="";
        firstname="";
        lastname="";
        emailaddress="";
        SSN="";
        address="";
        Date_Of_birth="";
        Phone_Number= "";
        Gender="";
        question1="";
        answer1="";
        city="";
        state="";
        zipcode="";
        Role=0;
               
    }
   public Login(String userID,String password,String firstname,String lastname,String emailaddress,String SSN ,String address
           ,String city,String state,String zipcode,String Date_Of_birth,String Phone_Number,String Gender,String question1,String answer1) 
   {
       this.userID = userID;
       this.password = password;
       this.firstname = firstname;
       this.lastname = lastname;
       this.emailaddress = emailaddress;
       this.SSN = SSN;
       this.address = address;
       this.city=city;
       this.state=state;
       this.zipcode=zipcode;
       this.Date_Of_birth = Date_Of_birth;   
       this.Phone_Number = Phone_Number;  
       this.Gender = Gender; 
       this.question1 = question1; 
       this.answer1 = answer1;
      
    }
   public Login(int Role){
       this.Role= Role;
   }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
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

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_Of_birth() {
        return Date_Of_birth;
    }

    public void setDate_Of_birth(String Date_Of_birth) {
        this.Date_Of_birth = Date_Of_birth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

  
    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
   
  }
