<%-- 
    Document   : bookresult
    Created on : 28 Nov, 2014, 7:22:05 PM
    Author     : Arj
--%>

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
                <a href="bookresult.jsp" id="breadcrumb"> Book Result Page</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession bookr = request.getSession();
                     ArrayList<bookprice> booklist = (ArrayList<bookprice>) bookr.getAttribute("the_book_list");
                int k=0;%>
             
            
                <div class="main-content">
                    
                    <h3>
                        Your Book Details
                    </h3>
                        
                    <table>
                        <tr>
                            
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
                            <td>
                               <img src="<%=booklist.get(k).getImageurl()%>" alt="image">
                            </td>
                            <td>
                               <%=booklist.get(k).getIsbn()%>
                            </td>
                            <td>
                                <%=booklist.get(k).getBooktitle()%>
                            </td>
                            <td>
                               <%=booklist.get(k).getAuthor()%>
                            </td>
                            <td>
                               <%=booklist.get(k).getBooksubject()%>
                            </td>
                            <td>
                               <%=booklist.get(k).getYear()%>
                            </td>
                            <td>
                               <%=booklist.get(k).getAvailability()%>
                            </td>
                            <td>
                                <a href="<%=booklist.get(k).getLinks()%>" ><%=booklist.get(k).getLinks()%></a>
                            </td>
                            <td>
                                <a href="<%=booklist.get(k).getLinks2()%>" ><%=booklist.get(k).getLinks2()%></a>
                            </td>
                            <td>
                               <%=booklist.get(k).getPrice()%>
                            </td>
                        <% } %>
                    </table>
                     <button onclick="goBack()" class="back">Go Back</button>
                     
               
            </div>
            <%@include file="includes/footer.jsp" %>
        


