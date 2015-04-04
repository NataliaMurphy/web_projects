<%-- 
    Document   : searchdelete
    Created on : 4 Dec, 2014, 8:35:14 AM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>

<div id="content">
    <h2>ENTER FLIGHT DETAILS</h2>
    <form action="dflightdetails" method="post">
    <h3>Flight Number</h3>
    <input type="text" name="flightnum" class="flightnum" required="required" placeholder="Enter Flight Number">
    <input type="submit" name="deleteflight" class="deleteflight" value="Delete flight">
    </form>
</div>
<%@ include file= "footer.jsp" %>
