package org.leetcode.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class WordDictionary {

  class TrieNode {

    boolean endOFWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOFWord = false;

    }
  }


  TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    root = new TrieNode();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.endOFWord = true;

  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {

    return searchRecursive(root, word, 0);

  }


  private boolean searchRecursive(TrieNode current, String word, int index) {
    if (index == word.length()) {
      return current.endOFWord;
    }
    char ch = word.charAt(index);

    if (ch == '.') {
      List<String> list = new ArrayList<>();
      for (Character key : current.children.keySet()) {
        list.add(key + word.substring(index + 1));
      }

      if (index > 0) {
        index = index - 1;
      }

      return wordHelper(list, current, index);
    }

    TrieNode node = current.children.get(ch);
    if (node == null) {
      return false;
    }

    return searchRecursive(node, word, ++index);
  }


  private boolean wordHelper(List<String> list, TrieNode current, int index) {
    if (list.size() == 0) {
      return false;
    }
    return searchRecursive(current, list.get(0), index) || wordHelper(list.subList(1, list.size()),
        current, index);
  }

  @Test
  public void test() {
    int i = "abc.abc".indexOf(".");

    System.out.println("abc.abc".substring(i + 1));


  }

  @Test
  public void test1() {
    addWord("bad");
    addWord("dad");
    addWord("mad");
    System.out.println(search("pad"));
    System.out.println(search("bad"));
    System.out.println(search(".ad"));
    System.out.println(search("b.."));
  }

  @Test
  public void test2() {
    addWord("a");
    addWord("a");
    System.out.println(search("."));
    System.out.println(search("a"));
    System.out.println(search("aa"));
    System.out.println(search("a"));
    System.out.println(search(".a"));
    System.out.println(search("a."));
    addWord("aa");
    System.out.println(search(".."));

  }

  @Test
  public void test3() {
    addWord("at");
    addWord("and");
    addWord("an");
    addWord("add");
    System.out.println(search("a"));
    System.out.println(search(".at"));
    addWord("bat");
    System.out.println(search(".at"));
    System.out.println(search("an."));
    System.out.println(search("a.d."));
    System.out.println(search("b."));
    System.out.println(search("a.d"));
    System.out.println(search("."));
  }
}
