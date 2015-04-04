<%-- 
    Document   : search
    Created on : 27 Nov, 2014, 12:16:33 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>

<div id="content">
    <h2>ADD FLIGHT DETAILS</h2>
    <form action="addflightdetails" method="post">
    <h3>Flight Number</h3>
    <input type="text" name="flightnum" class="flightnum" required="required" placeholder="Enter Flight Number">
    <h3>Source</h3>
    <select name="source" id="source" required="required" >
        <option value="select">--Select--</option>
        <option value="Douglas INT Airport-CLT">Douglas INT Airport-CLT</option>
        <option value="JFK INt Airport-NYC">JFK INt Airport-NYC</option>
        <option value="Chicago">Chicago O'Hare INT Airport</option>
    </select>
    <h3>Destination</h3>
    <select name="destination" id="destination" required="required" >
        <option value="select">--Select--</option>
        <option value="Douglas INT Airport-CLT">Douglas INT Airport-CLT</option>
        <option value="JFK INt Airport-NYC">JFK INt Airport-NYC</option>
        <option value="Chicago">Chicago O'Hare INT Airport</option>
    </select>
    <h3>Flight Type</h3>
    <input type="text" name="flighttype" class="flighttype" required="required" placeholder="Enter Flight Type">
    <h3>Arrival Time</h3>
    <input type="time" name="arrival" class="arrival" required="required" placeholder="Enter Arrival Time">
    <h3>Departure Time</h3>
    <input type="time" name="departure" class="departure" required="required" placeholder="Enter Departure Time">
    
    <input type="submit" class="addbutton" value="Add Flight Details">
    </form>     
</div>
<%@ include file= "footer.jsp" %>


