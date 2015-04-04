<%-- 
    Document   : Login.jsp
    Created on : 20 Nov, 2014, 3:51:02 PM
    Author     : Arj
--%>

<%@include file="includes/header.jsp" %>
    
<% String pwdmsg = (String)request.getAttribute("pwdmsg");
   if (pwdmsg != null)
   {    %>
   <p style="font-family: Calibri; color:red;font-size: large"> <%=pwdmsg %> 
     <% 
   }
   
   %>
   
             <p style="font-family: Calibri; color:red;font-size: large"><%=request.getAttribute("loginmsg") != null ? (String) request.getAttribute("loginmsg") : ""%></p> 
             <span class="title"><h2>Please Enter Your Login Details here</h2></span>
                <div class="login-form"><center>
                    <form action="Login" method="post">
                        <h2>UserID</h2>
                        <input type="text" name="userid"  formaction="login-form" placeholder="Enter your UserName here" size="30px">
                        <h2>Password</h2>
                        <input type="password" name="loginpassword"  placeholder="Enter your password here" size="30px">
                        </br></br><input type="submit" class="login-button" value="Login">
                        <h2>New user? Register as a Niner </h2>
                        </br>
                       <input type="submit" class="login-button" value="Register here" formaction="newuserform.jsp"></br></br>
                       <h2> OOPS! Forgot Password </h2>
                       <button class="login-button" type="submit" name="action" value="addques">Forgot Password</button>
                       </form> 
                        </br></center>
                    </div>
             
 <%@include file="includes/footer.jsp" %>   
             
             
             
             
             
         