<%-- 
    Document   : AddBook
    Created on : 1 Dec, 2014, 9:41:24 PM
    Author     : Arj
--%>

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
                <a href="AddBook-home.jsp" id="breadcrumb"> Add Book Page</a>
            </div>
        </td> 
    </tr>
</table>

<div id="content">
    <h1>Add Book Details </h1>
    
    <form action="add_book" method="post">
    <h3>ISBN Number : </h3>
    <input type="text"  class="isbn" name ="isbn" maxlength="5" required pattern="[0-9]{5}" placeholder="Enter your text here">
    <h3>Title :  </h3>
    <input type="text"  class="title" name ="title"  maxlength="20" required pattern="[a-zA-Z]+" placeholder="Enter your text here">
    <h3>Author :</h3>
    <input type="text"  class="author" name ="author"  maxlength="20" required pattern="[a-zA-Z]+" placeholder="Enter your text here">
    <h3>Subject :</h3>
    <input type="text"  class="subject" name ="subject"  maxlength="20" required pattern="[a-zA-Z]+"  placeholder="Enter your text here">
    <h3>Year Published:</h3>
    <input type="text" name="year" placeholder="Enter your text here"><br>
    Format:-
    YYYY<br>
    <h3>ImageUrl:</h3>
    <input type="text" name="imageurl" placeholder="Enter your text here"> 
     <h3>Availability :</h3>
    <input type="text" name="availability"  maxlength="2" required pattern="[0-9]{2}" placeholder="Enter your text here"> 
     <h3>Links :</h3>
    <input type="text" name="links"  placeholder="Enter your text here"> 
     <h3>Links2 :</h3>
    <input type="text" name="links2"  placeholder="Enter your text here"> 
    <h3>Price :</h3>
    <input type="text" name="price"  placeholder="Enter your text here"><br><br>
    
    <input type="submit" value="Add Book Details" class="Go-button">    
    <input type="reset" value="Clear" class="clear-button">
    </form>

</div>
<%@include file="includes/footer.jsp" %>  
