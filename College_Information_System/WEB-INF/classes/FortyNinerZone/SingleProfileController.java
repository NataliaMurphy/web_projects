/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arj
 */
@WebServlet(name = "SingleProfileController", urlPatterns = {"/SingleProfileController"})
public class SingleProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String url="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
    
            
         UserDB olyuser = new UserDB();
            ArrayList<NewUser> user_list;
            user_list = new ArrayList<>();  
            ArrayList<NewUser> profile_list;
            profile_list = new ArrayList<>();
            
            HttpSession single= request.getSession();
            
            final JPanel panel = new JPanel();
            String single_search = request.getParameter("search_profile");
            String first_name = request.getParameter("firstname");
            String last_name = request.getParameter("lastname");
            String club = request.getParameter("club");
            String dept = request.getParameter("dept");
            String Email_Address = request.getParameter("EmailAddress");
            String course = request.getParameter("course");
 
            UserDB u = new UserDB();
            String search = "";
 
                String FirstName = "FirstName" ,LastName = "LastName",Club = "Club",Department = "Department",
                        EmailAddress= "EmailAddress",Course = "Course", item;
                
                if((single_search.equals(u.getItem(FirstName,single_search)))) {                    
                    search = FirstName;
                    profile_list = u.getUsers(search,single_search);
                }
                else if((single_search.equals(u.getItem(LastName,single_search)))){
                    
                    search = LastName;
                    profile_list = u.getUsers(search,single_search);
                }
                else if((single_search.equals(u.getItem(EmailAddress,single_search)))){
                    
                    search = EmailAddress;
                    profile_list = u.getUsers(search,single_search);
                }
                else if((single_search.equals(u.getItem(Course,single_search)))){
                    
                    search = Course;
                    profile_list = u.getUsers(search,single_search);
                }
                else if((single_search.equals(u.getItem(Department,single_search)))){
                    
                    search = Department;
                    profile_list = u.getUsers(search,single_search);
                }
                else if((single_search.equals(u.getItem(Club,single_search)))){
                    
                    search = Club;
                    profile_list = u.getUsers(search,single_search);
                }
                else {
               
//                    JOptionPane.showMessageDialog(panel, "The UserID already Exists.Please Enter a New UserID", "Warning",
//                JOptionPane.WARNING_MESSAGE);
             //   JOptionPane.showMessageDialog(null, "NO RESULTS FOUND !!!","Message", JOptionPane.INFORMATION_MESSAGE);
                
                url="/profile-home.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                
                
                 single.setAttribute("the_single_list", profile_list);
                 url="/singleresult.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);        
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

                
                 