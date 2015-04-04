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

/**
 *
 * @author Arj
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        HttpSession session = request.getSession();
        if(action.equals("Book"))
        {
            
            order Order = new order();
            Login login=new Login(); 
            OrderDB orderdb=new OrderDB();
            Search search=(Search)session.getAttribute("search");
            Search search1=new Search();
            Search search2=new Search();
            String radio=session.getAttribute("radio").toString(); 
            session.setAttribute("radio",radio);
            String user=(String)session.getAttribute("user");
            String passenger=(String)session.getAttribute("no_of_passenger");
            int no_of_passenger=Integer.parseInt(passenger);
            if("oneway".equals(radio))
            {
                String flightnum_o_for=request.getParameter("select");
                search1=orderdb.selecttime(flightnum_o_for);               
                String datefor=session.getAttribute("fromdate").toString();
                int price=orderdb.selectprice(search.getFlight_class());
                double Total_sum=price*no_of_passenger;
                Order.setTotal_sum(Total_sum);
                Order.setFlight_num_for(flightnum_o_for);
                Order.setDeparture_forward(search1.getDeparture());
                Order.setFrom_date(datefor);
                Order.setPassenger(no_of_passenger);
                login.setUserID(user);
                Order.setLogin(login);
                session.setAttribute("order", Order);
                              
                
            }
            else if("roundtrip".equals(radio))
            {
                
                String flightnum_r_for=request.getParameter("select1");
                search1=orderdb.selecttime(flightnum_r_for); 
                String flightnum_r_ret=request.getParameter("select2");
                search2=orderdb.selecttime(flightnum_r_ret); 
                String datefor=session.getAttribute("fromdate").toString();
                String dateret=session.getAttribute("todate").toString();
                int price=orderdb.selectprice(search.getFlight_class());
                double Total_sum=2*price*no_of_passenger;
                Order.setTotal_sum(Total_sum);
                Order.setDeparture_forward(search1.getDeparture());
                Order.setDeparture_Return(search2.getDeparture());
                Order.setFlight_num_for(flightnum_r_for);
                Order.setFlight_num_return(flightnum_r_ret);
                Order.setFrom_date(datefor);
                Order.setTo_date(dateret);
                Order.setPassenger(no_of_passenger);
                login.setUserID(user);
                Order.setLogin(login);
                session.setAttribute("order", Order);
                
            }
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
        else if(action.equals("Checkout"))
        {
            OrderDB orderdb=new OrderDB(); 
            Search search1=(Search) session.getAttribute("search");
            order Order1=(order) session.getAttribute("order");
            orderdb.insertorder(Order1,search1);
            request.getRequestDispatcher("payment.jsp").forward(request, response);
        }
        else if(action.equals("Confirm Payment"))
        {
            request.getRequestDispatcher("paid.jsp").forward(request, response);
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
