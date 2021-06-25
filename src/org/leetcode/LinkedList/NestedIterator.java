package org.leetcode.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Flatten Nested List Iterator 341
 */
public class NestedIterator implements Iterator<Integer> {

  LinkedList<Integer> newList = new LinkedList<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    parseNestedList(nestedList);
  }

  public void parseNestedList(List<NestedInteger> nestedList) {
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        newList.add(nestedInteger.getInteger());
      } else {
        parseNestedList(nestedInteger.getList());
      }
    }
  }


  @Override
  public Integer next() {
    return newList.remove();
  }

  @Override
  public boolean hasNext() {
    return newList.size() > 0;
  }
}