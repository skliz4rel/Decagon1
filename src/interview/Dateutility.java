/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author skliz
 */
public class Dateutility {
    
    
    
      
    public static Date extractDate(Date date){
        Date dateonly = null;
        try{
        DateFormat formatter = new SimpleDateFormat("ddMMyyyy");

        dateonly = formatter.parse(formatter.format(date));
        }
        catch(Exception e){
            System.err.println(e.getCause()+" " +e.getMessage());
        }
        
        return dateonly;
    }
    
}
