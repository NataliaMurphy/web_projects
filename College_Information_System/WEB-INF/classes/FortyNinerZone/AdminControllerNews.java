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


@WebServlet(urlPatterns = {"/AdminControllerNews"})
public class AdminControllerNews extends HttpServlet {
HttpSession session = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminControllerNews</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminControllerNews at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        try {
        session = request.getSession();
        Newsdb news_obj = new Newsdb();
        ArrayList<News> new_list = new ArrayList<News>();

        new_list = news_obj.getAllNews();
        UserDetails user=new UserDetails();
        user=(UserDetails)session.getAttribute("theUser");
            int userType = user.getUserType();
            String userID=user.getUserID();
            if(userType == 1)
            {
        out.println("<form action=\"AdminControllerNews\" method=\"get\">");
        if(request.getParameter("newsid")!=null)
        if (request.getParameter("newsid").equalsIgnoreCase("heading"))
        {
            for(int i=0;i<new_list.size();i++) {

                out.print("<input type='radio' name = 'newsid' value="+new_list.get(i).getNewsid()+" />");
               out.print("<h2> <a href=\"Controller?newsid="+new_list.get(i).getNewsid()+"\">"+new_list.get(i).getNewstitle()+"</a> </h2> <br>");
               System.out.print("Inside Heading");
            }

        out.println("<input type = 'submit' value='update' name='redirecting' >");

          out.println("<input type = 'submit' value='delete' name='redirecting' >");
          out.println("<input type = 'submit' value='add' name='redirecting' >");

        out.println("</form>");

            }
            }
            else
            {
                if (request.getParameter("newsid").equalsIgnoreCase("heading"))
        {

            for(int i=0;i<new_list.size();i++) {
               out.println("<h2> <a href=\"NewsController?newsid="+new_list.get(i).getNewsid()+"\">"+new_list.get(i).getNewstitle()+"</a> </h2> <br>");
               System.out.print("Inside Heading");
            }
        }
            }

        if (request.getParameter("redirecting").equalsIgnoreCase("update"))
        {

        for(int i=0;i<new_list.size();i++) {

            if(request.getParameter("newsid").equalsIgnoreCase(new_list.get(i).getNewsid()))
            {

                request.setAttribute("newsid",new_list.get(i).getNewsid());
                request.setAttribute("newstitle",new_list.get(i).getNewstitle());
                request.setAttribute("description",new_list.get(i).getDescription());
                

                request.getRequestDispatcher("adminNewsPage.jsp").forward(request, response);
            }
            }

        }

        if (request.getParameter("redirecting").equalsIgnoreCase("delete"))
        {
            String newsID = request.getParameter("newsid");
      System.out.println(newsID);
      Newsdb newsdb = new Newsdb();
      newsdb.deleteNews(newsID);
      response.sendRedirect("AdminNews.jsp");


        }
        if (request.getParameter("redirecting").equalsIgnoreCase("add"))
        {
            System.out.println("inside Add");

            response.sendRedirect("AdminNewsadd.jsp");

        }




        }

        finally {
            out.close();
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("checkRedirect")!=null)
        if (request.getParameter("checkRedirect").equalsIgnoreCase("Update Database"))
        {

      String newsID = request.getParameter("newsid");
      System.out.println(newsID);
      String newsTitle = request.getParameter("newstitle");
      System.out.println(newsTitle);
      String description = request.getParameter("description");
      System.out.println(description);
      Newsdb newsdb = new Newsdb();
      newsdb.updateNews(newsID,newsTitle,description);
      response.sendRedirect("AdminNews.jsp");

    }
     if (request.getParameter("checkRedirect").equalsIgnoreCase("Add"))
     {
         String newsID = request.getParameter("newsid");
      System.out.println(newsID);
      String newsTitle = request.getParameter("newstitle");
      System.out.println(newsTitle);
      String description = request.getParameter("description");
      System.out.println(description);
      Newsdb newsdb = new Newsdb();
      newsdb.addNews(newsID,newsTitle,description);
      response.sendRedirect("AdminNews.jsp");
     }

}
}
