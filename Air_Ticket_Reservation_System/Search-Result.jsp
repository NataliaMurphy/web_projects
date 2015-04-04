<%-- 
    Document   : Search-Result
    Created on : 27 Nov, 2014, 12:01:44 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="appdbpackage.Search"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<form action="OrderController" method="post">
<div id="content">
    <h2>Your Search Result</h2>
    <p>Journey Detais<p>
    Class:${search.flight_class}
    Date:${fromdate}<br> 
    Source : ${search.source} Destination : ${search.destination}
    

    
            <div id="forward">
            CLT-NYC
            <% 
            HttpSession session1 = request.getSession();
            
            ArrayList<Search> result = (ArrayList<Search>)session1.getAttribute("thesearch1");
            int i=0;%>
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

                    <% for(i = 0;i< (result.size());i++) { %>
                    <tr>
                        <td><input type="radio" required = "required" name="select" value="<%= result.get(i).getFlight_number() %>"></td>
                        <td><%= result.get(i).getFlight_number() %></td>
                        <td><%= result.get(i).getSource()%></td>
                        <td><%= result.get(i).getDestination()%></td>
                        <td><%= result.get(i).getDeparture()%></td>
                        <td><%= result.get(i).getArrival()%></td>
                        <td><%= result.get(i).getFlight_class()%></td>
                        <td><%= result.get(i).getAvailable_seats()%></td>
                        <td>$<%= result.get(i).getPrice()%></td>
                    </tr>
                
                    <% } %>
            </table>
        </div>
               
          
<br><br>
<input type="submit" value="Book" name="action">
</div>
                    </form>                    
<%@ include file= "footer.jsp" %>
