package org.leetcode.StackandQueue;

public class MaxStack {

  public class StackElement {

    int val;
    int max;
    StackElement next;

    public StackElement(int val, int max, StackElement next) {
      this.val = val;
      this.max = max;
      this.next = next;
    }
  }

  StackElement topOfStack;

  public MaxStack() {

  }


  public void push(int x) {

    StackElement stackElement = null;
    if (topOfStack == null) {
      stackElement = new StackElement(x, x, null);
    } else {
      stackElement = new StackElement(x, Math.max(x, topOfStack.max), topOfStack);
    }

    topOfStack = stackElement;
  }

  public int top() {
    return topOfStack.val;
  }


  public int pop() {
    StackElement current = topOfStack;
    topOfStack = current.next;
    return current.val;
  }


  public int peekMax() {
    return topOfStack.max;
  }

  public int popMax() {

    if (topOfStack.val == topOfStack.max) {
      return pop();
    }

    int valueNeeded = topOfStack.max;
    StackElement current = topOfStack;
    StackElement previous = null;

    while (current != null) {
      if (current.val == valueNeeded) {
        previous.next = current.next;
        if (current.next != null) {
          previous.max = Math.max(previous.val, current.next.max);
        } else {
          previous.max = previous.val;
        }
        break;
      }

      if (current.max == valueNeeded) {
        if (current.next != null) {
          if (current.next.val != valueNeeded) {
            current.max = Math.max(current.val, current.next.val);
          } else {
            if (current.next.next != null) {
              current.max = Math.max(current.val, current.next.next.max);
            } else {
              current.max = current.val;
            }
          }
        }
      }
      previous = current;
      current = current.next;
    }

    return valueNeeded;

  }

  public static void main(String[] args) {
    MaxStack stack = new MaxStack();
    stack.push(5);
    stack.push(1);
    stack.push(-5);
    //System.out.println(stack.top()); //-> 5
    System.out.println(stack.popMax()); //-> 5
    System.out.println(stack.popMax());
    System.out.println(stack.top()); //-> 1
//    System.out.println(stack.peekMax()); //-> 5
//    System.out.println(stack.pop()); //-> 1
//    System.out.println(stack.top());// -> 5
  }

}
