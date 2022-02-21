package org.twentytwentytwo.practice;

public class MinStack {


  public class Element {

    private Integer data;
    private Integer min;
    private Element next;

    public Element(Integer data, Integer min, Element next) {
      this.data = data;
      this.min = min;
      this.next = next;
    }
  }

  private Element top;

  public MinStack() {

  }

  public void push(int val) {
    Integer min;
    if (top != null) {
      min = Math.min(top.min, val);
    } else {
      min = val;
    }
    Element newElem = new Element(val, min, top);
    top = newElem;
  }

  public void pop() {
    top = top.next;
  }

  public int top() {
    Integer data = top.data;
    return data;
  }

  public int getMin() {
    Integer min = top.min;
    return min;
  }


  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top());    // return 0
    System.out.println(minStack.getMin()); // return -2
  }

}
