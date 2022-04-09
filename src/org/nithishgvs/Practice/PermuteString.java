package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PermuteString {


  public static List<String> permute(String string) {
    final List<String> result = new ArrayList<>();

    permuteHelper(new StringBuilder(), string, result);

    return result;
  }

  private static void permuteHelper(StringBuilder stringBuilder, String string,
      List<String> result) {

    if (stringBuilder.length() == string.length()) {
      result.add(stringBuilder.toString());
      return;
    }

    for (int i = 0; i < string.length(); i++) {
      if (stringBuilder.toString().indexOf(string.charAt(i)) == -1) {
        stringBuilder.append(string.charAt(i));
        permuteHelper(stringBuilder, string, result);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      }
    }
  }

  @Test
  public void test() {
    System.out.println(permute("ABC"));
  }

}
