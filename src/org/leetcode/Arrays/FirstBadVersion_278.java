package org.leetcode.Arrays;

import org.junit.Test;

public class FirstBadVersion_278 extends VersionControl {

	public int firstBadVersion(int n) {
		if (n == 0 || n == 1)
			return n;
		int l = 0, h = n;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (isBadVersion(mid)) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	@Test
	public void testFirstBadVersion() {
		System.out.println(firstBadVersion(5));
	}

}
