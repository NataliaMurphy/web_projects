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
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Arj
 */
@WebServlet(name = "JavaMailServlet", urlPatterns = {"/JavaMailServlet"})
public class JavaMailServlet extends HttpServlet {
String url="";
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
            
            String action = request.getParameter("confirmemail");
            String email ="";
            HttpSession getid = request.getSession();
            if(action == null){
                action = "confirmemail";
            }  
            if("confirmemail".equals(action)) {
                UserDB uuu = new UserDB();
                String u = (String)getid.getAttribute("theuser");
                email = uuu.getEmail(u);
            }
            
            //send email to user
            String to = email;
            String from = "hellboyarj@gmail.com";
            String subject = "Welcome";
            String body = "Thank you for purchasing our product.Have a great day.Thank you";
            boolean IsBodyHTML = false;
            try{
                javamail.sendMail(to, from, subject, body, IsBodyHTML);
            }catch(MessagingException e){
                String errorMessage= "Unable to send email"
                + "ERROR MESSAGE:" + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                "Uable to send email. \n"
                        +"Here is the email you tried to send: \n"
                        +"-------------------------------------------- \n"
                );
                url = "/index.jsp";
                
            }
            
            getServletContext().getRequestDispatcher(url).forward(request,response);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JavaMailServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JavaMailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
