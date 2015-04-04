<%-- 
    Document   : ShoppingItem
    Created on : 18 Oct, 2014, 1:53:50 PM
    Author     : priyanka
--%>
<%@page import="FortyNinerZone.Item"%>
<%@page import="FortyNinerZone.UserDetails"%>
<%
    UserDetails user = (UserDetails)session.getAttribute("theUser");
    int usertype = user.getUserType();   %>
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
                <a href="ShoppingCatalog.jsp" id="breadcrumb">Shopping-Catalog</a> &raquo;
                <a href="ShoppingItem.jsp" id="breadcrumb"> Shopping-Item </a> 
            </div>
        </td> 
    </tr>
</table>
<main>
        <h2> Product Detail - <%= request.getAttribute("productName") %> - ${catalogName}</h2>

        <p> <%= request.getAttribute("idescription") %> - ${cdescription} </p>
        <div class="photoframe">
            <div class="largephoto">
                <img src="${imageURL}" alt="casual T shirt" class="largepic" />
            </div>
        </div>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p style="clear:both">Price</p>
        <table>
            <tr>
                <td class="category">$${price}0</td>
            </tr>
        </table>
        <br>
        <div class="addtocartfooter">
            <form action="Order" method="post">
                <input type="hidden" name="productList" value="${productCode}" /> 
                <button class="button" type="submit" name="action" value="updateCart" >Add to Cart</button>
                &nbsp;
                <button class="button" formaction="ShoppingCatalog.jsp" >Return to Catalog</button> &nbsp;
                <br/>
                
                   <%
                    if (usertype == 1){     
                        
                   %>
            </form>
             <form action="Admin" method="post">
                <button class="button" type="submit" name="action" value="updateitem" >Update Item</button>
                &nbsp;
                <button class="button" type="submit" name="action" value="deleteitem" >Delete Item</button>
                <input type="hidden" name="itemidval" value="${productCode}" />
                 <input type="hidden" name="itemname" value="<%= request.getAttribute("productName") %>" />
                 <input type="hidden" name="itemdesc" value="<%= request.getAttribute("idescription") %>" />
                 <input type="hidden" name="itemprice" value="${price}" />
                 <input type="hidden" name="itemURL" value="${imageURL}" />
                <% 
                    }
                %>
             </form>
        </div>
    </main>
</div>

<%@include file="includes/footer.jsp" %>