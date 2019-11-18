package org.leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestStringChain_1048 {


  int maxLength = 0;

  public int longestStrChain(String[] words) {

    int[] dp = new int[words.length];

    Arrays.fill(dp, 1);

    Arrays.sort(words,(a,b)->a.length()-b.length());

    for (int i = 1; i < words.length; i++) {
      for (int j = 0; j < i; j++) {
        if (oneLetterDiff(words[i], words[j])) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          maxLength = Math.max(dp[i], maxLength);
        }
      }
    }

    return maxLength = (maxLength == 0) ? 1 : maxLength;
  }

  private boolean oneLetterDiff(String parent, String child) {

    if (parent.length() == child.length() + 1) {

      Map<Character, Integer> map = new HashMap<>();

      for (char c : parent.toCharArray()) {
        if (!map.containsKey(c)) {
          map.put(c, 1);
        } else {
          map.put(c, map.get(c) + 1);
        }
      }

      for (char c : child.toCharArray()) {
        if (map.containsKey(c)) {
          map.put(c, map.get(c) - 1);
          if (map.get(c) == 0) {
            map.remove(c);
          }
        }

      }

      return map.keySet().size() == 1;

    }

    return false;
  }


  @Test
  public void test1() {
    System.out
        .println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
  }

  @Test
  public void test2() {
    System.out
        .println(longestStrChain(
            new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx",
                "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj",
                "grukj", "zczpzfvdhx", "gru"}));
  }

  @Test
  public void test3() {
    System.out
        .println(longestStrChain(
            new String[]{"wnyxmflkf", "xefx", "usqhb", "ttmdvv", "hagmmn", "tmvv", "pttmdvv",
                "nmzlhlpr", "ymfk", "uhpaglmmnn", "zckgh", "hgmmn", "isqxrk", "isqrk", "nmzlhpr",
                "uysyqhxb", "haglmmn", "xfx", "mm", "wymfkf", "tmdvv", "uhaglmmn", "mf",
                "uhaglmmnn", "mfk", "wnymfkf", "powttkmdvv", "kwnyxmflkf", "xx", "rnqbhxsj",
                "uysqhb", "pttkmdvv", "hmmn", "iq", "m", "ymfkf", "zckgdh", "zckh", "hmm", "xuefx",
                "mv", "iqrk", "tmv", "iqk", "wnyxmfkf", "uysyqhb", "v", "m", "pwttkmdvv",
                "rnqbhsj"}));
  }


}
