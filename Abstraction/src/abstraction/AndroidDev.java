/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

/**
 *
 * @author Mobile App Develop
 */
public class AndroidDev extends Developer{
    
    private  int salary = 50000;
    private int bonus = 11000;

    @Override
    public int getSalary() {
        
        return salary + bonus;
        
        
            }
    
}
