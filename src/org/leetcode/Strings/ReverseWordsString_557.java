package org.leetcode.Strings;

import org.junit.Test;

public class ReverseWordsString_557 {

	/**
	 * Input: "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL
	 * tsetnoc"
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		StringBuilder reversedString = new StringBuilder();
		String tempString = new String();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				reversedString.append(s.charAt(i));
			} else {
				reversedString = reversedString.reverse();
				tempString += reversedString.toString() + s.charAt(i);
				reversedString.delete(0, reversedString.length());
			}

		}
		tempString += reversedString.reverse().toString();
		return tempString;
	}

	@Test
	public void reverseWordsTest() {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));

	}

}
