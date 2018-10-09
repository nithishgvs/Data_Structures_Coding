package org.leetcode.Arrays;

public class GuessGame {

	public int guess(int num) {
		int out = 6;
		if (num == out)
			return 0;
		if (num > out)
			return 1;
		else
			return -1;
	}

}
