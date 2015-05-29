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
public class News  implements Serializable{
    String newsid;
    String newstitle;
    String description;
    
    
public News(String ni,String nt,String nd) 
{
    this.newsid = ni;
    this.newstitle=nt;
    this.description=nd;
    

}

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}
