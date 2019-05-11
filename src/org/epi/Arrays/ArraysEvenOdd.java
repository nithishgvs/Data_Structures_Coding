package org.epi.Arrays;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ArraysEvenOdd {

  public void evenOdd(List<Integer> array) {
    int nextEven = 0, nextOdd = array.size() - 1;
    while (nextEven < nextOdd) {
      if (array.get(nextEven) % 2 == 0) {
        nextEven++;
      } else {
        Collections.swap(array, nextEven, nextOdd--);
      }
    }
  }


  @Test
  public void testEvenOdd() {
    evenOdd(java.util.Arrays.asList(1, 2, 5, 7, 9));
  }


}
