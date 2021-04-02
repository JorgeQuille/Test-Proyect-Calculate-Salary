/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testioet.controller;

import com.mycompany.testioet.model.Day;
import com.mycompany.testioet.model.Employee;
import com.mycompany.testioet.model.Schedule;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jorge
 */
public class EmployeeController {

    static double costHours = 0;
    static List<Employee> listEmployee = new ArrayList<Employee>();

    public static void calculateAmountPay(Employee employee) {
        DoubleSummaryStatistics statistics = employee.getScheduleCost().stream()
                .collect(Collectors.summarizingDouble(Schedule::getCostHour));
        employee.setAmountPay(statistics.getSum());
    }

    public static double calculateCostHour(String dayCode, LocalTime hourStart, LocalTime hourEnd) {
        List<Schedule> shedules = ScheduleController.loadData();
        costHours = 0;
        shedules.forEach((Schedule sch) -> {
            boolean existDay = sch.getDay()
                    .stream()
                    .anyMatch(p -> p.getCode().startsWith(dayCode));
            if (existDay) {
                LocalTime end;
                if (sch.getHourEnd().equals(LocalTime.MIDNIGHT)) {
                    end = sch.getHourEnd().minusNanos(1);
                } else {
                    end = sch.getHourEnd();
                }
                if (sch.getHourStart().compareTo(hourStart) <= 0 && end.compareTo(hourEnd) >= 0) {
                    //if ((sch.getHourStart().equals(hourStart)||sch.getHourStart().isBefore(hourStart)) && (sch.getHourEnd().equals(hourEnd) || sch.getHourEnd().isAfter(hourEnd))){
                    long minute = Duration.between(hourStart, hourEnd).toMinutes();
                    costHours = (double) minute / 60 * sch.getCostHour();
                }
            }
        });
        return costHours;
    }

    public static List<Employee> registerEmployee(List<String> employeeData) {

        employeeData.forEach((String emp) -> {
            emp = emp.strip();
            if (emp.equals("") == false) {
                String[] dataEmployee = emp.split("=");
                if (dataEmployee.length >= 2) {
                    Employee employee = new Employee(dataEmployee[0].strip().toUpperCase());
                    String[] scheduleEmploye = dataEmployee[1].split("[,[-]]");
                    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("H:mm");//DateTimeFormatter.ISO_LOCAL_TIME;//ofLocalizedTime(FormatStyle.SHORT);
                    String dayCode = new String();
                    List<Schedule> schedules = new ArrayList<Schedule>();
                    Schedule schedule = new Schedule();
                    for (String element : scheduleEmploye) {
                        element = element.replace(" ", "");
                        if (element.length()> 5) {
                            dayCode = element.substring(0, 2).toUpperCase();
                            schedule.setDay(Arrays.asList(new Day(dayCode)));
                            element = element.substring(2);
                            schedule.setHourStart(LocalTime.parse(element, formatDate));
                        } else {
                            schedule.setHourEnd(LocalTime.parse(element, formatDate));
                            schedule.setCostHour(EmployeeController.calculateCostHour(dayCode, schedule.getHourStart(), schedule.getHourEnd()));
                            schedules.add(schedule);
                            schedule = new Schedule();
                        }
                    }
                    employee.setScheduleCost(schedules);
                    listEmployee.add(employee);
                }
            }
        });
        return listEmployee;
    }
}
