<%-- 
    Document   : user_order
    Created on : 4 Dec, 2014, 2:22:34 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
    
 <c:choose>
 <c:when test="${temp1==1}"> 
      
     <h3>Your Orders</h3>
    
         
    <table>
        <tr>
        
        <th>Order_ID</th>
        <th>Ticket_number</th>
        <th>Flight_Number_Onward</th>
        <th>Flight_Number_Return</th>
        <th>From_Date</th>
        <th>Return_Date</th>
        <th>UserID</th>
        <th>Passengers</th>
        <th>Total_Price</th>
        <th>Class</th>
        <th>Dep_Forward</th>
        <th>Dep_Return</th>
        </tr>
        
        <c:forEach var="item" items="${orderlist}">
  
            <tr>  
                           
        <td><c:out value='${item.getOrder_ID()}'/></td>
        <td><c:out value='${item.getTicket_number()}'/></td>
        <td><c:out value='${item.getFlight_Number_Onward()}'/></td>
        <td><c:out value='${item.getFlight_Number_Return()}'/></td>
        <td><c:out value='${item.getFrom_Date()}'/></td>
        <td><c:out value='${item.getReturn_Date()}'/></td>
        <td><c:out value='${item.getUserID() }'/></td>
        <td><c:out value='${item.getPassengers()}'/></td>
        <td>$<c:out value='${item.getTotal_Price()}'/></td>
        <td><c:out value='${item.getFlight_Class()}'/></td>
        <td><c:out value='${item.getDeparture_Forward()}'/></td>
        <td> <c:out value='${item.getDeparture_Return()}'/></td> </tr>

</c:forEach>
  
    </table>
         
    
      
 </c:when> 
    <c:otherwise>
      
        <h3>Your Orders</h3><br>
       <p> There were no orders placed till now !! </p>
       
       

    </c:otherwise>   
    
                </c:choose>  
                    

</div>
<%@ include file= "footer.jsp" %>

