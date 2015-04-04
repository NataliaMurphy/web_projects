<%-- 
    Document   : SecurityPage
    Created on : Nov 30, 2014, 1:30:09 PM
    Author     : preethi.stad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<% String pwdmsg = (String)request.getAttribute("pwdmsg");
   if (pwdmsg != null)
   {    %>
   
 <p style="font-family: Calibri; color:red;font-size: large"> <%=pwdmsg %> 
     <% 
   }
   
   %>
   
<span class="title"><h2>Please Enter Your Details here</h2></span>
                <div class="login-form"><center>
                    <form action="Login" method="post">
                        <h2>User ID</h2> <br/>
                        <input type="text" name="userID" placeholder="Enter your UNCC User ID here" required size="30px"> <br/>
                        <h2>Security Question 1 </h2> <p><%=request.getAttribute("ques1") %> </p>
                        <br/>
                        <input type="text" name="ans1"  placeholder="Enter your answer here" size="30px" required>
                        </br><h2>Security Question2 </h2> <p> <%=request.getAttribute("ques2") %> </p>
                        </br>
                        <input type="text" name="ans2"  placeholder="Enter your answer here" size="30px" required>
                        </br><h2> Enter a new Password</h2>
                        </br>
                        <input type="password" name="newpasswd"  placeholder="Enter your new password here" size="30px" required>
                        </br><h2> Retype your Password</h2>
                        </br>
                        <input type="password" name="repasswd"  placeholder="Retype password here" size="30px" required>
                        </br>
                        </br>
                        <button class="login-button" type="submit" name="action" value="forgotpasswd">Submit</button>
                        </br>
                        </br>
                        </br></center>
                    </form>
                    </div>

          <%@include file="includes/footer.jsp" %>