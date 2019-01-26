package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindDuplicateFileSystem_609 {

  public List<List<String>> findDuplicate(String[] paths) {

    List<List<String>> outList=new ArrayList<>();
    Map<String, List<String>> dupMap = new HashMap<>();
    for (int i = 0; i < paths.length; i++) {
      String pre = paths[i].substring(0, paths[i].indexOf(" "));
      String post = paths[i].substring(paths[i].indexOf(" ") + 1);
      while (post.length() > 0) {
        String key = post.substring(post.indexOf("(") + 1, post.indexOf(")"));
        String value = pre + "/" + post.substring(0, post.indexOf("("));
        if (!dupMap.containsKey(key)) {
          List<String> keyList = new ArrayList<>();
          keyList.add(value);
          dupMap.put(key, keyList);
        } else {
          List<String> keyList = dupMap.get(key);
          keyList.add(value);
          dupMap.put(key, keyList);
        }
        if (post.indexOf(" ") != -1) {
          post = post.substring(post.indexOf(" ")+1);
        } else {
          post = "";
        }
      }
    }

    for(Map.Entry<String, List<String>> entry:dupMap.entrySet()){
      if(entry.getValue().size()>1) {
        outList.add(entry.getValue());
      }
    }
    return outList;
  }


  @Test
  public void testDuplicateFiles() {
    String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
        "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
    //String[] paths={"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};
    findDuplicate(paths).forEach(v->System.out.println(v));
  }


}
