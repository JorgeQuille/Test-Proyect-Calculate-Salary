/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.model;


import java.util.List;

/**
 *
 * @author jorge
 */
public class Employee extends Person {

    private List<Schedule> scheduleCost;
    private double amountPay;

    public Employee(String name) {
        super(name);
    }

    public Employee(List<Schedule> scheduleCost, String name) {
        super(name);
        this.scheduleCost = scheduleCost;
    }

    public List<Schedule> getScheduleCost() {
        return scheduleCost;
    }

    public void setScheduleCost(List<Schedule> scheduleCost) {
        this.scheduleCost = scheduleCost;
    }

    public double getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(double amountPay) {
        this.amountPay = amountPay;
    }

    @Override
    public String toString() {
        return this.getName()+ "{" + "schedule=" + scheduleCost + ", amountPay=" + amountPay + '}';
    }

}
