 
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
       
        <h1> News Article </h1>
       <jsp:include page="AdminControllerNews?newsid=heading" flush="True"/>
       
       
       
        

    </div>   
   
      
  </div>
 
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>