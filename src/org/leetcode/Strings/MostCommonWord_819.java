package org.leetcode.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class MostCommonWord_819 {

  public String mostCommonWord2(String paragraph, String[] banned) {

    paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-z\\s+]", " ");
    String[] arr = paragraph.split("\\s+");
    List<String> bannedList = Arrays.asList(banned);
    Map<String, Integer> map = new HashMap<>();

    int max = 0;
    String word = "";

    for (String a : arr) {
      if (!bannedList.contains(a)) {
        if (!map.containsKey(a)) {
          map.put(a, 0);
        }

        int temp = map.get(a) + 1;
        if (max < temp) {
          max = temp;
          word = a;
        }

        map.put(a, temp);

      }
    }

//    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
//    Collections.sort(list, (v1, v2) -> v2.getValue() - v1.getValue());
    return word;

  }


  public String mostCommonWord1(String paragraph, String[] banned) {
    String array = paragraph.toLowerCase().replaceAll("[^a-zA-Z\\s+]", " ");
    String[] splitStr = array.split("\\s+");
    HashMap<String, Integer> countMap = new HashMap<>();
    List<String> bannedList = Arrays.asList(banned);
    for (int i = 0; i < splitStr.length; i++) {
      if (!bannedList.contains(splitStr[i])) {
        if (countMap.containsKey(splitStr[i])) {
          countMap.put(splitStr[i], countMap.get(splitStr[i]) + 1);
        } else {
          countMap.put(splitStr[i], 1);
        }
      }
    }

    PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    priorityQueue.addAll(countMap.entrySet());

    return priorityQueue.peek().getKey();
  }

  public String mostCommonWord(String paragraph, String[] banned) {
    String output = null;
    String array = paragraph.toLowerCase().replaceAll("[^a-z\\s+]", "");
    String[] splitStr = array.split("\\s+");
    HashMap<String, Integer> countMap = new HashMap<>();
    HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

    for (int i = 0; i < splitStr.length; i++) {
      if (!bannedSet.contains(splitStr[i])) {
        if (countMap.containsKey(splitStr[i])) {
          countMap.put(splitStr[i], countMap.get(splitStr[i]) + 1);
        } else {
          countMap.put(splitStr[i], 1);
        }
      }
    }
    output = Collections
        .max(countMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
        .getKey();
    return output;
  }

  @Test
  public void testMostCommonWord() {
    String paragraph = "Bob! hit a ball, the hit BALL flew far after it was hit.";
    String[] bannedwords = new String[]{"hit"};
    System.out.println(mostCommonWord(paragraph, bannedwords));
    System.out.println(mostCommonWord1(paragraph, bannedwords));
  }

  @Test
  public void testMostCommonWord2() {
    String paragraph = "a, a, a, a, b,b,b,c, c";
    String[] bannedwords = new String[]{"a"};
    System.out.println(mostCommonWord(paragraph, bannedwords));
    System.out.println(mostCommonWord1(paragraph, bannedwords));
  }

}
