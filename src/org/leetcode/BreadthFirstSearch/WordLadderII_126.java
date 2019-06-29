package org.leetcode.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class WordLadderII_126 {


  List<List<String>> ladderList = new ArrayList<>();

  public class WordNode {

    String word;
    List<String> ladder;

    public WordNode(String word, List<String> ladder) {
      this.word = word;
      this.ladder = ladder;
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    Queue<WordNode> queue = new ArrayDeque<>();

    Set<String> set = new HashSet<>(wordList);
    set.remove(beginWord);

    List<String> list = new ArrayList<>();
    list.add(beginWord);
    queue.add(new WordNode(beginWord, list));

    while (!queue.isEmpty()) {
      WordNode wordNode = queue.poll();
      String word = wordNode.word;
      if (word.equals(endWord)) {
        List<String> outList = wordNode.ladder;
        if (ladderList.size() > 0 && ladderList.get(0).size() == outList.size()) {
          ladderList.add(outList);
        } else if (ladderList.size() == 0) {
          ladderList.add(outList);
        }
        continue;
      }
      char[] array = word.toCharArray();

      for (int i = 0; i < array.length; i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          char temp = array[i];
          if (ch != array[i]) {
            array[i] = ch;
          }
          String tempString = new String(array);

          if (set.contains(tempString) && tempString.length() == word.length() && !tempString
              .equals(word)) {
            List<String> outList = new ArrayList<>(wordNode.ladder);
            outList.add(tempString);
            queue.add(new WordNode(tempString, outList));
            if (!tempString.equals(endWord)) {
              set.remove(tempString);
            }
          }
          array[i] = temp;
        }
      }
    }

    return ladderList;
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
        findLadders("hit", "cog", list));
  }


  @Test
  public void test2() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println(
        findLadders("a", "c", list));
  }

  @Test
  public void test3() {
    List<String> list = new ArrayList<>();
    list.add("ted");
    list.add("tex");
    list.add("red");
    list.add("tax");
    list.add("tad");
    list.add("den");
    list.add("rex");
    list.add("pee");
    System.out.println(
        findLadders("red", "tax", list));
  }


}
