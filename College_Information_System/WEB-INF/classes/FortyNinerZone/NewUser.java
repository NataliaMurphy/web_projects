/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

/**
 *
 * @author Arj
 */

import java.io.Serializable;
import java.util.Date;

public class NewUser implements Serializable {
    
    private String UserID;
    private String userpassword;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String zipcode;
    private String DateOfBirth;   
    private String PhoneNum;
    private String Course;
    private String Department;
    private String Club;
    private String Gender;   
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private int UserType;
    
public NewUser()
{}

public NewUser(String UserID)
{
    this.UserID = UserID;
}

public NewUser(String firstname,String lastname,String club,String dept,String EmailAddress,String course)
{
     this.FirstName = firstname;
     this.LastName = lastname;
     this.Club = club;
     this.Department = dept;
     this.EmailAddress = EmailAddress;
     this.Course = course;
}

    public NewUser(String UserID, String FirstName, String LastName,
                       String EmailAddress, String Address, String City, String State, String Country,
                       String zipcode,String DateOfBirth, String PhoneNum, String Course, String Department,
                       String Club, String Gender,int UserType, String userpassword,String question1,String answer1,String question2,String answer2)
    {  
        this.UserID = UserID;
        this.userpassword = userpassword;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailAddress = EmailAddress;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.zipcode = zipcode;
        this.DateOfBirth = DateOfBirth;
        this.PhoneNum = PhoneNum;
        this.Course = Course;
        this.Department = Department;
        this.Club = Club;
        this.Gender = Gender;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.UserType = UserType;
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

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getZIP() {
        return zipcode;
    }

    public void setZIP(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String Club) {
        this.Club = Club;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }
                        
    
}

