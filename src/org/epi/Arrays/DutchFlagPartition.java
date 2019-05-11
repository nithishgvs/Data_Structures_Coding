package org.epi.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class DutchFlagPartition {


  public enum Color {
    RED,
    WHITE,
    BLUE
  }

  public void dutchFlagPartition1(int pivotIndex, List<Color> array) {
    Color pivot = array.get(pivotIndex);
    //First pass: group elements smaller than pivot
    for (int i = 0; i < array.size(); ++i) {
      //Look for a smaller element
      for (int j = i + 1; j < array.size(); ++j) {
        if (array.get(j).ordinal() < pivot.ordinal()) {
          Collections.swap(array, i, j);
          break;
        }
      }
    }

    //Second pass: group elements larger than pivot
    for (int i = array.size() - 1; i >= 0 && array.get(i).ordinal() >= pivot.ordinal(); --i) {
      //Look for larger element .Stop when we reach an element less than pivot,since the first pass has moved them to the start of array

      for (int j = i - 1; j >= 0 && array.get(j).ordinal() >= pivot.ordinal(); --j) {
        if (array.get(j).ordinal() > pivot.ordinal()) {
          Collections.swap(array, i, j);
          break;
        }
      }
    }

  }

  public void dutchFlagPartition2(int pivotIndex, List<Color> array) {
    Color pivot = array.get(pivotIndex);
    int smaller = 0;
    //First pass group elements smaller than pivot
    for (int i = 0; i < array.size(); ++i) {
      if (array.get(i).ordinal() < pivot.ordinal()) {
        Collections.swap(array, smaller++, i);
      }
    }

    //Second pass: group elements larger than pivot

    int larger = array.size() - 1;

    for (int i = array.size() - 1; i >= 0 && array.get(i).ordinal() >= pivot.ordinal(); --i) {
      if (array.get(i).ordinal() > pivot.ordinal()) {
        Collections.swap(array, larger--, i);
      }
    }
  }


  @Test
  public void testDutchFlag1() {
    List<Color> array = Arrays
        .asList(Color.BLUE, Color.BLUE, Color.WHITE, Color.WHITE, Color.RED, Color.RED);
    dutchFlagPartition1(array.size() / 2, array);
  }

  @Test
  public void testDutchFlag2() {
    List<Color> array = Arrays
        .asList(Color.BLUE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.WHITE);
    dutchFlagPartition2(array.size() / 2, array);
  }

}
