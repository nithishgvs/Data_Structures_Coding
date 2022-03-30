package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class WordSearchII_212 {


  Set<String> result = new HashSet<>();

  public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }

  TrieNode root;


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

  public List<String> findWords(char[][] board, String[] words) {

    root = new TrieNode();

    for (String word : words) {
      insert(word);
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        StringBuilder stringBuilder = new StringBuilder();
        findWordHelper(i, j, visited, stringBuilder, root, board);
      }
    }

    return new ArrayList<>(result);
  }

  private void findWordHelper(int row, int col, boolean[][] visited, StringBuilder stringBuilder,
      TrieNode root, char[][] board) {
    if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length
        || visited[row][col] || !root.children.containsKey(board[row][col])) {
      return;
    }

    char key = board[row][col];
    stringBuilder.append(key);
    TrieNode newNode = root.children.get(key);
    if (newNode.endOfWord) {
      result.add(stringBuilder.toString());
    }
    visited[row][col] = true;
    findWordHelper(row, col + 1, visited, stringBuilder, newNode, board);
    findWordHelper(row, col - 1, visited, stringBuilder, newNode, board);
    findWordHelper(row - 1, col, visited, stringBuilder, newNode, board);
    findWordHelper(row + 1, col, visited, stringBuilder, newNode, board);
    visited[row][col] = false;
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);

  }

  @Test
  public void test1() {
    String[] words = {"oath", "pea", "eat", "rain"};
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}};
    findWords(board, words).forEach(v -> System.out.println(v));
  }

  @Test
  public void test2() {
    String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}};
    findWords(board, words).forEach(v -> System.out.println(v));
  }

  @Test
  public void test3() {
    String[] words = {"oa", "oaa"};
    char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'},
        {'a', 'f', 'l', 'v'}};
    findWords(board, words).forEach(v -> System.out.println(v));
  }

}
