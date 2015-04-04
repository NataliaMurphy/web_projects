<%-- 
    Document   : Login
    Created on : 14 Nov, 2014, 6:36:39 PM
    Author     : Arj
--%>

    <%@include file="header.jsp" %>

          <span class="title">Please Enter Your Login Details here</span>
            <div class="login-form">
              <form action="login-form" method="post">
                  <h3>UserID</h3>
                  <input type="text" name="userid" class="userid" placeholder="Enter your UserName here">
                  <h3>Password</h3>
                  <input type="password" name="loginpassword" class="loginpassword" placeholder="Enter your password here">
                  <input type="submit" class="clic" value="Login">
              </form>
              
                
              <form action="newuserform.jsp" method="post">
              <input type="submit" class="clic" value="Sign up">
              </form>
              
            </div>

    <%@include file="footer.jsp" %>