package org.leetcode.Strings;

import java.util.Stack;
import org.junit.Test;

public class IsSubsequence_392 {
	public boolean isSubsequence(String s, String t) {
		int index = 0;
		String temp = t;
		for (char c : s.toCharArray()) {
			if (temp.indexOf(c) + index >= index) {
				if (index != 0)
					index++;
				index += temp.indexOf(c);
				temp = t.substring(index + 1);
			} else {
				return false;
			}
		}
		return true;
	}

	private void checkforSubsequence(String S, String target)
	{

		// Declare a stack
		Stack<Character> s = new Stack<>();

		// Push the characters of
		// target into the stack
		for (int i = 0; i < target.length(); i++) {
			s.push(target.charAt(i));
		}

		// Traverse the string S in reverse
		for (int i = (int)S.length() - 1; i >= 0; i--) {

			// If the stack is empty
			if (s.empty()) {

				System.out.println("Yes");
				return;
			}

			// if S[i] is same as the
			// top of the stack
			if (S.charAt(i) == s.peek()) {

				// Pop the top of stack
				s.pop();
			}
		}

		// Stack s is empty
		if (s.empty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	@Test
	public void testIsSubsequence() {

		String s = "twn", t = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
		String s2 = "cd", t2 = "abcde";
		//System.out.println(isSubsequence(s2, t2));
		checkforSubsequence(t2,s2);

	}
}
