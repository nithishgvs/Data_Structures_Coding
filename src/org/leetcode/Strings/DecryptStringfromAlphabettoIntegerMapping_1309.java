package org.leetcode.Strings;

public class DecryptStringfromAlphabettoIntegerMapping_1309 {

  public String freqAlphabets(String s) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      char transformed = '\0';
      if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        String temp = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
        int value = Integer.valueOf(temp) + 96;
        transformed = (char) value;
        i = i + 2;
      } else {
        int value = Character.getNumericValue(ch) + 96;
        transformed = (char) value;
      }
      stringBuilder.append(transformed);
    }

    return stringBuilder.toString();
  }

}
