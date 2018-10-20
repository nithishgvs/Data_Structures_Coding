package org.leetcode.Stack;

import org.junit.Test;

import java.util.Stack;

public class BaseballGame_682 {

	public int calPoints(String[] ops) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < ops.length; i++) {

			switch (ops[i]) {
			case "D":
				sum += stack.peek() * 2;
				stack.push(stack.peek() * 2);
				break;
			case "C":
				sum -= stack.pop();
				break;
			case "+":
				int j = 0;
				int elem1 = -1;
				int elem2 = -1;
				while (j < 2) {
					if (elem1 == -1)
						elem1 = stack.pop();
					else
						elem2 = stack.pop();
					j++;
				}
				stack.add(elem2);
				stack.add(elem1);
				stack.add(elem2 + elem1);
				sum += elem1 + elem2;
				break;

			default:
				int value = Integer.parseInt(ops[i]);
				stack.push(value);
				sum += value;
				break;
			}

		}

		return sum;

	}

	@Test
	public void testCalPoints() {
		String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		System.out.println(calPoints(ops));
	}

}
