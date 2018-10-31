package org.leetcode.Heaps;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

//FindMedianDataStream_295
public class MedianFinder {

	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;

	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
	}

	public void addNum(int num) {
		if (minHeap.size() == maxHeap.size()) {
			if (minHeap.size() > 0) {
				minHeap.add(num);
				maxHeap.add(minHeap.poll());
			} else {
				maxHeap.add(num);
			}
		} else {
			minHeap.add(num);
		}

	}

	public double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (float) (minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}

	@Test
	public void testStream() {
		addNum(1);
		System.out.println(findMedian());
		addNum(2);
		System.out.println(findMedian());
		addNum(3);
		System.out.println(findMedian());
		addNum(4);
		System.out.println(findMedian());
		addNum(5);
		System.out.println(findMedian());
		addNum(6);
		System.out.println(findMedian());
		addNum(7);
		System.out.println(findMedian());
		addNum(8);
		System.out.println(findMedian());
		addNum(9);
		System.out.println(findMedian());
		addNum(10);
		System.out.println(findMedian());

	}

	@Test
	public void testStream1() {
		addNum(-1);
		System.out.println(findMedian());
		addNum(-2);
		System.out.println(findMedian());
		addNum(-3);
		System.out.println(findMedian());
		addNum(-4);
		System.out.println(findMedian());
		addNum(-5);
		System.out.println(findMedian());

	}

}
