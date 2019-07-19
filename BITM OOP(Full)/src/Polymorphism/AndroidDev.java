
package Polymorphism;


public class AndroidDev extends Developer{
    
    int bonus = 10000;
    
    
    @Override
    public int getSalary(){
        
        int mainSalary = super.getSalary() + bonus;
        
        return mainSalary;
        
    }
    
}
