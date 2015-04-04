/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Premkumar
 */
public class UpdateInformation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       final JPanel panel=new JPanel();
       UserDB con = new UserDB();
       Login l=new Login();
       connection Connection=new connection();
       String url=null;
       HttpSession session=request.getSession();
       PrintWriter out = response.getWriter();
       String action=request.getParameter("action");
       if(action.equals("update"))
       {
           String userid=session.getAttribute("user").toString();
           
           l=con.UserDetails(userid);
           session.setAttribute("updateinfo", l);
           url="/Update_Profile.jsp";
           session.setAttribute("user",userid);
           
       }
       else if(action.equals("updateadmin"))
       {
           String userid=session.getAttribute("user").toString();
           
           l=con.UserDetails(userid);
           session.setAttribute("updateinfo", l);
           url="/update_admin_profile.jsp";
           session.setAttribute("user",userid);
           
       }
       
       else if(action.equals("Back"))
       {
           url="/userhomepage.jsp";
           
       }
        else if(action.equals("Backadmin"))
       {
           url="/admin.jsp";
           
       }
       else if(action.equals("UpdateValue"))
       {
           String userid=session.getAttribute("user").toString();
           String emailaddress=request.getParameter("email");
           String address=request.getParameter("address");
           String city=request.getParameter("city");
           String state=request.getParameter("state");
           String zipcode=request.getParameter("zip");
           String phone=request.getParameter("phone");
           int result=con.changeDetails(userid, emailaddress, address,city,state, zipcode,phone);
           if(result==1)
           {
              JOptionPane.showMessageDialog(panel, "Success");
              url="/userhomepage.jsp";
              
           }
           else
           {
              JOptionPane.showMessageDialog(panel, "failed");
              url="/Update_Profile.jsp";
           }
// url="/userhomepage.jsp";*/
               
       }
       
           else if(action.equals("UpdateValues"))
       {
           String userid=session.getAttribute("user").toString();
           String emailaddress=request.getParameter("email");
           String address=request.getParameter("address");
           String city=request.getParameter("city");
           String state=request.getParameter("state");
           String zipcode=request.getParameter("zip");
           String phone=request.getParameter("phone");
           int result=con.changeDetails(userid, emailaddress, address,city,state, zipcode,phone);
           if(result==1)
           {
              JOptionPane.showMessageDialog(panel, "Success");
              url="/admin.jsp";
              
           }
           else
           {
              JOptionPane.showMessageDialog(panel, "failed");
              url="/update_admin_profile.jsp";
           }
// url="/userhomepage.jsp";*/
               
       }
       
       else if(action.equals("orders"))
       {
           String userid=session.getAttribute("user").toString();
           UserOrder order=new UserOrder();
           ArrayList<UserOrder> order1=new ArrayList<UserOrder>();
           order1=Connection.Orders(userid);
           int a=order1.size();
             if(a==0)
           {
            int temp1=0;
            session.setAttribute("temp1", temp1);
            //Cart=new cart();
                       
           }
           else
          {
           int temp1=1;
          session.setAttribute("temp1", temp1);
          }
          session.setAttribute("orderlist", order1);
          
          url="/user_order.jsp";
          
       }
         else if(action.equals("allorders"))
       {
           String userid=session.getAttribute("user").toString();
           UserOrder order=new UserOrder();
           ArrayList<UserOrder> order1=new ArrayList<UserOrder>();
           order1=Connection.AllOrders();
           int a=order1.size();
             if(a==0)
           {
            int temp1=0;
            session.setAttribute("temp1", temp1);
            //Cart=new cart();
                       
           }
           else
          {
           int temp1=1;
          session.setAttribute("temp1", temp1);
          }
          session.setAttribute("orderlist", order1);
          
           url="/allorders.jsp";
          
       }
            else if(action.equals("Cancel"))
       {
          String ordernum=request.getParameter("ordernum");
          int ordernum1=Integer.parseInt(ordernum);
          int result=Connection.DeleteOrder(ordernum1);
          if(result==1)
          {
          JOptionPane.showMessageDialog(panel, "Flight Cancelled");
          url="/userhomepage.jsp";
          }
          else
          {
              JOptionPane.showMessageDialog(panel, "Failed to cancel");
              url="/user_order.jsp";
          }
          
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
