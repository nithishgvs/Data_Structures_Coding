package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class QueueReconstructionbyHeight_406 {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (b[0] - a[0]));
    List<int[]> list = new ArrayList<>();

    for (int i = 0; i < people.length; i++) {
      list.add(people[i][1], people[i]);
    }
    return list.toArray(people);
  }


  @Test
  public void test1() {
    int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    System.out.println(reconstructQueue(people));
  }

}
