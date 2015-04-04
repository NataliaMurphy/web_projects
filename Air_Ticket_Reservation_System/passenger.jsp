<%-- 
    Document   : passenger
    Created on : 3 Dec, 2014, 8:10:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    
    <h2> Most preferred flight of Travel </h2>
    <p> Based on current orders by users: </p>
    <p> Flight preferred for Onward Journey : ${a2.flight_onward} </p>
    <p> Flight preferred for Return Journey : ${b2.flight_return} </p>
</div>
<%@ include file= "footer.jsp" %>