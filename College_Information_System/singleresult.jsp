<%-- 
    Document   : singleresult
    Created on : 28 Nov, 2014, 4:31:11 PM
    Author     : Arj
--%>

<%@page import="FortyNinerZone.NewUser"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script>
function goBack() {
    window.history.back()
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
                <a href="profile-home.jsp" id="breadcrumb"> Profile Page</a> &raquo;
                <a href="result-profile-admin.jsp" id="breadcrumb"> Result Page</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession single = request.getSession();
                     ArrayList<NewUser> single_list = (ArrayList<NewUser>) single.getAttribute("the_single_list");
                int k=0;%>
             
            
                <div class="main-content">
                    
                    <h3>
                        Your Profile Details
                    </h3>
                        
                    <table>
                        <tr>
                           
                            <th>
                                First Name
                            </th>
                            <th>
                                Last Name
                            </th>
                            <th>
                                Club
                            </th>
                            <th>
                                Department
                            </th>
                            <th>
                                Email ID
                            </th>
                            <th>
                                Course
                            </th>
                        </tr>
                        <% for(k = 0;k< (single_list.size());k++) { %>
                        <tr>
                            
                            <td id="tabled">
                               <%=single_list.get(k).getFirstName()%>
                            </td>
                            <td id="tabled">
                                <%=single_list.get(k).getLastName()%>
                            </td>
                            <td>
                               <%=single_list.get(k).getClub()%>
                            </td>
                            <td>
                               <%=single_list.get(k).getDepartment() %>
                            </td>
                            <td>
                               <%=single_list.get(k).getEmailAddress()%>
                            </td>
                            <td id="tabled">
                               <%=single_list.get(k).getCourse() %>
                            </td>
                        <% } %>
                    </table>
                          
                    <button onclick="goBack()" class="back">Go Back</button>                    
                    
                </div>
               
            </div>
            <%@include file="includes/footer.jsp" %>
        

