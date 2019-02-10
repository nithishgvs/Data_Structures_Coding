package org.leetcode.Strings;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ReverseVowelsString_345 {

  public String reverseVowels(String s) {

    if (s.length() < 2) {
      return s;
    }

    List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    char[] vowelArray = s.toCharArray();
    int p1 = 0, p2 = s.length() - 1;
    boolean p1Stop = false, p2Stop = false;

    while (p1 < p2) {
      if (vowelList.contains(vowelArray[p1]) && !p1Stop) {
        p1Stop = true;
      } else {
        if (!p1Stop) {
          p1++;
        }
      }
      if (vowelList.contains(vowelArray[p2]) && !p2Stop) {
        p2Stop = true;
      } else {
        if (!p2Stop) {
          p2--;
        }
      }
      if (p1Stop && p2Stop) {
        char temp = vowelArray[p1];
        vowelArray[p1] = vowelArray[p2];
        vowelArray[p2] = temp;
        p1Stop = false;
        p2Stop = false;
        p1++;
        p2--;
      }
    }

    return String.valueOf(vowelArray);
  }


  @Test
  public void testReverseVowels() {
    System.out.println(reverseVowels("hello"));
    System.out.println(reverseVowels("bcadf"));
    System.out.println(reverseVowels("leetcode"));
    System.out.println(reverseVowels("aA"));
  }

}
