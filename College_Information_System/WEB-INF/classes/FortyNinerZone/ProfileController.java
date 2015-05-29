/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {
private String url="";
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
            
         UserDB olyuser = new UserDB();
            ArrayList<NewUser> user_list;
            user_list = new ArrayList<>();  
            ArrayList<NewUser> profile_list;
            profile_list = new ArrayList<>();
            HttpSession session= request.getSession();
            HttpSession single= request.getSession();
            HttpSession utype= request.getSession();
            int ut = (int)utype.getAttribute("usertype");
            
            final JPanel panel = new JPanel();
            
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
                
                if((first_name.equals(u.getItem(FirstName,first_name))) && (!first_name.isEmpty())) {                    
                    search = FirstName;
                    item = first_name;    
                    user_list = u.getUsers(search,item);
                   
                }
                else if((last_name.equals(u.getItem(LastName,last_name))) && (!last_name.isEmpty())){
                    
                    search = LastName;
                    item = last_name;
                    user_list = u.getUsers(search,item);
                   
                }
                else if((Email_Address.equals(u.getItem(EmailAddress,Email_Address))) && (!Email_Address.isEmpty())){
                    
                    search = EmailAddress;
                    item = Email_Address;
                    user_list = u.getUsers(search,item);
                    
                }
                else if((course.equals(u.getItem(Course,course))) && (!course.isEmpty())) 
                        {
                    
                    search = Course;
                    item = course;
                    user_list = u.getUsers(search,item);
                   
                }
                else if((dept.equals(u.getItem(Department,dept))) && (!dept.isEmpty()))
                        {
                    
                    search = Department;
                    item = dept;
                    user_list = u.getUsers(search,item);
                  
                }
                else if((club.equals(u.getItem(Club,club))) && (!club.isEmpty()))
                    {
                    
                    search = Club;
                    item = club;
                    user_list = u.getUsers(search,item);
                  
                }
                else {
               
                JOptionPane.showMessageDialog(null, "NO RESULTS FOUND !!!","Message", JOptionPane.INFORMATION_MESSAGE);
                
                url="/profile-home.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                
                 session.setAttribute("the_user_list",user_list);
                
                 if(ut == 0) {
                 url="/result.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);        
                }
                 else {
                url="/result-profile-admin.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);   
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
