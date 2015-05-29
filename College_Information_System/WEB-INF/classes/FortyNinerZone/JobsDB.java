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

/**
 *
 * @author AndrewMannikus
 */
public class JobsDB {
    public String viewJob (String id, UserDetails user){
        String result = "";
        String SQL = "";
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        SQL = SQL + "SELECT JobTitle, Description, ShortDescription FROM Job WHERE JobID='" + id +"'";
        
        String title, descript, sDescript;
        
        try {
            ps = connection.prepareStatement(SQL);
            resultSet = ps.executeQuery();
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find job ID in JOBS table: " + id);
                return null;
            } else {
                title = resultSet.getString("JobTitle");
                descript = resultSet.getString("Description");
                sDescript = resultSet.getString("ShortDescription");
                System.out.println("Found id in jobs table: " + id);
            }
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
            return null;
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
        
        result = result + "<fieldset><legend><font size=\"6\">" + title + "</font></legend><br>Job ID: "+ id + "<br><br>Job Description: <br>" + descript + "<br></fieldset>";
        
        int userType = user.getUserType();
        String usersID = user.getUserID();
        
        result = result + "<form method=\"POST\" action=\"ApplyServlet\">"
                + "<br><input type=\"hidden\" name=\"hiddenID\" value=\"" + id + "\"/>"
                + "<button type=\"submit\" id=\"applyButt\">Apply to Job</button>"
                + "</form>";
        if(userType==0)
        {
            result = result + " <br> "
                    + "<form method=\"POST\" action=\"ViewApplication\">"
                        + "<input type=\"hidden\" name=\"hidden6\" value=\"" + id + "\"/>"
                        + "<input type=\"hidden\" name=\"hidden9\" value=\"" + usersID + "\"/>"
                        + "<input type=\"submit\" value=\"View Application\" />"
                    + "</form>";
        }
        if(userType==1)
        {
            result = result + " <br> "
                    + "<form method=\"POST\" action=\"EditServlet\">"
                        + "<input type=\"hidden\" name=\"hiddenEdit1\" value=\"" + id + "\"/>"
                        + "<input type=\"hidden\" name=\"hiddenEdit2\" value=\"" + title + "\"/>"
                        + "<input type=\"hidden\" name=\"hiddenEdit3\" value=\"" + sDescript + "\"/>"
                        + "<input type=\"hidden\" name=\"hiddenEdit4\" value=\"" + descript + "\"/>"
                        + "<button name=\"editButt\" id=\"editButt\">Edit Job</button>"
                    + "</form>"
                    + "<form method=\"POST\" action=\"DeleteJobServlet\">"
                        + "<input type=\"hidden\" name=\"jobID\" value=\"" + id + "\"/>"
                        + "<input name=\"deleteButt\" type=\"submit\" value=\"Delete Job\"/>"
                    + "</form>";
        }
        
        result = result + "<button onclick=\"window.location.href='jobPortal.jsp'\">Back</button>";
        
        return result;
    }
    
    public String viewAllJobs(UserDetails user)
    {
        String SQL = "";
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        int userType = user.getUserType();
        
        SQL = SQL + "SELECT * FROM Job;";
        String result = "<table border=\"1\">"
                + "<th>Job Vacancies</th>"
                + "<th></th>";
        if(userType==1)
        {
                result = result + "<th> <button id=\"addButton\" onclick=\"window.location.href='addJob.jsp'\">Add Job</button> </th> ";
        }
        else if(userType==0)
        {
                result = result + "<th></th>";
        }           
                result = result + "<th></th>";
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(SQL);
            resultSet = ps.executeQuery();
            while (resultSet.next()) 
            {
		result = result + "<tr>"
                                    + "<form method=\"POST\" action=\"JobsServlet\">"
                                        + "<td>" + resultSet.getString("JobTitle") + "</td>";
                                        String jobID = resultSet.getString("JobID");
                      result = result   + "<td> Job ID: " + resultSet.getString("JobID") + "<input type=\"hidden\" name=\"jobID\" value=\"" + jobID + "\"/></td>"
                                        + "<td>" + resultSet.getString("ShortDescription") + "</td>"
                                        + "<td><input type=\"submit\" value=\"View Job\"/></td>"
                                    + "</form>";
                            if(userType==1){
                                result = result + "<form method=\"POST\" action=\"ViewResumes\">"
                                        + "<td><input type=\"hidden\" name=\"hidden2\" value=\"" + jobID + "\"/><input type=\"submit\" value=\"View Resumes\"/></td>"
                                        + "</form>";
                            }
                            else{
                              result = result + "</tr>";
                              }
                                
            }
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
            return null;
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
        result = result + "</table>";
        
        return result;
    }
    
    public void addJob (String id, String title, String sD, String des){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement stat;
        String SQL = "";
        
        SQL = SQL + "INSERT INTO `SSDI_49erZone`.`Job` (`JobID`, `JobTitle`, `Description`, `ShortDescription`) VALUES"
                + "('" + id + "', "
                + "'" + title + "', "
                + "'" + des + "', "
                + "'" + sD + "')";
        
        try {
            stat = connection.createStatement();
            stat.executeUpdate(SQL);
            stat.close();
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
        } 
        
    }

    public void updateJob(String id, String title, String sD, String des)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        String SQL = "";
        
