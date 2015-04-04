

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="FortyNinerZone.Comment" %>
<!DOCTYPE html>
<html>
    <%@include file="includes/header.jsp" %>
    

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News Page</title>
    </head>
    <body>
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
         <a href="NewsHomepage.jsp">News Home</a> &raquo;
        
        
    </div>
 
        </td>
    </tr>
</table>
        <%  if(session!=null){
                String newsId = (String)session.getAttribute("newsid");
                String newsTitle = (String)session.getAttribute("newstitle");
                String description = (String)session.getAttribute("description");
                
                ArrayList<Comment> comment_list = (ArrayList<Comment>)session.getAttribute("comments");
                
        
    %>
        <h1><%=newsTitle%></h1>
        <p><%=description%></p>
        <br>
        
        <%
        for(Comment c : comment_list)
        {
            
            %>
            <%=c.getUserid()%>:
            <%=c.getComment()%><br>
           
            
        
                    <%}
                    %>
        
        <br>
        
      <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add a Comment </h4>
        <form action ="NewsController" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addComment" size="150" placeholder="Add your Comment here">
            <input type="hidden" name="newsid" value="<%=newsId%>"/>
            <% }%>
            <input type="hidden" name="header" value="comment"/>
            <br /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Add Comment" />
        </form>
        <br /><br />
        
    </body> 
    <%@include file="includes/footer.jsp" %>   
</html>
