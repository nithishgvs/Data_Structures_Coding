package org.leetcode.Tries;

import org.junit.Test;

/**
 * Credits to Tushar Roy
 *
 * @author nithishgvs
 */
public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
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

    current.endOfWord = true;
  }

  public void insertRecursive(String word) {
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

    insertRecursive(node, word, ++index);
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
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

  private boolean searchRecursive(TrieNode current, String word, int index) {
    if (index == word.length()) {
      return true;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
      return false;
    }

    return searchRecursive(node, word, index++);
  }

  public void delete(String word) {
    delete(root, word, 0);
  }

  private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      // when end of word is reached delete only if current.endOfWord is
      // True
      if (!current.endOfWord) {
        return false;
      }

      current.endOfWord = false;
      // if current has no other mapping return true;
      return current.children.size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

    // if true is returned then delete the mapping of character and trienode
    // reference from map.
    if (shouldDeleteCurrentNode) {
      current.children.remove(ch);
      // return true if no mappings are left in the map.
      return current.children.size() == 0;
    }
    return false;

  }

  @Test
  public void test() {
    Trie testTrie = new Trie();
    testTrie.insert("abc");
    testTrie.delete("abc");
  }

  @Test
  public void test1() {
    Trie testTrie = new Trie();
    testTrie.insert("a");
    testTrie.insert("b");
    testTrie.insert("abc");
  }
}
