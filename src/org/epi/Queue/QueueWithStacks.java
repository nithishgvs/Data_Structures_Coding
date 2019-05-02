package org.epi.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueWithStacks {

  private Deque<Integer> enqueue = new ArrayDeque<>();
  private Deque<Integer> dequeue = new ArrayDeque<>();

  public void enqueue(Integer x) {
    enqueue.addFirst(x);

  }

  public Integer dequeue() {
    if (dequeue.isEmpty()) {
      //Transfer all the elements from enqueue to dequeue
      while (!enqueue.isEmpty()) {
        dequeue.addFirst(enqueue.removeFirst());
      }
    }
    if (!dequeue.isEmpty()) {
      return dequeue.removeFirst();
    }

    throw new NoSuchElementException("Can't pop empty queue");
  }


}
