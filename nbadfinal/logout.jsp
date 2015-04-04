<%@include file="header.jsp" %>
           
    <div class="area">   
        
            <%  HttpSession s = request.getSession();
                if(s!=null)
                 {
                  s.removeAttribute("theuser");
                  s.invalidate();
                 }
            %>
        
        <div class="endnote">
        <h3>You have successfully logged out!!!</h3>
        <h3>Please visit the <a href="Login.jsp" id="loglink">Login page</a> inorder to log into your account.</h3>
        </div>  
    </div>
 <%@include file="footer.jsp" %>
        
