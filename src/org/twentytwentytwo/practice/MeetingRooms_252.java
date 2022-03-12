package org.twentytwentytwo.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MeetingRooms_252 {


  public boolean canAttendMeetings(int[][] intervals) {

    if (intervals.length == 0) {
      return true;
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    minHeap.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {
      if (!minHeap.isEmpty() && intervals[i][0] - minHeap.peek() >= 0) {
        minHeap.poll();
        minHeap.add(intervals[i][1]);
      } else {
        minHeap.add(intervals[i][1]);
      }
    }

    return minHeap.size() == 1;
  }

  @Test
  public void test1() {
    int[][] intervals = {{7, 10}, {2, 4}};
    System.out.println(canAttendMeetings(intervals));
  }

  @Test
  public void test2() {
    int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
    System.out.println(canAttendMeetings(intervals));
  }
}
