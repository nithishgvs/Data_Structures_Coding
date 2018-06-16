package org.leetcode.Strings;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GoatLatin_824 {

	public String toGoatLatin(String S) {

		String result = "";
		List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		String lastappending = "a";

		for (String str : S.split("\\s+")) {
			String temp = "";
			if (!vowelList.contains(str.charAt(0))) {
				if (str.substring(1, str.length()).length() > 0)
					temp += str.substring(1, str.length()) + str.charAt(0);
				else
					temp += str.charAt(0);
			} else
				temp += str;
			temp += "ma";
			temp += lastappending;
			result += temp + " ";
			lastappending += "a";
		}

		return result.trim();

	}

	@Test
	public void testGoatLatin() {
		String S = "The quick brown fox jumped over the lazy dog";
		System.out.println(toGoatLatin(S));
	}

}
