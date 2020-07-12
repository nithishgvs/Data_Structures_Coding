package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ShortestWordDistanceII_244
public class WordDistance {

  Map<String, List<Integer>> map = new HashMap<>();

  public WordDistance(String[] words) {
    for (int i = 0; i < words.length; i++) {
      List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
      list.add(i);
      map.put(words[i], list);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> list1 = map.get(word1);
    List<Integer> list2 = map.get(word2);
    int distance = Integer.MAX_VALUE;
    for (Integer list1Value : list1) {
      for (Integer list2Value : list2) {
        distance = Math.min(distance, Math.abs(list2Value - list1Value));
      }
    }
    return distance;
  }


  public static void main(String[] args) {
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    WordDistance wordDistance = new WordDistance(words);
    System.out.println(wordDistance.shortest("makes", "coding"));
  }
}
