package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FindAllNumbersDisappearedInAnArray_448 {


  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> outputList = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[Math.abs(nums[i]) - 1] > 0) {
        nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
      }
    }

    for(int i=0;i<nums.length;i++){
      if(nums[i]>0){
        outputList.add(i+1);
      }
    }


    return outputList;
  }

  @Test
  public void testDuplicates() {
    int[] array = {4, 3, 2, 7, 1, 2, 3, 1};
    //4,3,2,7,8,2,3,1
    findDisappearedNumbers(array);
  }

  @Test
  public void testDuplicates2() {
    int[] array = {1,1,2,4};
    //4,3,2,7,8,2,3,1
    findDisappearedNumbers(array);
  }

}
