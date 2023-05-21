package org.practice.io.SlidingWindow;

import org.junit.Test;

public class PermutationInString_567 {

  /**
   * https://www.youtube.com/watch?v=1hPOaLDW-d4
   */

  public boolean checkInclusion(String s1, String s2) {

    int[] s1Arr = new int[26];
    int[] s2Arr = new int[26];

    populates1Arr(s1, s1Arr);

    for (int i = 0; i < s2.length(); i++) {
      if (i < s1.length() - 1) {
        s2Arr[s2.charAt(i) - 'a']++;
      } else {
        s2Arr[s2.charAt(i) - 'a']++;
        if (matchFound(s1Arr, s2Arr)) {
          return true;
        } else {
          s2Arr[s2.charAt(i - s1.length() + 1) - 'a']--;
        }
      }
    }

    return false;

  }

  private boolean matchFound(int[] s1Arr, int[] s2Arr) {
    for (int i = 0; i < 26; i++) {
      if (s1Arr[i] != s2Arr[i]) {
        return false;
      }
    }
    return true;
  }

  private void populates1Arr(String s1, int[] s1Arr) {
    for (int i = 0; i < s1.length(); i++) {
      s1Arr[s1.charAt(i) - 'a']++;
    }
  }


  @Test
  public void test1() {
    System.out.println(checkInclusion("adc", "dcda"));
    System.out.println(checkInclusion("ab", "eidboaoo"));
    System.out.println(checkInclusion("ab", "eidbaooo"));
    System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
  }

}
