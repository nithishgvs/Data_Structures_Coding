package org.practice.io.Design;

public class BrowserHistory {

  //https://leetcode.com/problems/design-browser-history/

  DoubleLinkedNode head;

  public BrowserHistory(String homepage) {
    visit(homepage);
  }

  public void visit(String url) {
    DoubleLinkedNode newNode = new DoubleLinkedNode(url);
    if (this.head == null) {
      this.head = newNode;
    } else {
      DoubleLinkedNode current = head;
      newNode.previousNode = current;
      current.nextNode = newNode;
      head = newNode;
    }

  }

  public String back(int steps) {
    int i = steps;
    DoubleLinkedNode current = head;
    while (current.previousNode != null && i > 0) {
      current = current.previousNode;
      i--;
    }
    head = current;
    return head.url;
  }

  public String forward(int steps) {
    int i = steps;
    DoubleLinkedNode current = head;
    while (current.nextNode != null && i > 0) {
      current = current.nextNode;
      i--;
    }
    head = current;

    return head.url;
  }

  public class DoubleLinkedNode {

    private String url;
    private DoubleLinkedNode nextNode;
    private DoubleLinkedNode previousNode;

    public DoubleLinkedNode(String url) {
      this.url = url;
    }
  }


  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");
    browserHistory.visit("facebook.com");
    browserHistory.visit("youtube.com");
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.back(1));
    System.out.println(browserHistory.forward(1));
    browserHistory.visit("linkedin.com");
    System.out.println(browserHistory.forward(2));
    System.out.println(browserHistory.back(2));
    System.out.println(browserHistory.back(7));
  }

}
