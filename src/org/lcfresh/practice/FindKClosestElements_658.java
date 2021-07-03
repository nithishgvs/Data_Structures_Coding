package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class FindKClosestElements_658 {


  private class ElementDto {

    int element;
    int diff;

    public ElementDto(int element, int diff) {
      this.element = element;
      this.diff = diff;
    }
  }


  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();

    PriorityQueue<ElementDto> minHeap = new PriorityQueue<>((o1, o2) -> {
      if (o1.diff == o2.diff) {
        return o1.element - o2.element;
      }
      return o1.diff - o2.diff;
    });

    for (int elem : arr) {
      minHeap.add(new ElementDto(elem, Math.abs(x - elem)));
    }

    for (int i = 0; i < k; i++) {
      result.add(minHeap.poll().element);
    }

    Collections.sort(result);

    return result;
  }

  @Test
  public void test1() {
    findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
  }

  @Test
  public void test2() {
    findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
  }

  @Test
  public void test3() {
    findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
  }


}
