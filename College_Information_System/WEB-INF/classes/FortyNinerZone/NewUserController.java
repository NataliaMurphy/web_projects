/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arj
 */
@WebServlet(name = "NewUser", urlPatterns = {"/NewUser"})
public class NewUserController extends HttpServlet {

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
           
            final JPanel panel = new JPanel();
            String user_id = request.getParameter("userid");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String emailid = request.getParameter("emailid");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String zipcode = request.getParameter("zipcode");
            String dob = request.getParameter("DOB");
            String phoneno = request.getParameter("phoneno");
            String course = request.getParameter("course");
            String dept = request.getParameter("dept");
            String club = request.getParameter("club");
            String gender = request.getParameter("gender");
            String question1 = request.getParameter("question1");
            String answer1 = request.getParameter("answer1");
            String question2 = request.getParameter("question2");
            String answer2 = request.getParameter("answer2");
            int usertype = 000;
            
            
            UserDB user = new UserDB();
            NewUser newuser = new NewUser();
            if(request.getParameter("userid").equals(user.getUser(user_id).getUserID())) {          
            
            JOptionPane.showMessageDialog(panel, "The UserID already Exists.Please Enter a New UserID", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("newuserform.jsp").forward(request, response);
            }
            
            else {
                newuser = new NewUser(user_id,firstname,lastname,emailid,address,city,state,country,zipcode,dob,phoneno,
                course,dept,club,gender,usertype,password,question1,answer1,question2,answer2);
            user.addUser(newuser);
            
            JOptionPane.showMessageDialog(null, "Registration Successful !!!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
                
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
