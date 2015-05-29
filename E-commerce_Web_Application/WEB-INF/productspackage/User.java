/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;
import java.io.Serializable;
import javax.swing.JFrame;
/**
 *
 * @author Arj
 */
public class User extends JFrame implements Serializable{
    private String firstname,lastname,emailaddress,address1field,address2field,city,state,postcode,country,password;
    String userID;
  
   public User() 
   {
        userID = "";
        password="";
        firstname="";
        lastname="";
        emailaddress="";
        address1field="";
        address2field="";
        city="";
        state="";
        postcode="";
        country="";
      
    }
   public User(String userID,String password,String firstname,String lastname,String emailaddress,String address1field,String address2field,
           String city,String state,String postcode,String country) 
   {
       this.userID = userID;
       this.password = password;
       this.firstname = firstname;
       this.lastname = lastname;
       this.emailaddress = emailaddress;
       this.address1field = address1field;
       this.address2field = address2field;
       this.city = city;   
       this.state = state;  
       this.postcode = postcode; 
       this.country = country; 
      
    }
   public User(String userID,String firstname,String lastname,String emailaddress,String address1field,String address2field,String city,String state,String postcode,String country) 
   {
       this.userID = userID;
       this.firstname = firstname;
       this.lastname = lastname;
       this.emailaddress = emailaddress;
       this.address1field = address1field;
       this.address2field = address2field;
       this.city = city;   
       this.state = state;  
       this.postcode = postcode; 
       this.country = country; 
     
    }
   
   public User(String address1field,String address2field,String city,String state,String postcode,String country) 
   {
      
       this.address1field = address1field;
       this.address2field = address2field;
       this.city = city;   
       this.state = state;  
       this.postcode = postcode; 
       this.country = country; 
     
    }
   public User(String userID,String password) {
       
       this.userID = userID;
       this.password = password;
   }
   public User(String userID,String password,String emailaddress) {
       
       this.userID = userID;
       this.password = password;
       this.emailaddress = emailaddress;
   }
   public User(String userID) {
       
       this.userID = userID;
      
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
   
   public String getFirstName()
   {
      return firstname;
   }
   public void setFirstName(String firstname)
   {    
       this.firstname = firstname;
   }
   public String getLastName()
   {
      return lastname;
   }
   public void setLastName(String lastname)
   {    
       this.lastname = lastname;
   }
   public String getEmailAddress()
   {
       return emailaddress;
   }
   public void setEmailAddress(String emailaddress)
   {    
       this.emailaddress = emailaddress;
   }
   public String getAddress1Field()
   {
       return address1field;
   }
   public void setAddress1Field(String address1field)
   {    
       this.address1field = address1field;
   }
   public String getAddress2Field()
   {
       return address2field;
   }
   public void setAddress2Field(String address2field)
   {    
       this.address2field = address2field;
   }
    public String getCity()
   {    
       return city;
   }
   public void setCity(String city)
   {
       this.city=city;
   }
//    public String getStateu()
//   {    
//       return state;
//   }
//   public void setStateu(String state)
//   {
//       this.state=state;
//   }
   public String getPostCode()
   {    
       return postcode;
   }
   public void setPostCode(String postcode)
   {
       this.postcode=postcode;
   }
   public String getCountry()
   {    
       return country;
   }
   public void setCountry(String country)
   {
       this.country=country;
   }
}
     
 

   