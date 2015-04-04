<%-- 
    Document   : applyJob
    Created on : Dec 3, 2014, 12:38:20 PM
    Author     : AndrewMannikus
--%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/site-navigation.jsp" %>
<div align="center">
    <form method="POST" action="ApplicationServlet">
        <br>
        ${html}
        <br>
        <br>
        Name <br> <input type="text" name="Name" size="15" />
        <br>
        <br>
        UserID <br> <input type="text" name="user" size="15" />
        <br>
        <br>
        Resume    (*Note: Maximum 2,000 Characters)<br> <textarea name="resume" rows="15" cols="75"></textarea>
        <br>
        <input type="submit" value="Submit Application"/>
    </form>
        <button onclick="window.location.href='jobPortal.jsp'">Back</button>
</div>
<%@include file="includes/footer.jsp" %>