<%-- 
    Document   : AddUpdateItem
    Created on : 1 Dec, 2014, 3:30:04 PM
    Author     : priyanka
--%>

<%@page import="FortyNinerZone.UserDetails"%>
<%@include file="includes/header.jsp" %>

<table class="nav-table">
    <tr>
        <td>
            <nav> 
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="ShoppingCatalog.jsp">Shopping catalog</a>
        
            </nav>

        </td>

        <td>
            <div class="breadcrumb-links">
                <a href="index.jsp" id="breadcrumb">Home</a> &raquo;
                <a href="ShoppingCatalog.jsp" id="breadcrumb">Shopping-Catalog</a> &raquo;
                <a href="UpdateCatalog.jsp" id="breadcrumb"> Update Catalog </a> 
            </div>
        </td> 
    </tr>
</table>

<br/> <br/>

<% 
String updtmsg = (String)request.getAttribute("updatemsg");
if (updtmsg != null)
   {    %>
   <p style="font-family: Calibri; color:red;font-size: large"> <%=updtmsg %> 
     <% 
   }
   
   %>
<main>
     <form action="Admin" method="post">
  <table style="border-spacing:10px"> 
     
      <tr>
           <td style="width:300px;"><label> Catalog name </label> </td> 
           <td style="width:500px;"><input type="text" class="reginputbox" name="catname"  value="<%= request.getAttribute("catname") %>" required <% if(updtmsg != null) { %> readonly <% } %> /></td>
       </td>          
      </tr>
      <tr/> <tr/>
      <tr>
           <td><label> Catalog Description </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="catdesc" value="<%= request.getAttribute("catdesc")%>" <% if(updtmsg != null) { %> readonly <% } %>/></td>
      </tr>
      
  </table>
      <br/>
      <br/>
   <div class="addtocartfooter">     
       <button class="button" type="submit" name="action" value="updateCatDB">Update Database</button>  
       <input type="hidden" value="<%= request.getAttribute("catname")%>" name="catold" />
    </div>
       </form>
      
</main>
    <%@include file="includes/footer.jsp" %>