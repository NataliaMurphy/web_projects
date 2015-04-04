<%-- 
    Document   : events
    Created on : Nov 24, 2014, 3:42:01 PM
    Author     : LokeshPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="includes/header.jsp" %>
    <form action="PaymentEvent.jsp">
   
       <table class="nav-table">
    <tr>
        <td>
            <nav>
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="NewsHomepage.jsp">News Home</a>
                <a href="Eventhomepage.jsp"> Events Home</a>
               </nav>
        </td>
        <td>
    <div class="breadcrumb">
        <a href="index.jsp">Home</a> &raquo;
        <a href="Eventhomepage.jsp"> Events Home</a> 
        
    </div>
 
        </td>
    </tr>
</table>
        <h1>${eventtitle}</h1>
        <br>
        <p>
            ${eventdescription}
        </p>
        <h2 style="text-align:right;right:20px"> Event Fare:$${eventfare}</h2>
        
     
        
       
        
            
            
            <input type="submit" value="Book Ticket" style="float:right;" >
        </form>
     
        
        <br>
        <br>
        <br>
    <br>
    <br>
    <br>
    
    </body>
    
    
    
            
    <%@include file="includes/footer.jsp" %>   
</html>
