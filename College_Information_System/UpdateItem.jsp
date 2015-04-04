<%-- 
    Document   : UpdateItem
    Created on : 1 Dec, 2014, 11:33:07 PM
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
                <a href="ShoppingItem.jsp" id="breadcrumb">Shopping-Item</a> &raquo;
                <a href="UpdateCatalog.jsp" id="breadcrumb"> Update Item </a> 
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
           <td style="width:300px;"><label> Item ID </label> </td> 
           <td style="width:500px;"><input type="text" class="reginputbox" name="itemID"  value="<%= request.getAttribute("itemidval") %>" required  readonly  /></td>
               
      </tr>
      <tr/> 
      <tr>
           <td><label> Item name </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemname" value="<%= request.getAttribute("itemname") %>" <% if(updtmsg != null) { %> readonly <% } %>/></td>
      </tr>
      <tr>
           <td><label> Item description </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemdesc" value="<%= request.getAttribute("itemdesc") %>" <% if(updtmsg != null) { %> readonly <% } %>/></td>
      </tr>
      <tr>
           <td><label> Item Price </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemprice" value="<%= request.getAttribute("itemprice") %>" <% if(updtmsg != null) { %> readonly <% } %>/></td>
      </tr>
      <tr>
           <td><label> Image  URL </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemURL" value="<%= request.getAttribute("itemURL") %>" <% if(updtmsg != null) { %> readonly <% } %>/></td>
      </tr>
      
  </table>
      <br/>
      <br/>
   <div class="addtocartfooter">     
       <button class="button" type="submit" name="action" value="updateItemDB">Update Database</button>  
       <input type="hidden" value="<%= request.getAttribute("itemidval")%>" name="itemidval" />
    </div>
       </form>
      
</main>
    <%@include file="includes/footer.jsp" %>