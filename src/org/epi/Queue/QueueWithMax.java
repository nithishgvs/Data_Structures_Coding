package org.epi.Queue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class QueueWithMax {

  private Deque<Integer> data = new ArrayDeque<>();

  private void enqueue(Integer x) {
    data.add(x);
  }

  private Integer max() {
    if (!data.isEmpty()) {
      return Collections.max(data);
    }
    throw new IllegalStateException("can't perform max() on empty queue");
  }


}
