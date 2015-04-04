<%-- 
    Document   : profile-home
    Created on : 29 Oct, 2014, 12:24:23 PM
    Author     : Arj
--%>
<% String view = request.getParameter("v");
    if (view == null || !view.equals("widget")) {    
%>
<%@include file="includes/header.jsp" %>
<link href="style1.css" rel="stylesheet" type="text/css">
<table class="nav-table">
    <tr>
        <td>
            <nav> 
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
            </nav>

        </td>

        <td>
            <div class="breadcrumb-links">
                <a href="index.jsp" id="breadcrumb">Home</a> &raquo;
                <a href="profile-home.jsp" id="breadcrumb"> Profile Search Home Page</a> 
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
    <div id="profile-content">
        <h1> PROFILE DIRECTORY </h1>
        
        <div class="profile">
        <h2>Search for profile </h2>
        <form action="Basic_search" method="get">
            <input type ="search" name ="search_profile" placeholder="Enter your text here"><br>
        <input type="submit" class="Go-button" value="Go">
        </form>
        </div>
        
        <div class="advanced-profile">
        <h2>Advanced Search for profile </h2>
        <img src="images/help.png" id="myimage">
        <form action="Advanced-profile.jsp" method="get">
        <input type="submit" class="click-button" value="Click here">
        </form>
        </div>
        
    </div>
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>