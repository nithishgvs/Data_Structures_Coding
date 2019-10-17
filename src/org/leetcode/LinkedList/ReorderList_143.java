package org.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {

  public void reorderList(ListNode head) {

    if (head == null) {
      return;
    }

    List<ListNode> list = new ArrayList<>();
    ListNode current = head;

    while (current != null) {
      list.add(current);
      current = current.next;
    }

    int count=0;
    ListNode dummyHead = null;

    ListNode dummyCurrent = null;
    while(true){
      if(list.size()%2==1 && count ==list.size()/2){
        break;
      }else{
        if(count ==list.size()/2){
          break;
        }
      }
      if(dummyHead==null){
        dummyHead=list.get(0);
        dummyHead.next=list.get(list.size()-1);
      }

    }




  }

}
