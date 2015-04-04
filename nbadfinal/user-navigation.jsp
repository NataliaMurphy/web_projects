<%-- 
    Document   : user-navigation
    Created on : 13 Sep, 2014, 5:58:42 PM
    Author     : Arj
--%>
        <div class="user-navi">
            <%HttpSession login = request.getSession();
            String logname = (String) login.getAttribute("theuser");
            if(logname != null) {
            logname = "Log out";}
            %>
            <a href="logout.jsp"><%= logname%></a>|
            <a href="cart.jsp">Cart</a> |    
           <form action="MyOrder" method="get">
             <input type="submit" value="My Orders" class="orderlink">
           </form>
            <span class="admin_link">
              <a href="admin.jsp">Admin</a>  
            </span>
        </div>

 