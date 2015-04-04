

<%@page import="FortyNinerZone.bookprice"%>
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
                <a href="bookprice-home.jsp" id="breadcrumb"> Book Price Home Page</a> &raquo;
                <a href="addupdatebook.jsp" id="breadcrumb"> Add Update Book</a>
            </div>
        </td> 
    </tr>
</table>
<div id="content">
    
    <% HttpSession book = request.getSession();
    bookprice b = (bookprice) book.getAttribute("updatebook");
    %>
    <h1> UPDATE BOOK DETAILS </h1>
    
    <form action="update_book" method="post">
    
    <input type="hidden"  class="isbn" name ="isbn" value="<%=b.getIsbn()%>" >
    <h3>Title :  </h3>
    <input type="text"  class="title" name ="title"  value="<%=b.getBooktitle()%>" >
    <h3>Author :</h3>
    <input type="text"  class="author" name ="author" value="<%=b.getAuthor()%>" >
    <h3>Subject :</h3>
    <input type="text"  class="subject" name ="subject" value="<%=b.getBooksubject()%>">
    <h3>Year Published:</h3>
    <input type="text" name="year" value="<%=b.getYear()%>"><br>
    Format:-
    YYYY<br>
    <h3>Availability :</h3>
    <input type="text" name="availability" value="<%=b.getAvailability()%>">
    <h3>ImageURL:</h3>
    <input type="text" name="imageurl"  value="<%=b.getImageurl()%>">
    <h3>Links :</h3>
    <input type="text" name="links"  value="<%=b.getLinks()%>">
    <h3>Links2 :</h3>
    <input type="text" name="links2"  value="<%=b.getLinks2()%>">
    <h3>Price :</h3>
    <input type="text" name="price"  value="<%=b.getPrice()%>"><br><br>
    
    <input type="submit" value="Update" class="addupdate-button">    
    <input type="reset" value="Clear" class="clear-button">
    </form>

</div>
<%@include file="includes/footer.jsp" %> 
