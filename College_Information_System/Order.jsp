<%-- 
    Document   : Order
    Created on : 29 Nov, 2014, 2:23:10 PM
    Author     : priyanka
--%>

<%@page import="FortyNinerZone.OrderItem"%>
<%@page import="FortyNinerZone.Order"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@include file="includes/header.jsp"  %>
<body>
<table class="nav-table">
    <tr>
        <td>
            <nav> 
                <a href="index.jsp">Home</a>
                <a href="aboutus.jsp">About Us</a>
                <a href="contactus.jsp">Contact Us</a>
                <a href="ShoppingCart.jsp">My Cart</a>
                <a href="ShoppingCatalog.jsp"> Shopping Catalog</a>
                
            </nav>

        </td>

        <td>
            <div class="breadcrumb-links">
                <a href="index.jsp" id="breadcrumb">Home</a> &raquo;
                <a href="Order.jsp" id="breadcrumb">My Order</a> 
            </div>
        </td> 
    </tr>
</table>

    <main>
        <h2>Order Invoice</h2>
        <%
            Order currentOrder = (Order) currentSession.getAttribute("currentOrder");
            if(currentOrder == null)
            {
        %>
        <p>You do not have any current order.<br />
            Do check out our vast <a href="ShoppingCatalog.jsp">catalog</a> for some amazing products.
        </p>
        <%   
            } 
            else if(currentOrder.getOrderItem()!=null) {
            int orderItemSize = currentOrder.getOrderItem().size();
            if(orderItemSize == 0)
                
            {             
        %>
       <p>You do not have any current order.<br />
            Do check out our vast <a href="ShoppingCatalog.jsp">catalog</a> for some amazing products.
        </p>
        <% } 
            else
                {
         %>
        <p>Date: <%= new SimpleDateFormat("MM/dd/yyyy").format(currentOrder.getDate())%></p>
        <h3>Ship to/Bill to:</h3>
        <p>
            <b><%=currentOrder.getUser().getFirstName() %> &nbsp; <%=currentOrder.getUser().getLastName() %></b> <br />
            <%=currentOrder.getUser().getAddress()%> <br />
               <%=currentOrder.getUser().getCity()%>, <%=currentOrder.getUser().getState()%> <%=currentOrder.getUser().getZIP()%>
                   
        </p>
        <h3>Order Details</h3>
        
            <table id="carttable">
                <thead>
                    <tr>
                        <th style="text-align:left">Description</th>
                        <th style="text-align:center">Price</th>
                        <th style="text-align:right">Quantity</th>
                        <th style="text-align:right">Total</th>
                    </tr>
                </thead>
                <%
                    //int orderItemSize = currentOrder.getOrderItem().size();
                    for(int x = 0; x < orderItemSize; x++)
                    {
                        OrderItem orderItem = currentOrder.getOrderItem().get(x);
                %>
                <tr>
                    <td>
                        <a href="Catalog?productCode=<%=orderItem.getProduct().getItemID()%>">
                            <%=orderItem.getProduct().getItemID()%>
                        </a>
                    </td>  
                    <td style="text-align:center">$<%=orderItem.getProduct().getPrice()%>0</td>
                    <td style="text-align:right">
                        <%=orderItem.getQuantity()%>
                    </td>
                    <td style="text-align:right"><strong>$<%=orderItem.getTotal()%>0</strong> </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="4" style="background-color:#FFF;">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color:#fff;">Sub Total</td>
                    <td style="text-align:right;background-color:#fff;">$<%=currentOrder.getTotalCost()%>0</td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color:#fff;">Tax (<%=currentOrder.getTaxRate()%>%)</td>
                    <td style="text-align:right;background-color:#fff;">$<%=currentOrder.getTaxAmount()%></td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color:#fff;"><strong>Total</strong>
                    </td>
                    <td style="text-align:right;background-color:#fff;"><strong>$<%=currentOrder.getTotalCostAfterTax()%></strong>
                    </td>
                </tr>  
                <tr>
                    <td colspan="4" style="background-color:#FFF;">&nbsp;</td>
                </tr>
            </table>                    
        
                    <% } 
            String paidmsg = (String)request.getAttribute("paid");
            if(paidmsg == null){
                    %>
        <div class="addtocartfooter">
            <form action="Order" method="post">
                <button class="button" type="submit" name="action">Back to Cart</button>  
                <button class="button" type="submit" name="action" value="purchase">Purchase</button>
            </form>
        </div>
        <%
            } else { 
            
        %>
        <p style="color:red;font-family:Calibri;font-size: large"> <strong> Payment made successfully!! </strong>   </p>
            
     <%         currentSession.removeAttribute("currentOrder");
                currentSession.removeAttribute("theShoppingCart");    
            } }
            
        %>
    </main>
</div>    
<%@include file="includes/footer.jsp" %>

