/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.controller;


import com.mycompany.testioet.model.Day;
import com.mycompany.testioet.model.Schedule;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jorge
 */
public class ScheduleController {

    public static List<Schedule> loadData() {
            Day mo = new Day("Monday", "MO");
            Day tu = new Day("Tuesday", "TU");
            Day we = new Day("Wednesday", "WE");
            Day th = new Day("Thursday", "TH");
            Day fr = new Day("Friday", "FR");
            Day sa = new Day("Saturday", "SA");
            Day su = new Day("Sunday", "SU");
            
            List<Day> workingDays = Arrays.asList(mo, tu, we, th, fr);
            List<Day> weekEnd = Arrays.asList(sa, su);
            //DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");//DateTimeFormatter.ISO_LOCAL_TIME;
            
            Schedule scheduleDays1 = new Schedule(workingDays, LocalTime.parse("00:01", formatter), LocalTime.parse("09:00", formatter), 25);
            Schedule scheduleDays2 = new Schedule(workingDays, LocalTime.parse("09:01", formatter), LocalTime.parse("18:00", formatter), 15);
            Schedule scheduleDays3 = new Schedule(workingDays, LocalTime.parse("18:01", formatter), LocalTime.MIDNIGHT, 20);
            Schedule scheduleDays4 = new Schedule(weekEnd, LocalTime.parse("00:01", formatter), LocalTime.parse("09:00", formatter), 30);
            Schedule scheduleDays5 = new Schedule(weekEnd, LocalTime.parse("09:01", formatter), LocalTime.parse("18:00", formatter), 20);
            Schedule scheduleDays6 = new Schedule(weekEnd, LocalTime.parse("18:01", formatter), LocalTime.MIDNIGHT, 25);
            List<Schedule> listScheduleCost = Arrays.asList(scheduleDays1, scheduleDays2, scheduleDays3, scheduleDays4, scheduleDays5, scheduleDays6);
            return listScheduleCost;
    }
}
