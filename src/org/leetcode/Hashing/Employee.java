package org.leetcode.Hashing;

import java.util.List;

public class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
	public Employee(int id, int importance, List<Integer> subordinates) {
		super();
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}