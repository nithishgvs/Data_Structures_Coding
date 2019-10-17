package org.leetcode.SearchingSorting;

import org.junit.Test;

public class MergeSort_Practice {


  public void mergeSort(int[] list) {
    if (list.length == 1) {
      return;
    }

    int midIndex = list.length / 2 + list.length % 2;

    int[] firstHalfList = new int[midIndex];
    int[] secondHalfList = new int[list.length - midIndex];

    //
    splitFunction(list, firstHalfList, secondHalfList);
    mergeSort(firstHalfList);
    mergeSort(secondHalfList);

    merge(list, firstHalfList, secondHalfList);
  }

  private void merge(int[] list, int[] firstHalfList, int[] secondHalfList) {
    int mergeIndex = 0;
    int firstHalfIndex = 0;
    int secondHalfIndex = 0;

    while (firstHalfIndex < firstHalfList.length && secondHalfIndex < secondHalfList.length) {

      //both even
      if (firstHalfList[firstHalfIndex] % 2 == 0 && secondHalfList[secondHalfIndex] % 2 == 0) {
        if (firstHalfList[firstHalfIndex] < secondHalfList[secondHalfIndex]) {
          list[mergeIndex] = firstHalfList[firstHalfIndex];
          firstHalfIndex++;
        } else if (secondHalfIndex < secondHalfList.length) {
          list[mergeIndex] = secondHalfList[secondHalfIndex];
          secondHalfIndex++;
        }
        mergeIndex++;
      }

      //both odd
      else if (firstHalfList[firstHalfIndex] % 2 == 1 && secondHalfList[secondHalfIndex] % 2 == 1) {
        if (firstHalfList[firstHalfIndex] < secondHalfList[secondHalfIndex]) {
          list[mergeIndex] = firstHalfList[firstHalfIndex];
          firstHalfIndex++;
        } else if (secondHalfIndex < secondHalfList.length) {
          list[mergeIndex] = secondHalfList[secondHalfIndex];
          secondHalfIndex++;
        }
        mergeIndex++;
      } else {
        //odd one even one
        //first half one is odd
        if (firstHalfList[firstHalfIndex] % 2 == 1 && secondHalfList[secondHalfIndex] % 2 == 0) {
          list[mergeIndex] = firstHalfList[firstHalfIndex];
          firstHalfIndex++;
        } else if (secondHalfIndex < secondHalfList.length) {
          list[mergeIndex] = secondHalfList[secondHalfIndex];
          secondHalfIndex++;
        }
        mergeIndex++;
      }
    }

    if (firstHalfIndex < firstHalfList.length) {
      while (mergeIndex < list.length) {
        list[mergeIndex++] = firstHalfList[firstHalfIndex++];
      }
    }
    if (secondHalfIndex < secondHalfList.length) {
      while (mergeIndex < list.length) {
        list[mergeIndex++] = secondHalfList[secondHalfIndex++];
      }
    }


  }

  private void splitFunction(int[] list, int[] firstHalfList, int[] secondHalfList) {
    int index = 0;

    int secondListIndex = firstHalfList.length;

    for (int i : list) {
      if (index < firstHalfList.length) {
        firstHalfList[index] = list[index];
      } else {
        secondHalfList[index - secondListIndex] = list[index];
      }
      index++;
    }

  }

  @Test
  public void test1() {
    int[] list = new int[]{3, 2, 6, 4, 5};
    mergeSort(list);
    for (int g : list) {
      System.out.println(g);
    }
  }

}
