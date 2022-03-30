package org.twentytwentytwo.practice;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses_1249 {


  public class Parentheses {

    char ch;
    int pos;

    public Parentheses(char ch, int pos) {
      this.ch = ch;
      this.pos = pos;
    }
  }

  public String minRemoveToMakeValid(String s) {

    Stack<Parentheses> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stack.push(new Parentheses(ch, i));
      } else if (ch == ')') {
        if (!stack.isEmpty() && stack.peek().ch == '(') {
          stack.pop();
        } else {
          stack.push(new Parentheses(ch, i));
        }
      }
    }

    StringBuilder stringBuilder=new StringBuilder();

    for(int i=s.length()-1;i>=0;i--){
      if(!stack.isEmpty()&& stack.peek().pos==i){
        stack.pop();
      }else{
        stringBuilder.append(s.charAt(i));
      }
    }

    return stringBuilder.reverse().toString();

  }

  @Test
  public void test1() {
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
    System.out.println(minRemoveToMakeValid("))(("));
  }


}
