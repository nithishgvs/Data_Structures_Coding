package org.leetcode.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class WordLadder_127 {


  public class WordNode {

    String word;
    int noOfSteps;

    public WordNode(String word, int noOfSteps) {
      this.word = word;
      this.noOfSteps = noOfSteps;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    Queue<WordNode> queue = new ArrayDeque<>();

    queue.add(new WordNode(beginWord, 1));
    Set<String> set = new HashSet<>(wordList);

    while (!queue.isEmpty()) {
      WordNode currentNode = queue.poll();
      if (currentNode.word.equals(endWord)) {
        return currentNode.noOfSteps;
      }
      char[] array = currentNode.word.toCharArray();
      for (int i = 0; i < array.length; i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          char temp = array[i];
          if (ch != temp) {
            array[i] = ch;
          }
          String newString = new String(array);

          if (set.contains(newString)) {
            System.out.println(newString);
            queue.add(new WordNode(newString, currentNode.noOfSteps + 1));
            set.remove(newString);
          }
          array[i] = temp;

        }
      }

    }

    return 0;
  }


  @Test
  public void test1() {
    List<String> list = new ArrayList<>();
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");
    System.out.println(
        ladderLength("hit", "cog", list));
  }

}
