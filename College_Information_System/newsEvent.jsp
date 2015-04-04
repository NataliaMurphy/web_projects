<%-- 
    Document   : newsEvent
    Created on : 19 Nov, 2014, 9:28:00 AM
    Author     : priyanka
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
<div id="content" style="width:90%;padding-left:10px;padding-right:10px">
    <div style="width: 55%;display: inline;float: left;border-right: 1px solid #1F5C3D;padding-left:2px">
        <h1> News headlines </h1>
        <h2> <a href="news.jsp">Belk College NEXT Speaker to Focus on Innovation, Creativity</a> </h2> <br>
        <h2> <a href="news.jsp">UNC Charlotte Marching Band Named: 'Pride of Niner Nation'</a></h2> <br>
        <h2> <a href="news.jsp">Levine Scholars Program Extended with $13 Million Gift</a> </h2> <br>
        <h2> <a href="news.jsp">Professors Reveal Cost of Domestic Violence in North Carolina</a> </h2>
    </div>    
   
    <div style="width: 41%;display: inline;float: right;">
        <h1>  Up coming Event </h1>
        <h2> <a href="news.jsp">The Agile Product Owner</a> </h2> <br>
        <h2> <a href="news.jsp">International Coffee hour</a> </h2> <br>
        <h2> <a href="news.jsp">Workshop on Aging in Turkey</a> </h2>
        
    </div>    
  </div>
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>