/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arj
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

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
             final JPanel panel2 = new JPanel();
            String user_id = request.getParameter("userid");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String emailid = request.getParameter("emailid");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String zipcode = request.getParameter("zipcode");
           
            
            
            UserDB user = new UserDB();
            User newuser = new User();
            if(user_id.equals(user.getUser(user_id).getUserID())) {  
                JOptionPane.showMessageDialog(panel, "The UserID already Exists.Please Enter a New UserID", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("newuserform.jsp").forward(request, response);
            }
            else {
            newuser = new User(user_id,firstname,lastname,emailid,address1,address2,city,state,zipcode,country,password
                );
            user.addUser(newuser);
            
            JTextField textEmail = new JTextField(20);
                JLabel label_msg = new JLabel("In order to obtain/subscribe for updates regarding the products, PLEASE provide another email address");
                JLabel label = new JLabel("Enter e-mail address:");
                JLabel label_msg2 = new JLabel("To unsubscribe, please call our customer service representative");
                label.setLabelFor(textEmail);
                label.setDisplayedMnemonic('E');
                label_msg.setLabelFor(textEmail);
                label_msg.setDisplayedMnemonic('E');
                label_msg2.setLabelFor(textEmail);
                label_msg2.setDisplayedMnemonic('E');
                panel2.add(label);
            JOptionPane.showMessageDialog(null, "Registration Successful !!!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "PLease login using your credentials","Request", JOptionPane.INFORMATION_MESSAGE);
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
