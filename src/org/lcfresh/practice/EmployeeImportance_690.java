package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;
import org.leetcode.Hashing.Employee;

public class EmployeeImportance_690 {


  public int getImportance(List<Employee> employees, int id) {

    int importance = 0;

    ListIterator<Employee> itr = employees.listIterator();
    while (itr.hasNext()) {
      Employee emp = itr.next();
      if (emp.id == id) {
        importance = emp.importance;
        for (Integer sub : emp.subordinates) {
          importance += getImportance(employees, sub);
        }
      }
    }
    return importance;

  }

  @Test
  public void testEmployees() {
    // [[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]]
    Integer[] array1 = {2, 3};
    Integer[] array2 = {};
    Integer[] array3 = {};
    Employee innerObj1 = new Employee(1, 5, Arrays.asList(array1));
    Employee innerObj2 = new Employee(2, 3, Arrays.asList(array2));
    Employee innerObj3 = new Employee(3, 3, Arrays.asList(array3));
    Employee innerObj4 = new Employee(4, 1, Arrays.asList(array3));
    List<Employee> employees = new ArrayList<>();
    employees.add(innerObj1);
    employees.add(innerObj2);
    employees.add(innerObj3);
    //employees.add(innerObj4);
    System.out.println(getImportance(employees, 1));
  }

  @Test
  public void testEmployees2() {
    // [[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]]
    Integer[] array1 = {5};
    Integer[] array2 = {};
    Integer[] array3 = {};
    Employee innerObj1 = new Employee(1, 2, Arrays.asList(array1));
    Employee innerObj2 = new Employee(5, -3, Arrays.asList(array2));
    Employee innerObj3 = new Employee(3, 3, Arrays.asList(array3));
    Employee innerObj4 = new Employee(4, 1, Arrays.asList(array3));
    List<Employee> employees = new ArrayList<>();
    employees.add(innerObj1);
    employees.add(innerObj2);
    //employees.add(innerObj3);
    //employees.add(innerObj4);
    System.out.println(getImportance(employees, 5));
  }


}
