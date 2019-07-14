package org.leetcode.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class HappyNumber_202 {

  Set<Integer> set = new HashSet<>();

  Map<Integer,Integer> map=new HashMap<>();

  public boolean isHappy(int n) {
    return checkIsHappy(n);
  }

  private boolean checkIsHappy(int n) {
    if (n == 1) {
      return true;
    }
    int output = 0;
    while (n != 0) {
      int remainder = n % 10;
      output += Math.pow(remainder, 2);
      n = n / 10;
    }

    if (map.containsKey(output)) {
      return false;
    }
    map.putIfAbsent(output,0);
    return checkIsHappy(output);
  }

  @Test
  public void testHappy() {

    System.out.println(isHappy(19));
    //System.out.println(2/10);
  }

}
