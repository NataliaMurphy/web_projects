/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
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
            
            final JPanel panel = new JPanel();
            String userid;
            Boolean paid= false;
            UserDB olyuser = new UserDB();
            HttpSession session = request.getSession();
             HttpSession login2 = request.getSession();
            Order itm2 = new Order();
            itm2 = (Order)session.getAttribute("currentOrder");
            double tcost = itm2.getTotalCost();
             String action = request.getParameter("action");
             if(action == null) {
               
             action="confirmOrder";
             }
            if((action.equals("confirmOrder")) && tcost != 0){
                
            Cart confirm_order = new Cart();
            ProductDB  pitems = new ProductDB();
            confirm_order = (Cart)session.getAttribute("theShoppingCart");
            for(int i=0; i < confirm_order.items.size() ;i++) {
                
            // for orders table
            String user_id =(String) login2.getAttribute("theuser");
            Float taxrate = itm2.getTaxRate();
            Double totalcost = itm2.getTotalCost();
            String date = itm2.getDate();
             paid = true;
            pitems.addOrder(user_id,taxrate,totalcost,date,paid);
            
            //for orderitem table
            HttpSession orderno = request.getSession();
            int order_num;
            order_num = pitems.getOrderNum();
            orderno.setAttribute("OrderNum", order_num);
            OrderItem itm = new OrderItem();
            itm = confirm_order.getItems().get(i);
            pitems.addOrderItems(itm,order_num);
            }
            
            if(paid == true) {
              itm2.setMessage("PAID IN FULL"); 
              url = "/order.jsp";  
              request.getRequestDispatcher(url).forward(request, response);
            }
         } 
            else {
           JOptionPane.showMessageDialog(null, "Cannot Confirm Payment","Sorry", JOptionPane.INFORMATION_MESSAGE);
           url = "/catalog1.jsp";  
           request.getRequestDispatcher(url).forward(request, response);
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
