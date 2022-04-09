package org.nithishgvs.Practice;

public class TestPrac {


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

  public static class InnerclassTest {

    public static String temp;
  }

  public static class InnerclassTest2 {

    public static String temp;
  }


  public static void main(String[] args) {
    TestPrac testPrac = new TestPrac();
    TestPrac.InnerclassTest innerclassTest = new InnerclassTest();
    TestPrac.InnerclassTest2 innerclassTest2 = new InnerclassTest2();
    System.out.println(testPrac.shiftingLetters("aez", new int[]{1, 1, 3}));
  }
}
