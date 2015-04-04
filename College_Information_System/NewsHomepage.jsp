<%--
    Document   : newsEvent
    Created on : 19 Nov, 2014, 9:28:00 AM
    Author     : lokesh
--%>
 
<%@include file="includes/header.jsp" %>
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


<div>
    <div >
         <h1> News Article </h1>
        <jsp:include page="NewsController?newsid=heading" flush="True"/>
        
  
  
        

       
    </div>
</div>

 
<%@include file="includes/footer.jsp" %>  
