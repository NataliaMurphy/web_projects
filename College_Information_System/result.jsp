
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
              
                <a href="result.jsp" id="breadcrumb">  New User Result Page</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession session2 = request.getSession();
                     ArrayList<NewUser> list = (ArrayList<NewUser>) session2.getAttribute("the_user_list");
                int k=0;%>
             
            
                <div class="main-content">
                    
                    <h3>
                        Your Profile Details
                    </h3>
                        
                    <table>
                        <tr>
                            <th>
                                Select
                            </th>
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
                        <% for(k = 0;k< (list.size());k++) { %>
                        <tr>
                            <td>
                                <input type="checkbox" name="check" class="check">
                            </td>
                            <td>
                               <%=list.get(k).getFirstName()%>
                            </td>
                            <td>
                                <%=list.get(k).getLastName()%>
                            </td>
                            <td>
                               <%=list.get(k).getClub()%>
                            </td>
                            <td>
                               <%=list.get(k).getDepartment() %>
                            </td>
                            <td>
                               <%=list.get(k).getEmailAddress()%>
                            </td>
                            <td>
                               <%=list.get(k).getCourse() %>
                            </td>
                        <% } %>
                    </table>
                          
                  <button onclick="goBack()">Go Back</button>
                    
                    
                </div>
               
            </div>
            <%@include file="includes/footer.jsp" %>
        

