<%-- 
    Document   : searchupdate
    Created on : 2 Dec, 2014, 5:55:35 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>

<div id="content">
    <h2>ENTER FLIGHT DETAILS</h2>
    <form action="uflightdetails" method="post">
    <h3>Flight Number</h3>
    <input type="text" name="flightnum" class="flightnum" required="required" placeholder="Enter Flight Number">
    <input type="submit" name="updateflight" class="updateflight" value="Update flight">
    </form>
</div>
<%@ include file= "footer.jsp" %>



