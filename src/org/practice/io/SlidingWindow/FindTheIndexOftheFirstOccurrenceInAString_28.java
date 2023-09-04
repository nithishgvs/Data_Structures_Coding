package org.practice.io.SlidingWindow;

import org.junit.Test;

public class FindTheIndexOftheFirstOccurrenceInAString_28 {

  public int strStr2(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  public int strStr(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }
    int startIndexSecond = 0;
    int resultIndex = -1;
    int endIndex = 0;

    boolean matchFound = false;

    while (endIndex < haystack.length()) {
      if (haystack.charAt(endIndex) == needle.charAt(startIndexSecond)) {
        ++startIndexSecond;
        if (!matchFound) {
          matchFound = true;
          resultIndex = endIndex;
        }
        if (startIndexSecond == needle.length()) {
          break;
        }
      } else if (matchFound) {
        matchFound = false;
        endIndex = endIndex - startIndexSecond + 1;
        resultIndex = -1;
        startIndexSecond = 0;
        continue;
      }

      endIndex++;

    }

    return startIndexSecond == needle.length() ? resultIndex : -1;
  }

  @Test
  public void test() {
    System.out.println(strStr("mississippi", "issip"));
  }

}
