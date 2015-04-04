

<%@page import="FortyNinerZone.UserDetails"%>
<%@include file="includes/header.jsp"  %>
<%UserDetails user=new UserDetails();
        user=(UserDetails)session.getAttribute("theUser");%>
        <body>
            
<table class="nav-table">
    <tr>
        <td>
            <nav>
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="NewsHomepage.jsp">News Home</a>
                <a href="Eventhomepage.jsp"> Events Home</a>
               </nav>
        </td>
        <td>
    <div class="breadcrumb">
        <a href="index.jsp">Home</a> &raquo;
        <a href="Eventhomepage.jsp"> Events Home</a> 
        
    </div>
 
        </td>
    </tr>
</table>
    <main>
        <h2> Payment Information</h2>
        <table>
            <tr>
                <td> First Name:</td>
                <td><input type="text" value="<%= user.getFirstName()%>" readonly="readonly"> </td>
            </tr>
            <tr>
                <td>
                    Last Name:
                </td>
                <td><input type="text" value="<%= user.getLastName()%>" readonly="readonly"></td>
           
            </tr>
            <tr>
                <td>
                    Student Number:
                </td>
                <td>
                    <input type="text" value="<%= user.getUserID()%>" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    Email ID:
                </td>
                <td>
                    <input type="text" value="<%= user.getEmailAddress()%>" readonly="readonly">
                </td>
            </tr>
            
        </table>
        
            <script>
                function display()
                {
                    alert("Payement made Successfully")
                }
            </script>
                <button class="button" type="submit" name="action" onclick="display()">Confirm Payment</button>
                
                <a href="Eventhomepage.jsp">
   <input type="button" value="Cancel" class="button"/>
</a>
 
 
          
    </main>   
    <%@include file="includes/footer.jsp" %>