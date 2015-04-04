<%-- 
    Document   : AdminEventadd
    Created on : Dec 1, 2014, 10:30:49 AM
    Author     : LokeshPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="includes/header.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Page</title>
    </head>
    <body>
       
        <table class="nav-table">
    <tr>
        <td>
            <nav>
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="AdminNews.jsp">News Home</a>
                <a href="AdminEvent.jsp"> Events Home</a>
               </nav>
        </td>
        <td>
    <div class="breadcrumb">
        <a href="index.jsp">Home</a> &raquo;
        <a href="AdminEvent.jsp">Event Home</a> &raquo;
    </div>
 
        </td>
    </tr>
</table>
        
        <form name="Addition" method='post' action ="AdminEvent"  >
            <br>
            <br>
            <br>
        <table>
                <tr> <td> Event Id:</td> <td> <textarea name="eventid"></textarea></td> </tr>
                <tr> <td> Event Title:</td>  <td><textarea  rows ="5" cols="50" name="eventtitle" > </textarea> </td></tr>
        
                <tr> <td> Event Description:</td> <td> <textarea rows ="5" cols="50" name="eventdescription"></textarea></td> </tr>
        <tr> <td> Event Fare:</td>  <td><textarea   name="eventfare" > </textarea> </td></tr>
                <tr> <td colspan="2"> <input type="submit" value="Add" name="checkRedirect"> </td> </tr>
            </table>
        </form>
        <br /><br />
        
    </body> 
    <%@include file="includes/footer.jsp" %>   
</html>