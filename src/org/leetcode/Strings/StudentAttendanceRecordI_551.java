package org.leetcode.Strings;

import org.junit.Test;

public class StudentAttendanceRecordI_551 {

	public boolean checkRecord(String s) {
		int aCount = 0;
		int lCount = 0;
		Character prev = null;

		for (Character c : s.toCharArray()) {
			if (c.equals('A')) {
				aCount++;
			} else if (prev != null && c.equals('L') && prev == 'L') {
				lCount++;
			} else if (!c.equals('L') && lCount > 0) {
				lCount = 0;
			}
			if (aCount > 1 || lCount > 1) {
				return false;
			}
			prev = c;
		}
		return true;
	}

	@Test
	public void testCheckRecord() {
		System.out.println(checkRecord("PPALLL"));
	}

}
