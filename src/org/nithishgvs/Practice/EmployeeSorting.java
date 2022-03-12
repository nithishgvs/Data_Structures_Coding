package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSorting {


  public static void main(String[] args) {
    Employee employee1 = new Employee(20, 20000, "sai");
    Employee employee2 = new Employee(22, 20002, "temp");
    Employee employee3 = new Employee(27, 20600, "test");

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(employee3);
    employeeList.add(employee1);
    employeeList.add(employee2);

    Collections.sort(employeeList, (a, b) -> (int) (a.salary - b.salary));

    for (Employee employee : employeeList) {
      System.out.println(employee);
    }

  }
}
