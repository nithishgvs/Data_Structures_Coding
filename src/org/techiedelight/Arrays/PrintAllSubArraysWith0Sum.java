package org.techiedelight.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PrintAllSubArraysWith0Sum {


  public void printAllSubArraysWith0Sum(int[] array) {

    Map<Integer, ArrayList<Integer>> subArrayMap = new HashMap<>();

    fillMap(subArrayMap, 0, -1);

    int sum = 0;

    for (int i = 0; i < array.length; i++) {
      sum += array[i];

      if (subArrayMap.containsKey(sum)) {
        for (Integer integer : subArrayMap.get(sum)) {
          System.out
              .println("zero sum found,here are the indices [" + (integer + 1) + ".." + i + "]");
        }
      }
      fillMap(subArrayMap, sum, i);
    }

    System.out.println("Done");

  }

  private void fillMap(Map<Integer, ArrayList<Integer>> subArrayMap, int key, int value) {

    if (!subArrayMap.containsKey(key)) {
      subArrayMap.put(key, new ArrayList<>());
    }

    subArrayMap.get(key).add(value);
  }

  @Test
  public void testSubArray() {
    int[] array = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
    printAllSubArraysWith0Sum(array);
  }


  @Test
  public void testSubArray2() {
    int[] array = {3, 4, -7, 1, 3, 3, 1, -4};
    printAllSubArraysWith0Sum(array);
  }
}
