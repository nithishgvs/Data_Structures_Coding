package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class LargestNumber_179 {

  public String largestNumber(int[] nums) {
    if (nums.length == 0) {
      return "";
    }

    StringBuilder output = new StringBuilder();

    List<char[]> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      list.add(String.valueOf(nums[i]).toCharArray());
    }

    Comparator<char[]> comparator = new Comparator<char[]>() {
      @Override
      public int compare(char[] lhs, char[] rhs) {

        if (Integer.valueOf(lhs[0]) > Integer.valueOf(rhs[0])) {
          return 1;
        } else if (Integer.valueOf(lhs[0]) < Integer.valueOf(rhs[0])) {
          return -1;
        } else if (Integer.valueOf(rhs[0]) == Integer.valueOf(lhs[0])) {
          if (Double.valueOf(String.valueOf(lhs) + String.valueOf(rhs)) > Double
              .valueOf(String.valueOf(rhs) + String.valueOf(lhs))) {
            return 1;
          } else {
            return -1;
          }
        }
        return 0;
      }
    };

    Collections.sort(list, comparator);

    for (int i = list.size() - 1; i > -1; i--) {
      output.append(list.get(i));
    }

    if (output.toString().matches("[0]+")) {
      return "0";
    }
    return output.toString();

  }


  @Test
  public void test() {
    int[] nums = {3, 30, 34, 5, 9};
    System.out.println(largestNumber(nums));
  }


  @Test
  public void test2() {
    int[] nums = { 10,2};
    System.out.println(largestNumber(nums));
  }

  @Test
  public void test3() {
    int[] nums = {999999998, 999999997, 999999999};
    System.out.println(largestNumber(nums));
  }


  @Test
  public void test4() {
    int[] nums = {0, 0};
    System.out.println(largestNumber(nums));
  }

  @Test
  public void test5() {
    int[] nums = {2, 3, 4, 5};

    List<Integer> list= Arrays.asList(2,3,4,5);

    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer lhs, Integer rhs) {
        if (rhs < lhs) {
          return 1;
        } else if (rhs > lhs) {
          return -1;
        } else {
          return 0;
        }
      }};

    Collections.sort(list,comparator);
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }
}
