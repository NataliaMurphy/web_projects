/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author priyanka
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {
    
    HttpSession session = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                
        UserDB olyuser = new UserDB();
        UserDetails ud = new UserDetails();
        String userid = request.getParameter("userid");
        String userID = request.getParameter("userID");
        String password = request.getParameter("loginpassword");
        String action = request.getParameter("action");
        String ans1 = request.getParameter("ans1");
        String ans2 = request.getParameter("ans2");
        String newpasswd = request.getParameter("newpasswd");
        String repasswd = request.getParameter("repasswd");
        
        
        String url = "";
            
        
        
            if(action == null && userid != null) { 
                
                ud = olyuser.getLogin(userid);  
                        
                if((userid.equals(ud.getUserID())) &&
                        (password.equals(ud.getUserpassword()))) {
                    
                     session.setAttribute("userid", ud.getUserID());
                     session.setAttribute("firstname",ud.getFirstName());
                     session.setAttribute("theUser", ud);
                     session.setAttribute("usertype", ud.getUserType());
                     session.setAttribute("email", ud.getEmailAddress());
                     System.out.println(ud.getFirstName());
                     url = "index.jsp";
                }  else {
                    url = "Login.jsp";
                }
                
                
            request.getRequestDispatcher(url).forward(request, response);
            
             }
            
            else if (action != null && action.equals("logout")) {
            session.invalidate();
            request.setAttribute("loginmsg", "You have been logged out successfully.<br />");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
           }
            else if (action != null && action.equals("addques")) {
               
                ud = olyuser.getLogin(userid);  
                request.setAttribute("ques1", ud.getQues1());
                request.setAttribute("ques2", ud.getQues2());
               request.getRequestDispatcher("forgotpass.jsp").forward(request, response);
           } 
            else if(action != null && action.equals("forgotpasswd"))
           {
               if(userID != null){ 
                   
                ud = olyuser.getLogin(userID);
                System.out.println(ud.getAns1());
                System.out.println(ud.getAns2());
                System.out.println(ans1);
                System.out.println(ans2);
                 System.out.println(newpasswd);
                  System.out.println(repasswd);
               if(userID.equals(ud.getUserID()))
               {
                   if(ans1.equals(ud.getAns1())&&ans2.equals(ud.getAns2()))
                   { 
                       if(newpasswd.equals(repasswd)&&!newpasswd.equals(ud.getUserpassword()))
                       {
                           olyuser.setpassword(newpasswd, userID);
                           url ="Login.jsp";
                           request.setAttribute("pwdmsg", "Password reset successfully. Please Login again");
                       }
                       else {
                           url ="forgotpass.jsp";
                           request.setAttribute("pwdmsg", "Password mismatch. Please enter new password");
                           
                       }
                   }
                   else {
                           url ="forgotpass.jsp";
                           request.setAttribute("pwdmsg", "Entered answer is wrong. Please enter again");
                           
                       }
               } else {
                           url ="Login.jsp";
                           request.setAttribute("pwdmsg", "Entered userID is wrong. Please enter again");
                           
                       }
               
               request.getRequestDispatcher(url).forward(request, response);
            }
          }
    }   
    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         session = request.getSession();   
        processRequest(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            session = request.getSession();
        processRequest(request, response);
    }
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


