package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern_890 {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();

    String patternString = buildPatternMap(pattern);

    for (String word : words) {
      String currentString = buildPatternMap(word);
      if (patternString.equals(currentString)) {
        result.add(word);
      }
    }


    return result;
  }


  private String buildPatternMap(String pattern) {
    Map<Character, String> patternMap = new LinkedHashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char character = pattern.charAt(i);
      String value = patternMap.getOrDefault(character, "");
      value = value + i;
      patternMap.put(character, value);
    }

    StringBuilder stringBuilder=new StringBuilder();
    patternMap.values().forEach(value->{
      stringBuilder.append(value).append("|");
    });
    return stringBuilder.toString();
  }

}
