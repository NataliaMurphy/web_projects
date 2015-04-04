

<%@page import="FortyNinerZone.UserDetails"%>
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
                <a href="profile-home.jsp" id="breadcrumb"> Profile Home Page</a> &raquo;
                <a href="add-update-profile.jsp" id="breadcrumb"> Add Update Profile </a>
            </div>
        </td> 
    </tr>
</table>
    <div id="content">
     <% HttpSession profile = request.getSession();
    UserDetails b = (UserDetails) profile.getAttribute("updateprofile");
    %>
    <h2> Update Profile Details</h2>
    <form action="updateprofile" method="post">
    <h3>First Name: </h3>
    <input type="text" name="firstname" class="firstname" value="<%=b.getFirstName()%>">
    <h3>Last Name :  </h3>
    <input type="text" name="lastname" class="lastname" value="<%=b.getLastName()%>">
    <h3>Clubs :</h3>
    <input type="text" name="club" class="club" value="<%=b.getClub()%>">
    <h3>Department :</h3>
    <input type="text" name="dept" class="dept" value="<%=b.getDepartment()%>">
    <h3>Email ID :</h3>
    <input type="text" name="emailid" class="emailid" value="<%=b.getEmailAddress()%>">
    <h3>Course :</h3>
    <input type="text" name="course" class="course" value="<%=b.getCourse()%>"><br><br>

    <input type="submit" value="Update" class="uupdate-button">

    <input type="reset" value="Clear" class="clear-button">
    </form>

    </div>
 <%@include file="includes/footer.jsp" %>
        

