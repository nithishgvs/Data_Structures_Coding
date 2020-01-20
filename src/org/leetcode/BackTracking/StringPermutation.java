package org.leetcode.BackTracking;

import org.junit.Test;

public class StringPermutation {


  public void stringPermute(int l, int h, String string) {
    if (l == h) {
      System.out.println(string);
    }
    for (int i = l; i <= h; i++) {
      System.out.println(i + "   " + l);
      string = swap(string, i, l);
      stringPermute(l + 1, h, string);
      string = swap(string, i, l);
    }
  }




  private String swap(String string, int i, int j) {
    char[] arr = string.toCharArray();
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return String.valueOf(arr);
  }

  @Test
  public void test() {
    stringPermute(0, 2, "abc");
  }



}
