<%-- 
    Document   : update_admin_profile
    Created on : 4 Dec, 2014, 4:12:40 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Update your profile </h1>
<a href="UpdateInformation?action=Backadmin">Back to homepage</a>
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
<input type="Submit" name="action" value="UpdateValues">

</form>

</div>
<%@ include file= "footer.jsp" %>