package org.epi.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.junit.Test;

public class ShortestEquivalentPath {

  public String shortestEquivalentPath(String path) {

    if (path.equals("")) {
      throw new IllegalArgumentException("Empty string is not legal path.");
    }

    Deque<String> pathNames = new ArrayDeque<>();

    //Special case: starts with "/", which is an absolute path

    if (path.startsWith("/")) {
      pathNames.addFirst("/");
    }

    for (String token : path.split("/")) {
      if (token.equals("..")) {
        if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
          pathNames.addFirst(token);
        } else {
          if (pathNames.peekFirst().equals("/")) {
            throw new IllegalArgumentException("Path error, trying to go up root" + path);
          }
          pathNames.removeFirst();
        }
      } else if (!token.equals(".") && !token.isEmpty()) {
        pathNames.addFirst(token);
      }
    }

    StringBuilder result = new StringBuilder();

    if (!pathNames.isEmpty()) {
      Iterator<String> iterator = pathNames.descendingIterator();
      String prev = iterator.next();
      result.append(prev);

      while (iterator.hasNext()) {
        if (!prev.equals("/")) {
          result.append("/");
        }
        prev = iterator.next();
        result.append(prev);
      }

    }

    return result.toString();
  }


  @Test
  public void testPath() {
    System.out.println(shortestEquivalentPath("sc//./../tc/awk/././"));
  }


}
