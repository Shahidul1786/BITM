/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;


public class startup {

   
    public static void main(String[] args) {
//        AndroidDev androidDev = new AndroidDev();
//     
//        System.out.println(androidDev.getSalary());
//        
//        WebDev webDev = new WebDev();
//        System.out.println(webDev.getSalary());
        
        //UP CASTING
        
        Developer developer = new AndroidDev();
        System.out.println(developer.getSalary());
        
        //DOWN CASTING
        
        WebDev webDev = (WebDev)developer;
        System.out.println(webDev.getSalary());
    }
    
}
