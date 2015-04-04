<%-- 
    Document   : Addprofile
    Created on : 1 Dec, 2014, 9:07:50 PM
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
                <a href="profile-home.jsp" id="breadcrumb"> Profile Home Page</a> &raquo;
                <a href="Addprofile-home.jsp" id="breadcrumb"> Add Profile Page</a>
            </div>
        </td> 
    </tr>
</table>
 
            <div id="content">
            <h3>ENTER PROFILE DETAILS </h3>
            <form action="add_profile" method="post">
            <h3>User ID: </h3>
            <input type="text" name="userid" class="userid" minlength="5" maxlength="9" required pattern="[0-9]{9}" placeholder="Enter your text here">
            <h3>First Name: </h3>
            <input type="text" name="firstname" class="firstname" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your text here">
            <h3>Last Name :  </h3>
            <input type="text" name="lastname" class="lastname" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your text here">
            <h3>Clubs :</h3>
            <input type="text" name="club" class="club" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your text here">
            <h3>Department :</h3>
            <input type="text" name="dept" class="dept" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your text here">
            <h3>Email ID :</h3>
            <input type="text" name="emailid" class="emailid" required pattern="^[a-zA-Z0-9-\_.]+@[a-zA-Z0-9-\_.]+\.[a-zA-Z0-9.]{2,5}$" placeholder="Enter your text here">
            <h3>Course :</h3>
            <input type="text" name="course" class="course" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your text here"><br><br>
            
            <input type="submit" value="Add Profile" class="PAdd-button" >
            <input type="reset" value="Clear" class="clear-button">
            </form>

            </div>
<%@include file="includes/footer.jsp" %>
        