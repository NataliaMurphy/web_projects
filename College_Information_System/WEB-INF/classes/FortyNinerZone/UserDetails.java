
package FortyNinerZone;

import java.io.Serializable;

public class UserDetails implements Serializable {

    private String UserID;
    private String userpassword;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String ZIP;
    private String DateOfBirth;
    private String PhoneNum;
    private String Course;
    private String Department;
    private String Club;
    private char Gender;
    private int UserType;
    private String ques1;
    private String ans1;
    private String ques2;
    private String ans2;


    public UserDetails()
    {
        this.UserID = UserID;
        this.userpassword = userpassword;
    }


    public UserDetails(String UserID, String userpassword, String FirstName, String LastName,String EmailAddress, String Address, String City, String State, String ZIP, int UserType, String ques1, String ans1, String ques2, String ans2) {
        this.UserID = UserID;
        this.userpassword = userpassword;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailAddress = EmailAddress;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.ZIP = ZIP;
        this.UserType = UserType;
        this.ques1 = ques1;
        this.ans1 = ans1;
        this.ques2 = ques2;
        this.ans2 = ans2;
    }



    public UserDetails(String UserID, String FirstName, String LastName, String EmailAddress, String Address, String City, String State, String Country, String ZIP) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailAddress = EmailAddress;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.ZIP = ZIP;
    }

    public UserDetails(String FirstName, String LastName,String Club,String Department, String EmailAddress, String Course)
	    {

	        this.FirstName = FirstName;
	        this.LastName = LastName;
	        this.Club = Club;
	        this.Department = Department;
	        this.EmailAddress = EmailAddress;
	        this.Course = Course;
	    }

    public UserDetails(String UserID, String userpassword, String FirstName, String LastName, String EmailAddress, String Address, String City, String State, String Country, String ZIP, String DateOfBirth, String PhoneNum, String Course, String Department, String Club, char Gender, int UserType, String ques1, String ans1, String ques2, String ans2)
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
        this.ZIP = ZIP;
        this.DateOfBirth = DateOfBirth;
        this.PhoneNum = PhoneNum;
        this.Course = Course;
        this.Department = Department;
        this.Club = Club;
        this.Gender = Gender;
        this.UserType = UserType;
        this.ques1 = ques1;
        this.ans1 = ans1;
        this.ques2 = ques2;
        this.ans2 = ans2;
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
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
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

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public String getQues1() {
        return ques1;
    }

    public void setQues1(String ques1) {
        this.ques1 = ques1;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getQues2() {
        return ques2;
    }

    public void setQues2(String ques2) {
        this.ques2 = ques2;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getFullName() {
        return String.format("%s %s", this.FirstName, this.LastName);
    }

}
