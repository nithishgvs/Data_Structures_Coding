package org.epi.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class DutchFlagNumbers {

  public void sortColorsTwoLoops(int[] nums) {

    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int smallest = 0;
    int pivot = nums[nums.length / 2];
    //First pass group elements smaller than pivot
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) < pivot) {
        Collections.swap(list, smallest++, i);
      }
    }
    //Second pass greater than pivot to the right
    int largest = nums.length - 1;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i) > pivot) {
        Collections.swap(list, largest--, i);
      }
    }
    nums = list.stream().mapToInt(i -> i).toArray();
    System.out.println(Arrays.toString(nums));
  }


  public void sortColorsOneLoop(int[] nums) {

  }

  @Test
  public void testSortColors1() {
    int[] nums = {2, 0, 2, 1, 1, 0};
    sortColorsOneLoop(nums);
  }

  @Test
  public void testSortColors2() {
    int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    sortColorsTwoLoops(nums);
  }

}
