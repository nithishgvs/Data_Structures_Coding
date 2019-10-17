package org.leetcode.SearchingSorting;

import org.junit.Test;

public class QuickSort_Practice {


  public int partition(int[] list, int low, int high) {
    int l = low;
    int h = high;

    int pivot = list[low];

    while (l < h) {
      while (list[l] <= pivot && l < h) {
        l++;
      }
      while (list[h] > pivot) {
        h--;
      }
      if (l < h) {
        swap(list, l, h);
      }
    }
    swap(list, low, h);

    return h;
  }

  private void swap(int[] list, int l, int h) {

    int t = list[l];
    list[l] = list[h];
    list[h] = t;
  }

  private void quickSort(int[] list, int low, int high) {
    if (low >= high) {
      return;
    }

    int pivot = partition(list, low, high);
    quickSort(list, low, pivot - 1);
    quickSort(list, pivot + 1, high);

  }


  @Test
  public void test1() {
    int[] list = {6, 1, 2, 4, 7, 5};
    quickSort(list, 0, list.length - 1);
  }


}
