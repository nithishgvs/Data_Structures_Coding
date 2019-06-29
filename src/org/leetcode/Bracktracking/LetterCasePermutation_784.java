package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Note: ascii lowercase 97 to 122 upper case 65 to 90 (-32 from lower gives upper)
 */
public class LetterCasePermutation_784 {

  List<String> list = new ArrayList<>();

  public List<String> letterCasePermutation(String S) {
    S = S.toLowerCase();
    if (S.length() == 1) {
      if (S.charAt(0) >= 'a' && S.charAt(0) <= 'z') {
        list.add(S);
        list.add(S.toUpperCase());
        return list;
      } else {
        list.add(S);
        return list;
      }
    }
    permutationHelper(S.toCharArray(), 0, S.length());
    return list;
  }

  private void permutationHelper(char[] charArray, int i, int length) {
    if (i == length) {
      list.add(new String(charArray));
    }

    if (i < length) {
      if (charArray[i] >= 'a' && charArray[i] <= 'z') {
        //Convert to uppercase
        charArray[i] = Character.toUpperCase(charArray[i]);
        permutationHelper(charArray, i + 1, length);
        //Convert to lowercase
        charArray[i] = Character.toLowerCase(charArray[i]);
      } else {
        permutationHelper(charArray, i + 1, length);
      }
    }

  }

  @Test
  public void test1() {
    char x = 'a';
    System.out.println(Character.toString((char) (x + 32)));
    System.out.println(Character.toString((char) (x - 32)));
    //letterCasePermutation("a1b2").forEach(k -> System.out.println(k));
    letterCasePermutation("").forEach(k -> System.out.println(k));
  }
}
