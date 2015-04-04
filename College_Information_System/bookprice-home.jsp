<%-- 
    Document   : bookprice-home
    Created on : 29 Oct, 2014, 2:55:33 PM
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
                <a href="bookprice-home.jsp" id="breadcrumb"> Book Price Comparator Home Page</a> 
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
<div id="content">
    <h1> BOOK PRICE COMPARATOR </h1>
    
    <form action="search_book" method="post">
    <h3>ISBN Number : </h3>
    <input type="text"  class="isbn" name ="isbn"  placeholder="Enter your text here">
    <h3>Title :  </h3>
    <input type="text"  class="title" name ="title"  placeholder="Enter your text here">
    <h3>Author :</h3>
    <input type="text"  class="author" name ="author"  placeholder="Enter your text here">
    <h3>Subject :</h3>
    <input type="text"  class="subject" name ="subject"  placeholder="Enter your text here">
    <h3>Year Published:</h3>
    <input type="text" name="year" placeholder="Enter your text here"><br>
    Format:-
    YYYY<br><br>
    
    <input type="submit" value="Go" class="Go-button">    
    <input type="reset" value="Clear" class="clear-button">
    </form>

</div>
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>