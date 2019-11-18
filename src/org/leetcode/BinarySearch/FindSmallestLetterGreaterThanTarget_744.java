package org.leetcode.BinarySearch;

import org.junit.Test;

public class FindSmallestLetterGreaterThanTarget_744 {


  public char nextGreatestLetter(char[] letters, char target) {

    int l = 0;
    int h = letters.length - 1;

    int finalIndex = -1;

    while (l < h) {
      int mid = l + (h - l) / 2;

      if (target < letters[l]) {
        finalIndex = l;
        break;
      } else if (target > letters[h]) {
        finalIndex = h + 1;
        break;
      }

      if (target >= letters[mid]) {
        l = mid + 1;
      } else if (target <= letters[mid]) {
        h = mid - 1;
      }
    }

    if (finalIndex == -1) {
      if (letters[l] <= target) {
        finalIndex = l + 1;
      } else if (letters[h] > target) {
        finalIndex = h;
      }
    }

    finalIndex = finalIndex >= letters.length ? 0 : finalIndex;
    return letters[finalIndex];

  }


  @Test
  public void test() {
    char[] letters = new char[]{'c', 'f', 'j'};
    System.out.println(nextGreatestLetter(letters, 'c'));
  }

  @Test
  public void test1() {
    char[] letters = new char[]{'c', 'f', 'j'};
    System.out.println(nextGreatestLetter(letters, 'd'));
  }

  @Test
  public void test2() {
    char[] letters = new char[]{'c', 'f', 'j'};
    System.out.println(nextGreatestLetter(letters, 'a'));
  }

}
