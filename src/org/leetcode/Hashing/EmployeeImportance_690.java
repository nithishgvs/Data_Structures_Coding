package org.leetcode.Hashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class EmployeeImportance_690 {
	/**
	 * Recursion look again
	 * 
	 * @param employees
	 * @param id
	 * @return
	 */
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
		Integer[] array1 = { 2, 3 };
		Integer[] array2 = { 4 };
		Integer[] array3 = {};
		Employee innerObj1 = new Employee(1, 5, Arrays.asList(array1));
		Employee innerObj2 = new Employee(2, 3, Arrays.asList(array2));
		Employee innerObj3 = new Employee(3, 4, Arrays.asList(array3));
		Employee innerObj4 = new Employee(4, 1, Arrays.asList(array3));
		List<Employee> employees = new ArrayList<>();
		employees.add(innerObj1);
		employees.add(innerObj2);
		employees.add(innerObj3);
		employees.add(innerObj4);
		System.out.println(getImportance(employees, 1));
	}

}
