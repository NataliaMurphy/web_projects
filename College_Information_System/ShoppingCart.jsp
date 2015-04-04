
<%@page import="FortyNinerZone.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="FortyNinerZone.Cart"%>
<%@include file="includes/header.jsp" %>
<body>
<table class="nav-table">
    <tr>
        <td>
            <nav> 
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="Order.jsp">My Order</a>
                <a href="ShoppingCatalog.jsp"> Shopping Catalog</a>
                
            </nav>

        </td>

        <td>
            <div class="breadcrumb-links">
                <a href="index.jsp" id="breadcrumb">Home</a> &raquo;
                <a href="ShoppingCart.jsp" id="breadcrumb">Shopping-Cart</a> 
            </div>
        </td> 
    </tr>
</table>

<main>
        <h2>Your Cart</h2>
        
        <%                
            Cart cart = (Cart) currentSession.getAttribute("theShoppingCart");
            if (cart == null || cart.getItems().size() == 0) {
        %>    
        <p>Your shopping cart is empty! <br />
            Do check out our vast <a href="ShoppingCatalog.jsp">catalog</a> for some amazing products.
        </p>
        <%
        } else {
        %>        
        <p>Below are the item(s) that are currently in your cart. When you are ready to buy, please click on the Checkout button.</p>
        <form action="Order" method="post">
            <table id="carttable">
                <thead>
                    <tr>
                        <th style="width: 55%">Description</th>
                        <th style="text-align:right">Price</th>
                        <th style="text-align:center">Quantity</th>
                        <th style="text-align:right">Total Price</th>
                    </tr>
                </thead>  
                 <%
                    List<OrderItem> cartItems = cart.getItems();
                    for (int c = 0; c < cartItems.size(); c++) {
                        OrderItem cartItem = cartItems.get(c);
                  int value = (cartItem.getProduct().getItemID());
                %>
                
                <tr>
                    <td>
                        <input type="hidden" name="productList" value="<%=cartItem.getProduct().getItemID()%>" />
                        <a href="Catalog?productCode=<%=cartItem.getProduct().getItemID()%>"><%=cartItem.getProduct().getItemName()%></a>
                    </td>  
                    <td style="text-align:right">$<%=cartItem.getProduct().getPrice()%>0</td>
                    <td style="text-align:center">
                        <input type="text" value="<%=cartItem.getQuantity()%>" name="<%=cartItem.getProduct().getItemID()%>" class="cartquantity" />
                    </td>
                    <td style="text-align:right"><strong> $<%=cartItem.getTotal()%>0</strong>
                    </td>
                </tr>
               <%
                    }                
                %>
                <tr>
                    <td colspan="4" style="background-color:#FFF;">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color:#FFF;"><strong>Total</strong>
                    </td>
                    <td style="text-align:right;background-color:#FFF;"><strong>$<%=cart.getTotalCost()%>0</strong>
                    </td>
                </tr>
            </table>            
            <p style="clear:both">&nbsp;</p>
            <div class="addtocartfooter">
                <button class="button" type="submit" name="action" value="updateCart">Update Cart</button>&nbsp;
                <button class="button" type="submit" name="action" value="checkout">Checkout</button>
            </div>
            <%
                }
            %>
         </form>
    </main>
</div>

<%@include file="includes/footer.jsp" %>