/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.springtestaltkom.springaspect;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class TargetBean2 implements NewInterface {

    @Override
    public void someMethod(int id) {
        System.out.println("2");
    }

    @Override
    public void method2() {
        System.out.println("2");
    }
    
}
