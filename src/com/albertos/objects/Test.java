/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.objects;

import com.albertos.controllers.EMFactory;
import com.albertos.controllers.EmployeeJpaController;

/**
 *
 * @author hero
 */
public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFirstName("Tristan");
        employee.setLastname("Arevalo-Macadangdang");
        employee.setUsername("Tantan");
        employee.setPassword("gwapo");
        EmployeeJpaController employeeJpaController = new EmployeeJpaController(EMFactory.getEmf());
        employeeJpaController.create(employee);
    }
}
