<%-- 
    Document   : NewsPage
    Created on : Nov 20, 2014, 9:41:04 AM
    Author     : LokeshPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="includes/header.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News Page</title>
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
        <a href="AdminNews.jsp">News Home</a> &raquo;
    </div>
 
        </td>
    </tr>
</table>
        <form name="Addition" method='post' action ="AdminControllerNews"  >
            <br>
            <br>
            <br>
        <table>
                <tr> <td> News Id:</td> <td> <textarea name="newsid"></textarea></td> </tr>
                <tr> <td> News Title:</td>  <td><textarea  rows ="5" cols="50" name="newstitle" > </textarea> </td></tr>
        
                <tr> <td> News Description:</td> <td> <textarea rows ="5" cols="50" name="description"></textarea></td> </tr>
        
                <tr> <td colspan="2"> <input type="submit" value="Add" name="checkRedirect"> </td> </tr>
            </table>
        </form>
        <br /><br />
        
    </body> 
    <%@include file="includes/footer.jsp" %>   
</html>
