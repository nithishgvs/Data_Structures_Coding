package org.leetcode.Hashing;

import java.util.TreeSet;
import org.junit.Test;

public class ShortestDistancetoaCharacter_821 {


  /**
   * floor​(E e): This method returns the greatest element in this set less than or equal to the
   * given element, or null if there is no such element. ceiling​(E e): This method returns the
   * least element in this set greater than or equal to the given element, or null if there is no
   * such element.
   */

  public int[] shortestToChar(String S, char C) {
    int[] array = new int[S.length()];

    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < S.length(); i++) {

      char ch = S.charAt(i);

      if (ch == C) {
        set.add(i);
        array[i] = 0;

      }

    }

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      if (ch != C) {
        Integer ceiling = set.ceiling(i);
        Integer floor = set.floor(i);

        if (ceiling == null) {
          ceiling = Integer.MAX_VALUE;
        }

        if (floor == null) {
          floor = Integer.MAX_VALUE;
        }

        array[i] = Math.min(Math.abs(ceiling - i), Math.abs(floor - i));


      }

    }

    return array;
  }


  @Test
  public void test() {
    shortestToChar("leetcode", 'e');
  }


}
