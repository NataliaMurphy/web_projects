<%-- 
    Document   : getUser
    Created on : 27 Nov, 2014, 5:29:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Forgotten Password</h1>
<form action="forgotPassword" method="post">
Please enter your user_id:<input type="text" name="userid">
<input type="hidden" name="action" value="forgot"><input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
</div>
<%@ include file= "footer.jsp" %>