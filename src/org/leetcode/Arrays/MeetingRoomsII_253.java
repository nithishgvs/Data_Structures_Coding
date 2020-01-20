package org.leetcode.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Test;

public class MeetingRoomsII_253 {

  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      return a[0] - b[0];
    });

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int[] interval : intervals) {
      if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
        minHeap.poll();
      }
      minHeap.add(interval[1]);

    }

    return minHeap.size();
  }


  @Test
  public void test() {
    int[][] rooms = new int[][]{{0, 30}, {5, 10}, {15, 20}};
    System.out.println(minMeetingRooms(rooms));

  }

  @Test
  public void test1() {
    int[][] rooms = new int[][]{{7, 10}, {2, 4}};
    System.out.println(minMeetingRooms(rooms));

  }

  @Test
  public void test3() {
    int[][] rooms = new int[][]{{2, 11}, {6, 16}, {11, 16}};
    System.out.println(minMeetingRooms(rooms));

  }

}
