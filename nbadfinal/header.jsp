<%-- 
    Document   : header
    Created on : 13 Sep, 2014, 5:49:57 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BigCart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/css1.css">
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-2.1.0.min"></script>
        <script type="text/javascript" src="js/jqueryui/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <script type="text/javascript" src="js/js1.js"></script>
        <script type="text/javascript" src="js3.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        
            
    </head>
    <body>
        <div class="wrapper">
        <div class="header">
            <a href="index.jsp"><img src="images/logo.png" alt="logo-img"></a>
            <%HttpSession name = request.getSession();
            String loginname = (String) name.getAttribute("theuser");
            if(loginname == null) {
            loginname = "User";}
            %>
            <span class="header_login">Welcome <%=loginname%>
            </span>
            
           <!-- <a href="logout.jsp" id="logout">Log Out</a>-->
        </div>
    
