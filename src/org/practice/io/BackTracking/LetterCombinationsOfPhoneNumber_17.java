package org.practice.io.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LetterCombinationsOfPhoneNumber_17 {

  Map<String, String> phoneMap = Map
      .of("2", "abc", "3", "def", "4", "ghi", "5", "jkl", "6", "mno", "7", "pqrs", "8", "tuv", "9",
          "wxyz");

  public List<String> letterCombinations(String digits) {

    List<String> allCombinations = new ArrayList<>();
    if (digits.length() == 0) {
      return allCombinations;
    }

    generateAllLetterCombinations(0, digits, "", allCombinations);
    return allCombinations;
  }

  private void generateAllLetterCombinations(int index, String digits, String currentCombination,
      List<String> allCombinations) {
    if (currentCombination.length() == digits.length()) {
      allCombinations.add(currentCombination);
      return;
    }

    String currentValue = phoneMap.get(String.valueOf(digits.charAt(index)));

    for (int i = 0; i < currentValue.length(); i++) {
      char character = currentValue.charAt(i);
        currentCombination += character;
        generateAllLetterCombinations(++index, digits, currentCombination, allCombinations);
        currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
        index = index - 1;
      }
  }

  @Test
  public void test() {
    letterCombinations("22");
  }

}
