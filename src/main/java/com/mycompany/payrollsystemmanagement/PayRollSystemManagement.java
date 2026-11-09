package com.mycompany.payrollsystemmanagement;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Comparator;
public class PayRollSystemManagement {

    public static void main(String[] args) {
  ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("F1", "Ahmed", 5000, LocalDate.of(2016, 3, 15), 500));
        employees.add(new FullTimeEmployee("F2", "Sara", 6500, LocalDate.of(2018, 7, 1), 700));
        employees.add(new ContractEmployee("C1", "Omar", LocalDate.of(2023, 1, 10), 40, 120));
        employees.add(new ContractEmployee("C2", "Laila", LocalDate.of(2022, 9, 5), 55, 100));
 
     System.out.println("Original list: ");
for (int i = 0; i < employees.size(); i++) {
    System.out.println(employees.get(i));
}
 
        Collections.sort(employees);
 
        System.out.println();
        System.out.println("Sorted by net salary (highest first): ");
        for (int i = 0; i < employees.size(); i++) {
    System.out.println(employees.get(i));
        }
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getJoinDate().compareTo(b.getJoinDate());
            }
        });
 
        System.out.println();
        System.out.println("Sorted by join date (oldest first):");
       for (int i = 0; i < employees.size(); i++) {
    System.out.println(employees.get(i));
        }
 
        double performanceScore = 1; 
        double totalTax = 0;
        double totalBonus = 0;
 
    for (int i = 0; i < employees.size(); i++) {
    Employee e = employees.get(i);
    totalTax += e.calculateTax();
    totalBonus += e.calculateBonus(performanceScore);
}
 
        System.out.println();
        System.out.println("Totals:");
        System.out.println("Total Tax: " + totalTax);
        System.out.println("Total Bonus: " + totalBonus);
    }
}