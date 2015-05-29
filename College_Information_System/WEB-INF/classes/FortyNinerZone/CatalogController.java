/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author priyanka
 */
@WebServlet(name = "CatalogController", urlPatterns = {"/Catalog"})
public class CatalogController extends HttpServlet {

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
        
        UserDetails user = new UserDetails();
        int itemIDParam = Integer.parseInt(request.getParameter("itemID"));
        String catName = request.getParameter("catalogName");
        if(user.getUserType() == 0)
            { 
                request.setAttribute("mode","user");
            }
            else
            { 
                request.setAttribute("mode","admin");
            }
        if (catName == null && itemIDParam == 0) {
            
            request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
        } else {
            //Load the catalog of products
            ItemDB db = new ItemDB();
            ArrayList<Item> productList = db.getAllProducts();  //p
            Boolean validParameter = false;

            if (itemIDParam != 0) {
                //Product
                int prodDBSize = productList.size();
               
                for (int i = 0; i < prodDBSize; i++) {
                    if (itemIDParam == (productList.get(i).getItemID())) {
                        validParameter = true;
                        request.setAttribute("productCode", productList.get(i).getItemID());
                        request.setAttribute("productName", productList.get(i).getItemName());
                        request.setAttribute("cdescription", productList.get(i).getCatalogDescription());
                        request.setAttribute("idescription", productList.get(i).getItemDescription());
                        request.setAttribute("catalogName", productList.get(i).getCatalogName());
                        request.setAttribute("price", productList.get(i).getPrice());
                        request.setAttribute("imageURL", productList.get(i).getImageURL());
                        request.getRequestDispatcher("ShoppingItem.jsp").forward(request, response);
                        break;
                    }
                }
            } else if (catName != null) {
                for (int i = 0; i < productList.size(); i++) {
                    if (catName.equals(productList.get(i).getCatalogName())) {
                        validParameter = true;
                        request.setAttribute("catalogName", productList.get(i).getCatalogName());
                        request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
                        break;
                    }
                }
            }

            if (!validParameter) {
                request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
            }
        }
    }

    
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

   

}
