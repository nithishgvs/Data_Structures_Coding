package org.leetcode.Design;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class Trie {


  public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }


  TrieNode root;

  /**
   * Initialize your data structure here.
   */

  public Trie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.children.get(word.charAt(i));
      if (node == null) {
        node = new TrieNode();
        current.children.put(word.charAt(i), node);
      }
      current = node;
    }
    current.endOfWord = true;

  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.children.get(word.charAt(i));
      if (node != null) {
        if (i == word.length() - 1) {
          return node.endOfWord;
        }
        current = node;
      } else {
        return false;
      }
    }

    return true;
  }


  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode node = current.children.get(prefix.charAt(i));
      if (node != null) {
        current = node;
      } else {
        return false;
      }
    }

    return true;
  }

  @Test
  public void test1() {
    insert("abc");
    insert("abcd");
    System.out.println(search("abc"));
    System.out.println(startsWith("abce"));
  }

  @Test
  public void test2() {
    insert("apple");
    //insert("abcd");
    System.out.println(search("apple"));
    System.out.println(search("app"));
    System.out.println(startsWith("app"));
    insert("app");
    System.out.println(search("app"));
  }


}
