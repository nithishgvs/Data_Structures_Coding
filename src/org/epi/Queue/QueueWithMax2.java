package org.epi.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.junit.Test;

public class QueueWithMax2<T extends Comparable<T>> {

  private Queue<T> entries = new ArrayDeque<>();
  private Deque<T> canditatesForMax = new ArrayDeque<>();

  public void enqueue(T x) {
    entries.add(x);
    while (!canditatesForMax.isEmpty() && canditatesForMax.peekLast().compareTo(x) < 0) {
      //Eliminate dominated elements in canditatesMax
      canditatesForMax.removeLast();
    }
    canditatesForMax.addLast(x);
  }


  public T dequeue() {
    if (!entries.isEmpty()) {
      T result = entries.remove();
      if (result.equals(canditatesForMax.peekFirst())) {
        canditatesForMax.removeFirst();
      }
      return result;
    }
    throw new NoSuchElementException("called dequeue() on empty queue.");
  }

  public T max() {
    if (!canditatesForMax.isEmpty()) {
      return canditatesForMax.peekFirst();
    }
    throw new NoSuchElementException("empty queue");
  }


  @Test
  public void testQueue() {
    QueueWithMax2 queueWithMax = new QueueWithMax2();
    queueWithMax.enqueue(3);
    queueWithMax.enqueue(1);
    queueWithMax.enqueue(2);

  }

}
