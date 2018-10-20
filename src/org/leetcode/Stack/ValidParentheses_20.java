package org.leetcode.Stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

	public static Map<Character, Character> paranthesisMap = new HashMap<>();

	static {
		paranthesisMap.put('}', '{');
		paranthesisMap.put(')', '(');
		paranthesisMap.put(']', '[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (!paranthesisMap.containsKey(ch))
				stack.push(ch);
			else {
				if (!stack.isEmpty() && stack.peek().equals(paranthesisMap.get(ch)))
					stack.pop();
				else
					stack.push(ch);
			}
		}

		return stack.isEmpty();
	}

	@Test
	public void testValidParentheses() {
		String s = ")";
		System.out.println(isValid(s));
	}

}
