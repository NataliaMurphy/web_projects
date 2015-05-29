/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author priyanka
 */
public class AdminController extends HttpServlet {
    
    HttpSession session = null;
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
        
        Item item = new Item();
        ItemDB idb = new ItemDB();
        String action = request.getParameter("action");
        String catname = request.getParameter("catname");
        
        if(action.equals("deleteCat"))
        {
            idb.deleteCatalog(catname);
            request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
        }
        else if(action.equals("updateCatalog"))
        {
            idb.deleteCatalog(catname);
            request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
        }
        else if(action.equals("updateCatalogval"))
        {
            request.setAttribute("catname", request.getParameter("catname"));
            request.setAttribute("catdesc",request.getParameter("catdesc"));
            request.getRequestDispatcher("UpdateCatalog.jsp").forward(request, response);
            
        }else if(action.equals("updateCatDB"))
        {
            String catname1 = request.getParameter("catname");
            String catdesc1 = request.getParameter("catdesc");
            String catold = request.getParameter("catold");
            
            idb.updateCatalog(catname1, catdesc1,catold);
            
            request.setAttribute("catname", catname1);
            request.setAttribute("catdesc",catdesc1);
            request.setAttribute("updatemsg", "updated Successfully");
            request.getRequestDispatcher("UpdateCatalog.jsp").forward(request, response);
            
        }else if(action.equals("deleteitem"))
        {
            int itemidval = Integer.parseInt(request.getParameter("itemidval"));
            idb.deleteItem(itemidval);
            request.setAttribute("delmsg", "item deleted Successfully");
            request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
            
        } else if(action.equals("updateitem"))
        {
            request.setAttribute("itemidval",request.getParameter("itemidval"));
            request.setAttribute("itemname",request.getParameter("itemname"));
            request.setAttribute("itemdesc",request.getParameter("itemdesc"));
            request.setAttribute("itemprice",request.getParameter("itemprice"));
            request.setAttribute("itemURL",request.getParameter("itemURL"));
            request.getRequestDispatcher("UpdateItem.jsp").forward(request, response);
        
        }else if(action.equals("updateItemDB"))
        {
            int itemID = Integer.parseInt(request.getParameter("itemidval"));
            double price = Double.parseDouble(request.getParameter("itemprice"));
            String name = request.getParameter("itemname");
            String desc = request.getParameter("itemdesc");
            String imageurl = request.getParameter("itemURL");
            idb.updateItem(itemID, name, desc, price, imageurl);
            item = idb.getProduct(itemID);
            request.setAttribute("itemidval",item.getItemID());
            request.setAttribute("itemname",item.getItemName());
            request.setAttribute("itemdesc",item.getItemDescription());
            request.setAttribute("itemprice",item.getPrice());
            request.setAttribute("itemURL",item.getImageURL());
            request.setAttribute("updatemsg", "Item updated Successfully");
            request.getRequestDispatcher("UpdateItem.jsp").forward(request, response);
            
        }else if(action.equals("additem"))
        {
            request.setAttribute("catname",request.getParameter("catname"));
            request.setAttribute("catdesc",request.getParameter("catdesc"));
            request.getRequestDispatcher("Additem.jsp").forward(request, response);
        
        }else if(action.equals("addItemDB"))
        {
            int itemID = Integer.parseInt(request.getParameter("itemID"));
            double price = Double.parseDouble(request.getParameter("itemprice"));
            String name = request.getParameter("itemname");
            String desc = request.getParameter("itemdesc");
            String imageurl = request.getParameter("itemURL");
            String catName = request.getParameter("catname");
            String catDesc = request.getParameter("catdesc");
            idb.addItem(itemID, name, desc,catName, catDesc, price, imageurl);
            request.setAttribute("addmsg", " Item added Successfully");
            request.getRequestDispatcher("ShoppingCatalog.jsp").forward(request, response);
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
        session = request.getSession();
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
        session = request.getSession();
    }


}
