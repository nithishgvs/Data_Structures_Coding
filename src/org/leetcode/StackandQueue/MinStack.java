package org.leetcode.StackandQueue;

import java.util.Stack;

class StackElement {

  int value;
  int minValue;

  public StackElement(int value, int minValue) {
    this.value = value;
    this.minValue = minValue;
  }
}

public class MinStack {

  Stack<StackElement> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int val) {
    if (!stack.isEmpty() && stack.peek().minValue < val) {
      stack.push(new StackElement(val, stack.peek().minValue));
    } else {
      stack.push(new StackElement(val, val));
    }
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().value;
  }

  public int getMin() {
    return stack.peek().minValue;
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }

}
