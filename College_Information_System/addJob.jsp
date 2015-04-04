<%-- 
    Document   : addJob
    Created on : Nov 28, 2014, 10:22:22 PM
    Author     : AndrewMannikus
--%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/site-navigation.jsp" %>
<div align="center">
    <form method="POST" action="AddJobServlet">
        <br>
        Job ID <br> <input type="text" name="jobid" size="15" />
        <br>
        <br>
        Job Title <br> <input type="text" name="title" size="15" />
        <br>
        <br>
        Short Description <br> <input type="text" name="sDescript" size="15" />
        <br>
        <br>
        Description <br> <textarea name="descript" rows="5" cols="50"></textarea>
        <br>
        <input type="submit" value="Add Job"/>
    </form>
    <button onclick="window.location.href='jobPortal.jsp'">Back</button>
</div>
<%@include file="includes/footer.jsp" %>
