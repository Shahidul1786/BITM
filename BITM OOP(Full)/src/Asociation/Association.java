/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asociation;

/**
 *
 * @author Shahidul
 */
public class Association {
    
    public static void main(String[] args) {
        
        Bank bank = new Bank("shahid");
        Employee employee = new Employee(10000);
        Branch branch = new Branch("Dhanmondi");
        
        System.out.println(bank.getName()+"  salary is  "+employee.salary+"  branch is  "+branch.getBrachName());
        
    }
    
}
