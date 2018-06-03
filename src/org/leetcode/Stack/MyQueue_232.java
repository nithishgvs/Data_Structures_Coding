package org.leetcode.Stack;
//The ask was to implement Queue using stack

import java.util.Stack;

import org.junit.Test;

public class MyQueue_232 {

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	/** Initialize your data structure here. */
	public MyQueue_232() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		return false;
	}

	@Test
	public void queueTest() {
		MyQueue_232 queue = new MyQueue_232();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}

}
