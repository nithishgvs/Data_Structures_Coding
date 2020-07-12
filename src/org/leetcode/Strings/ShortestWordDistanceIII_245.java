package org.leetcode.Strings;

import org.junit.Test;

public class ShortestWordDistanceIII_245 {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    int distance = Integer.MAX_VALUE;
    int word1Index = -1;
    int word2Index = -1;
    boolean flag = false;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];

      if (word.equals(word1) && word1.equals(word2)) {
        if (word1Index == -1 || !flag) {
          word1Index = i;
          flag = !flag;
        } else if (word2Index == -1 || flag) {
          word2Index = i;
          flag = !flag;
        }
      } else {
        if (word.equals(word1)) {
          word1Index = i;

        }
        if (word.equals(word2)) {
          word2Index = i;
        }
      }

      if (word2Index != -1 && word1Index != -1) {
        distance = Math.min(distance, Math.abs(word2Index - word1Index));
      }

    }

    return distance;
  }

  @Test
  public void test1() {
    String[] words = {"practice", "makes", "perfect", "coding", "makes","makes"};
    System.out.println(shortestWordDistance(words, "makes", "makes"));

  }

}
