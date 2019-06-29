package org.leetcode.Tries;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class CamelcaseMatching_1023 {


  class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      children = new TreeMap<>();
      endOfWord = false;
    }

  }

  private TrieNode root = new TrieNode();

  public void insert(String word) {
    insertRecursive(root, word, 0);
  }

  private void insertRecursive(TrieNode current, String word, int index) {

    if (index == word.length()) {
      current.endOfWord = true;
      return;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
      node = new TrieNode();
      current.children.put(ch, node);
    }
    insertRecursive(node, word, index + 1);
  }


  public List<Boolean> camelMatch(String[] queries, String pattern) {
    insert(pattern);
    for (int i = 0; i < queries.length; i++) {
      insert(queries[i]);
    }
    System.out.println("");
    return null;
  }


  @Test
  public void test1() {
    camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
        "FB");
  }

}
