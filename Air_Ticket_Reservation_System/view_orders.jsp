<%-- 
    Document   : view_orders
    Created on : 15 Nov, 2014, 3:30:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    <h3> Your Current Orders : </h3>
    
 <table style="width:100%">
  <tr>
    <th>Order ID</th>
    <th>Ticket Number</th>		
    <th>Flight Number</th>
    <th>Flight Type</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Departure</th>
    <th>Arrival</th>
    <th>Start Date</th>
    <th>Price</th>
    <th>Cancel Ticket Y/N?</th>
  </tr>
  <tr>
    <td>1258962</td>
    <td>552862</td>		
    <td>NC1456</td>
    <td>Boeing 187</td>
    <td>Charlotte- CLT</td>
    <td>New York- NYK</td>
    <td>19:00</td>
    <td>23:00</td>
    <td>25/11/2014</td>
    <td>$550</td>
    <td><input type="button" value="Delete"> </td>
  </tr>
  <tr>
    <td>1258962</td>
    <td>662689</td>		
    <td>NC5698</td>
    <td>Boeing 127</td>
    <td>New York- NYK</td>
    <td>Charlotte-CLT</td>	
    <td>9:00</td>
    <td>11:00</td>
    <td>12/12/2014</td>
    <td>$650</td>
    <td><input type="button" value="Delete"> </td>
    
  </tr>
  
</table>
    
    
</div>
		
<%@ include file= "footer.jsp" %>