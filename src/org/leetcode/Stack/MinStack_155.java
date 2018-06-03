package org.leetcode.Stack;

import org.junit.Test;

public class MinStack_155 {

	private StackElement top;

	/** initialize your data structure here. */
	public MinStack_155() {

	}

	public void push(int x) {
		StackElement elem = null;
		if (top == null)
			elem = new StackElement(x, x, top);
		else
			elem = new StackElement(x, Math.min(x, top.min), top);
		top = elem;
	}

	public void pop() {
		if (top != null)
			top = top.getNext();

	}

	public int top() {
		if (top != null)
			return top.getData();
		return -1;
	}

	public int getMin() {
		if (top != null)
			return top.getMin();
		return -1;
	}

	class StackElement {

		public int data;
		public int min;
		public StackElement next;

		public int getMin() {
			return min;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public StackElement getNext() {
			return next;
		}

		public void setNext(StackElement next) {
			this.next = next;
		}

		public StackElement(int data, int min, StackElement next) {
			this.data = data;
			this.next = next;
			this.min = min;

		}

	}

	@Test
	public void testStack() {
		MinStack_155 minStack = new MinStack_155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // --> Returns -3.
		minStack.pop();
		minStack.top(); // --> Returns 0.
		System.out.println(minStack.getMin()); // --> Returns -2.
	}

}
