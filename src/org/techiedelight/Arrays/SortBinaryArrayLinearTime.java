package org.techiedelight.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class SortBinaryArrayLinearTime {


  public void sortBinaryArray(int[] array) {

    int countO = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        countO++;
      }
    }
    Arrays.fill(array, 0, countO, 0);
    Arrays.fill(array, countO, array.length, 1);
  }


  @Test
  public void sortTest() {
    int[] array = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};
    sortBinaryArray(array);
    System.out.println(Arrays.toString(array));
  }

}
