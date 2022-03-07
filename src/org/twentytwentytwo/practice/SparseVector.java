package org.twentytwentytwo.practice;

import java.util.Vector;

public class SparseVector {

  int[] nums;

  SparseVector(int[] nums) {
    this.nums = nums;
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    int product = 0;

    for (int i = 0; i < vec.nums.length; i++) {
      if (vec.nums[i] != 0) {
        product += vec.nums[i] * nums[i];
      }
    }

    return product;

  }

  public static void main(String[] args) {
    // Your SparseVector object will be instantiated and called as such:
    int[] nums1 = {0, 1, 0, 0, 2, 0, 0};
    int[] nums2 = {1, 0, 0, 0, 3, 0, 4};
    SparseVector v1 = new SparseVector(nums1);
    SparseVector v2 = new SparseVector(nums2);
    int ans = v1.dotProduct(v2);
    Vector<Integer> vector=new Vector<>();
  }
}
