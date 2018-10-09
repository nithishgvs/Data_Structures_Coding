package org.leetcode.Heaps;

import java.util.PriorityQueue;

public class KthLargest {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
	}

	public int add(int val) {
		minHeap.add(val);
		if (minHeap.size() > k)
			minHeap.poll();
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 8, 2 };
		int[] nums2 = {};
		KthLargest kthstream = new KthLargest(3, nums);
		System.out.println(kthstream.add(3));
		System.out.println(kthstream.add(5));
		System.out.println(kthstream.add(10));
		System.out.println(kthstream.add(9));
		System.out.println(kthstream.add(4));
	}
}
