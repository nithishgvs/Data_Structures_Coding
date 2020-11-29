package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class RearrangeWordsInASentence_1451 {

  public String arrangeWords(String text) {
    StringBuffer stringBuffer = new StringBuffer();
    Map<Integer, List<String>> map = new TreeMap<>();
    for (String values : text.trim().split("\\s+")) {
      List<String> list = map.getOrDefault(values.length(), new ArrayList<>());
      list.add(values.toLowerCase());
      map.put(values.length(), list);
    }

    List<Integer> list = new ArrayList<>(map.keySet());
    Collections.sort(list);

    for (Integer values : list) {
      List<String> treeValues = map.get(values);
      treeValues.forEach(treeValue -> {
        if (stringBuffer.length() == 0) {
          char[] arr = treeValue.toCharArray();
          char ch = arr[0];
          stringBuffer.append(String.valueOf(ch).toUpperCase());
          if (treeValue.length() > 1) {
            stringBuffer.append(treeValue.substring(1));
          }
        } else {
          stringBuffer.append(treeValue);
        }
        stringBuffer.append(" ");
      });

    }
    return stringBuffer.toString().trim();
  }


  @Test
  public void test1() {
    System.out.println(arrangeWords("Leetcode is cool a"));
  }

}
