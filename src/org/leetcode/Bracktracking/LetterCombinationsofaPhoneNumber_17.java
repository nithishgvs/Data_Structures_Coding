package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LetterCombinationsofaPhoneNumber_17 {


  List<String> list = new ArrayList<>();


  public List<String> letterCombinations(String digits) {

    Map<String, String> map = new HashMap<>();
    map.put("2", "abc");
    map.put("3", "def");
    map.put("4", "ghi");
    map.put("5", "jkl");
    map.put("6", "mno");
    map.put("7", "pqrs");
    map.put("8", "tuv");
    map.put("9", "wxyz");
    letterCombinationsHelper(digits.toCharArray(), 0, map, digits.length(), "");
    return list;
  }

  private void letterCombinationsHelper(char[] digits, int index, Map<String, String> map,
      int length,
      String result) {

    if(digits.length==0){
      return;
    }

    if (result.length() == length) {
      list.add(result);
      return;
    }


    String value = map.get(String.valueOf(digits[index]));

    for (int i = 0; i < value.length(); i++) {
      result = result + value.charAt(i);
      letterCombinationsHelper(digits, index + 1, map, length, result);
      result = result.substring(0, result.length() - 1);
    }


  }


  @Test
  public void test1() {
    letterCombinations("234").forEach(k -> System.out.println(k));
  }

}
