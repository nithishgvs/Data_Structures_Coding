package org.leetcode.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class BrickWall_554 {


  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (List<Integer> subWalls : wall) {
      int previous = 0;
      for (int i = 0; i < subWalls.size() - 1; i++) {
        Integer newKey = subWalls.get(i) + previous;
        Integer newValue = map.getOrDefault(newKey, 0) + 1;
        map.put(newKey, newValue);
        max = Math.max(max, newValue);
        previous = newKey;
      }
    }

    return max == 0 ? wall.size() : wall.size() - max;
  }


  @Test
  public void test1() {
    List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
    List<Integer> list2 = Arrays.asList(3, 1, 2);
    List<Integer> list3 = Arrays.asList(1, 3, 2);
    List<Integer> list4 = Arrays.asList(2, 4);
    List<Integer> list5 = Arrays.asList(3, 1, 2);
    List<Integer> list6 = Arrays.asList(1, 3, 1, 1);
    List<List<Integer>> mainList = Arrays.asList(list1, list2, list3, list4, list5, list6);
    System.out.println(leastBricks(mainList));
  }

}
