package org.leetcode.Strings;

import org.junit.Test;

public class MergeStringsAlternately_1768 {

  public String mergeAlternately(String word1, String word2) {

    StringBuilder result = new StringBuilder();
    int index = 0;

    while (index < word1.length() || index < word2.length()) {
      if (index == word1.length()) {
        result.append(word2.substring(index));
        break;
      }
      if (index == word2.length()) {
        result.append(word1.substring(index));
        break;
      }
      result.append(word1.charAt(index));
      result.append(word2.charAt(index));
      index++;
    }

    return result.toString();

  }

  @Test
  public void test1(){
    //System.out.println(mergeAlternately("abc","pqr"));
    System.out.println(mergeAlternately("ab","pqrs"));
  }

}
