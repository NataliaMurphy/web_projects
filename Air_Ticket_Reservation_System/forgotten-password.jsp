<%-- 
    Document   : forgotten-password
    Created on : 27 Nov, 2014, 12:08:28 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h1>Forgotten Password</h1>
<form action="forgotPassword" method="post">
Please answer your security question: ${forgot.question1}<br><br><br>
Answer : <input type="text" name="answer"> <br><br><br>
<input type="hidden" name="action" value="checkpassword"><input type="Submit" value="Submit">
<input type="reset" value="Reset">
</form>
</div>
<%@ include file= "footer.jsp" %>