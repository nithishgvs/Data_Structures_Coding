package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindtheLongestSubstringContainingVowelsinEvenCounts_1371 {


  public int findTheLongestSubstring(String s) {

    int longestLength = 0;

    Map<Character, Integer> vowelMap = new HashMap<Character, Integer>() {
      {
        put('a', 0);
        put('e', 0);
        put('i', 0);
        put('o', 0);
        put('u', 0);
      }

    };

    int start = 0, end = 0;

    while (end < s.length()) {

      char ch = s.charAt(end);

      if (vowelMap.containsKey(ch)) {
        vowelMap.put(ch, vowelMap.get(ch) + 1);
      }
      if (vowelConditionMet(vowelMap)) {
        int currentLength = end - start + 1;
        if (currentLength > longestLength) {
          longestLength = currentLength;
        }
      }

      while (!vowelConditionMet(vowelMap) && start < end) {
        if (vowelMap.containsKey(s.charAt(start))) {
          vowelMap.put(s.charAt(start), vowelMap.get(s.charAt(start)) - 1);
        }
        start++;
      }

      end++;

    }

    return longestLength;

  }

  private boolean vowelConditionMet(Map<Character, Integer> vowelMap) {

    if (vowelMap.get('a') % 2 == 0 && vowelMap.get('e') % 2 == 0 && vowelMap.get('i') % 2 == 0
        && vowelMap.get('o') % 2 == 0 && vowelMap.get('u') % 2 == 0) {
      return true;
    }

    return false;
  }


  @Test
  public void test() {
    System.out.println(0 % 2);
    //System.out.println(findTheLongestSubstring("yopumzgd"));
    System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    System.out.println(findTheLongestSubstring("bcbcbc"));
    System.out.println(findTheLongestSubstring("eleetminicoworoep"));
  }

}
