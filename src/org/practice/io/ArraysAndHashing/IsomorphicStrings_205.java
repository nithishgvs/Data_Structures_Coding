package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IsomorphicStrings_205 {

  public boolean isIsomorphic(String s, String t) {
    return prepareString(s).equals(prepareString(t));
  }

  private String prepareString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder str = new StringBuilder();

    for(int i=0;i<s.length();i++){
      char ch=s.charAt(i);
      if(!map.containsKey(ch)){
        map.put(ch,i);
      }
      str.append(map.get(ch)).append("_");
    }


    return str.toString();
  }


  @Test
  public void test1() {
    //System.out.println(isIsomorphic("paper", "title"));
    System.out.println(isIsomorphic("13", "42"));
  }

}
