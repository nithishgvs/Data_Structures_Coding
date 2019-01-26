package org.leetcode.Tries;

import org.junit.Test;

public class Trie_ {

  private TrieNode_ root;

  public Trie_() {
    root = new TrieNode_();
  }

  public void insert(String word) {
    TrieNode_ current = root;
    for (int i = 0; i < word.length(); i++) {
      Character ch = word.charAt(i);
      TrieNode_ node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode_();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.endOfWord = true;
  }


  public void insertRecursive(String word) {
    insertRecursive(root, word, 0);
  }

  private void insertRecursive(TrieNode_ current, String word, int index) {

    if (word.length() == index) {
      current.endOfWord = true;
      return;
    }

    Character ch = word.charAt(index);
    TrieNode_ node = current.children.get(ch);
    if (node == null) {
      node = new TrieNode_();
      current.children.put(ch, node);
    }
    insertRecursive(node, word, ++index);

  }

  public boolean search(String word) {
    TrieNode_ current = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode_ node = current.children.get(ch);
      if (node == null) {
        return false;
      }
      current = node;
    }

    return current.endOfWord;
  }


  public boolean searchRecursive(String word) {
    return searchRecursive(root, word, 0);
  }

  private boolean searchRecursive(TrieNode_ current, String word, int index) {
    if (index == word.length()) {
      return current.endOfWord;
    }

    TrieNode_ node = current.children.get(word.charAt(index));
    if (node == null) {
      return false;
    }

    return searchRecursive(node, word, ++index);
  }


  @Test
  public void testInsert() {
    insertRecursive("abc");
    System.out.println(searchRecursive("abc"));
  }


}
