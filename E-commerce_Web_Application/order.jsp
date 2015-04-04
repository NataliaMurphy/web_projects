<%-- 
    Document   : cart
    Created on : 13 Sep, 2014, 5:45:32 PM
    Author     : Arj
--%>
<%@page import="productspackage.User"%>
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
                    >   <a href="order.jsp">Invoice</a>
                </div>
                 <%@include file="site-navigation.jsp" %>
                <div class="main-content">
                    <h2>
                        Invoice Details
                    </h2>
                    ${currentOrder.getMessage()}<br>
                    
                    Date: ${currentOrder.getDate()}<br>

                    Ship Address/Billing Address<br>
                    ${add.getAddress1Field()}
                    ${add.getAddress2Field()}
                    ${add.getCity()},${add.getState()} ,${add. getPostCode()}
                    ${add.getCountry()}<br><br>
                    
                    <form action="updateCart">
                    
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
                        <c:forEach var="item" items="${theShoppingCart.items}">
                        <tr>
                            <td>
                                ${item.getProduct().productName}
                            </td>
                            <td>
                                ${item.getProduct().price}
                            </td>
                            <td>
                                ${item.quantity}
                            </td>
                            <td>
                                ${item.getTotal()}
                            </td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td id="subtotal">Subtotal</td>
                            <td>$${subtotal}</td>
                    </table>
                    </form>
                    <div class="in-buttons">
                    <form action="cart.jsp" id="cart">
                    <input type="submit" class="cart" value="Back to Cart">
                    </form>
                    <form action="payment.jsp" id="cart">
                        <input type="submit" class="cart" value="Purchase">
                    </form>
                    </div>
                </div>
                <div class="ads">
                    <p>
                        Payment Methods
                    </p>
                    <a href="#"><img src="images/payment.jpg" alt="payment-img"></a>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        

