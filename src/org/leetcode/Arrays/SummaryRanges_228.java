package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class SummaryRanges_228 {

  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) {
      return new ArrayList<>();
    }
    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);
    map.put(0, list);
    int k = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1] + 1) {
        list = map.get(k);
        list.add(nums[i]);
        map.put(k, list);
      } else {
        list = new ArrayList<>();
        list.add(nums[i]);
        map.put(++k, list);
      }

    }
    List<String> out = new ArrayList<>();
    Iterator<List<Integer>> iterator = map.values().iterator();
    while (iterator.hasNext()) {
      List<Integer> vals = iterator.next();
      String x = "";
      if (vals.size() >= 2) {
        x = vals.get(0) + "->" + vals.get(vals.size() - 1);
      } else {
        x += vals.get(0);
      }

      out.add(x);
    }

    return out;
  }


  @Test
  public void test1() {
    summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
  }

}
