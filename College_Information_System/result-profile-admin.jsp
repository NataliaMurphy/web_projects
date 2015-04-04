


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
                <a href="result-profile-admin.jsp" id="breadcrumb"> Admin Result Page</a>
            </div>
        </td> 
    </tr>
</table>
            <div class="area">
                <%HttpSession session2 = request.getSession();
                     ArrayList<NewUser> list = (ArrayList<NewUser>) session2.getAttribute("the_user_list");
                int k=0;%>
             
            
                <div class="main-content">
                     <form action="add-update-profile" method="get">
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
                                <input type="radio" name="radio" class="check" value="<%=list.get(k).getEmailAddress()%>">
                            </td>
                            <td id="tabled">
                               <%=list.get(k).getFirstName()%>
                            </td>
                            <td id="tabled">
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
                            <td id="tabled">
                               <%=list.get(k).getCourse() %>
                            </td>
                        <% } %>
                    </table>
                          
                  <button onclick="goBack()" class="back">Go Back</button>
                    
            <input type="submit" value="Update profile details" class="rupdate-button">
            </form>   
           <form action="admindeleteprofile.jsp" method="get">
           <input type="submit" value="Delete profile" class="delete-button">
           </form>
            <form action="Addprofile.jsp" method="get">
            <input type="submit" value="Add profile" class="add-button">
            </form>
          </div>

        </div> 
        <%@include file="includes/footer.jsp" %>
        


    
 

