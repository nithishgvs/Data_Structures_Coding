package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;

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

  public Trie(TrieNode root) {
    this.root = new TrieNode();
  }

  public void insert(String word) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      TrieNode newNode = current.children.get(word.charAt(i));
      if (newNode == null) {
        newNode = new TrieNode();
        current.children.put(word.charAt(i), newNode);
      }
      current = newNode;
    }
    current.endOfWord = true;
  }
}
