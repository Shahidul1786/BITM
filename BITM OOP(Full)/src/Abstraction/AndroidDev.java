
package Abstraction;


public class AndroidDev extends Developer{
    
    private int salary = 40000;
    private int bonus = 10000;

    @Override
    public int getSalary() {
      
        return salary + bonus;
    }
    
    
}
