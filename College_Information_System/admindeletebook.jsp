

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
                <a href="admindeletebook.jsp" id="breadcrumb"> Admin Delete Book Page</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession bookr2 = request.getSession();
                     ArrayList<bookprice> booklist2 = (ArrayList<bookprice>) bookr2.getAttribute("the_book_list2");
                int k=0;%>
             
                
                <div class="main-content">
                   <form action="deletebooks" method="get"> 
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
                        <% for(k = 0;k< (booklist2.size());k++) { %>
                        <tr>
                            <td>
                                <input type="radio" name="radio" class="check" value="<%=booklist2.get(k).getIsbn()%>">
                            </td>
                            <td>
                               <img src="<%=booklist2.get(k).getImageurl()%>" alt="image">
                            </td>
                            <td>
                               <%=booklist2.get(k).getIsbn()%>
                            </td>
                            <td>
                                <%=booklist2.get(k).getBooktitle()%>
                            </td>
                            <td>
                               <%=booklist2.get(k).getAuthor()%>
                            </td>
                            <td>
                               <%=booklist2.get(k).getBooksubject()%>
                            </td>
                            <td>
                               <%=booklist2.get(k).getYear()%>
                            </td>
                            <td>
                               <%=booklist2.get(k).getAvailability()%>
                            </td>
                            <td>
                                <a href="<%=booklist2.get(k).getLinks()%>" ><%=booklist2.get(k).getLinks()%></a>
                            </td>
                            <td>
                                <a href="<%=booklist2.get(k).getLinks2()%>" ><%=booklist2.get(k).getLinks2()%></a>
                                <td>
                               <%=booklist2.get(k).getPrice()%>
                            
                            </td>
                        <% } %>
                    </table>
                     <button onclick="goBack()" class="back">Go Back</button>
          
                    
                    <input type="submit" value="Delete book details" class="delete-button">
                    </form>

                </div>
               
            </div>
            <%@include file="includes/footer.jsp" %>
        



