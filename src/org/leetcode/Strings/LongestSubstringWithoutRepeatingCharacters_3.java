package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {


  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    if (s == null || s.length() == 0) {
      return max;
    }

    Set<Character> set = new LinkedHashSet<>();
    for (char ch : s.toCharArray()) {
      if (!set.contains(ch)) {
        set.add(ch);
      } else {
        List<Character> list = new ArrayList<>(set);
        if (list.get(0) == ch) {
          list.remove(0);
          list.add(ch);
          set.removeAll(set);
          set.addAll(list);
        } else {
          int i = 0;
          int actualIndex = list.indexOf(ch);
          while (i <= actualIndex) {
            list.remove(0);
            i++;
          }
          max = Math.max(max, set.size());
          set.removeAll(set);
          set.addAll(list);
          set.add(ch);
        }
      }
      max = Math.max(max, set.size());
    }

    return max;
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
    System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
  }

  @Test
  public void testSubString5() {
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }//"ohvhjdml"

  @Test
  public void testSubString6() {
    System.out.println(lengthOfLongestSubstring("ohvhjdml"));
  }

  @Test
  public void testSubString7() {
    System.out.println(lengthOfLongestSubstring("aabaab!bb"));
  }//"yfsrsrpzuya"

  @Test
  public void testSubString8() {
    System.out.println(lengthOfLongestSubstring("yfsrsrpzuya"));
  }

  @Test
  public void testSubString9() {
    System.out.println(lengthOfLongestSubstring("wslznzfxojzd"));
  }
}
