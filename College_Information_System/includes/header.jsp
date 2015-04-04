

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    
    <% 
    HttpSession currentSession = request.getSession();    
    String name = (String)currentSession.getAttribute("firstname");
    if(name == null){
        name = "Guest";
    }
    %>
    
    <head>
        <title>49er-Zone All about UNCC </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Style.css" rel="stylesheet" type="text/css">
         <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script type="text/javascript" src="js/js1.js"></script>
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo"><img src="images/UNCC_49ers.gif" alt="Logo"/></a>
            Welcome! to 49er-Zone <div id="usernav">
            <% if(name.equals("Guest")){
            %>
            <strong>Hi <%=name %> </strong> | <a href="Login.jsp">Log in</a>    
                    
         <%   }else {   %>
            <strong>Hi <%=name %> </strong> | <a href="Login?action=logout">Log Out</a>
            <% } %>
            </div>
        </header>