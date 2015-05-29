/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FortyNinerZone.JobsDB;
import FortyNinerZone.UserDB;
import FortyNinerZone.UserDetails;
import java.io.Console;
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
 * @author AndrewMannikus
 */
@WebServlet(urlPatterns = {"/JobsServlet"})
public class JobsServlet extends HttpServlet {
    
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
        
        String jobid = request.getParameter("jobID");
        System.out.println("TEST Job ID:" + jobid);
        
        HttpSession session = request.getSession();
        UserDetails user = (UserDetails)session.getAttribute("theUser");
        JobsDB job = new JobsDB();
        String result = job.viewJob(jobid, user);
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("/viewJob.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(); 
	String sessionCheck = (String)session.getAttribute("username");
        if(sessionCheck=="")
	{
            response.sendRedirect("Login.jsp");
	}
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(); 
        processRequest(request, response);
    }

}
