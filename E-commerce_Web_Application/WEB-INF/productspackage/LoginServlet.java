/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
 *
 * @author Arj
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String userid;
            UserDB olyuser = new UserDB();
            HttpSession login = request.getSession();
                
            userid = request.getParameter("userid");
            String password = request.getParameter("loginpassword");
            if(userid != null) {
                String userid2 = olyuser.getLogin(userid).getUserID();
                String password2 = olyuser.getLogin(userid).getPassword();
                if((userid2 == null || !userid.equals(userid2)) && (!password.equals(password2) || password2 == null)) {  
                    
                    JOptionPane.showMessageDialog(null, "Invalid Credentials.Please check your username and password","Sorry", JOptionPane.INFORMATION_MESSAGE);
                    String url = "/Login.jsp";  
                    request.getRequestDispatcher(url).forward(request, response);
                    
                }
                
                else if((request.getParameter("userid").equals(olyuser.getLogin(userid).getUserID())) &&
                        (request.getParameter("loginpassword").equals(olyuser.getLogin(userid).getPassword()))) {  
                    
                     login.setAttribute("theuser", userid);
                      JOptionPane.showMessageDialog(null, "Login Successful !!!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
                     request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            
            else {
                 
                JOptionPane.showMessageDialog(null, "Invalid Credentials.Please check your username and password","Sorry", JOptionPane.INFORMATION_MESSAGE);
                String url = "/Login.jsp";  
                request.getRequestDispatcher(url).forward(request, response);
                 }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
