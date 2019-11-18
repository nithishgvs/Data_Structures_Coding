package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SmallestStringWithSwaps_1202 {

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

    String out = "";

    List<String> list=new ArrayList<>();
    for (int i = 0; i < pairs.size(); i++) {
      s = swap(s, pairs.get(i).get(0), pairs.get(i).get(1));
      list.add(s);
    }

    return out;

  }

  private String swap(String s, Integer index1, Integer index2) {
    char[] arr = s.toCharArray();
    char temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
    return String.valueOf(arr);

  }

  @Test
  public void test1(){

    System.out.println();
  }

}
