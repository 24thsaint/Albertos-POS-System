/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.displays.customer;

/**
 *
 * @author hero
 */
public class TestDisplay {
    public static void main(String[] args) {
        CashierInterface cashier = new CashierInterface();
        CustomerInterface customer = new CustomerInterface();
        cashier.setoutput(customer);
        cashier.setVisible(true);
        customer.setVisible(true);
        
    }
}
