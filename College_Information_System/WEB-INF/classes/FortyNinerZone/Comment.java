/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.Serializable;

/**
 *
 * @author LokeshPC
 */
public class Comment implements Serializable{
    String newsid;
    String userid;
    String comment;
   
    
public Comment(String ni,String ui,String c) 
{
    this.newsid = ni;
    this.userid=ui;
    this.comment=c;
  
}
public Comment()
{
    
}

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
