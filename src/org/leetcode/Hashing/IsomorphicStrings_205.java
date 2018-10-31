package org.leetcode.Hashing;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

	public boolean isIsomorphic(String s, String t) {
		StringBuffer tBuffer = new StringBuffer(t);
		Map<Character, Character> crazyMap = new LinkedHashMap<>();
		for (int i = 0; i < t.length(); i++) {
			if (!crazyMap.containsKey(t.charAt(i))) {
				if (!crazyMap.containsValue(s.charAt(i))) {
					crazyMap.put(t.charAt(i), s.charAt(i));
					tBuffer.setCharAt(i, s.charAt(i));
				} else
					return false;
			} else {
				tBuffer.setCharAt(i, crazyMap.get(t.charAt(i)));
			}

		}
		return tBuffer.toString().equals(s);
	}

	@Test
	public void testIsomorphic() {
		System.out.println(isIsomorphic("aa", "ab"));
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("aba", "baa"));
	}

}
