
package inheritance;


public class AndroidDev extends Developer{
    
    private  int bonus = 10000;
    
    @Override
    public int getSalary(){
        
        int mainSalary = super.getSalary()+ bonus;
       
        return mainSalary;
    }
    
    
}
