<%-- 
    Document   : Additem
    Created on : 2 Dec, 2014, 3:34:57 PM
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
                <a href="UpdateCatalog.jsp" id="breadcrumb"> Add Item </a> 
            </div>
        </td> 
    </tr>
</table>

<br/> <br/>


<main>
     <form action="Admin" method="post">
  <table style="border-spacing:10px"> 
     
      
      <tr>
           <td style="width:300px;"><label> Catalog Name </label> </td> 
           <td style="width:500px;"><input type="text" class="reginputbox" name="catname"  value="<%= request.getAttribute("catname") %>" required  readonly  /></td>
               
      </tr>
      <tr>
           <td style="width:300px;"><label> Catalog Description </label> </td> 
           <td style="width:500px;"><input type="text" class="reginputbox" name="catdesc"  value="<%= request.getAttribute("catdesc") %>" required  readonly  /></td>
               
      </tr>
      <tr>
           <td style="width:300px;"><label> Item ID </label> </td> 
           <td style="width:500px;"><input type="text" class="reginputbox" name="itemID"  value="" required /></td>
               
      </tr>
     
      
      <tr>
           <td><label> Item name </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemname" value=""  required/></td>
      </tr>
      <tr>
           <td><label> Item description </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemdesc" value="" required/></td>
      </tr>
      <tr>
           <td><label> Item Price </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemprice" value="" required/></td>
      </tr>
      <tr>
           <td><label> Image  URL </label> </td> 
           <td> <input type="text"  class="reginputbox"  name="itemURL" value="" required/></td>
      </tr>
      
  </table>
      <br/>
      <br/>
   <div class="addtocartfooter">     
       <button class="button" type="submit" name="action" value="addItemDB">Add to Database</button> 
    </div>
       </form>
      
</main>
    <%@include file="includes/footer.jsp" %>
