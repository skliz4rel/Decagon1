/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.models;

/**
 *
 * @author skliz
 */
public class Response {
    
    //The current page of the result
    private int page;
            
    // The maximum number of users returned per page
    private int per_page;
    
    //The total number of users on all pages of the result
    private int total;
    
    //The total number of pages with results
    private int total_pages;
    
    //An aray of objects containing users returned on the requested page
   private User[] data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public User[] getData() {
        return data;
    }

    public void setData(User[] data) {
        this.data = data;
    }
   
}
