package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class UncommonWordsTwoSentences_884 {


  public String[] uncommonFromSentences(String A, String B) {
    Map<String, Integer> uncommonMap = new HashMap<>();
    String[] array = A.split("\\s");

    for (String val : array) {
      if (!uncommonMap.containsKey(val)) {
        uncommonMap.put(val, 1);
      } else {
        uncommonMap.put(val, uncommonMap.get(val) + 1);
      }
    }

    array = B.split("\\s");

    for (String val : array) {
      if (!uncommonMap.containsKey(val)) {
        uncommonMap.put(val, 1);
      } else {
        uncommonMap.put(val, uncommonMap.get(val) + 1);
      }
    }

    return uncommonMap.entrySet().stream().filter(val -> val.getValue() == 1).map(val->val.getKey())
        .collect(Collectors.toList()).stream().toArray(String[]::new);
  }


  @Test
  public void testUncommonWords() {
    String A = "abcd def abcd xyz", B = "ijk def ijk";
    String[] array = uncommonFromSentences(A, B);
    System.out.println(array.length);
  }

  @Test
  public void testUncommonWords2() {
    String A = "this apple is sweet", B = "this apple is sour";
    String[] array = uncommonFromSentences(A, B);
    System.out.println(array.length);
  }

  @Test
  public void testUncommonWords3() {
    String A = "s z z z s", B = "s z ejt";
    String[] array = uncommonFromSentences(A, B);
    System.out.println(array.length);
  }

}
