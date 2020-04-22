/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.http;

import com.google.gson.Gson;
import interview.models.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author skliz
 */
public class Webservice {
 
    private static String GET_URL ="https://jsonmock.hackerrank.com/api/article_users/search?page=";
    
    	public static Response sendGET(int pageNumber) throws IOException {
            
            
            Response response = null;
            String jsonResponse = "";
            
		URL obj = new URL(GET_URL+ pageNumber);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestMethod("GET");                
                
		//con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		//System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpsURLConnection.HTTP_OK) { // success
                                      
                    InputStream inputStream = con.getInputStream();
                    jsonResponse = convertStreamToString(inputStream);
                    
                    if(jsonResponse != null){
                        response = fromjsonToObject(jsonResponse, Response.class);
                    }

			// print result
			//System.out.println(jsonResponse);
		} else {
			System.out.println("GET request not worked");
		}

               return response;
	}
    
        
    public static  <T> T fromjsonToObject(String json, final Class<T> objectClass){

        //return new GsonBuilder().create().fromJson(json, objectClass);

        Gson gson = new Gson();
        return  gson.fromJson(json, objectClass);
    }
          
    private static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
        	System.err.println("first "+e.toString());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            	System.out.println("second  "+e.toString());
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
 
        return stringBuilder.toString();
    }
    
}
