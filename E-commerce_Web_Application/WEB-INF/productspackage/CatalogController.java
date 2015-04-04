/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.util.*;
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
@WebServlet(name = "CatalogController", urlPatterns = {"/CatalogController"})
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
        try (PrintWriter out = response.getWriter()) {
            
           
            ProductDB pros = new ProductDB();
            UserDB olyuser = new UserDB();
            ArrayList<User> u_db = new ArrayList<>();
            // u_db = olyuser.getAllUsers();
            ArrayList<Product> pro_db = pros.getAllProducts();
            if(request.getParameter("product_code")!= null) {
            for(int i=0 ; i< pro_db.size() ;i++) {
                
             if(request.getParameter("product_code").equals(pro_db.get(i).getProductCode())){
                 request.setAttribute("product_code", pro_db.get(i).getProductCode());
                 request.setAttribute("product_name", pro_db.get(i).getProductName());
                 request.setAttribute("catalog_category", pro_db.get(i).getCatalogCategory());
                 request.setAttribute("description", pro_db.get(i).getDescription());
                 request.setAttribute("price", pro_db.get(i).getPrice());
                 request.setAttribute("imageURL", pro_db.get(i).getImageURL());
                 request.getRequestDispatcher("item.jsp").forward(request, response);
             }
            }
           }
   
            int reqvar;
            if(request.getParameter("catalog_category")!= null) {
                    if(request.getParameter("catalog_category").equals("Menclothing")) {
                    reqvar =0;
                    request.setAttribute("catalog_category", pro_db.get(reqvar).getCatalogCategory());
                    request.getRequestDispatcher("catalog.jsp").forward(request, response);
                    }
                    else if(request.getParameter("catalog_category").equals("Electronics")) {
                    reqvar =3;
                    request.setAttribute("catalog_category", pro_db.get(reqvar).getCatalogCategory());
                    request.getRequestDispatcher("catalog2.jsp").forward(request, response);
                    }
                    else if(request.getParameter("catalog_category").equals("catalog_page")) {
                    request.getRequestDispatcher("catalog1.jsp").forward(request, response);
                    }
                    else {
                        request.getRequestDispatcher("catalog1.jsp").forward(request, response);
                    }
                   }
            else {
                 request.getRequestDispatcher("catalog1.jsp").forward(request, response);
             }
            
            
           
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
//            String search = request.getParameter("search");
//            
//            if(request.getParameter("search")!= null) {
//                for(int j=0 ; j< (olyuser.users.size())-1 ; j++) {
//                if(request.getParameter("search").equals(olyuser.users.get(j).getFirstName())){
//                    request.setAttribute("firstname", olyuser.users.get(j).getFirstName());
//                    request.setAttribute("lastname", olyuser.users.get(j).getLastName());
//                    request.setAttribute("emailaddress", olyuser.users.get(j).getEmailAddress());
//                    request.setAttribute("address1field", olyuser.users.get(j).getAddress1Field());
//                     request.getRequestDispatcher("result.jsp").forward(request, response);
//                    }
//                }
//                
//                for(int k=0 ; k < (olyuser.users.size())-1 ; k++) {
//                if(request.getParameter("search").equals(olyuser.users.get(k).getLastName())){
//                    request.setAttribute("firstname", olyuser.users.get(k).getFirstName());
//                    request.setAttribute("lastname", olyuser.users.get(k).getLastName());
//                    request.setAttribute("emailaddress", olyuser.users.get(k).getEmailAddress());
//                    request.setAttribute("address1field", olyuser.users.get(k).getAddress1Field());
//                     request.getRequestDispatcher("result.jsp").forward(request, response);
//                    }
//                }
//            }
//                else {
//                 request.getRequestDispatcher("catalog1.jsp").forward(request, response);
//             }
            
            /* TODO output your page here. You may use following sample code. */
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
