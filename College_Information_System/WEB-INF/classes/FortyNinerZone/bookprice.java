/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.io.Serializable;

/**
 *
 * @author Arj
 */
public class bookprice implements Serializable {
    String isbn, availability,imageurl;
    String booktitle,author,booksubject,year,links,links2,price;
    
    public bookprice(String isbn, String booktitle, String author, String booksubject, String year) {
        this.isbn = isbn;
        this.booktitle = booktitle;
        this.author = author;
        this.booksubject = booksubject;
        this.year = year;
    }
     public bookprice(String isbn, String booktitle, String author, String booksubject, String year
             ,String imageurl,String availability,String links,String links2,String price) {
        this.isbn = isbn;
        this.booktitle = booktitle;
        this.author = author;
        this.booksubject = booksubject;
        this.year = year;
        this.imageurl = imageurl;
        this.availability = availability;
        this.links = links;
        this.links2 = links2;   
        this.price = price;
    }
 
     
      public bookprice( String booktitle, String author, String booksubject, String year
             ,String imageurl,String availability,String links) {
        
        this.booktitle = booktitle;
        this.author = author;
        this.booksubject = booksubject;
        this.year = year;
        this.imageurl = imageurl;
        this.availability = availability;
        this.links = links;
    }

    bookprice() {
        
    }

    
    public String getLinks2() {
        return links2;
    }

    public void setLinks2(String links2) {
        this.links2 = links2;
    }
     public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooksubject() {
        return booksubject;
    }

    public void setBooksubject(String booksubject) {
        this.booksubject = booksubject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

//    public String getLinks() {
//        return links;
//    }
//
//    public void setLinks(String links) {
//        this.links = links;
//    }
}
