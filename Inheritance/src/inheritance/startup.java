
package inheritance;

import inheritance.inheritance2.WebDev;


public class startup {

   
    public static void main(String[] args) {
      
        AndroidDev androidDev = new AndroidDev();
       System.out.println(androidDev.salary);
       
        WebDev webDev = new WebDev();
        System.out.println("Total salary : "+webDev.getSalary());
        
      System.out.println("Total salary : "+androidDev.getSalary());
       
       
       
      
    }
    
}
