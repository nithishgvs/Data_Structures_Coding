package org.leetcode.Hashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones_771 {
   /**
    * 
    * @param J
    * @param S
    * @return
    */
	public int numJewelsInStones(String J, String S) {
		int jewelsInStones = 0;

		HashMap<Character, Integer> hMap = new HashMap<>();

		for (int i = 0; i < S.length(); i++) {
			if (!hMap.containsKey(S.charAt(i)))
				hMap.put(S.charAt(i), 1);
			else
				hMap.put(S.charAt(i), hMap.get(S.charAt(i)) + 1);
		}

		for (Map.Entry<Character, Integer> entry : hMap.entrySet()) {
			if (J.contains(entry.getKey().toString())) {
				jewelsInStones += entry.getValue();
			}
		}

		return jewelsInStones;
	}

	public int numJewelsInStones2(String J, String S) {
		int jewelsInStones = 0;
		for (int i = 0; i < S.length(); i++) {
			if (J.contains(String.valueOf(S.charAt(i)))) {
				jewelsInStones++;
			}
		}
		return jewelsInStones;
	}

	@Test
	public void testJewelsStones() {
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones2(J, S));
	}

}
