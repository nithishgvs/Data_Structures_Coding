package org.leetcode.Hashing;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LongestWordinDictionarythroughDeleting_524 {


  public String findLongestWord(String s, List<String> d) {
    String longestWord = "";
    char[] arrSource = s.toCharArray();
    Arrays.sort(arrSource);

    for (String str : d) {
      String sTemp = new String(arrSource);
      char[] arrSource2 = str.toCharArray();
      Arrays.sort(arrSource2);
      String temp = new String(arrSource2);

      int prevIndex = -1;
      boolean flag = false;
      for (char c : temp.toCharArray()) {
        if (!sTemp.contains(String.valueOf(c))) {
          flag = true;
          break;
        } else {
          if (prevIndex > sTemp.indexOf(c)) {
            flag = true;
            break;
          } else {
            prevIndex = sTemp.indexOf(c);
            sTemp = sTemp.replaceFirst(String.valueOf(c), "");
          }
        }
      }
      if (!flag) {
        if (str.length() > longestWord.length()) {
          longestWord = str;
        } else if (str.length() == longestWord.length()) {
          longestWord = longestWord.compareTo(str) > 0 ? str : longestWord;
        }
      }
    }

    return longestWord;


  }


  @Test
  public void test1() {
    System.out
        .println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
  }


  @Test
  public void test2() {
    System.out
        .println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
  }

  @Test
  public void test3() {
    System.out
        .println(findLongestWord("aewfafwafjlwajflwajflwafj",
            Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));
  }
}
