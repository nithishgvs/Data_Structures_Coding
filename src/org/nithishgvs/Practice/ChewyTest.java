package org.nithishgvs.Practice;

public class ChewyTest {


  public String shiftingLetters(String s, int[] shifts) {

    char[] charArray = s.toCharArray();

    for (int i = 0; i < shifts.length; i++) {
      int currShift = shifts[i];

      for (int j = 0; j < currShift; j++) {
        if (charArray[j] == 'z') {
          charArray[j] = 'a';
        } else {
          charArray[j] = (char) ((int) charArray[j] + 1);
        }

      }

    }

    return String.valueOf(charArray);
  }


  public static void main(String[] args) {
    ChewyTest chewyTest = new ChewyTest();
    System.out.println(chewyTest.shiftingLetters("aez", new int[]{1, 1, 3}));
  }
}