        SQL = SQL + "UPDATE `SSDI_49erZone`.`Job` SET `JobTitle`='" + title + "', `Description`='" + des + "', `ShortDescription`='" + sD + "' WHERE `JobID`='" + id + "';";

        try {
            ps = connection.prepareStatement(SQL);
            ps.executeUpdate();
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public void deleteJob(String id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        String SQL = "";
        
        SQL = "DELETE FROM `SSDI_49erZone`.`Job` WHERE `JobID`='" + id + "'";
        
        try {
            ps = connection.prepareStatement(SQL);
            ps.executeUpdate();
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
    }
    
    public int getCount()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
       
        String sql1 = "Select count(*) AS rowcount FROM `SSDI_49erZone`.`Applications`";
        int number = 0;
        
        try {
            ps = connection.prepareStatement(sql1);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find job : ");
                //return null;
            } else {
                number = resultSet.getInt("rowcount");
            }
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + sql1);
            System.out.println("SQL error: " + se);
        } 
        
        number = number + 1;
        
        return number;
    }
    
    public void applyJob (String id, String name, String user, String resume){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement stat;
        
        int number = getCount();
        
        String SQL = "";
        SQL = SQL + "INSERT INTO `SSDI_49erZone`.`Applications` (`Number`, `JobID`, `Name`, `UserID`, `Resume`) VALUES"
                + "('" + number + "', "
                + "'" + id + "', "
                + "'" + name + "', "
                + "'" + user + "', "
                + "'" + resume + "');";

        try {
            stat = connection.createStatement();
            stat.executeUpdate(SQL);
            stat.close();
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
        }  
    }
    
    public String viewAllResumes(String id)
    {
        String SQL = "";
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        SQL = SQL + "SELECT * FROM Applications WHERE JobID='" + id + "';";
        String result = "<table border=\"1\">"
                + "<th>Applicant Name</th>"
                + "<th>User ID</th>"
                + "<th>Resume</th>"
                + "<th>Current Application Status</th>"
                + "<th>Update Status</th>"
                + "<th></th>";
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(SQL);
            resultSet = ps.executeQuery();
            while (resultSet.next()) 
            {
		result = result + "<tr>"
                                    + "<form method=\"POST\" action=\"UpdateStatus\">"
                                        + "<td>" + resultSet.getString("Name") + "</td>";
                                        String userID = resultSet.getString("UserID");
                                        String jobID = resultSet.getString("JobID");
                      result = result   + "<td>" + resultSet.getString("UserID") + "<input type=\"hidden\" name=\"hidden\" value=\"" + userID + "\"/>"
                              + "<input type=\"hidden\" name=\"hidden2\" value=\"" + jobID + "\"/></td>"
                                        + "<td>" + resultSet.getString("Resume") + "</td>"
                                        + "<td>" + resultSet.getString("Status") + "</td>"
                                        + "<td> <select name=\"status\">\n" +
                                            "  <option value=\"Under Review\">Under Review</option>\n" +
                                            "  <option value=\"Approved\">Approved</option>\n" +
                                            "  <option value=\"Denied\">Denied</option>\n" +
                                            "</select> </td>"
                                        + "<td><input type=\"submit\" value=\"Update Status\"/></td>"
                                    + "</form>";
            }
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
            return null;
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
        result = result + "</table>";
        result = result + "<br><button onclick=\"window.location.href='jobPortal.jsp'\">Back</button>";
        return result;
    }
    
    public void updateStatus(String jobid, String user, String stat)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        String SQL = "";
        
        SQL = SQL + "UPDATE `SSDI_49erZone`.`Applications` SET `Status`='" + stat + "' WHERE `JobID`='" + jobid + "' AND `UserID`='" + user + "';";

        try {
            ps = connection.prepareStatement(SQL);
            ps.executeUpdate();
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
    }
    public String viewApp(String id, String user)
    {
        String result = "";
        String SQL = "";
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        SQL = SQL + "SELECT * FROM Applications WHERE JobID='" + id +"' AND UserID='" + user + "'";
        
        try {
            ps = connection.prepareStatement(SQL);
            resultSet = ps.executeQuery();
            if (!resultSet.next()) {
                result = result + "<h1>Error: No Application Found!</h1><br><br>";
                result = result + "<button onclick=\"window.location.href='jobPortal.jsp'\">Back</button>";
            } else {
                String JobID = resultSet.getString("JobID");
                String UserID = resultSet.getString("UserID");
                String Name = resultSet.getString("Name");
                String Resume = resultSet.getString("Resume");
                String Status = resultSet.getString("Status");
                
                result = result + "<div align=\"center\">" +
                                    "    <br>" +
                                    "    <h2>Application for " + JobID + "</h2>" +
                                    "    <br>" +
                                    "    <strong>User ID: </strong>" + UserID +
                                    "    <br>" +
                                    "    <br>" +
                                    "    <strong>Name: </strong>" + Name +
                                    "    <br>" +
                                    "<fieldset><legend><font size=\"5\">Resume</font></legend>" + Resume + "</fieldset>" +
                                    "<br><br>" +
                                    "<strong>Current Status: </strong>" + Status + "<br>" +
                                    "<br><button onclick=\"window.location.href='jobPortal.jsp'\">Back</button>" +
                                    "</div>";
            }
        } 
        catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + SQL);
            System.out.println("SQL error: " + se);
            return null;
        } 
        finally
        {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
        }
        
        
        
        return result;
    }
}
