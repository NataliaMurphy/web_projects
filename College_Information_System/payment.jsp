<%-- 
    Document   : payment
    Created on : 29 Nov, 2014, 4:16:56 PM
    Author     : priyanka
--%>


<%@page import="FortyNinerZone.OrderItem"%>
<%@page import="FortyNinerZone.Order"%>
<%@include file="includes/header.jsp"  %>
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
    </tr> 
</table>
<div id="content">
    <div class="breadcrumb">
        <a href="index.jsp">Home</a> &raquo;
        <a href="ShoppingCatalog.jsp">Catalog</a> &raquo;
        <a href="ShoppingCart.jsp">My Cart</a> &raquo; 
         <a href="Order.jsp">My Order</a> &raquo; Payment
    </div> 
    
    <main>
        <h2>Enter your Payment Information</h2>
        <h3> Card Detail </h3>
        <form action="Order?action=confirmOrder" method="post">
            <table class="cardtable">
                <tr>
                    <td class="paymenttext">
                        Credit Card Type 
                    </td>
                    <td class="paymentinput">

                        <select name="cardtype">
                            <option value="blank">Select</option>
                            <option value="visa">Visa</option>
                            <option value="master">Master Card</option>
                            <option value="discover">Discover</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td class="paymenttext">
                        Card number 
                    </td>
                    <td class="paymentinput">

                        <input type="text" name="cardno" value="12344477789001">

                    </td>
                </tr>

                <tr>
                    <td class="paymenttext">
                        Expiration Date (MM/YYYY) 
                    </td>
                    <td class="paymentinput">
                        <input type="month" name="month" />
                        
                    </td>
                </tr>
                <tr>
                    <td class="paymenttext">
                        CVV (3 digit)
                    </td>
                    <td class="paymentinput">

                        <input type="text" name="cvv" value="343">

                    </td>
                </tr>
                <tr></tr>
                <tr>
                    <td class="paymenttext">
                        Your Card will be charged total of :
                    </td>
                    <td class="paymenttext">
                        <% Order order =(Order)session.getAttribute("currentOrder"); %>
                        $<%= order.getTotalCostAfterTax()  %>
                           
                    </td>
                </tr>   
            </table>

            <br>         
            <div class="addtocartfooter">

                <button class="button" type="submit" name="action">Confirm Payment</button>  


            </div>

        </form>
    </main>    
    <%@include file="includes/footer.jsp" %>
