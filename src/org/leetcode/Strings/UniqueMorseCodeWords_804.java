package org.leetcode.Strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {

	static String[] morseCodes = ".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--.."
			.split(",");

	public int uniqueMorseRepresentations(String[] words) {
		Set<String> hashSet = new HashSet<>();
		for (String s : words) {
            String out="";
			for (int i = 0; i < s.length(); i++) {
				int ascii = (int) s.charAt(i) - 97;	
               out+=morseCodes[ascii];
			}
			hashSet.add(out);
		}
		return hashSet.size();
	}

	@Test
	public void testMorse() {
		String[] words = { "gin", "zen", "gig", "msg" };
		String[] words2 = { "abc" };

		System.out.println(uniqueMorseRepresentations(words));
	}
}
