package org.nithishgvs.Practice;

import java.util.Random;

public class QuickSelect {


  private int[] nums;

  public QuickSelect(int[] nums) {
    this.nums = nums;
  }

  public QuickSelect() {

  }


  public int select(int k) {
    //k-1 because of array indices adjustment
    return select(0, nums.length - 1, k - 1);
  }

  private int select(int firstIndex, int lastIndex, int k) {

    int pivot = partition(firstIndex, lastIndex);

    if (pivot > k) {
      return select(firstIndex, pivot - 1, k);
    } else if (pivot < k) {
      return select(pivot + 1, lastIndex, k);
    }

    return nums[k];
  }

  private int partition(int firstIndex, int lastIndex) {

    int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
    //pivot value moved to the lastIndex position
    swap(lastIndex, pivot);

    for (int i = firstIndex; i < lastIndex; i++) {
      //nums[lastIndex] has the pivot
      if (nums[i] > nums[lastIndex]) {
        swap(i, firstIndex);
        firstIndex++;
      }
    }
    //pivot at lastindex moved to the actual position
    swap(firstIndex, lastIndex);

    return firstIndex;
  }

  private void swap(int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  public static void main(String[] args) {
    int nums[] = {1, -2, 5, 8, 7, 6};
    QuickSelect quickSelect = new QuickSelect(nums);
    System.out.println(quickSelect.select(2));
  }


}
