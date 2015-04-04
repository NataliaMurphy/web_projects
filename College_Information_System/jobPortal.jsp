<%-- 
    Document   : job-portal
    Created on : Oct 20, 2014, 4:27:51 PM
    Author     : Andrew Mannikus
--%>
<%@page import="FortyNinerZone.UserDetails"%>
<%@page import="FortyNinerZone.JobsDB"%>
<%    
    String view = request.getParameter("v");
    if (view == null || !view.equals("widget")) {    
%>
    <%@include file="includes/header.jsp" %>
    <%@include file="includes/site-navigation.jsp" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <h1>Welcome to the 49er Zone Job Portal</h1>
        <br> 
<%
} else {
        Thread.sleep(2000); }
%>
    <%
        UserDetails user = (UserDetails)session.getAttribute("theUser");    
        JobsDB job = new JobsDB();
        String results = job.viewAllJobs(user);
        request.setAttribute("results", results);
    %>
        ${results}

<%
    if (view == null || !view.equals("widget")) {
%>  
    <%@include file="includes/footer.jsp" %>   
<%
    }
%>
