package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LetterCombinationsofaPhoneNumberClone_17 {


  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    backTrackingHelper(digits.toCharArray(), map, result, "", 0);

    return result;

  }

  private void backTrackingHelper(char[] digits, Map<Character, String> map, List<String> result,
      String currentCombo, int index) {
    if (digits.length == 0) {
      return;
    }
    if (currentCombo.length() == digits.length) {
      result.add(currentCombo);
      return;
    }
    String value = map.get(digits[index]);

    for (int i = 0; i < value.length(); i++) {
      currentCombo += value.charAt(i);
      backTrackingHelper(digits, map, result, currentCombo, index + 1);
      currentCombo = currentCombo.substring(0, currentCombo.length() - 1);
    }

  }

  @Test
  public void test1() {
    letterCombinations("").forEach(k -> System.out.println(k));
  }

}
