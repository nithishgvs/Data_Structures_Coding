package org.epi.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class StackMaxWithCount {


  public static class MaxWithCount {

    public Integer max;
    public Integer count;

    public MaxWithCount(Integer max, Integer count) {
      this.max = max;
      this.count = count;
    }
  }

  //actual implementation

  private Deque<Integer> element = new ArrayDeque<>();
  private Deque<MaxWithCount> cachedMaxWithCount = new ArrayDeque<>();

  public boolean empty() {
    return element.isEmpty();
  }

  public Integer max() {
    if (empty()) {
      throw new IllegalStateException("max(): empty stack");
    }
    return cachedMaxWithCount.peekFirst().max;
  }


  public Integer pop() {
    if (empty()) {
      throw new IllegalStateException("pop(): empty stack");
    }
    Integer popElement = element.removeFirst();
    if (popElement.equals(cachedMaxWithCount.peekFirst().max)) {
      cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count - 1;
      if (cachedMaxWithCount.peekFirst().count.equals(0)) {
        cachedMaxWithCount.removeFirst();
      }
    }
    return popElement;
  }

  public void push(Integer x) {
    element.addFirst(x);
    if (!cachedMaxWithCount.isEmpty()) {
      if (Integer.compare(x, cachedMaxWithCount.peekFirst().max) == 0) {
        cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count + 1;
      } else if (Integer.compare(x, cachedMaxWithCount.peekFirst().max) > 0) {
        cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
      }
    } else {
      cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
    }
  }


  @Test
  public void testStackMax() {
    StackMaxWithCount stack = new StackMaxWithCount();
    stack.push(1);
    stack.push(2);
    stack.push(2);
    stack.pop();
    stack.pop();
    System.out.println(stack.max());
  }


}
