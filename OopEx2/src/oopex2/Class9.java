/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopex2;


public class Class9 {

   
    public static void main(String[] args) {
      User user =  new User("s100","Shahidul","shahid@gmail.com","male","0160000000","Dhanmondi-15");
      
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getGender());
        System.out.println(user.getMobileNumber());
       // System.out.println(user.getAddress());
        
        if (user.getAddress()!= null) {
            
         System.out.println(user.getAddress());   
        }
         
        
       
        
        
        
    }
    
}
