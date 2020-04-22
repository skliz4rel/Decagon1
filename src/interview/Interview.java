/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview;

import interview.http.Webservice;
import interview.models.Response;
import interview.models.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author skliz
 */
public class Interview {

    private static Response response =null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        response = Webservice.sendGET(1);
        
        //System.out.println(" "+response.getPage());
        //System.out.println(response.getTotal());
        
         displayAnswers();
        }
        catch(Exception e){
            System.err.println(e.getCause()+" "+e.getMessage());
        }
    }
    
    
    public static void displayAnswers(){
        
        List<String> usernames = getUsernames(1000);        
        
        System.out.println("Username by the number of submitted articules showing how active they are \n"+usernames);
        
        System.out.println();
        
        String username_HighComments = getUsernameWithHighestCommentCount();
        
        System.out.println("Username with Highest comment \n"+username_HighComments);
        
         System.out.println();
        
       List<String > usernames_sortedBydate = getUsernamesSortedByRecordDate(1298054029); //So this is the TimeSpan for the date we are using has test.  So I am check for most for a particular day, in same month and same year.
       
       System.out.println("Usernames users sorted by date \n"+usernames_sortedBydate);
    }
    
 
    //This function would retrieve the names of the most active authors according to a set minimum threshold.
    //We are going to sort this authors based on the total number of articles that they sumitted.We would be using the threshold on the total submitted articules
    public static List<String> getUsernames(int threshold) {
   
        User[] users = response.getData();
        
        List<User> activeauthors = new ArrayList<User>();
        
        List<String> activeUsernames = new ArrayList<String>();
        
        for(User u : users){
            if(u.getSubmitted() >= threshold){
                activeauthors.add(u);
            }
        }
        
        //System.out.println(activa)
        
        //Now we are going to sort this users below
        Collections.sort(activeauthors, Comparator.comparing(User::getSubmitted));
        
        for(User u : activeauthors){
           
            
            if(u.getSubmitted() >= threshold){
                activeUsernames.add(u.getUsername());
             
              //   System.out.println(u);
            }
        }
        
        return activeUsernames;
    }
    
    //
    public static String getUsernameWithHighestCommentCount(){
        
         User[] users = response.getData();
         
         List<User> userlist =new ArrayList<>();
         
         for(User u : users){
             userlist.add(u);
         }
         
         Collections.sort(userlist, Comparator.comparing(User::getComment_count));
         
         User u = userlist.get(userlist.size()-1);
         
         return u.getUsername();
    }
    
   
    //So enter the timespan for the particular day or datetime that you want and it 
    public static List<String> getUsernamesSortedByRecordDate(int threshold) {
    
          User[] users = response.getData();
          
          List<User> userlist = Arrays.asList(users);
        
          //Let us try and sort users by date that were created
          Collections.sort(userlist,  Comparator.comparing(User::getCreatedDate)); //This is going to make thee list in ascending order before doing a search
                      
          //System.out.println(userlist);          
          
          List<String> usernames   = new ArrayList<String>();
          
          
        Timestamp ts=new Timestamp(threshold); //System.currentTimeMillis()
        Date sortDate=new Date(ts.getTime());
        sortDate =Dateutility.extractDate(sortDate);
        
            for(User u : userlist){
                
                if( sortDate.toString().equals(u.getCreatedDate().toString()) ){
                    usernames.add(u.getUsername());
                }
            }
            
            return usernames;
    }
  

}


