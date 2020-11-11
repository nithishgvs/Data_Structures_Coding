package org.leetcode.Arrays;

import java.util.Arrays;
import java.util.TreeMap;
import org.junit.Test;

public class HowManyNumbersAreSmallerThantheCurrentNumber_1365 {


  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] result = new int[nums.length];

    int[] copy = Arrays.copyOfRange(nums, 0, nums.length);

    Arrays.sort(copy);

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    int duplicateCount = 1;

    for (int i = 0; i < copy.length; i++) {
      Integer floorKey = treeMap.floorKey(copy[i]);
      if (floorKey != null) {
        if (!treeMap.containsKey(copy[i])) {
          if (duplicateCount > 1) {
            treeMap.put(copy[i], treeMap.get(floorKey) + duplicateCount);
          } else {
            treeMap.put(copy[i], treeMap.get(floorKey) + 1);
          }
          duplicateCount = 1;
        } else {
          duplicateCount++;
        }
      } else {
        treeMap.put(copy[i], 0);
      }
    }

    for(int i=0;i<nums.length;i++){
      result[i]=treeMap.get(nums[i]);
    }

    return result;
  }


  @Test
  public void test1() {
    int[] nums = {8, 1, 2, 2,2, 3};
    System.out.println(smallerNumbersThanCurrent(nums));

  }

  @Test
  public void test2() {
    int[] nums = {};
    System.out.println(smallerNumbersThanCurrent(nums));

  }



}
