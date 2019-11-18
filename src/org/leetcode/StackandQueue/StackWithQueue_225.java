package org.leetcode.StackandQueue;

import java.util.LinkedList;
import java.util.Queue;
//Did with 1 queue
public class StackWithQueue_225 {

	/** Initialize your data structure here. */

	Queue<Integer> queue;

	public StackWithQueue_225() {
		queue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		int size = queue.size();
		queue.add(x);
		for (int i = 0; i < size; i++) {
			queue.add(queue.poll());
		}

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.poll();

	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		StackWithQueue_225 stack = new StackWithQueue_225();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top()); // returns 2
		System.out.println(stack.pop()); // returns 2
		System.out.println(stack.empty()); // returns false
	}

}
