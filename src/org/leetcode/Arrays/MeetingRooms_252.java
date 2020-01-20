package org.leetcode.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Test;

public class MeetingRooms_252 {


  public boolean canAttendMeetings(int[][] intervals) {

    Arrays.sort(intervals, (ints, t1) -> {
      return ints[0] - t1[0];
    });

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    for (int[] interval : intervals) {
      if (!priorityQueue.isEmpty() && priorityQueue.peek() <= interval[0]) {
        priorityQueue.poll();
      }
      if (priorityQueue.size() > 0) {
        return false;
      }
      priorityQueue.add(interval[1]);
    }

    return true;
  }

  @org.junit.Test
  public void test() {
    int[][] rooms = new int[][]{{0, 30}, {5, 10}, {15, 20}};
    System.out.println(canAttendMeetings(rooms));

  }

  @org.junit.Test
  public void test1() {
    int[][] rooms = new int[][]{{7, 10}, {2, 4}};
    System.out.println(canAttendMeetings(rooms));

  }

  @Test
  public void test3() {
    int[][] rooms = new int[][]{{2, 11}, {6, 16}, {11, 16}};
    System.out.println(canAttendMeetings(rooms));

  }

}
