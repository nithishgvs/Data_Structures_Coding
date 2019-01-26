package org.leetcode.Strings;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {


  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    StringBuffer currentLongest = new StringBuffer();
    Set<Character> hset = new LinkedHashSet<>();
    for (char ch : s.toCharArray()) {
      if (!hset.contains(ch)) {
        hset.add(ch);
      } else {
        if (hset.size() > currentLongest.length()) {
          currentLongest.delete(0, currentLongest.length());
          hset.forEach((item) -> {
            currentLongest.append(item);
          });
          hset.removeAll(hset);
          hset.add(ch);
          continue;
        }
        hset.removeAll(hset);
        hset.add(ch);
      }
    }

    if(currentLongest.length()<hset.size()){
      return hset.size();
    }
    return currentLongest.length();
  }

  @Test
  public void testSubString1() {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

  @Test
  public void testSubString2() {
    System.out.println(lengthOfLongestSubstring("bbbbb"));
  }

  @Test
  public void testSubString3() {
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }

  @Test
  public void testSubString4() {
    System.out.println(lengthOfLongestSubstring(" "));
  }

  @Test
  public void testSubString5() {
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }
}
