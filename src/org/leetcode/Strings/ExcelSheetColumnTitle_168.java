package org.leetcode.Strings;

import org.junit.Test;

public class ExcelSheetColumnTitle_168 {
	public String convertToTitle(int n) {
		String output = "";
		while (n != 0) {
			int temp = n % 26;
			if (temp == 0) {
				temp = 26;
				if ((n / 26) == 1)
					n = 1;
			}
			output = Character.toString((char) (temp + 64)) + output;
			n = (n - 1) / 26;
		}
		return output;
	}

	@Test
	public void testExcelQuestion() {
		System.out.println(convertToTitle(58));
	}
}
