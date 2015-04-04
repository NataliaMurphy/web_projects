<%-- 
    Document   : newpassword
    Created on : 27 Nov, 2014, 6:57:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Forgotten Password</h1>
<form action="forgotPassword" method="post">
    Please enter your New Password:<input type="password" required="required" name="nwpassword"> <br><br>
    Please re-enter your Password:<input type="password" required="required" name="re-password"><br><br>
<input type="hidden" name="action" value="change"><input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
</div>
<%@ include file= "footer.jsp" %>