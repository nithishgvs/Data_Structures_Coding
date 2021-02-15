package org.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PairsofSongsWithTotalDurationsDivisibleby60_1010 {

  /**
   * https://www.youtube.com/watch?v=5gHnQ4lfDko&feature=emb_title
   */
  public int numPairsDivisibleBy60(int[] time) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap();
    for (int t : time) {
      if (t % 60 == 0)
        count += map.getOrDefault(0, 0);
      else
        count += map.getOrDefault(60 - t % 60, 0);
      map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
    }
    return count;
  }


  @Test
  public void test1() {
    int[] time = {30,20,150,100,40};
        //{439,407,197,191,291,486,30,307,11};
    System.out.println(numPairsDivisibleBy60(time));
  }
}
