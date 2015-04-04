

<%@page import="FortyNinerZone.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
UserDetails user = (UserDetails) session.getAttribute("theUser");
int usertype = user.getUserType();
if(usertype == 0)
{
    %>
    <form action="Eventhomepage.jsp" >
    <input type="hidden" />
    </form>
    <%
} 
 %>

    <%@include file="includes/header.jsp" %>
       
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
        <form name="updation" method='post' action ="AdminEvent"  >
            <br/>
            <br/>
            <br/>
            <table>
                <tr>
                    <td>Event ID:</td> <td> <input type="text" value="${eventid}" readonly="readonly" name="eventid"></td> </tr>
                <tr> <td>  Event Title:</td> <td><textarea  rows ="5" cols="50" name="eventtitle" > ${eventtitle} </textarea></td> </tr>
        
                <tr> <td> Event Description:</td> <td>  <textarea rows ="5" cols="50" name="eventdescription">${eventdescription}</textarea> </td> </tr>
      <tr> <td> Event Fare:</td> <td>  <textarea name="eventfare" >${eventfare}</textarea> </td> </tr>
                <tr> <td colspan="2"> <input type="submit" value="Update DataBase" name="checkRedirect"> </td> </tr>
            </table>
        </form>
        <br /><br />
        
    </body> 
    <%@include file="includes/footer.jsp" %>   
</html>

