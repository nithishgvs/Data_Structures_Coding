package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

  public List<List<String>> partition(String s) {
    List<List<String>> decompositions = new ArrayList();

    decomposeString(0, s, new ArrayList<>(), decompositions);

    return decompositions;
  }

  private void decomposeString(int workingIndex, String s, ArrayList<String> palindromes,
      List<List<String>> decompositions) {
    if (workingIndex == s.length()) {
      decompositions.add(new ArrayList<>(palindromes));
      return;
    }

    for (int i = workingIndex; i < s.length(); i++) {
      if (isPalindrome(workingIndex, i, s)) {
        palindromes.add(s.substring(workingIndex, i + 1));
        decomposeString(i + 1, s, palindromes, decompositions);
        palindromes.remove(palindromes.size() - 1);
      }

    }

  }

  private boolean isPalindrome(int l, int h, String s) {

    while (l < h) {
      if (s.charAt(l) == s.charAt(h)) {
        l++;
        h--;
      } else {
        return false;
      }
    }

    return true;
  }

}
