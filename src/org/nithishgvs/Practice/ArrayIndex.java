package org.nithishgvs.Practice;

import java.util.ArrayList;
import java.util.List;

public class ArrayIndex {


  public static void main(String[] args) {
    int[] input = {5, 3, -3, -4, 0, 2, -1, 4, -7, 2};
    int[] output = new int[input.length];

    List<Integer> posIndexes = new ArrayList<>();
    List<Integer> negIndexes = new ArrayList<>();

    for (int i = 0; i < input.length; i++) {
      if (input[i] < 0) {
        negIndexes.add(i);
      } else {
        posIndexes.add(i);
      }
    }

    for (int i = 0; i < posIndexes.size(); i++) {
      output[i] = input[posIndexes.get(i)];
    }

    for (int i = 0; i < negIndexes.size(); i++) {
      output[posIndexes.size() + i] = input[negIndexes.get(i)];
    }

    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }
  }


}
