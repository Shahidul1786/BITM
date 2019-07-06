/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.inheritance2;

import inheritance.Developer    ;

/**
 *
 * @author Mobile App Develop
 */
public class WebDev extends Developer{
    
    int bonus = 11000;
    
    @Override
    public int getSalary(){
        
        int totalSalary = super.getSalary() + bonus;
        return totalSalary;
        
    }
    
}
