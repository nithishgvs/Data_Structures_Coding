package org.twentytwentytwo.practice;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class WordBreak_139 {


  public boolean wordBreak(String s, List<String> wordDict) {

    boolean[] possible = new boolean[s.length() + 1];

    possible[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (possible[j] && wordDict.contains(s.substring(j, i))) {
          possible[i] = true;
          break;
        }
      }
    }

    return possible[s.length()];

  }

  @Test
  public void test() {
    List<String> wordDict = Arrays.asList("ap", "pl", "e");
    System.out.println(wordBreak("apple", wordDict));
  }

}
