/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstraction;

/**
 *
 * @author Shahidul
 */
public class WebDev extends Developer {

    private int salary = 35000;
    private int bonus = 8000;

    @Override
    public int getSalary() {

        return salary + bonus;

    }

}
