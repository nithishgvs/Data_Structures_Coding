package org.leetcode.StackandQueue;

import org.junit.Test;
import org.leetcode.Arrays.GuessGame;

public class GuessNumber_374 extends GuessGame {
	public int guessNumber(int n) {
		if (n == 0 || n == 1)
			return n;
		int l = 0, h = n;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int result = guess(mid);
            if(result == 0)return mid;
            else if(result == 1)l = mid + 1;
            else h = mid - 1;
		}
		return l;
	}
	
	@Test
	public void testGuess() {
		System.out.println(guessNumber(10));
	}

}
