package org.epi.StackQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;


public class StackWithMaxCached {

  public static class ElementWithCachedMax {

    public Integer element;
    public Integer max;

    public ElementWithCachedMax(Integer element, Integer max) {
      this.element = element;
      this.max = max;
    }
  }

  //Stores(element, cached maximum) pair

  private Deque<ElementWithCachedMax> elementWithCachedMax = new ArrayDeque<>();

  public boolean empty() {
    return elementWithCachedMax.isEmpty();
  }

  public Integer max() {
    if (empty()) {
      throw new IllegalStateException("max(): empty stack");
    }
    return elementWithCachedMax.peek().max;
  }


  public Integer pop() {
    if (empty()) {
      throw new IllegalStateException("pop(): empty stack");
    }

    return elementWithCachedMax.removeFirst().element;
  }

  public void push(Integer x) {
    elementWithCachedMax.addFirst(new ElementWithCachedMax(x, Math.max(x, empty() ? x : max())));
  }


  @Test
  public void testElementCachedMax() {
    StackWithMaxCached stack = new StackWithMaxCached();
    stack.push(1);
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
  }


}
