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
    <h2>SEARCH FOR FLIGHTS</h2>
    <form action="SearchController" method="post">
    <div class="left-column">
    <h3>One Way: <input type="radio" required="required" name="radio" value="oneway" class="one-radio"></h3>
    <h3>Source</h3>
    <select name="source" id="source" required="required" >
        <option value="select">--Select--</option>
        <option value="Douglas INT Airport-CLT">Douglas INT Airport-CLT</option>
        <option value="JFK INt Airport-NYC">JFK INt Airport-NYC</option>
        <option value="Chicago O Hare INT Airport">Chicago O Hare INT Airport</option>
    </select>
    <h3>Class</h3>
    <select name="Class_select" required="required" >
        <option value="select">--Select--</option>
        <option value="Economy">Economy</option>
        <option value="Business">Business</option>
    </select>
    <h3>Start Date</h3>
    <input type="text" name="datepicker" id="datepicker" required="required" placeholder="Enter Date"><br><br>
    <input type="submit" class="searchbutton" name="action" value="Search">
    </div>
    <div class="right-column">
    <h3>Round Trip: <input type="radio" name="radio" value="roundtrip" required="required" class="round-radio"></h3>
    <h3>Destination</h3>
    <select name="destination" id="destination" required="required" >
        <option value="select">--Select--</option>
        <option value="Douglas INT Airport-CLT">Douglas INT Airport-CLT</option>
        <option value="JFK INt Airport-NYC">JFK INt Airport-NYC</option>
        <option value="Chicago O Hare INT Airport">Chicago O Hare INT Airport</option>
    </select>
    <h3>Number of Passengers</h3>
    <input type="number" name="passenger" class="passenger" required="required" placeholder="Enter no. of passengers">
    <h3>End Date</h3>
    <input type="text" name="datepicker1" id="datepicker1" required="required" placeholder="Enter Date">
    </div> 
    </form>     
</div>
<%@ include file= "footer.jsp" %>


