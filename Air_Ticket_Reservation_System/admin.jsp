<%-- 
    Document   : admin
    Created on : 27 Nov, 2014, 12:03:01 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    <h2>Welcome Admin !!</h2>
 
    <h4>Would you like to ...</h4>
    <a href="UpdateInformation?action=updateadmin">Update your personal information</a> <br>  <br>
    <a href="Addflights.jsp">Add flight details</a> <br> <br>
    <a href="searchupdate.jsp">Update flight details</a> <br> <br>
    <a href="searchdelete.jsp">Delete flight details</a> <br> <br>
    <a href="UpdateInformation?action=allorders">View all order details</a> <br> <br>
    
    
</div>
<%@ include file= "footer.jsp" %>