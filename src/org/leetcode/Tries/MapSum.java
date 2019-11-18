package org.leetcode.Tries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class MapSum {

  class TrieNode {

    int sum;
    Map<Character, TrieNode> children;

    public TrieNode(int sum) {
      this.children = new HashMap<>();
      this.sum = sum;
    }
  }

  TrieNode root;

  Set<String> words;

  /**
   * Initialize your data structure here.
   */
  public MapSum() {
    root = new TrieNode(0);
    words = new HashSet<>();
  }

  public void insert(String key, int val) {

    TrieNode current = root;

    if (!words.contains(key)) {
      for (int i = 0; i < key.length(); i++) {
        char ch = key.charAt(i);
        TrieNode node = current.children.get(ch);
        if (node == null) {
          node = new TrieNode(val);
          current.children.put(ch, node);
        } else {
          node.sum = node.sum + val;
        }
        current = node;
      }
      words.add(key);
    } else {
      updateTrie(key, val);
    }

  }

  private void updateTrie(String key, int val) {

    TrieNode current = root;

    for (int i = 0; i < key.length(); i++) {
      char ch = key.charAt(i);
      TrieNode node = current.children.get(ch);
      node.sum = val;
      current = node;
    }


  }

  public int sum(String prefix) {
    TrieNode current = root;

    int sum = 0;
    int i;

    for (i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (current.children.get(ch) != null) {
        current = current.children.get(ch);
        if (i == prefix.length() - 1) {
          sum = current.sum;
        }
      } else {
        break;
      }
    }

    return sum;


  }


  @Test
  public void test() {
    insert("apple", 3);
    System.out.println(sum("ap"));
    insert("app", 2);
    Input:
    System.out.println(sum("ap"));
  }

  @Test
  public void test1() {
    insert("a", 3);
    System.out.println(sum("ap"));
    insert("b", 2);
    Input:
    System.out.println(sum("a"));
  }


  @Test
  public void test2() {
    insert("aa", 3);
    System.out.println(sum("a"));
    insert("aa", 2);
    Input:
    System.out.println(sum("a"));
  }

}
