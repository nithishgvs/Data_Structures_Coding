package org.leetcode.Strings;

public class ReorderLogFiles_937 {

//  public String[] reorderLogFiles(String[] logs) {
//
//    if (logs.length == 0 || logs.length == 1) {
//      return logs;
//    }
//    List<String[]> list = new ArrayList<>();
//
//    List<String[]> list1 = new ArrayList<>();
//
//
//
//
//    for (String str : logs) {
//      String[] arr = str.split("\\s+");
//      if (!Character.isDigit(arr[1].charAt(0))) {
//        list.add(arr);
//        continue;
//      }
//      list1.add(arr);
//    }
//
//   // Collections.sort(list, comparator);
//
//    int j = 0;
//
//    for (j = 0; j < list.size(); j++) {
//      String[] arr = list.get(j);
//      StringBuilder stringBuilder = new StringBuilder();
//      for (int i = 0; i < arr.length; i++) {
//        stringBuilder.append(arr[i] + " ");
//      }
//      logs[j] = stringBuilder.toString().trim();
//    }
//
//    for (int k = 0; k < list1.size(); k++) {
//      String[] arr = list1.get(k);
//      StringBuilder stringBuilder = new StringBuilder();
//      for (int i = 0; i < arr.length; i++) {
//        stringBuilder.append(arr[i] + " ");
//      }
//      logs[j + k] = stringBuilder.toString().trim();
//    }
//
//    return logs;
//  }
//
//
//  @Test
//  public void test1() {
//    String[] arr = reorderLogFiles(
//        new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
//    System.out.println(Arrays.toString(arr));
//    //"a1 9 2 3 1","zo4 4 7",
////
////    List<String> list = Arrays.asList("zzz", "bct", "act");
////    Comparator<String> comparator = new Comparator<String>() {
////      @Override
////      public int compare(String s, String t1) {
////        System.out.println(s + " " + t1 + " " + s.compareTo(t1));
////        return s.compareTo(t1);
////      }
////    };
////
////    Collections.sort(list, comparator);
////
////    System.out.println(Arrays.toString(list.toArray()));
//  }
//@Test
//  public void test2() {
//  String[] arr = reorderLogFiles(
//      new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});
//  System.out.println(Arrays.toString(arr));
//
//  }

}
