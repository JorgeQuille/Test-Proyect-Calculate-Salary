/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.controller;

import com.mycompany.testioet.model.Day;
import com.mycompany.testioet.model.Employee;
import com.mycompany.testioet.model.Schedule;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jorge
 */
public class EmployeeControllerTest {

    static double salidaMetodo = 0;

    public EmployeeControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateAmountPay method, of class EmployeeController.
     */
    @Test
    public void testCalculateAmountPay() {
        System.out.println("calculateAmountPay");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
        Schedule shedule = new Schedule(Arrays.asList(new Day("MO")), LocalTime.parse("9:00", formatter), LocalTime.parse("12:00", formatter), 45);
        double salida = 45.00;
        List<Schedule> listShedule = Arrays.asList(shedule);
        Employee employee = new Employee(listShedule, "Juan");
        EmployeeController.calculateAmountPay(employee);

        listShedule.forEach(sch -> {
            salidaMetodo = sch.getCostHour();
        });
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(salida, salidaMetodo);
        if (salida != salidaMetodo) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of calculateCostHour method, of class EmployeeController.
     */
    @Test
    public void testCalculateCostHour() {
        System.out.println("calculateCostHour");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
        String dayCode = "SA";
        LocalTime hourStart = LocalTime.parse("01:30", formatter);
        LocalTime hourEnd = LocalTime.parse("2:00", formatter);
        double expResult = 15;
        double result = EmployeeController.calculateCostHour(dayCode, hourStart, hourEnd);
        assertEquals(expResult, result);
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of registerEmployee method, of class EmployeeController.
     */
    @Test
    public void testRegisterEmployee() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
        Schedule schedule1 = new Schedule(Arrays.asList(new Day("MO")), LocalTime.parse("10:00", formatter), LocalTime.parse("12:00", formatter), 30.00);
        Schedule schedule2 = new Schedule(Arrays.asList(new Day("TU")), LocalTime.parse("10:00", formatter), LocalTime.parse("12:00", formatter), 30.00);
        Schedule schedule3 = new Schedule(Arrays.asList(new Day("TH")), LocalTime.parse("1:00", formatter), LocalTime.parse("03:00", formatter), 50.00);
        Schedule schedule4 = new Schedule(Arrays.asList(new Day("SA")), LocalTime.parse("14:00", formatter), LocalTime.parse("18:00", formatter), 80.00);
        Schedule schedule5 = new Schedule(Arrays.asList(new Day("SU")), LocalTime.parse("20:00", formatter), LocalTime.parse("21:00", formatter), 25.00);
        List<Schedule> listSchedule = Arrays.asList(schedule1, schedule2, schedule3, schedule4, schedule5);
        Employee employee = new Employee(listSchedule, "RENE");
        System.out.println("registerEmployee");
        String data = "rene  =  MO10:00-12:00,TU10:00-12:00,TH1:00-03:00,SA14:00-18:00,SU20:00-21:00";
        List<String> employeeData = Arrays.asList(data);
        List<Employee> expResult = Arrays.asList(employee);
        expResult.forEach(x->System.out.println("Test: "+ x));
        List<Employee> result = EmployeeController.registerEmployee(employeeData);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        if (expResult.toString().equals(result.toString()) == false){
            fail("The test case is a prototype.");
        }
    }

}
