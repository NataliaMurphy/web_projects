/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        final JPanel panel = new JPanel();
        UserDB userdb=new UserDB();
        if(action.equals("login"))
        {
            Login login1=new Login();           
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            int role = userdb.getUserRole(username);
            session.setAttribute("Role", role);
            boolean userexist=userdb.CheckUser(username, password);
            if(userexist==false)
            {  
                JOptionPane.showMessageDialog(panel, "The UserID/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                               
            }
            else if(userexist==true)
            {
                if(role==0)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("userhomepage.jsp").forward(request, response);
                }
                else if(role==1)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                    
                }
                else if(role==2)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("analyst.jsp").forward(request, response);
                    
                }
                
                
            }
        }
        else if(action.equals("Register"))
        {
            Login login=new Login();
            login.setFirstname(request.getParameter("firstname"));
            login.setLastname(request.getParameter("lastname"));
            login.setGender(request.getParameter("gender"));
            login.setUserID(request.getParameter("userid"));
            login.setPassword(request.getParameter("password"));
            login.setQuestion1(request.getParameter("security"));
            login.setAnswer1(request.getParameter("answer"));
            login.setDate_Of_birth(request.getParameter("dob"));
            login.setAddress(request.getParameter("Address"));
            login.setSSN(request.getParameter("ssn"));
            login.setEmailaddress(request.getParameter("email"));
            login.setPhone_Number(request.getParameter("phone"));
            login.setCity(request.getParameter("city"));
            login.setState(request.getParameter("state"));
            login.setZipcode(request.getParameter("zipcode"));
            
            if(login.getUserID().equals(userdb.getUser(login.getUserID()))) {  
                JOptionPane.showMessageDialog(panel, "The UserID already Exists.Please Enter a New UserID", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
                               
            }
            else
            {
                userdb.adduser(login);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                
            }
        }
            else if(action.equals("logout"))
         {
             session.removeAttribute("user");
             session.removeAttribute("order");
             session.removeAttribute("search");
             request.getRequestDispatcher("index.jsp").forward(request, response);
         }      
        
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
        
        
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        final JPanel panel = new JPanel();
        UserDB userdb=new UserDB();
        if(action.equals("login"))
        {
            Login login1=new Login();           
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            int role = userdb.getUserRole(username);
            session.setAttribute("Role", role);
            boolean userexist=userdb.CheckUser(username, password);
            if(userexist==false)
            {  
                JOptionPane.showMessageDialog(panel, "The UserID/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                               
            }
            else if(userexist==true)
            {
                if(role==0)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("userhomepage.jsp").forward(request, response);
                }
                else if(role==1)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                    
                }
                else if(role==2)
                {
                session.setAttribute("user",username);
                request.getRequestDispatcher("analyst.jsp").forward(request, response);
                    
                }
                
                
            }
        }
        else if(action.equals("Register"))
        {
            Login login=new Login();
            login.setFirstname(request.getParameter("firstname"));
            login.setLastname(request.getParameter("lastname"));
            login.setGender(request.getParameter("gender"));
            login.setUserID(request.getParameter("userid"));
            login.setPassword(request.getParameter("password"));
            login.setQuestion1(request.getParameter("security"));
            login.setAnswer1(request.getParameter("answer"));
            login.setDate_Of_birth(request.getParameter("dob"));
            login.setAddress(request.getParameter("Address"));
            login.setSSN(request.getParameter("ssn"));
            login.setEmailaddress(request.getParameter("email"));
            login.setPhone_Number(request.getParameter("phone"));
            login.setCity(request.getParameter("city"));
            login.setState(request.getParameter("state"));
            login.setZipcode(request.getParameter("zipcode"));
            
            if(login.getUserID().equals(userdb.getUser(login.getUserID()))) {  
                JOptionPane.showMessageDialog(panel, "The UserID already Exists.Please Enter a New UserID", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
                               
            }
            else
            {
                userdb.adduser(login);
                JOptionPane.showMessageDialog(panel, "Registration Successful", "Congratulations",
                JOptionPane.INFORMATION_MESSAGE);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                
            }
        }
            else if(action.equals("logout"))
         {
             session.removeAttribute("user");
             session.removeAttribute("order");
             session.removeAttribute("search");
             request.getRequestDispatcher("index.jsp").forward(request, response);
         }
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
