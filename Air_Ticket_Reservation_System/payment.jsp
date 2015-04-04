<%-- 
    Document   : payment
    Created on : 27 Nov, 2014, 12:11:59 PM
    Author     : Arj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
                <div id="content">
                    <h2>
                        Enter Your Payment Information
                    </h2>
                    <form action="OrderController" method="post">
                        <h4>Credit Card Type</h4>
                        <!--<input type="selectbox" name="credit_card" class="credit_card" placeholder="enter your credit card type"/>
                        -->
                        <select name="credit_card" required="required">
                            <option value="select">--Select--</option>
                            <option value="VISA">VISA</option>
                            <option value="MASTERCARD">MASTERCARD</option>
                            <option value="AMERICAN EXPRESS">AMERICAN EXPRESS</option>
                            <option value="DISCOVER">DISCOVER</option>
                        </select>
                        <h4>Card Number</h4>
                        <input type="number" name="card_number" class="card_number"  required="required" placeholder="Enter your card number type"/>
                        <h4>Expiration Date(MM / YYYY)</h4>
                        <!--<input type="text" name="expiration" class="expiration" placeholder="enter your expiration date type"/>-->
                        <select name="expiration" required="required">
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
                        <select name="year" required="required">
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
                        <input type="number" name="cvv" required="required" class="cvv" placeholder="Enter CVV">
                        <p>
                            Your card will be charged a total of: $ ${order.total_sum}
                        </p>
                        <input type="submit" name="action"  value="Confirm Payment">
                    </form>
                </div>
          <%@include file="footer.jsp" %>
        
