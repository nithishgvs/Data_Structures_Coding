package org.leetcode.Strings;

import org.junit.Test;

import java.util.HashMap;

public class JudgeRouteCircle_657 {

	HashMap<Character, Integer> routeMap = new HashMap<>();

	public void prepareMap() {
		routeMap.put('L', -1);
		routeMap.put('R', 1);
		routeMap.put('U', 1);
		routeMap.put('D', -1);
	}

	public boolean judgeCircle(String moves) {
		int totalSum = 0;
		prepareMap();
		for (Character c : moves.toCharArray()) {
			totalSum += routeMap.get(c);
		}
		return (totalSum == 0);
	}

	@Test
	public void testJudgeCircle() {
		String moves = "RL";
		System.out.println(judgeCircle(moves));

	}
}
