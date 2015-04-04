<%-- 
    Document   : editJob
    Created on : Nov 28, 2014, 11:57:55 PM
    Author     : AndrewMannikus
--%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/site-navigation.jsp" %>
<div align="center">
    <form method="POST" action="EditJobSerlvet">
        <br>
        ${html}
        
    </form>
        <button onclick="window.location.href='jobPortal.jsp'">Back</button>
</div>
<%@include file="includes/footer.jsp" %>

