package org.leetcode.Strings;

import org.junit.Test;

public class ReverseOnlyLetters_917 {

  public String reverseOnlyLetters(String S) {

    if (S == null || S.length() == 0 || S.length() == 1) {
      return S;
    }

    int l = 0;
    int h = S.length() - 1;

    while (l <= h) {
      if (!Character.isLetter(S.charAt(l))) {
        l++;
        continue;
      }

      if (!Character.isLetter(S.charAt(h))) {
        h--;
        continue;
      }

      char x = S.charAt(l);
      char[] arr = S.toCharArray();
      arr[l] = S.charAt(h);
      arr[h] = x;
      S = String.valueOf(arr);
      l++;
      h--;

    }

    return S;

  }


  @Test
  public void test1() {
    //System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }

}
