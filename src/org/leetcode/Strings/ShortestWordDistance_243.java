package org.leetcode.Strings;

import org.junit.Test;

public class ShortestWordDistance_243 {

  public int shortestDistance(String[] words, String word1, String word2) {
    int distance = Integer.MAX_VALUE;
    int word1Index = -1;
    int word2Index = -1;

    for (int i = 0; i < words.length; i++) {
      String word = words[i];

      if (word.equals(word1)) {
        if (word2Index != -1) {
          distance = Math.min(distance, Math.abs(word2Index - i));
        }
        word1Index = i;
      } else if (word.equals(word2)) {
        if (word1Index != -1) {
          distance = Math.min(distance, Math.abs(word1Index - i));
        }
        word2Index = i;
      }

    }

    return distance;

  }

  @Test
  public void test1() {
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    System.out.println(shortestDistance(words, "makes", "coding"));

  }

}
