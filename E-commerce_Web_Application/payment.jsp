<%-- 
    Document   : payment
    Created on : 14 Nov, 2014, 5:17:24 PM
    Author     : Arj
--%>

<%@page import="productspackage.Order"%>
<%@page import="productspackage.OrderItem"%>
<%@page import="productspackage.ProductDB"%>
<%@page import="productspackage.Cart"%>
<%@include file="header.jsp" %>
            <%@include file="user-navigation.jsp" %>
            <div class="area">
                <div id="navigation_links">
                        <a href="index.jsp">Home</a>
                    >   <a href="CatalogController?catalog_category=catalog_page">Catalog</a>
                    >   <a href="CatalogController?catalog_category=catalog_page">Items</a>
                    >   <a href="cart.jsp">Cart</a>
                    >   <a href="order.jsp">Invoice</a>
                    >   <a href="payment.jsp">Payment</a>
                </div>
                <%@include file="site-navigation.jsp" %>
                <div class="main-content">
                    <%
                     Order total = new Order();
                    total = (Order)session.getAttribute("currentOrder");
                    %>
                    <h2>
                        Enter Your Payment Information
                    </h2>
                    <form action="confirmOrder" method="post">
                        <h4>Credit Card Type</h4>
                        <!--<input type="selectbox" name="credit_card" class="credit_card" placeholder="enter your credit card type"/>
                        -->
                        <select name="credit_card">
                            <option value="select">--Select--</option>
                            <option value="VISA">VISA</option>
                            <option value="MASTERCARD">MASTERCARD</option>
                            <option value="AMERICAN EXPRESS">AMERICAN EXPRESS</option>
                            <option value="DISCOVER">DISCOVER</option>
                        </select>
                        <h4>Card Number</h4>
                        <input type="text" name="card_number" class="card_number" maxlength="16" required pattern="[0-9]{16}" placeholder="Enter your card number"/>
                         
                        <h4>Expiration Date(MM / YYYY)</h4>
                        <!--<input type="text" name="expiration" class="expiration" placeholder="enter your expiration date type"/>-->
                        <select name="expiration">
                            <option value="month">--Month--</option>
                            <option value="Jan">Jan</option>
                            <option value="Feb">Feb</option>
                            <option value="March">March</option>
                            <option value="April">April</option>
                            <option value="May">May</option>
                            <option value="June">June</option>
                            <option value="July">July</option>
                            <option value="August">August</option>
                            <option value="Sept">Sept</option>
                            <option value="Oct">Oct</option>
                            <option value="Nov">Nov</option>
                            <option value="Dec">Dec</option>
                        </select>
                        <select name="year">
                            <option value="year">--Year--</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                        </select>
                        <h4>CVV(3-Digit)</h4>
                        <input type="text" name="cvv" class="cvv" maxlength="3" required pattern="[0-9]{3}" placeholder="Enter CVV">
                        <p>
                            Your card will be charged a total of: $ <%= total.getTotalCost() %>
                        </p>
                        <input type="submit" name="confirm-button" class="clic" value="Confirm Payment">
                    </form>
                        <div class="email-button">
                    <form action="confirmemail" method="post">
                        <input type="submit" class="email" value="Send Email">
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
        