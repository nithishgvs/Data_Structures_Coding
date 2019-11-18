package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

//FindMedianDataStream_295
public class MedianFinder {

  PriorityQueue<Integer> minHeap = null;
  PriorityQueue<Integer> maxHeap = null;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>((a, b) -> b.intValue() - a.intValue());
  }

  public void addNum(int num) {
    maxHeap.add(num);
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    }
    if (minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
      int x = maxHeap.poll();
      maxHeap.add(minHeap.poll());
      minHeap.add(x);
    }
  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return (float) (minHeap.peek() + maxHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }

  @Test
  public void testStream() {
    addNum(1);
    System.out.println(findMedian());
    addNum(2);
    System.out.println(findMedian());
    addNum(3);
    System.out.println(findMedian());
    addNum(4);
    System.out.println(findMedian());
    addNum(5);
    System.out.println(findMedian());
    addNum(6);
    System.out.println(findMedian());
    addNum(7);
    System.out.println(findMedian());
    addNum(8);
    System.out.println(findMedian());
    addNum(9);
    System.out.println(findMedian());
    addNum(10);
    System.out.println(findMedian());

  }

  @Test
  public void testStream1() {
    addNum(-1);
    System.out.println(findMedian());
    addNum(-2);
    System.out.println(findMedian());
    addNum(-3);
    System.out.println(findMedian());
    addNum(-4);
    System.out.println(findMedian());
    addNum(-5);
    System.out.println(findMedian());

  }

}
