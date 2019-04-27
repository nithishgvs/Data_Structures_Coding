package org.techiedelight.String;


import org.junit.Test;

/**
 * //https://www.techiedelight.com/check-given-string-rotated-palindrome-not/
 */
public class StringRotatedPalindrome {


  private boolean isPalindrome(String string) {
    if (new StringBuilder(string).reverse().toString().equals(string)) {
      return true;
    }
    return false;
  }


  public boolean isRotatedPalindrome(String string) {

    for (int i = 0; i < string.length(); i++) {
      if (isPalindrome(string)) {
        return true;
      }
      string = string.substring(1, string.length()) + string.charAt(0);
    }

    return false;
  }


  @Test
  public void testIsRotatedPalindrome() {
    System.out.println(isRotatedPalindrome("CBAABCD"));
  }

}
