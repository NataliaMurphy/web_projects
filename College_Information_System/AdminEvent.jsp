
<%--
    Document   : AdminEvent
    Created on : Dec 1, 2014, 10:10:13 AM
    Author     : LokeshPC
--%>
<% String view = request.getParameter("v");
    if (view == null || !view.equals("widget")) {    
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
        
    </div>
 
        </td>
    </tr>
</table>
<%
 }
    else {
        Thread.sleep(2000);
        
    }
%>

<div id="content" >
   
   
    <div >
        <h1>  Up coming Event </h1>
        <jsp:include page="AdminEvent?eventid=heading1" flush="True"/>

       
    </div>   
  </div>
 
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>