package org.epi.Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Queue {

  private int head = 0, tail = 0, numQueueElements = 0;

  public final int SCALE_FACTOR = 2;

  private Integer[] entries;

  public Queue(int capacity) {
    entries = new Integer[capacity];
  }

  public void enqueue(Integer data) {
    if (numQueueElements == entries.length) {
      //Need to resize
      //Make the queue elements to appear consecutively
      Collections.rotate(Arrays.asList(entries), -head);
      //Reset head and tail
      head = 0;
      tail = numQueueElements;
      entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
    }

    entries[tail] = data;
    tail = (tail + 1) % entries.length;
    ++numQueueElements;
  }


  public Integer dequeue() {
    if (numQueueElements != 0) {
      --numQueueElements;
      Integer data = entries[head];
      head = (head + 1) % entries.length;
      return data;
    }
    throw new NoSuchElementException("Dequeue called on empty queue.");
  }


  public int size() {
    return numQueueElements;
  }

}
