<%-- 
    Document   : userhomepage
    Created on : 17 Nov, 2014, 7:54:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    <h2>Hello User ..!!</h2>
    <br>
   
    <h4>What would you like to do today ?</h4>
     <br>
    <a href="UpdateInformation?action=update">Update your personal information </a> <br>  <br>
    <a href="search.jsp">Search a new flight</a> <br> <br>
    <a href="UpdateInformation?action=orders">View your current orders</a> <br> <br>
    
    
</div>
<%@ include file= "footer.jsp" %>