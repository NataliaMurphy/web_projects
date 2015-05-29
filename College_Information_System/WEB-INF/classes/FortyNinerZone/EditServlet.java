/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndrewMannikus
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

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
        
        String jobid = request.getParameter("hiddenEdit1");
        String title = request.getParameter("hiddenEdit2");
        String shortd = request.getParameter("hiddenEdit3");
        String desc = request.getParameter("hiddenEdit4");
        String html = "";
        
        html = html + "Job ID <br> <input type=\"text\" name=\"jobid\" size=\"15\" value=\""+jobid+"\" readonly/>";
        html = html + "" +
        "<br>" +
        "<br>" +
        "Job Title <br> <input type=\"text\" name=\"title\" size=\"15\"  value=\""+title+"\"/>" +
        "<br>" +
        "<br>" +
        "Short Description <br> <input type=\"text\" name=\"sDescript\" size=\"15\"  value=\""+shortd+"\"  />" +
        "<br>" +
        "<br>" +
        "Description <br> <textarea name=\"descript\" rows=\"5\" cols=\"50\" >"+desc+" </textarea>" + 
        "<br>" +
        "<input type=\"submit\" value=\"Update Job\"/>";
        
        request.setAttribute("html", html);
        request.getRequestDispatcher("/editJob.jsp").forward(request, response);
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
