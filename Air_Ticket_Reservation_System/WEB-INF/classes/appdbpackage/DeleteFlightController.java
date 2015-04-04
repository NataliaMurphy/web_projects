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
@WebServlet(name = "DeleteFlightController", urlPatterns = {"/DeleteFlightController"})
public class DeleteFlightController extends HttpServlet {
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
        
                UserDB olyuser = new UserDB();
            FlightDetails flight_list = new FlightDetails();
                       
            HttpSession session= request.getSession();
            HttpSession single= request.getSession();
            HttpSession utype= request.getSession();
            //int ut = (int)utype.getAttribute("usertype");
            
            final JPanel panel = new JPanel();
            String flightnumber = request.getParameter("flightnum");           
 
            FlightDB u = new FlightDB();
 
                String FlightNumber = "Flight_Number" ;
                
                if((flightnumber.equals(u.getFlight(FlightNumber,flightnumber))) && (!flightnumber.isEmpty())) {                       
                    u.deleteFlightChild(flightnumber);
                    u.deleteFlightParent(flightnumber);
                    JOptionPane.showMessageDialog(null, "Flight Details Successfully Deleted !!!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    url="/admin.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                   
                }                            
                else {
               
                JOptionPane.showMessageDialog(null, "NO RESULTS FOUND !!!","Message", JOptionPane.INFORMATION_MESSAGE);
                
                url="/admin.jsp";
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
