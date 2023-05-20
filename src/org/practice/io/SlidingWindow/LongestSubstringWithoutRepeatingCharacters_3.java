package org.practice.io.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {


  public int lengthOfLongestSubstring(String s) {

    if (s.length() == 0) {
      return 0;
    }

    int length = 1;

    int start = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (!freqMatch(map)) {
        if (map.get(s.charAt(start)) > 1) {
          map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
        } else {
          map.remove(s.charAt(start));
        }
        start++;
      }
      length = Math.max(length, i - start + 1);
    }

    return length;

  }

  private boolean freqMatch(Map<Character, Integer> map) {
    Set<Integer> hashSet = new HashSet<>();
    hashSet.addAll(map.values());
    return hashSet.size() == 1 && hashSet.contains(1);
  }


  @Test
  public void test() {
    lengthOfLongestSubstring("pwwkew");
  }

}
