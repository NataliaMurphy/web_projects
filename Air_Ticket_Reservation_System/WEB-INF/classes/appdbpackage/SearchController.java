/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {
    String url = "";
    private Component panel;

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
           String action=request.getParameter("action");
           if (action.equals("Search"))
            {
            int i=1;
            int j =0;
            ArrayList<Search> list1 = new ArrayList<Search>();
            ArrayList<Search> list2 = new ArrayList<Search>();
            ArrayList<Search> list3 = new ArrayList<Search>();
            HttpSession session1 = request.getSession();
            HttpSession session2 = request.getSession();
            HttpSession session3 = request.getSession();
            
            String radio = request.getParameter("radio");
            String fromvenue = request.getParameter("source");
            String tovenue = request.getParameter("destination");
            String datepicker = request.getParameter("datepicker");
            session1.setAttribute("fromdate",datepicker);
            String datepicker1 = request.getParameter("datepicker1");
            session1.setAttribute("todate", datepicker1);
            String passenger = request.getParameter("passenger");
            String Class_select = request.getParameter("Class_select");
            Search search =new Search();
            search.setSource(fromvenue);
            search.setDestination(tovenue);
            search.setFlight_class(Class_select);
            session1.setAttribute("search", search);
            session1.setAttribute("radio", radio);
            session1.setAttribute("no_of_passenger", passenger);
            SearchDB sea = new SearchDB();
            Search s = new Search();
            
            if(fromvenue == null ? tovenue == null : fromvenue.equals(tovenue)) {
                JOptionPane.showMessageDialog(null, "Source and Destination cannot be the same.Please change the source and destination","Message", JOptionPane.INFORMATION_MESSAGE);
                 url = "/search.jsp";
                 getServletContext().getRequestDispatcher(url).forward(request, response); 
            }
            
            
            else if(datepicker.equals(datepicker1)) {
                JOptionPane.showMessageDialog(null, "No Results Found","Message", JOptionPane.INFORMATION_MESSAGE);
                 url = "/search.jsp";
                  getServletContext().getRequestDispatcher(url).forward(request, response); 
            }  
            
            else if("oneway".equals(radio)){
            list1 = sea.getSearch1(fromvenue,tovenue,Class_select,datepicker);
            if(list1.isEmpty()){
                  JOptionPane.showMessageDialog(null, "No Results Found","Message", JOptionPane.INFORMATION_MESSAGE);
                 url = "/search.jsp";
                }
            else {
                session1.setAttribute("thesearch1", list1);
                 url = "/Search-Result.jsp";
                 
                }
            }
            else if("roundtrip".equals(radio)) {
            list3 = sea.getSearch1(fromvenue,tovenue,Class_select,datepicker);
            list2 = sea.getSearch2(tovenue,fromvenue,Class_select,datepicker1);
            if(list3.isEmpty() && list2.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Results Found","Message", JOptionPane.INFORMATION_MESSAGE);
                 url = "/search.jsp";
                }
            else {
                session3.setAttribute("thesearch3", list3);
                session2.setAttribute("thesearch2", list2);
                url = "/sresult.jsp";
                }
            }
    
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
