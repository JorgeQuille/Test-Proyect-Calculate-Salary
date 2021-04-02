/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Schedule {
    private List<Day> day;
    private LocalTime hourStart;
    private LocalTime hourEnd;
    private double costHour;

    public Schedule(List<Day> day, LocalTime hourStart, LocalTime hourEnd, double costHour) {
        this.day = day;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.costHour = costHour;
    }

    public Schedule() {
    }

    public LocalTime getHourStart() {
        return hourStart;
    }

    public void setHourStart(LocalTime hourStart) {
        this.hourStart = hourStart;
    }

    public LocalTime getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(LocalTime hourEnd) {
        this.hourEnd = hourEnd;
    }

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }

    public double getCostHour() {
        return costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        return "Schedule{" + "day=" + day + " "+formatter.format(hourStart) + "-" + formatter.format(hourEnd) + ", costHour=" + costHour + " USD" +'}';
    }
    
}