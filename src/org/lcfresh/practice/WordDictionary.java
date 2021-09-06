package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {


  public class TrieNode {

    private boolean endOfWord;
    private Map<Character, TrieNode> children;

    public TrieNode() {
      this.endOfWord = false;
      this.children = new HashMap<>();
    }
  }

  private TrieNode root;

  public void insertRecursive(String word) {
    insertHelper(word, 0, root);
  }

  private void insertHelper(String word, int index, TrieNode trieNode) {
    if (index == word.length()) {
      trieNode.endOfWord = true;
      return;
    }
    final char ch = word.charAt(index);
    TrieNode node = trieNode.children.get(ch);

    if (node == null) {
      node = new TrieNode();
      trieNode.children.put(ch, node);
    }
    insertHelper(word, ++index, node);
  }

  public boolean searchRecursive(String word) {
    return searchHelper(word, 0, root);
  }

  private boolean searchHelper(String word, int index, TrieNode trieNode) {
    if (word.length() == index) {
      return trieNode.endOfWord;
    }
    final char ch = word.charAt(index);
    if (ch == '.') {
      Map<Character, TrieNode> children = trieNode.children;
      for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
        final boolean found = searchHelper(word, index+1, entry.getValue());
        if (found) {
          return true;
        }
      }
    }
    TrieNode node = trieNode.children.get(ch);
    if (node == null) {
      return false;
    }
    return searchHelper(word, ++index, node);
  }

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    insertRecursive(word);
  }

  public boolean search(String word) {
    return searchRecursive(word);
  }


  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.insertRecursive("ran");
    wordDictionary.insertRecursive("rune");
    wordDictionary.insertRecursive("runner");
    wordDictionary.insertRecursive("runs");
    wordDictionary.insertRecursive("add");
    wordDictionary.insertRecursive("adds");
    wordDictionary.insertRecursive("adder");
    wordDictionary.insertRecursive("addee");
    System.out.println(wordDictionary.searchRecursive("r.n"));
    System.out.println(wordDictionary.searchRecursive("ru.n.e"));
    System.out.println(wordDictionary.searchRecursive("add"));
    System.out.println(wordDictionary.searchRecursive("add."));
    System.out.println(wordDictionary.searchRecursive("adde."));
    System.out.println(wordDictionary.searchRecursive(".an."));
    System.out.println(wordDictionary.searchRecursive("...s"));
    System.out.println(wordDictionary.searchRecursive("....e."));
    System.out.println(wordDictionary.searchRecursive("......."));
    System.out.println(wordDictionary.searchRecursive("..n.r"));

  }
}
