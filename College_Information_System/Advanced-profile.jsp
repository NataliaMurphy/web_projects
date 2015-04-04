<%-- 
    Document   : Advanced-profile
    Created on : 29 Oct, 2014, 3:43:01 PM
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
                <a href="Advanced-profile.jsp" id="breadcrumb"> Advance Search page </a>
            </div>
        </td> 
    </tr>
</table>
 
            <div id="content">
            <h3>ENTER PROFILE DETAILS FOR ADVANCED SEARCH</h3>
            <form action="profile" method="post">
            <h3>First Name: </h3>
            <input type="text" name="firstname" class="firstname" placeholder="Enter your text here">
            <h3>Last Name :  </h3>
            <input type="text" name="lastname" class="lastname" placeholder="Enter your text here">
            <h3>Clubs :</h3>
            <input type="text" name="club" class="club" placeholder="Enter your text here">
            <h3>Department :</h3>
            <input type="text" name="dept" class="dept" placeholder="Enter your text here">
            <h3>Email ID :</h3>
            <input type="text" name="emailid" class="emailid" placeholder="Enter your text here">
            <h3>Course :</h3>
            <input type="text" name="course" class="courses" placeholder="Enter your text here"><br><br>
            
            <input type="submit" value="Go" class="Go-button" >
            <input type="reset" value="Clear" class="clear-button">
            </form>

            </div>
<%@include file="includes/footer.jsp" %>
        

