<%-- 
    Document   : cart
    Created on : 13 Sep, 2014, 5:45:32 PM
    Author     : Arj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
            <%@include file="header.jsp" %>
            <%@include file="user-navigation.jsp" %>
            <div class="area">
                <div id="navigation_links">
                        <a href="index.jsp">Home</a>
                    >   <a href="CatalogController?catalog_category=catalog_page">Catalog</a>
                    >   <a href="CatalogController?catalog_category=catalog_page">Items</a>
                    >   <a href="cart.jsp">Cart</a>
                    </div>
                 <%@include file="site-navigation.jsp" %>
                <div class="main-content">
                    <form action="updateCart">
                    <h3>
                        Your Cart Details
                    </h3>
                    <table>
                        <tr>
                            <th>
                                Item Names
                            </th>
                            <th>
                                Cost
                            </th>
                            <th>
                                Quantity
                            </th>
                            <th>
                                Total
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                ${firstname}
                            </td>
                            <td>
                                ${lastname}
                            </td>
                            <td>
                                ${emailaddress}
                            </td>
                            <td>
                                ${address1field}
                            </td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td></td>
                            <td id="subtotal">Subtotal</td>
                            <td>$${subtotal}</td>
                    </table>
                    <input type="hidden" name="action" value="updateCart"/>
                    <input class="clic" type="submit" value="Update Cart"/>
                    </form>
                    <form action="checkout" method="post">
                    <input type="hidden" name="action" value="checkout"/>
                    <input type="submit" class="clic" value="Checkout">
                    </form>
                </div>
                <div class="ads">
                    <p>
                        Payment Methods
                    </p>
                    <a href="#"><img src="images/payment.jpg" alt="payment-img"></a>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        


