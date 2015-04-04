/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Analyst extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
            
    {
        
        final JPanel panel=new JPanel();
        PrintWriter out = response.getWriter();
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        connection con = new connection();
        String url=null;
         
        if(action.equals("seasonal"))
        {        
            AnalystBean a=new AnalystBean();
            AnalystBean b=new AnalystBean();
             a=con.Seasonal_Onward();
             b=con.Seasonal_Return();
            
            session.setAttribute("a", a);
            session.setAttribute("b", b);
            request.getRequestDispatcher("/des.jsp").forward(request,response);
        }
        else if(action.equals("flight"))
        {
            AnalystBean a1=new AnalystBean();
           
            a1=con.Flight_Class();
           
            session.setAttribute("a1", a1);
            
            request.getRequestDispatcher("/flight.jsp").forward(request,response);
          
        }
       else if(action.equals("passenger"))
       {
             AnalystBean a2=new AnalystBean();
             AnalystBean b2=new AnalystBean();
             a2=con.Onward_flight();
             b2=con.Return_flight();
             session.setAttribute("a2", a2);
             session.setAttribute("b2", b2);
             request.getRequestDispatcher("/passenger.jsp").forward(request,response);          
           
       
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
