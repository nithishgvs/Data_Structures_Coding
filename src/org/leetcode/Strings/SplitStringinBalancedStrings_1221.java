package org.leetcode.Strings;

import org.junit.Test;

public class SplitStringinBalancedStrings_1221 {

  public int balancedStringSplit(String s) {
    int count = 0;

    int lCount = 0, rCount = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'L') {
        lCount++;
      } else {
        rCount++;
      }
      if (lCount == rCount) {
        count++;
        lCount = 0;
        rCount = 0;
      }
    }

    return count;
  }

  @Test
  public void test() {
    System.out.println(balancedStringSplit("RLRRRLLRLL"));
  }

}
