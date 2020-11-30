package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class CarPooling_1094 {


  public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer, List<Integer>> dropOff = new TreeMap<>();

    Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));

    for (int[] array : trips) {
      int passengers = array[0];
      Map.Entry<Integer, List<Integer>> canDropPeople = dropOff.floorEntry(array[1]);
      while (canDropPeople != null) {
        List<Integer> list = canDropPeople.getValue();
        for (Integer dropOffPeople : list) {
          capacity += dropOffPeople;
        }
        dropOff.remove(canDropPeople.getKey());
        canDropPeople = dropOff.floorEntry(array[1]);
      }
      if (capacity >= passengers) {
        capacity = capacity - array[0];
      } else {
        return false;
      }

      List<Integer> list = dropOff.getOrDefault(array[2], new ArrayList<>());
      list.add(array[0]);
      dropOff.put(array[2], list);
    }

    return true;
  }


  @Test
  public void test1() {
    int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
    System.out.println(carPooling(trips, 3));
  }

  @Test
  public void test2() {
    int[][] trips = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
    System.out.println(carPooling(trips, 11));
  }

  //{{10,5,7},{10,3,4},{7,1,8},{6,3,4}}

  @Test
  public void test3() {
    int[][] trips = new int[][]{{10, 5, 7}, {10, 3, 4}, {7, 1, 8}, {6, 3, 4}};
    System.out.println(carPooling(trips, 24));
  }

}
