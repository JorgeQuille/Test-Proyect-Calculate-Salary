/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.main;

import com.mycompany.testioet.controller.EmployeeController;
import com.mycompany.testioet.model.Employee;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Main {
    static String result= "";
    public static void main(String[] args) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showDialog(null, "Choose employee data .txt");
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            List<String> dataEmployee = Files.readAllLines(Path.of(path));
            List<Employee> listEmployee = EmployeeController.registerEmployee(dataEmployee);
            listEmployee.forEach(emp -> {
                EmployeeController.calculateAmountPay(emp);
            });
            listEmployee.forEach((Employee emp) -> {
                result = result.concat("The amount to pay " + emp.getName() + " is: " + emp.getAmountPay() + " USD\n");
            });
            JOptionPane.showMessageDialog(null, result,"Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error opening the entered .txt file","Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
