package org.leetcode.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class JumpGameIII_1306 {

  public boolean canReach(int[] arr, int start) {

    if (start < 0 || start > arr.length - 1) {
      return false;
    }

    Queue<Integer> queue = new ArrayDeque<>();

    Set<Integer> visited = new HashSet<>();

    queue.add(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      int currIndex = queue.poll();
      if (arr[currIndex] == 0) {
        return true;
      }

      //possible indices

      int index1 = currIndex + arr[currIndex];
      int index2 = currIndex - arr[currIndex];

      if (!visited.contains(index1) && index1 > -1 && index1 < arr.length) {
        queue.add(index1);
        visited.add(index1);
      }

      if (!visited.contains(index2) && index2 > -1 && index2 < arr.length) {
        queue.add(index2);
        visited.add(index2);
      }

    }

    return false;
  }


  @Test
  public void test1() {
    System.out.println(canReach(new int[]{4,2,3,0,3,1,2}, 0));
  }

}
