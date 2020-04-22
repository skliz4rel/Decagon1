/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.models;

import interview.Dateutility;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author skliz
 */
//This is a inner class
public class User{
    private int id;  //unique ID of the user
    
    private String username;//the username of the user
    
    private String about;//the about infomation of the user
    
    private int submitted;// total number of articles submitted by the user
    
    private String updated_at;//the date and time of the last update to this record
    
    private int submission_count; //the number of submitted articles that are approved
    
    private int comment_count; //the total number of comments the user made
    
    private String created_at; // the date and time when the record was created
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getSubmitted() {
        return submitted;
    }

    public void setSubmitted(int submitted) {
        this.submitted = submitted;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getSubmission_count() {
        return submission_count;
    }

    public void setSubmission_count(int submission_count) {
        this.submission_count = submission_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
    //We are going to use this method to cast the date for a search operation
    //We are going to convert the timeStamp of the date to real date format so that we can perform search operations.
    public Date getCreatedDate(){

        Long timestamp = Long.parseLong(this.created_at);
        
        Timestamp ts=new Timestamp(timestamp); //System.currentTimeMillis()
        Date date=new Date(ts.getTime());
      //  System.out.println(date);
        
        date = Dateutility.extractDate(date);
   
        return date;
    }
    
    @Override
    public String toString(){
        
       String tostring = "{";
            tostring += " id = "+id;
            tostring += " username = "+username;
            tostring += " about = "+about;
            tostring += " submitted = "+submitted;
            tostring += " updated_at = "+updated_at;
            tostring += " submission_count = "+submission_count;
            tostring += " comment_count  = "+comment_count;
            tostring += " created_at = "+created_at;
            tostring += " created_date = "+this.getCreatedDate().toString();
            tostring += "} \n";
            
            return tostring;
    }
    
}
