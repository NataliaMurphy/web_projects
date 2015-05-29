/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LokeshPC
 */
public class Newsdb {
    
    ArrayList<News> newslist = new ArrayList<News>();
    ArrayList<Comment> commentlist = new ArrayList<Comment>();
    public Newsdb(){
        

}
 public ArrayList<News> getAllNews() {
        ArrayList<News> news_list = new ArrayList<News>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String newsid = "";
        String newstitle = "";
        String description = "";
        String newscomment = "";
        String imageurl = "";
         String query= 
                    "SELECT * FROM news";

        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();        
            while (resultSet.next()) {
                newsid = resultSet.getString("newsid");
                newstitle = resultSet.getString("newstitle");
                description = resultSet.getString("description");
                
               

                News newsobj = new News(newsid, newstitle, description);
                news_list.add(newsobj);

            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getAllNews()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        }

        return news_list;
    }

 
 /* CODE TO GET ALL COMMENTS */
 /*public static Comment getAllComments()
 {
  ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection1 = pool.getConnection();
        Statement ps1 = null;
        String query1 = "select * from comment";
        Comment c1 = null;
        try
        {
         ps1 = connection1.createStatement();
         ResultSet rs = ps1.executeQuery(query1);
          c1 = new Comment();
         
         while(rs.next())
         {
         c1.setNewsid(rs.getString(1));
         c1.setComment(rs.getString(3));
         c1.setUserid(rs.getString(2));
         }
        }
        catch(Exception e)
        {
         System.out.println("Exception ");
        }
        finally {
            pool.freeConnection(connection1);
           Dbutil.closePreparedStatement(ps1);
            
            
      }
      
         return c1;
 }*/
    public  static int addComment(String comment,String newsId ,String Username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into comment (Newsid,Username,comment)" + "values (?, ?, ?)" ;
        
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,newsId);
            ps.setString(2,Username);
            ps.setString(3,comment);
            return ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getAllNews()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return 0;
            
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
            
      }
    }
    
    public static ArrayList<Comment> getAllComment(String newsId) {
        ArrayList<Comment> comment_list = new ArrayList<Comment>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        Statement ps = null;

        String newsid = "";
        String username = "";
        String comment = "";
        
         String query= 
                    "SELECT * FROM comment where newsid =\'"+newsId+"\'";
         
        try {
            ps = connection.createStatement();
            
            
            resultSet = ps.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Comment"+resultSet.getString("comment"));
                newsid = resultSet.getString("newsid");
                username = resultSet.getString("username");
                comment = resultSet.getString("comment");
                Comment commentobj = new Comment(newsid, username, comment);
                
                comment_list.add(commentobj);
            }
            System.out.println("Size of list: "+comment_list.size());
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getAllComment()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
            
      }
        

        return comment_list;
    }

    public void updateNews(String newsID, String newsTitle, String description) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String newsid = newsID;
        String newsTitle1 = newsTitle;
        String description1 = description;
        
         String query="update news set newstitle= \'"+newsTitle1+"\' , description= \'"+description1+"\' Where newsid = \'"+newsid+"\'";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.executeUpdate(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getupdateNews()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
 }
    
  }

    void deleteNews(String newsID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String newsid = newsID;
 
        
         String query="delete from news Where newsid = \'"+newsid+"\'";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.executeUpdate(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getdeleteNews()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
 }
    
  }

    void addNews(String newsID, String newsTitle, String description) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String newsid = newsID;
        String newsTitle1 = newsTitle;
        String description1 = description;
        
         String query="INSERT INTO news (NewsID,NewsTitle,Description)VALUES ('"+newsid+"','"+newsTitle1+"','"+description1+"');";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.execute(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in:");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
 }
    
  }
        
    }

    
    
    

