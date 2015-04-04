<%-- 
    Document   : Login
    Created on : 27 Nov, 2014, 11:59:58 AM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Please enter your Login Details</h1>
<form action="LoginController" method="post">
Username: <input type="text" name="username"><br><br>
password : <input type="password" name="password"><br><br>
<input type="submit" name="action" value="login"><br><br>
</form>

<a href="getUser.jsp">Forgot your Password</a><br><br>
<a href="Register.jsp">Sign Up</a>

</div>

<%@ include file= "footer.jsp" %>
