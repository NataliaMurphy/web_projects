<%-- 
    Document   : Update
    Created on : 28 Nov, 2014, 8:56:23 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Update your profile </h1>
<a href="UpdateInformation?action=Back">Back to homepage</a>
<form action="UpdateInformation" method="get">
    <br>
    <br>
    
Please update your information and update<br>
    <br>
Email Address : ${updateinfo.emailaddress}   Updated Value :<input type="text" name="email" required="required"> <br><br>
Address : ${updateinfo.address}   Updated Value : <input type="text" name="address" required="required"><br><br>
    
City : ${updateinfo.city}  Updated Value :<input type="text" name="city" required="required"><br><br>
State : ${updateinfo.state} Updated Value :<input type="text" name="state" required="required"><br><br>
Zipcode : ${updateinfo.zipcode} Updated Value :<input type="text" name="zip" required="required"><br><br>
Phone : ${updateinfo.getPhone_Number()} Updated Value :<input type="text" name="phone" required="required"><br><br>
<input type="Submit" name="action" value="UpdateValue">

</form>

</div>
<%@ include file= "footer.jsp" %>