<%-- 
    Document   : sresult
    Created on : 27 Nov, 2014, 5:38:08 PM
    Author     : Arj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="appdbpackage.Search"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<form action="OrderController" method="post">
<div id="content">
    <h2>Your Search Result</h2>
    <p>Forward Journey Details<p>
    Class:${search.flight_class}
    Date:${fromdate}<br> 
    Source : ${search.source} Destination : ${search.destination}
    <p>Return Journey Details</p>
    Date:${todate} <br>
    Source : ${search.destination} Destination : ${search.source}<br><br>

            
            <div id="forward">
            CLT-NYC
             <% 
            HttpSession session3 = request.getSession();
            ArrayList<Search> result3 = (ArrayList<Search>)session3.getAttribute("thesearch3");
            int k=0;%>
            
            <table>
                    <tr>
                        <th></th>
                        <th>Flight Number</th>
                        <th>Source</th>
                        <th>Destination</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Class</th>
                        <th>Availability</th>
                        <th>Price</th>

                    </tr>

                    <% for(k = 0;k< (result3.size());k++) { %>
                    <tr>
                        <td><input type="radio" required = "required" name="select1" value="<%= result3.get(k).getFlight_number() %>"></td>
                        <td><%= result3.get(k).getFlight_number() %></td>
                        <td><%= result3.get(k).getSource()%></td>
                        <td><%= result3.get(k).getDestination()%></td>
                        <td><%= result3.get(k).getDeparture()%></td>
                        <td><%= result3.get(k).getArrival()%></td>
                        <td><%= result3.get(k).getFlight_class()%></td>
                        <td><%= result3.get(k).getAvailable_seats()%></td>
                        <td>$<%= result3.get(k).getPrice()%></td>
                    </tr>
                
                    <% } %>
            </table>
        </div>
            <br>
        <div id="return">
            NYC- CLT
             <% 
            HttpSession session2 = request.getSession();
            ArrayList<Search> result2 = (ArrayList<Search>)session2.getAttribute("thesearch2");
            int j=0;%>
            <table>
                <tr>
                    <th></th>
                    <th>Flight Number</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Class</th>
                    <th>Availability</th>
                    <th>Price</th>

                </tr>
         <% for(j = 0;j< (result2.size());j++) { %>
                    <tr>
                        <td><input type="radio" required = "required"  name="select2" value="<%= result2.get(j).getFlight_number() %>"></td>
                        <td><%= result2.get(j).getFlight_number() %></td>
                        <td><%= result2.get(j).getSource()%></td>
                        <td><%= result2.get(j).getDestination()%></td>
                        <td><%= result2.get(j).getDeparture()%></td>
                        <td><%= result2.get(j).getArrival()%></td>
                        <td><%= result2.get(j).getFlight_class()%></td>
                        <td><%= result2.get(j).getAvailable_seats()%></td>
                        <td>$<%= result2.get(j).getPrice()%></td>
                    </tr>
                
                    <% } %>
            </table>
        </div>
          
<br><br>
<input type="submit" value="Book" name="action">
</div>
</form>
<%@ include file= "footer.jsp" %>



