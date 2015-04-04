<%-- 
    Document   : admin
    Created on : 14 Nov, 2014, 6:25:51 PM
    Author     : Arj
--%>

<%@include file="header.jsp" %>
            <%@include file="user-navigation.jsp" %>
            <div class="area">
                <%@include file="site-navigation.jsp" %>
                <div class="main-content">
                    <h3>
                        Administrator Menu
                    </h3>
                    <form action="viewOrders" method="post">
                        <input type="submit" name="display_orders" class="display_orders" value="Display All Orders">                     
                    </form>
                </div>
                </div>
          <%@include file="footer.jsp" %>