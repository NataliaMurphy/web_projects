<%-- 
    Document   : Register
    Created on : 27 Nov, 2014, 12:01:08 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    <h1>Please fill in the registration form</h1>
    <form action="LoginController" method="get">
    Firstname&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="firstname"><br><br>
    Lastname&nbsp&nbsp;&nbsp;: <input type="text" required="required" name="lastname"><br><br>
    Gender: <input type="radio" name="gender" required="required" value="male">Male
    <input type="radio" name="gender" required="required" value="female">Female<br>
    EmailAddress:<input type="email" required="required" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" name="email"><br><br>
    <h3>Please enter the UserID you use to Login to our Website</h3>
    UserID&nbsp&nbsp;&nbsp;: <input type="text" maxlength="10" required="required" name="userid"><br><br>
    
    <h3>Please enter your password</h3>
    Password&nbsp&nbsp;&nbsp;: <input type="password" required="required" maxlength ="16" name="password"><br><br>
    <h3>Please select your Security Question</h3><br>
    <select name="security" required="required" >
        <option  value="select">Select your Question</option>
        <option value="What is your Mother's Maiden name?">What is your Mother's Maiden name?</option>
        <option value="Who is your favourite teacher?">Who is your favourite teacher?</option>
        <option value="Who is your childhood best friend?">Who is your childhood best friend?</option>
        <option value="What is your favourite pet?">What is your favourite pet?</option>
    </select>
    Answer : <input type="text" required="required" required="required" name="answer"><br><br>
    <h4>Additional Personal Information</h4>
    Date of Birth : <input type="text" id="dob" required="required" name="dob"><label for="dob">(Format dd/mm/yyyy)</label> <br><br>
    Phone Number: <input type="number" maxlength="10" required="required" name="phone"><br><br>
    SSN: <input type="text"  maxlength="16" required="required" name="ssn"><br><br>
    Address: <input type="text" required="required" name="Address"><br><br>
    City &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="city"><br><br>
    State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="state"><br><br>
    Zipcode &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="number" required="required" name="zipcode"><br><br>
    <input type="submit" name="action" value="Register">
    <input type="reset" value="Reset" name="reset">
    </form>
    </div>
<%@ include file= "footer.jsp" %>

