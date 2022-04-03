package org.twentytwentytwo.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ReplaceWords_648 {

  public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }




  /**
   * Initialize your data structure here.
   */

  TrieNode root;


  /**
   * Inserts a word into the trie
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
   * Returns if the word is in the trie
   */
  public boolean search(String word, StringBuilder stringBuilder) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.children.get(word.charAt(i));
      if (node != null) {
        stringBuilder.append(word.charAt(i));
        if (node.endOfWord) {
          return node.endOfWord;
        }
        current = node;
      } else {
        return false;
      }
    }

    return true;
  }

  public String replaceWords(List<String> dictionary, String sentence) {

    StringBuilder stringBuilder = new StringBuilder();
    root = new TrieNode();

    for (String dict : dictionary) {
      insert(dict);
    }

    String[] arr = sentence.split(" ");

    for (String word : arr) {
      StringBuilder temp = new StringBuilder();
      if (search(word, temp)) {
        stringBuilder.append(temp).append(" ");
      }else{
        stringBuilder.append(word).append(" ");
      }

    }

    return stringBuilder.toString().trim();


  }


  @Test
  public void test1(){
    List<String> words= Arrays.asList("cat","bat","rat");
    System.out.println(replaceWords(words,"the cattle was rattled by the battery"));
  }


}
