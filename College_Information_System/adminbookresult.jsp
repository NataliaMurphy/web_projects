

<%@page import="FortyNinerZone.bookprice"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script>
function goBack() {
    window.history.back();
}
</script>
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
                <a href="adminbookresult.jsp" id="breadcrumb"> Admin Book result</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession bookr = request.getSession();
                     ArrayList<bookprice> booklist = (ArrayList<bookprice>) bookr.getAttribute("the_book_list");
                int k=0;%>
             
                
                <div class="main-content">
                   <form action="add_update_book" method="get"> 
                    <h3>
                        Your Book Details
                    </h3>
                        
                    <table>
                        <tr>
                            <th>
                                Select
                            </th>
                            <th>
                                Image
                            </th>
                            <th>
                                ISBN NO
                            </th>
                            <th>
                                Title
                            </th>
                            <th>
                                Author
                            </th>
                            <th>
                                Subject
                            </th>
                            <th>
                                Year
                            </th>
                            <th>
                                Availability
                            </th>
                            <th>
                                Links
                            </th>
                            <th>
                                Links2
                            </th>
                            <th>
                                Price
                            </th>
                        </tr>
                        <% for(k = 0;k< (booklist.size());k++) { %>
                        <tr>
                            <td id="tabled">
                                <input type="radio" name="radio" class="check" value="<%=booklist.get(k).getIsbn()%>">
                            </td>
                            <td>
                               <img src="<%=booklist.get(k).getImageurl()%>" alt="image">
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getIsbn()%>
                            </td>
                            <td id="tabled">
                                <%=booklist.get(k).getBooktitle()%>
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getAuthor()%>
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getBooksubject()%>
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getYear()%>
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getAvailability()%>
                            </td>
                            <td>
                            <a href="<%=booklist.get(k).getLinks()%>" target="blank" ><%=booklist.get(k).getLinks()%></a>
                            </td>
                            <td>
                            <a href="<%=booklist.get(k).getLinks2()%>" target="blank" ><%=booklist.get(k).getLinks2()%></a>
                            </td>
                            <td id="tabled">
                               <%=booklist.get(k).getPrice()%>
                            </td>
                        <% } %>
                    </table>
                     <button onclick="goBack()" class="back">Go Back</button>
          
                        
                    <input type="submit" value="Update book details" class="update-button">
                    </form>
                    <form action="admindeletebook.jsp" method="post">
                    <input type="submit" value="Delete book details" class="delete-button">
                    </form>
                    <form action="AddBook.jsp" method="post">
                    <input type="submit" class="add-button" value="Add book details">
                    </form>
                    </div>

                </div>
              
            <%@include file="includes/footer.jsp" %>
        



