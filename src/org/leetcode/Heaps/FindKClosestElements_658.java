package org.leetcode.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class FindKClosestElements_658 {

  class Element {

    int value;
    int distance;

    public Element(int value, int distance) {
      this.value = value;
      this.distance = distance;
    }
  }


  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    List<Element> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      Element element = new Element(arr[i], Math.abs(arr[i] - x));
      list.add(element);
    }

    PriorityQueue<Element> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (a.distance == b.distance) {
        return a.value - b.value;
      }
      return a.distance - b.distance;
    });

    priorityQueue.addAll(list);
    int i = 0;

    while (i < k) {
      result.add(priorityQueue.poll().value);
      i++;
    }
    Collections.sort(result);
    return result;

  }

  @Test
  public void test1() {
    findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
  }

  @Test
  public void test2() {
    findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
  }

}
