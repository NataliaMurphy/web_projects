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
import javax.servlet.http.HttpSession;


@WebServlet(name = "EventController2", urlPatterns = {"/EventController2"})
public class EventController extends HttpServlet {
     HttpSession session = null;  

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        
        
        //String newsid = request.getParameter("newsid");
        
        
        
        
    }
         

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
         PrintWriter out = response.getWriter();
       
 Eventdb event_obj = new Eventdb();
        ArrayList<Event> event_list = new ArrayList<Event>();
        event_list = event_obj.getAllEvent();
        
        if (request.getParameter("eventid").equalsIgnoreCase("heading1"))
        {
            for(int i=0;i<event_list.size();i++) {
               out.println("<h2> <a href=\"EventController?eventid="+event_list.get(i).getEventid()+"\">"+event_list.get(i).getEventtitle()+"</a> </h2> <br>");
               System.out.print("Hi all");               
            }
            }
            for(int i=0;i<event_list.size();i++) {
            if(request.getParameter("eventid").equals(event_list.get(i).getEventid())) {
//                request.setAttribute("eventtitle",event_list.get(i).getEventtitle());
//                request.setAttribute("eventdescription",event_list.get(i).getEventdescription());
//                request.setAttribute("eventfare",event_list.get(i).getEventfare());
//                request.setAttribute("eventimageurl",event_list.get(i).getEventimageurl());
                session.setAttribute("eventid", request.getParameter("eventid"));
                session.setAttribute("eventtitle", event_list.get(i).eventtitle);
                session.setAttribute("eventdescription", event_list.get(i).eventdescription);
                session.setAttribute("eventfare", event_list.get(i).eventfare);
                
                //getServletContext().getRequestDispatcher("NewsPage.jsp").forward(request, response);
                request.getRequestDispatcher("events.jsp").forward(request, response);
            }
          }
            
        
        
           
       
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
