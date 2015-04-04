

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.*,java.util.*" %>
<%@page import = "javax.servlet.RequestDispatcher" %>
<%@page import="FortyNinerZone.*" %>
<%
    UserDetails user = (UserDetails)session.getAttribute("theUser");
    int usertype = user.getUserType();
    ItemDB db2 = new ItemDB();
    List<Item> prodDB = db2.getAllProducts();
    Dictionary<String, List<Item>> catalogItems = new Hashtable<String, List<Item>>();
    String catName = (String) request.getAttribute("catalogName");
    
    
    for (int i = 0; i < prodDB.size(); i++) {
        Item p = prodDB.get(i);
        if (catName == null || catName == p.getCatalogName()) {
            List<Item> catItems = catalogItems.get(p.getCatalogName());
            if (catItems != null) {
                catItems.add(p);
            } else {
                catItems = new ArrayList();
                catItems.add(p);
                catalogItems.put(p.getCatalogName(), catItems);
            }
        }
    }
   
    String view = request.getParameter("v");
    if (view == null || !view.equals("widget")) {    
%>
<%@include file="includes/header.jsp" %>


<table class="nav-table">
    <tr>
        <td>
            <nav> 
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="ShoppingCart.jsp">My Cart</a>
                <a href="Order.jsp">My Order</a>
            </nav>

        </td>

        <td>
            <div class="breadcrumb-links">
                <a href="index.jsp" id="breadcrumb">Home</a> &raquo;
                <a href="ShoppingCatalog.jsp" id="breadcrumb"> Shopping Catalog</a> 
            </div>
        </td> 
    </tr>
</table>

<%
 }
    else {
        Thread.sleep(2000);
        
        
%>
<link href="Style.css" rel="stylesheet" type="text/css">
<%
    } 
    String delmsg = (String)request.getAttribute("delmsg");
    String addmsg = (String)request.getAttribute("addmsg");
        if ((delmsg != null))
   {    %>
   <p style="font-family: Calibri; color:red;font-size: large"> <%=delmsg %> 
       <% } 
        if(addmsg != null) {  %>
        
   <p style="font-family: Calibri; color:red;font-size: large"> <%=addmsg %> 
     <% 
   }
   
   %>
<main>
    
    <% if (view == null || !view.equals("widget")) { %>
    <h2>It's time to get Green</h2>

    <p>We have large selections of UNCC products, select your favorite one </p>

    <% } %>
    <form action="Admin" method="post">  
        
         <%    Enumeration<String> en = catalogItems.keys();
                while (en.hasMoreElements()) {
                    String productCategory = en.nextElement();
                    List<Item> catProds = catalogItems.get(productCategory);
            
                    String catLink = String.format("%s", productCategory);
                    if (catName == null) { 
                    catLink = String.format("<a href=\"Catalog?catalogName=%s\" style='color:white'>%s </a>", productCategory, productCategory);
                    }
            %>
        
        <h3><div style="width:100%" ><div style="width:98%;display:inline"><%=catLink%> </div> <% if(usertype == 1){ %> <div style="width:2%;display:inline;float:right"> <a href="Admin?action=deleteCat&catname=<%=productCategory %>" title="delete" ><img src="images/delete.png" alt="delcatalog"height ="20px" width="20px" /></a> </div> <% } %> </div></h3>

        
            
              <ul class="catview">
                <%
                    for (int x = 0; x < catProds.size(); x++) {
                %>

                <li><a href="Catalog?itemID=<%=catProds.get(x).getItemID()%>"
                       title="<%=catProds.get(x).getItemName() %>">
                        <img src="<%=catProds.get(x).getImageURL()%>" class="caticon"
                             alt="<%=catProds.get(x).getItemName()%>" /><br />
                        <%=catProds.get(x).getItemName()%></a></li>
                

                <%
                    }   if (usertype == 1){   
                        
                         Item p = prodDB.get(0);
                         String catdesc = p.getCatalogDescription();
                %>
                  <li>
                <a href="Admin?action=additem&catname=<%=productCategory %>&catdesc=<%=catdesc %>" title="shirt4"><img src="images/add.png" alt="sweatshirt"class="caticon"/><br/>
                    Add Item </a>
            </li>
            
            </ul>
                
        <div class="addtocartfooter">
            <button class="button" type="submit" name="action" value="updateCatalogval">Update Catalog</button>
            <input type="hidden" value="<%= productCategory %>" name="catname" />
            <input type="hidden" value="<%=catdesc %>" name="catdesc" />
        </div>

            <%
        } }

            %>
        
    </form>
</main>
<%
    if (view == null || !view.equals("widget")) {
%>
<%@include file="includes/footer.jsp" %>   
<%
    }
%>