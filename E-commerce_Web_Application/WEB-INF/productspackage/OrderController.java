/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arj
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {
    private Product product;
    private int quantity;
    private String url="";
    private int total;
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc= getServletContext();
        
             Cart theShoppingCart;        
             ProductDB pros = new ProductDB();
             ProductDB products = new ProductDB();
             final JPanel panel = new JPanel();
             double subtotal=0;
             double stotal =0;
             HttpSession session = request.getSession();
             HttpSession session1 = request.getSession();
             Cart cart=(Cart) session.getAttribute("theShoppingCart");
             if(cart == null) {
                 cart = new Cart();
                 session.setAttribute("theShoppingCart", cart);
             }
             String action = request.getParameter("action");
             if(action == null) {
             action="updateCart";
             url="/cart.jsp";
             }
             
             if(action.equals("updateCart")){
              String[] productList = request.getParameterValues("productList");   
              
                 if(productList != null){
             
             for(int i=0 ; i< productList.length ;i++) {
                 if(products.getProduct(productList[i])!=null){
                 String productCode= productList[i];
                 int quantity =0;
                 OrderItem item = new OrderItem();
                 item.setProduct(products.getProduct(productCode));
                 quantity = Integer.parseInt(request.getParameter(productList[i]));
                 item.setQuantity(quantity);
            
                if(quantity > 0){
                   cart.addItem(item);
                   subtotal=0;
                   }
                else if(quantity == 0){
                   cart.removeItem(item);
                   subtotal=0;  
                   
                   }
                 }
                 for(int j=0;j< cart.items.size();j++){
                 OrderItem item = cart.getItems().get(j);
                 subtotal= subtotal + item.getTotal();
                 NumberFormat.getCurrencyInstance().format(subtotal);
                 session.setAttribute("subtotal",subtotal);
                  JOptionPane.showMessageDialog(null, "Please click on catalog link on side menu to add another item ","Message", JOptionPane.INFORMATION_MESSAGE);
                 }                   
                 if(cart.items.size()== 0){
                 subtotal = 0;
                 session.setAttribute("subtotal",subtotal);
                 }
                  session.setAttribute("theShoppingCart", cart);
                  url="/cart.jsp";                 
                }
              }
           }
             
             else if(action.equals("checkout")){
                 Order order = new Order();
                 if(cart.items.size()==0){
                    order.setMessage("ADD ITEMS TO YOUR CART PLEASE...!!!"); 
                    session.setAttribute("currentOrder",order);
                    url = "/order.jsp";
                 }
                 else {
                      JOptionPane.showMessageDialog(null, "Checkout Successful !!!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
                HttpSession address = request.getSession();
//                String uid = (String)ID.getAttribute("theuser");
                UserDB users = new UserDB();
                User user = new User(); 
                User user1 = new User();
                //order.setOrderNumber(1000);
                //order.setDate(Calendar.getInstance().getTime());
                String u = (String) session1.getAttribute("theuser");
                // order.setUser(uid);
                user1 = users.getUserAddress(u);
                address.setAttribute("add", user1);
                Date d = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                String dstore = sdf.format(d);
                order.setDate(dstore);
                order.setTaxRate(0.4f);
                order.setItems(cart.getItems());
                double total=0;
                for(int i=0; i < cart.getItems().size();i++){
                OrderItem item= cart.getItems().get(i);
                total = total + item.getTotal();
                }
                for(int j=0;j< cart.items.size();j++){
                 OrderItem item = cart.getItems().get(j);
                 subtotal= subtotal + item.getTotal();
                 NumberFormat.getCurrencyInstance().format(subtotal);
                 session.setAttribute("subtotal",subtotal);
                }             
                order.setPaid(true);
                order.setTaxRate(0.4f);
                order.setTotalCost(total);
                session.setAttribute("currentOrder",order);
                
                JTextField textEmail = new JTextField(20);
                JLabel label_msg = new JLabel("In order to obtain/subscribe for updates regarding the products, PLEASE provide your email address");
                JLabel label = new JLabel("Enter e-mail address:");
                JLabel label_msg2 = new JLabel("To unsubscribe, please call our customer service representative");
                label.setLabelFor(textEmail);
                label.setDisplayedMnemonic('E');
                label_msg.setLabelFor(textEmail);
                label_msg.setDisplayedMnemonic('E');
                label_msg2.setLabelFor(textEmail);
                label_msg2.setDisplayedMnemonic('E');
                panel.add(label);
                
                url = "/order.jsp";
               }
             
             }
             
           
             
             else if(action.equals("removeAll")) {
             cart =(Cart) session.getAttribute("theShoppingCart");
             cart.emptyCart();
             session.setAttribute("theShoppingCart", cart);
             url="/catalog1.jsp";
                 
             }
 /*-------------------------------------------------my orders----------------------------------------------------------*/
            
                 
               
             
          getServletContext().getRequestDispatcher(url).forward(request, response);
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
