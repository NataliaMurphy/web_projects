<%-- 
    Document   : order
    Created on : Dec 3, 2014, 4:09:47 PM
    Author     : Premkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<form action="OrderController" method="post">
<div id="content">
    <c:choose>
        <c:when test="${user==null}">
            Your not Logged in.Please <a href="Login.jsp">Login</a> to proceed with the order.
        </c:when>  
        <c:otherwise>
            <c:choose>
                <c:when test="${radio == 'oneway'}">
                    <h2>Your Journey Details</h2>
                    Your flight number:${order.flight_num_for}<br><br>
                    Class:${search.flight_class}<br><br>
                    Source:${search.source}<br><br>
                    Destination:${search.destination}<br><br>
                    Departure Time:${order.getDeparture_forward()} <br><br>                  
                    Total Price:${order.total_sum}<br><br><br>
                </c:when>
                <c:when test="${radio == 'roundtrip'}">
                    <h2>Your forward Journey Details</h2>              
                    Class:${search.flight_class}<br><br>
                    Your flight number:${order.flight_num_for}<br><br>
                    Source:${search.source}<br><br>
                    Destination:${search.destination}<br><br>
                    Departure Time:${order.getDeparture_forward()}<br><br><br>         
                     <h2>Your Return Journey Details</h2>
                     Class:${search.flight_class}<br><br>
                     Your flight number:${order.flight_num_return}<br><br>
                     Source:${search.destination}<br><br>
                     Destination:${search.source}<br><br>
                     Departure Time:${order.getDeparture_Return()}<br><br>
                    Total Price:${order.total_sum}<br><br><br>                   
                </c:when>
            </c:choose>
           <input type="submit" name="action" value="Checkout">
           
        </c:otherwise>
    </c:choose>
                    
</div>
</form>
<%@ include file= "footer.jsp" %>