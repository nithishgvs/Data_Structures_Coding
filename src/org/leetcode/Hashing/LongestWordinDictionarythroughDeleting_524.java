package org.leetcode.Hashing;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LongestWordinDictionarythroughDeleting_524 {


  public String findLongestWord(String s, List<String> d) {
    String longestWord = "";


    for (String value : d) {
      if (isSubSequenceFound(value, s)) {
        if (longestWord.length() > 0) {
          if (longestWord.length() == value.length()) {
            longestWord = longestWord.compareTo(value) > 0 ? value : longestWord;
          } else {
            longestWord = value.length() > longestWord.length() ? value : longestWord;
          }
        } else {
          longestWord = value;
        }
      }
    }

    return longestWord;


  }


  public static boolean isSubSequenceFound(String str1, String str2){
    int j = 0;
    for(int i = 0; i < str2.length(); i++){
      // If char found move to next char
      if(str1.charAt(j) == str2.charAt(i)){
        ++j;
      }
      // Equal means all the characters of str1 are
      // found in str2 in order
      if(j == str1.length()){
        return true;
      }
    }
    return false;
  }


  @Test
  public void test100() {
    System.out.println(isSubSequenceFound("apple","abpcplea"));
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
