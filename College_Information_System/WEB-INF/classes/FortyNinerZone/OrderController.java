/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author priyanka
 */
@WebServlet(name = "OrderController", urlPatterns = {"/Order"})
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
    
    List<Item> itemDBList = null;
    Cart cart = null;
    List<OrderItem> cartItems = null;
    HttpSession session = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Load product list
        ItemDB db = new ItemDB();
        itemDBList = db.getAllProducts();

        cart = (Cart) session.getAttribute("theShoppingCart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("theShoppingCart", cart);
        }
        cartItems = cart.getItems();

        String actionParam = request.getParameter("action");
        if (actionParam == null) {
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
        } else if (actionParam.equals("updateCart")) {
            updateCart(request, response);
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
        } else if (actionParam.equals("checkout")) {
            checkout(request, response);
            request.getRequestDispatcher("Order.jsp").forward(request, response);
        } else if(actionParam.equals("purchase")) {
            request.getRequestDispatcher("payment.jsp").forward(request, response);
        }else if(actionParam.equals("confirmOrder")) {
            request.setAttribute("paid","Payment made successfully");
            request.getRequestDispatcher("Order.jsp").forward(request, response);   
        }
        else {
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
        session = request.getSession();
        processRequest(request, response);
    }
    // </editor-fold>

    private void updateCart(HttpServletRequest request, HttpServletResponse response) {

        //Get the productList from request
        String[] prodList = request.getParameterValues("productList");
        int prodListLen = prodList.length;
        
        for (int i = 0; i < prodListLen; i++) {
            System.out.println(prodList[i]);
            int prodListint = Integer.parseInt(prodList[i]);
            Item currentProduct = getProduct(prodListint);
            if (currentProduct != null) {

                //Requested product is valid
                String qStr = request.getParameter(prodList[i]);
                if (Util.IsValidOrderQty(qStr)) {
                    int cartIdx = getProductIndexInCart(Integer.parseInt(prodList[i]));
                    if (cartIdx == -1) {
                        //Product does not exist in cart
                        //If the product doesnâ€™t already exist in the cart, 
                        //the current cart quantity should be considered zero to begin
                        OrderItem oItem = new OrderItem(currentProduct, 0);
                        
                        //Add as the last item in cart
                        cartIdx = cartItems.size();
                        cartItems.add(cartIdx, oItem);                        
                    }

                    //Product exists in cart
                    //Get current quantity
                    int currQty = cartItems.get(cartIdx).getQuantity();

                    if (qStr == null || qStr.isEmpty()) {
                        //If there was no quantity specified in the request parameter, 
                        //add 1 to the quantity of the product in the cart
                        cartItems.get(cartIdx).setQuantity(++currQty);
                    } else {
                        int requestedQty = Integer.parseInt(qStr);
                        if (requestedQty == 0) {
                            //If the request parameter quantity is zero, remove the product from the cart
                            cartItems.remove(cartIdx);
                        } else if (requestedQty != currQty) {
                            //If the two quantities are different, 
                            //update the cart with the new value for quantity for that
                            //product from the request parameter
                            cartItems.get(cartIdx).setQuantity(requestedQty);
                        }
                    }
                }
            }
        }
    }

    private Item getProduct(int itemID) {
        Item p = null;
        for (int x = 0; x < itemDBList.size(); x++) {
            if (itemDBList.get(x).getItemID() == itemID ) {
                p = itemDBList.get(x);
                break;
            }
        }
        return p;
    }

    private int getProductIndexInCart(int requestedProduct) {
        int index = -1;

        for (int x = 0; x < cartItems.size(); x++) {
            if (cartItems.get(x).getProduct().getItemID() == requestedProduct){
            index = x;
                break;
            }
        }

        return index;
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response) {
        UserDB userDB = new UserDB();
        
        UserDetails user = (UserDetails)session.getAttribute("theUser"); 
        
        
        Order order = new Order();
        order.setUser(user);
        order.setOrderNumber(1);
        order.setOrderItem(cartItems);
        order.setTaxRate(7.25); //Tax will depend on randomUser.getState()?

        session.setAttribute("currentOrder", order);
    }
}
