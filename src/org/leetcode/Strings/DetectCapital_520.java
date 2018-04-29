package org.leetcode.Strings;

import org.junit.Test;

public class DetectCapital_520 {

	public boolean detectCapitalUse(String word) {
		int capitalCount = 0;

		for (int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				capitalCount++;
			}
		}
		if (capitalCount == 0) {
			return true;
		} else if (capitalCount == 1 && Character.isUpperCase(word.charAt(0))) {
			return true;
		} else if (capitalCount == word.length()) {
			return true;
		}

		return false;

	}

	@Test
	public void detectCapitalUseTest() {
		System.out.println(detectCapitalUse("Google"));
		System.out.println(detectCapitalUse("FlaG"));
	}

}
