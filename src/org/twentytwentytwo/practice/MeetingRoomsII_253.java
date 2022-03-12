package org.twentytwentytwo.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MeetingRoomsII_253 {

  public int minMeetingRooms(int[][] intervals) {

    Arrays.sort(intervals, (Comparator.comparingInt(a -> a[0])));

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {

      int[] newInterval = intervals[i];

      if (newInterval[0] - priorityQueue.peek() >= 0) {
        priorityQueue.poll();
        priorityQueue.add(newInterval[1]);
      } else {
        priorityQueue.add(newInterval[1]);
      }

    }

    return priorityQueue.size();
  }


  @Test
  public void test1() {
    int[][] intervals = {{2, 11}, {6, 16}, {11, 16}};
    System.out.println(minMeetingRooms(intervals));
  }

}
