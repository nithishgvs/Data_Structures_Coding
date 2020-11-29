package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class LexicographicalNumbers_386 {


  public List<Integer> lexicalOrder(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      list.add(i);
    }
    Collections.sort(list, Comparator.comparing(String::valueOf));
    return list;
  }

  @Test
  public void test() {
    System.out.println(lexicalOrder(13));
  }
}
