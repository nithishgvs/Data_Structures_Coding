package org.leetcode.Greedy;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestPalindromeByConcatenatingTwoLetterWords_2131 {

  public int longestPalindrome(String[] words) {
    int max = 0;

    Map<String, Integer> map = new HashMap<>();

    int freeEqual = 0;

    for (String word : words) {
      //Same word like aa
      if (word.charAt(1) == word.charAt(0)) {
        if (map.getOrDefault(word, 0) > 0) {
          freeEqual--;
          map.put(word, 0);
          max += 4;
        } else {
          map.put(word, 1);
          freeEqual++;
        }
      } else {
        String reverse = "" + word.charAt(1) + word.charAt(0);
        if (map.getOrDefault(reverse, 0) > 0) {
          map.put(reverse, map.get(reverse) - 1);
          max += 4;
        } else {
          map.put(word, map.getOrDefault(word, 0) + 1);
        }
      }

    }
    //Now if freeEqual > 0 means one or more strings with same chars is left we can use one of this to add in the center of palindrome or it will be the only palindrome
    //aa bb is input freeEqual==2 we can use one of this as palindrome not both
    return freeEqual > 0 ? max + 2 : max;
  }


  @Test
  public void test1() {
    String[] words = new String[]{"cc", "ll", "xx"};
    System.out.println(longestPalindrome(words));
  }

  @Test
  public void test2() {
    String[] words = new String[]{"ab", "ty", "yt", "lc", "cl", "ab"};
    System.out.println(longestPalindrome(words));
  }

  @Test
  public void test3() {
    String[] words = new String[]{"lc", "cl", "gg"};
    System.out.println(longestPalindrome(words));
  }

  @Test
  public void test4() {
    String[] words = new String[]{"aa", "bb"};
    System.out.println(longestPalindrome(words));
  }
}
