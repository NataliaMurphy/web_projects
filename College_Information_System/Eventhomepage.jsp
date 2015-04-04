<%-- 
    Document   : Eventhomepage.
    Created on : Nov 29, 2014, 10:57:09 AM
    Author     : LokeshPC
--%>
<%   
    String view = request.getParameter("v");
    if (view == null || !view.equals("widget")) {   
%>
<%@include file="includes/header.jsp" %>
<%
} else {
        Thread.sleep(2000); }
%>
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
        
    </div>
 
        </td>
    </tr>
</table>
  


<div id="content" >
    <div >
         
    
   
  
        <h1>  Up coming Event </h1>
        <jsp:include page="EventController?eventid=heading1" flush="True"/>

       
    </div>   
  </div>
        <%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>  
<%
    }
%>
 
 