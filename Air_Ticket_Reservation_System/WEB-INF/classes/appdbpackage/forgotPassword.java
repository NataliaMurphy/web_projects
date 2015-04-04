/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.IOException;
import java.sql.Connection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Premkumar
 */
public class forgotPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        final JPanel panel=new JPanel();
        PrintWriter out = response.getWriter();
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        UserDB con = new UserDB();
        String url=null;
        if(action.equals("forgot"))
        {
           Login l=new Login();
           String userid=request.getParameter("userid");
           if(userid.equals(""))
           {
               JOptionPane.showMessageDialog(panel, "Please provide the correct userid");
               url="/getUser.jsp";
               
           }
           else
           {
           l=con.getUserDetails(userid);
           if(l.getUserID().equals(""))
           {
               JOptionPane.showMessageDialog(panel, "Please provide the correct userid");
               url="/getUser.jsp";
           }
           else
           {
           session.setAttribute("forgot", l);
           url="/forgotten-password.jsp";
           }
        }
        }
        else if(action.equals("checkpassword"))
        {
         String answer=request.getParameter("answer");
         Login login=(Login) session.getAttribute("forgot");
         if(answer.equals(login.getAnswer1()))
         {
              url="/newpassword.jsp";
         }
         else
         {
             JOptionPane.showMessageDialog(panel, "Password Mismatch");
             url="/forgotten-password.jsp";
         }
        }
        else if(action.equals("change"))
         {
             String newpassword=request.getParameter("nwpassword");
             String retyped=request.getParameter("re-password");
             if(newpassword.equals(retyped))
             {
             Login login=(Login) session.getAttribute("forgot");
             String userid=login.getUserID();
             int updte=con.changePassword(userid, newpassword);
             if (updte==1)
             {
                 JOptionPane.showMessageDialog(panel, "Password update successful.Please Login to continue");
                 url="/Login.jsp";
                 
             }
             else
             { 
                JOptionPane.showMessageDialog(panel, "Password update  was unsuccessful.Please try again");  
                 url="/getUser.jsp";
                 
             }
              
              
             }
             else
             {
                 //JOptionPane.showMessageDialog(panel,"Wring match","Warning",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(panel, "Password did not match.Try again");
                 url="/newpassword.jsp";
                 
             }
         }
         else
        {
            url="/Login.jsp";
        }
        
        
        
        getServletContext().getRequestDispatcher(url).forward(request,response);
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
