package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class UniqueNumberofOccurrences_1207 {

  public boolean uniqueOccurrences(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i : arr) {
      if (!map.containsKey(i)) {
        map.put(i, 0);
      }
      map.put(i, map.get(i) + 1);
    }

    Set<Integer> set = new HashSet<>();

    for (int x : map.values()) {
      if (set.contains(x)) {
        return false;
      }
      set.add(x);
    }

    return true;
  }

  @Test
  public void test(){
    System.out.println(uniqueOccurrences(new int[]{1,2}));
  }



}
